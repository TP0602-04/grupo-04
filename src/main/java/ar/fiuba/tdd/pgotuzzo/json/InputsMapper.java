package ar.fiuba.tdd.pgotuzzo.json;

import ar.fiuba.tdd.pgotuzzo.json.scenario.CellMapper;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InputsMapper {
    @SerializedName("inputs")
    private List<CellMapper> inputs;
}
