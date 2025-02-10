package org.example.utilities;

import java.util.Map;
import java.util.function.Function;

public abstract class MapUtils {



    public static <T> void printMapForPlayer(Map<Integer,T> mapToPrint, Function<T, String> methodToBeCalled) {
        for (Map.Entry<Integer, ? extends T> entry : mapToPrint.entrySet()) {
            System.out.println(entry.getKey() + " : " + methodToBeCalled.apply(entry.getValue()));
        }
    }
}
