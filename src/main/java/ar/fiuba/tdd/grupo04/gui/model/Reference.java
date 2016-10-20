package ar.fiuba.tdd.grupo04.gui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Reference<T> {
    @SerializedName("value")
    private T value;
    @SerializedName("group")
    private CellGroup group;

    public T getValue() {
        return value;
    }

    public List<Cell> getCells() {
        return group.getCells();
    }

}
