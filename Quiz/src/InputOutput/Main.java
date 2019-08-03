package InputOutput;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import static InputOutput.Animal.deserializeAnimalArray;
import static InputOutput.Chars.readAsString;

public class Main extends CheckSumOfStream {

    public static void winToUnix (InputStream inputStream, OutputStream outputStream) throws IOException{

        int buffer1 = inputStream.read();
        int buffer2;

        while (buffer1 != -1){
            buffer2 = inputStream.read();
            if(buffer1 != 13 || buffer2 != 10){
                outputStream.write(buffer1);
            }
            buffer1 = buffer2;
        }
        outputStream.flush();
    }

    public static double parseNums (){
        Scanner sc = new Scanner(System.in);
        double d = 0;
        while(sc.hasNext()){
            try{
                d += Double.parseDouble(sc.next());
            } catch(NumberFormatException e) {

            }
        }
        return d;
    }

    public static void main(String[] args) throws IOException{

        Animal[] animals = {new Animal("Cat"), new Animal("Dog"), new Animal("Cow")};
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeInt(animals.length);
        for (int i = 0; i < animals.length; i++) {
            oos.writeObject(animals[i]);
        }
        oos.close();
        System.out.println(Arrays.toString(animals));
        Animal[] animal3 = deserializeAnimalArray(bos.toByteArray());
        System.out.println(Arrays.toString(animal3));

        double d = parseNums();
        System.out.format("%.6f%n",d);

        byte[] test = new byte[]{65, 13, 10, 10, 13};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(10);

        winToUnix(new ByteArrayInputStream(test),outputStream );
        byte[] out = outputStream.toByteArray();
        for (int i : out) {
            System.out.println(i);
        }

        InputStream stream;
        int result;
        stream = getStream(new byte[] {0x33, 0x45, 0x01});

        result = checkSumOfStream(stream);
        System.out.print(result);

        try {
            Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
            writer.append("ПриветHello");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        String str = readAsString(inputStream, Charset.forName("ASCII"));
        System.out.println(str);
    }

}

