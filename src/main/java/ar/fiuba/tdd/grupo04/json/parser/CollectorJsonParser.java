package ar.fiuba.tdd.grupo04.json.parser;

import ar.fiuba.tdd.grupo04.json.model.JsonCollector;
import ar.fiuba.tdd.grupo04.model.board.IBoard;
import ar.fiuba.tdd.grupo04.model.rule.collector.ICollector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class CollectorJsonParser {
    private final static String COLLECTORS_PATH = "ar.fiuba.tdd.grupo04.model.rule.collector.";

    public static ICollector parse(JsonCollector jsonCollector, IBoard board) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ICollector collector;
        List<Integer> params = jsonCollector.getParams();
        Class<?> cl = Class.forName(COLLECTORS_PATH + jsonCollector.getType());
        Constructor<?> cons;
        switch (params.size()) {
            case 1:
                cons = cl.getConstructor(IBoard.class, Integer.class);
                collector = (ICollector) cons.newInstance(board, params.get(0));
                break;
            case 2:
                cons = cl.getConstructor(IBoard.class, Integer.class, Integer.class);
                collector = (ICollector) cons.newInstance(board, params.get(0), params.get(1));
                break;
            default:
                cons = cl.getConstructor(IBoard.class);
                collector = (ICollector) cons.newInstance(board);
                break;
        }
        return collector;
    }
}
