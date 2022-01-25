package test.wavcut;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
/**
 * @Author: Zhangdongdong
 * @Date: 2022/1/14 17:55
 */
public class WavUtils {


    /**
     * @param sourcefile
     * @param targetfile
     * @param start
     * @param end
     * @return
     */
    public static boolean cut(String sourcefile, String targetfile, int start, int end) {
        try {
            if (!sourcefile.toLowerCase().endsWith(".wav") || !targetfile.toLowerCase().endsWith(".wav")) {
                System.out.println("文件格式不正确");
                return false;
            }
            File wav = new File(sourcefile);
            if (!wav.exists()) {
                System.out.println("文件不存在");
                return false;
            }
            long t1 = getTimeLen(wav);  //总时长(秒)
            if (start < 0 || end <= 0 || start >= t1 || end > t1 || start >= end) {
                System.out.println("时间范围不正确，需在总时长内剪辑");
                return false;
            }
            FileInputStream fis = new FileInputStream(wav);
            long wavSize = wav.length() - 44;  //音频数据大小（44为128kbps比特率wav文件头长度）
            long splitSize = (wavSize / t1) * (end - start);  //截取的音频数据大小
            long skipSize = (wavSize / t1) * start;  //截取时跳过的音频数据大小
            int splitSizeInt = Integer.parseInt(String.valueOf(splitSize));
            int skipSizeInt = Integer.parseInt(String.valueOf(skipSize));

            ByteBuffer buf1 = ByteBuffer.allocate(4);  //存放文件大小,4代表一个int占用字节数
            buf1.putInt(splitSizeInt + 36);  //放入文件长度信息
            byte[] flen = buf1.array();  //代表文件长度
            ByteBuffer buf2 = ByteBuffer.allocate(4);  //存放音频数据大小，4代表一个int占用字节数
            buf2.putInt(splitSizeInt);  //放入数据长度信息
            byte[] dlen = buf2.array();  //代表数据长度
            flen = reverse(flen);  //数组反转
            dlen = reverse(dlen);
            byte[] head = new byte[44];  //定义wav头部信息数组
            fis.read(head, 0, head.length);  //读取源wav文件头部信息
            for (int i = 0; i < 4; i++) {  //4代表一个int占用字节数
                head[i + 4] = flen[i];  //替换原头部信息里的文件长度
                head[i + 40] = dlen[i];  //替换原头部信息里的数据长度
            }
            byte[] fbyte = new byte[splitSizeInt + head.length];  //存放截取的音频数据
            for (int i = 0; i < head.length; i++) {  //放入修改后的头部信息
                fbyte[i] = head[i];
            }
            byte[] skipBytes = new byte[skipSizeInt];  //存放截取时跳过的音频数据
            fis.read(skipBytes, 0, skipBytes.length);  //跳过不需要截取的数据
            fis.read(fbyte, head.length, fbyte.length - head.length);  //读取要截取的数据到目标数组
            fis.close();

            File target = new File(targetfile);
            if (target.exists()) {  //如果目标文件已存在，则删除目标文件
                target.delete();
            }
            FileOutputStream fos = new FileOutputStream(target);
            fos.write(fbyte);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static long getTimeLen(File file) {
        long tlen = 0;
        if (file != null && file.exists()) {
            Encoder encoder = new Encoder();
            try {
                MultimediaInfo m = encoder.getInfo(file);
                long ls = m.getDuration();
                tlen = ls / 1000;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return tlen;
    }

    public static byte[] reverse(byte[] array) {
        byte temp;
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
        return array;
    }

    public static void closeIO(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        }
        catch (IOException arg1) {
            ;
        }
    }

    public static String wav2PCM(String src, String target) {
        FileInputStream fis;
        FileOutputStream fos;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(target);
            byte[] b = inputStreamToByte(fis);
            byte[] c = Arrays.copyOfRange(b, 44, b.length);
            fos.write(c);
            closeIO(fis);
            closeIO(fos);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }

    private static byte[] inputStreamToByte(FileInputStream fis) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        long size = fis.getChannel().size();
        byte[] buffer = null;
        if (size <= Integer.MAX_VALUE) {
            buffer = new byte[(int) size];
        }
        else {
            buffer = new byte[8];
            for (int ix = 0; ix < 8; ++ix) {
                int offset = 64 - (ix + 1) * 8;
                buffer[ix] = (byte) ((size >> offset) & 0xff);
            }
        }
        int len;
        while ((len = fis.read(buffer)) != -1) {
            byteStream.write(buffer, 0, len);
        }
        byte[] data = byteStream.toByteArray();
        closeIO(byteStream);
        return data;
    }

    public static void playPCM(String filePath) {
        try
        {
            File file = new File("F:\\testFile\\test.pcm");
            System.out.println(file.length());
            int offset = 0;
            int bufferSize = Integer.valueOf(String.valueOf(file.length()));
            byte[] audioData = new byte[bufferSize];
            InputStream in = new FileInputStream(file);
            in.read(audioData);

            float sampleRate = 100000;  //播放速度控制
            int sampleSizeInBits = 16;
            int channels = 1;
            boolean signed = true;
            boolean bigEndian = false;

            // sampleRate - 每秒的样本数
            // sampleSizeInBits - 每个样本中的位数
            // channels - 声道数（单声道 1 个，立体声 2 个）
            // signed - 指示数据是有符号的，还是无符号的
            // bigEndian - 指示是否以 big-endian 字节顺序存储单个样本中的数据（false 意味着
            // little-endian）。
            AudioFormat af = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
            SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class, af, bufferSize);
            SourceDataLine sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(af);
            sdl.start();
            while (offset < audioData.length)
            {
                offset += sdl.write(audioData, offset, bufferSize);
            }
        }
        catch(LineUnavailableException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 测试wav文件根据时间剪切
     * @param args
     */
    public static void main(String[] args) {
        String fileName ="F:\\testFile\\abc.wav";
        String targetName1 ="F:\\testFile\\aaa.wav";
        String targetName2 ="F:\\testFile\\ccc.wav";
        String targetName3 ="F:\\testFile\\fff.wav";
        String pcmFile = "F:\\testFile\\mmm.pcm";
        try {
            File wav = new File(fileName);
            long timeLen = getTimeLen(wav); //获取总时长
            System.out.println("音频总时长：" + timeLen);
            System.out.println("剪切第一段：" + cut(fileName, targetName3, 0, 5));
            System.out.println("剪切第二段：" + cut(fileName, targetName1, 5, 10));
            System.out.println("剪切第三段：" + cut(fileName, targetName2, 10, (int) timeLen));
            wav2PCM(fileName, pcmFile);
            playPCM(pcmFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
