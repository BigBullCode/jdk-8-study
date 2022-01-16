package test.wavcut;

import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.*;

public class Mp3CutUtils {
    /**
     * @Description 获取打印mp3信息
     * @Author  C.
     * @Date   2021/7/23 10:36
     * @Param  [mp3Path]
     * @Return      void
     *
     */
    private static void getMp3Head(String mp3Path) {

        MP3File mp3File = null;//封装好的类
        try {
            mp3File = new MP3File(mp3Path);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取文件失败");
            return;
        }

        System.out.println("----------------Loading...Head-----------------");

        MP3AudioHeader header = mp3File.getMP3AudioHeader();
        System.out.println("时长: " + header.getTrackLength()); //获得时长
        System.out.println("比特率: " + header.getBitRateAsNumber()); //获得比特率
        System.out.println("音轨长度: " + header.getTrackLength()); //音轨长度
        System.out.println("格式: " + header.getFormat()); //格式，例 MPEG-1
        System.out.println("声道: " + header.getChannels()); //声道
        System.out.println("采样率: " + header.getSampleRate()); //采样率
        System.out.println("MPEG: " + header.getMpegLayer()); //MPEG
        System.out.println("MP3起始字节: " + header.getMp3StartByte()); //MP3起始字节
        System.out.println("精确的音轨长度: " + header.getPreciseTrackLength()); //精确的音轨长度

        System.out.println("----------------Loading...Content-----------------");


    }

    /**
     * @Description 根据路径剪辑
     * @Author  C.
     * @Date   2021/7/23 10:36
     * @Param  [sourceFile, targetFile, start, end]
     * @Return      boolean
     *
     */
    public static boolean Mp3cut(MP3File mp3File, String targetFile, int start, int end) {
        return cut(mp3File.getFile(), targetFile, start, end, (int) mp3File.getMP3AudioHeader().getBitRateAsNumber());

    }

    /**
     * @Description 传入文件剪辑
     * @Author  C.
     * @Date   2021/7/23 10:39
     * @Param  [sou, targetFile, start, end, kbps]
     * @Return      boolean
     *
     */
    public static boolean cut(File sou, String targetFile, int start, int end, int kbps) {

        File out = new File(targetFile);
        try {
            if (!out.getParentFile().exists()) {
                out.getParentFile().mkdirs();
            }
            boolean p = out.createNewFile();
            System.out.println("创建文件：{" + p + "}");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        BufferedInputStream bis1 = null;
        BufferedOutputStream bos = null;
        //剪切部分起始字节
        int start1 = start * kbps * 128;//128kbps（比特率）*20s*1024/8=327680 比特率可以查看音频属性获知
        int end1 = end * kbps * 128;//128kbps*25s*1024/8=409600

        int tatol1 = 0;
        try {
            //输入流
            bis1 = new BufferedInputStream(new FileInputStream(sou));
            //缓冲字节输出流（true表示可以在流的后面追加数据，而不是覆盖！！）
            bos = new BufferedOutputStream(new FileOutputStream(out, false));

            //剪切、写入
            byte[] b1 = new byte[1024];
            int len1 = 0;
            while ((len1 = bis1.read(b1)) != -1) {
                tatol1 += len1;   //累积tatol
                if (tatol1 < start1) {  //tatol小于起始值则跳出本次循环
                    continue;
                }
                bos.write(b1);   //写入的都是在我们预先指定的字节范围之内
                if (tatol1 >= end1) {  //当tatol的值超过预先设定的范围，则立刻刷新bos流对象，并结束循环
                    bos.flush();
                    break;
                }
            }
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {//切记要关闭流！！
                if (bis1 != null) bis1.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }


}
