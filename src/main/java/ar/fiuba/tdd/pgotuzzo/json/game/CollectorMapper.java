package ar.fiuba.tdd.pgotuzzo.json.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectorMapper {
    public static final String ALL = "All";
    public static final String ROWS = "Rows";
    public static final String COLUMNS = "Columns";
    public static final String BLOCKS = "Blocks";
    public static final String CUSTOM = "Custom";
    public static final String VALUED = "Valued";

    @SerializedName("type")
    private String type;
    @SerializedName("params")
    private List<Integer> params;

    public String getType() {
        return type;
    }

    public List<Integer> getParams() {
        return params;
    }
}
