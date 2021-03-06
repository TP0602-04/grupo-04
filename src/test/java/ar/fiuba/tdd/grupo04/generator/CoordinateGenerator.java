package ar.fiuba.tdd.grupo04.generator;

import ar.fiuba.tdd.grupo04.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;

import static ar.fiuba.tdd.grupo04.generator.IntGenerator.getInt;

public class CoordinateGenerator {
    private static final Random RANDOM = new Random();

    public static Coordinate getCoordinate() {
        return new Coordinate(getInt(), getInt());
    }

    public static Coordinate getCoordinate(int inclusiveMin, int exclusiveMax) {
        PrimitiveIterator.OfInt iterator = RANDOM.ints(inclusiveMin, exclusiveMax).iterator();
        return new Coordinate(iterator.next(), iterator.next());
    }

    public static List<Coordinate> getCoordinateList(int listSize) {
        return getCoordinateList(
                RANDOM.ints().iterator(),
                listSize
        );
    }

    public static List<Coordinate> getCoordinateList(int listSize, int inclusiveMin, int exclusiveMax) {
        return getCoordinateList(
                RANDOM.ints(inclusiveMin, exclusiveMax).iterator(),
                listSize
        );
    }

    private static List<Coordinate> getCoordinateList(PrimitiveIterator.OfInt iterator, int listSize) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            Coordinate coordinate = new Coordinate(iterator.next(), iterator.next());
            coordinates.add(coordinate);
        }
        return coordinates;
    }


}
