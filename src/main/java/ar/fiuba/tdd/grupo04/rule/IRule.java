package ar.fiuba.tdd.grupo04.rule;

import ar.fiuba.tdd.grupo04.board.IBoard;

public interface IRule {
    // Conditions
    String UNIQUE = "Unique";
    String GREATER_THAN = "GreaterThan";
    String LESSER_THAN = "LesserThan";
    String LESSER_THAN_SLOT_SIZE = "LesserThanSlotSize";
    String FILLED = "Filled";
    String EQUALS_SUM = "EqualsSum";
    String EQUALS_MULTIPLY = "EqualsMultiply";
    String NO_BRANCHED_OFF = "NoBranchedOff";
    String NO_LOOP = "NoLoop";
    String SINGLE_LOOP = "SingleLoop";
    String COUNT_WITHIN_RANGE = "CountWithinRange";
    String SLOTS_OF_SIZE = "SlotsOfSize";
    String MIN_MATCH_AT_VALUE_DISTANCE = "MinMatchAtValueDistance";
    // Collectors
    String ALL = "All";
    String ROWS = "Rows";
    String COLUMNS = "Columns";
    String BLOCKS = "Blocks";
    String VALUED = "Valued";
    String CUSTOM = "Custom";
    String CUSTOM_VALUED = "CustomValued";

    boolean check(IBoard board);
}
