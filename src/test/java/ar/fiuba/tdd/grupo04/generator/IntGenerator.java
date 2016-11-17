package ar.fiuba.tdd.grupo04.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class IntGenerator {
    private static final Random RANDOM = new Random();

    public static int getInt() {
        return RANDOM.nextInt();
    }

    public static int getInt(int inclusiveMin, int exclusiveMax) {
        return RANDOM.ints(inclusiveMin, exclusiveMax).iterator().next();
    }

    public static List<Integer> getIntList(int listSize, int inclusiveMin, int exclusiveMax) {
        return RANDOM
                .ints(inclusiveMin, exclusiveMax)
                .limit(listSize).boxed()
                .collect(Collectors.toList());
    }

}
