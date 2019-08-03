package FcknStreams;

import java.util.stream.IntStream;

public class IntStreamClass {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, smthng -> smthng*smthng/10%1000);
    }

}
