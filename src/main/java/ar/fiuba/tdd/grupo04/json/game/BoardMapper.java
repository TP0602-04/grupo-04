package ar.fiuba.tdd.grupo04.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BoardMapper {
    @SerializedName("columns")
    private int columns;
    @SerializedName("rows")
    private int rows;
    @SerializedName("cellType")
    private String cellType;
    @SerializedName("structure")
    private List<StructureMapper> structure = new ArrayList<>();

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public List<StructureMapper> getStructure() {
        return structure;
    }
}
