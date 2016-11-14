package ar.fiuba.tdd.grupo04.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BoardMapper {
    public static final String INPUT_NUMERIC = "Numeric";
    public static final String INPUT_BOOLEAN = "Boolean";
    public static final String INPUT_DIAGONAL = "Diagonal";

    @SerializedName("columns")
    private int columns;
    @SerializedName("rows")
    private int rows;
    @SerializedName("inputType")
    private String inputType;
    @SerializedName("structure")
    private List<StructureMapper> structure = new ArrayList<>();

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String getInputType() {
        return inputType;
    }

    public List<StructureMapper> getStructure() {
        return structure;
    }
}
