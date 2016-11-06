package ar.fiuba.tdd.pgotuzzo.json;

import ar.fiuba.tdd.pgotuzzo.Coordinate;
import ar.fiuba.tdd.pgotuzzo.Input;
import ar.fiuba.tdd.pgotuzzo.json.scenario.CellMapper;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;

public class InputsMapper {
    @SerializedName("inputs")
    private List<CellMapper> inputs;

    public List<Input> getInputs() {
        return inputs
                .stream()
                .map(this::convertToInput)
                .collect(Collectors.toList());
    }

    private Input convertToInput(CellMapper cellMapper) {
        Coordinate coordinate = new Coordinate(
                cellMapper.getRow(),
                cellMapper.getColumn()
        );
        Integer value = cellMapper.getValue();
        return new Input(coordinate, value);
    }
}
