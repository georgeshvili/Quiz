package InputOutput;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Chars {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while((i = inputStreamReader.read()) != -1)
                stringBuilder.append((char) i);
            return stringBuilder.toString();
    }

}
