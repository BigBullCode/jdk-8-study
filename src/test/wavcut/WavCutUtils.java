package test.wavcut;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.*;
import java.nio.ByteBuffer;


/** 
 * wav音频文件截取工具 
 * （适用于头文件长度不一样的wav音频文件，WAV音频文件的头部信息占用长度44字节(一般标准，没有拓展块的情况)）
 * @author Carlos IP
 * 
 */  
public class WavCutUtils {
      
    /** 
     * 截取wav音频文件 
     * @param sourceFile  源文件地址
     * @param targetFile  目标文件地址
     * @param start  截取开始时间（秒） 
     * @param end  截取结束时间（秒）
     */  
    public static boolean cut(String sourceFile, String targetFile, int start, int end) throws IOException {
        File wav = new File(sourceFile);
        return cut(wav,targetFile,start,end);
    }

    public static boolean cut(File wav, String targetFile, int start, int end) throws IOException {

        try{
            RandomAccessFile src = new RandomAccessFile(wav, "r");
            int headSize= getHeadSize(src);
            if(!wav.exists()){
                return false;
            }
            long t1 = getTimeLen(wav);  //总时长(秒)
            System.out.println("总时长：" + t1);
            if(start<0 || end<=0 || start>=t1 || end>t1 || start>=end){
                return false;
            }
            FileInputStream fis = new FileInputStream(wav);
            //long wavSize = wav.length()-44;  //音频数据大小（44为128kbps比特率wav文件头长度）
            long wavSize = wav.length()-headSize;  //音频数据大小（wav文件头长度不一定是44）
            long splitSize = (wavSize/t1)*(end-start);  //截取的音频数据大小
            long skipSize = (wavSize/t1)*start;  //截取时跳过的音频数据大小
            int splitSizeInt = Integer.parseInt(String.valueOf(splitSize));
            int skipSizeInt = Integer.parseInt(String.valueOf(skipSize));

            ByteBuffer buf1 = ByteBuffer.allocate(4);  //存放文件大小,4代表一个int占用字节数
            buf1.putInt(splitSizeInt+36);  //放入文件长度信息
            byte[] flen = buf1.array();  //代表文件长度
            ByteBuffer buf2 = ByteBuffer.allocate(4);  //存放音频数据大小，4代表一个int占用字节数
            buf2.putInt(splitSizeInt);  //放入数据长度信息
            byte[] dlen = buf2.array();  //代表数据长度
            flen = reverse(flen);  //数组反转
            dlen = reverse(dlen);
            //byte[] head = new byte[44];  //定义wav头部信息数组
            byte[] head = new byte[headSize];
            fis.read(head, 0, head.length);  //读取源wav文件头部信息
            for(int i=0; i<4; i++){  //4代表一个int占用字节数
                head[i+4] = flen[i];  //替换原头部信息里的文件长度
                //head[i+40] = dlen[i];  //替换原头部信息里的数据长度
                head[i+headSize-4] = dlen[i];  //替换原头部信息里的数据长度
            }
            byte[] fbyte = new byte[splitSizeInt+head.length];  //存放截取的音频数据
            for(int i=0; i<head.length; i++){  //放入修改后的头部信息
                fbyte[i] = head[i];
            }
            byte[] skipBytes = new byte[skipSizeInt];  //存放截取时跳过的音频数据
            fis.read(skipBytes, 0, skipBytes.length);  //跳过不需要截取的数据
            fis.read(fbyte, head.length, fbyte.length-head.length);  //读取要截取的数据到目标数组
            fis.close();

            File target = new File(targetFile);
            if(target.exists()){  //如果目标文件已存在，则删除目标文件
                target.delete();
            }
            FileOutputStream fos = new FileOutputStream(target);
            fos.write(fbyte);
            fos.flush();
            fos.close();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }



    /** 
     * 获取音频文件总时长 
     * @param file  文件路径
     * @return 
     */  
    private static long getTimeLen(File file){  
        long tlen = 0;  
        if(file!=null && file.exists()){  
            Encoder encoder = new Encoder();
            try {  
                 MultimediaInfo m = encoder.getInfo(file);
                 long ls = m.getDuration();  
                 tlen = ls/1000;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return tlen;  
    }  
      
    /** 
    * 数组反转 
    * @param array 
    */  
    private static byte[] reverse(byte[] array){  
        byte temp;  
        int len=array.length;  
        for(int i=0;i<len/2;i++){  
            temp=array[i];  
            array[i]=array[len-1-i];  
            array[len-1-i]=temp;  
        }  
        return array;  
    }  
      
    
    //HeadSize得到头文件大小
	public static int getHeadSize(RandomAccessFile srcFis) throws IOException {
        int offset = 0;
        //riff
        getChunkId(srcFis);
        offset += 4;
        //length
        getChunkSize(srcFis);
        offset += 4;
        //wave
        getChunkId(srcFis);
        offset += 4;
        //fmt
        getChunkId(srcFis);
        offset += 4;
        //fmt length
        int skipLength = getChunkSize(srcFis);
        offset += 4;
        byte[] skipBytes = new byte[skipLength];
        srcFis.read(skipBytes);
        offset += skipLength;
        String chunkId = getChunkId(srcFis);
        offset += 4;
        while (!chunkId.equals("data")) {
            skipLength = getChunkSize(srcFis);
            offset += 4;
            skipBytes = new byte[skipLength];
            srcFis.read(skipBytes);
            offset += skipLength;
            chunkId = getChunkId(srcFis);
            offset += 4;
        }
        offset += 4;
        System.out.println("headSize="+offset);
        return offset;
    }

    private static int getChunkSize(RandomAccessFile srcFis) throws IOException {
        byte[] formatSize = new byte[4];
        srcFis.read(formatSize);
        int fisrt8 = formatSize[0] & 0xFF;  
        int fisrt16 = formatSize[1] & 0xFF;
        int fisrt24 = formatSize[2] & 0xFF;
        int fisrt32 = formatSize[3] & 0xFF;
        int chunkSize = fisrt8 | (fisrt16 << 8) | (fisrt24 << 16) | (fisrt32 << 24);
        System.out.println("ChunkSize=" + chunkSize);
        return chunkSize;
    }

    private static String getChunkId(RandomAccessFile srcFis) throws IOException {
        byte[] bytes = new byte[4];
        srcFis.read(bytes);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append((char) bytes[i]);
        }
        String chunkId = stringBuilder.toString();
        System.out.println("ChunkId=" + chunkId);
        return chunkId;
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

        //        boolean result1 =  cut(fileName,targetName1,0,5);
        //        boolean result3 = cut(fileName,targetName2,5,8);
        boolean cut = false;
        try {
            cut = WavCutUtils.cut(fileName, targetName3, 0, 5);
            WavCutUtils.cut(fileName, targetName1, 5, 10);
            WavCutUtils.cut(fileName, targetName2, 10, 15);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //        System.out.println(result1);
        //        System.out.println(result3);
        System.out.println(cut);
    }

}
