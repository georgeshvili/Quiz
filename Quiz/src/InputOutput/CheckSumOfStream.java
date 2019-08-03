package InputOutput;

import java.io.*;

public class CheckSumOfStream {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {

        int c = 0;
        int b = 0;
        while(b != -1) {
            b = inputStream.read();
            if(b == -1)
                break;
            c = Integer.rotateLeft(c, 1) ^ b;
        }
        return c;
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream (data);
    }

}
