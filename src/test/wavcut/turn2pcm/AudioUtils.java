package test.wavcut.turn2pcm;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 音频转换工具（wav -> pcm）
 */
public class AudioUtils {
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

    public static String convertAudioFiles(String src, String target) {
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

    public static void main(String[] args) {
        convertAudioFiles("F:\\testFile\\abc.wav", "F:\\testFile\\test.pcm");
    }

}
