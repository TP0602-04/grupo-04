package ar.fiuba.tdd.grupo04.json;

import ar.fiuba.tdd.grupo04.Coordinate;
import ar.fiuba.tdd.grupo04.Input;
import ar.fiuba.tdd.grupo04.json.scenario.CellMapper;
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
