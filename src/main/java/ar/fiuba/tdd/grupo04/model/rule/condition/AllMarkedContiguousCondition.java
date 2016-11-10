package ar.fiuba.tdd.grupo04.model.rule.condition;

import ar.fiuba.tdd.grupo04.model.board.Coordinate;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInput;
import ar.fiuba.tdd.grupo04.model.inputs.GraphInputType;
import ar.fiuba.tdd.grupo04.model.inputs.IInput;
import ar.fiuba.tdd.grupo04.model.rule.IInputGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("CPD-START")
public class AllMarkedContiguousCondition<R extends IInputGroup<GraphInput>> implements ICondition<R> {
    private final List<Coordinate> path = new ArrayList<>();

    @Override
    public boolean check(R inputGroup) {
        final List<GraphInput> markedInputs = inputGroup.getInputs().stream().filter(GraphInput::isMarked).collect(Collectors.toList());
        final List<Coordinate> coordinates = markedInputs.stream().map(IInput::getCoordinate).collect(Collectors.toList());

        if (markedInputs.isEmpty()) {
            return true;
        }
        Optional<GraphInput> firstNodeInput = getFirstNode(markedInputs);

        if (!firstNodeInput.isPresent()) {
            return false;
        }
        Coordinate firstNode = firstNodeInput.get().getCoordinate();
        path.add(firstNode);
        Optional<Coordinate> actualNode = Optional.of(firstNode);

        Optional<Coordinate> actualEdge = getNextEdge(coordinates, firstNode);

        if (!actualEdge.isPresent()) {
            return false;
        }
        path.add(actualEdge.get());

        // it can be an edge to the other side
        Optional<Coordinate> otherEdge = getNextEdge(coordinates, firstNode, actualEdge.get());

        boolean findNextStep = true;
        while (findNextStep) {
            actualNode = getNextNode(actualEdge.get(), actualNode.get());
            if (!actualNode.isPresent()) {
                findNextStep = false;
            } else if (path.contains(actualNode.get())) {
                findNextStep = false;
            } else {
                path.add(actualNode.get());

                actualEdge = getNextEdge(coordinates, actualNode.get(), actualEdge.get());
                if (!actualEdge.isPresent()) {
                    findNextStep = false;
                } else {
                    path.add(actualEdge.get());
                }
            }
        }

        calculateToTheOtherEdge(coordinates, otherEdge, firstNode);
        return path.size() == coordinates.size();
    }

    private void calculateToTheOtherEdge(List<Coordinate> coordinates, Optional<Coordinate> otherEdge, Coordinate firstNode) {
        if (!otherEdge.isPresent()) {
            return;
        }

        Optional<Coordinate> actualNode = Optional.of(firstNode);
        Optional<Coordinate> actualEdge = otherEdge;
        boolean findNextStep = true;
        while (findNextStep) {
            actualNode = getNextNode(actualEdge.get(), actualNode.get());
            if (!actualNode.isPresent()) {
                return;
            } else if (path.contains(actualNode.get())) {
                return;
            } else {
                path.add(actualNode.get());

                actualEdge = getNextEdge(coordinates, actualNode.get(), actualEdge.get());
                if (!actualEdge.isPresent()) {
                    return;
                } else {
                    path.add(actualEdge.get());
                }
            }
        }
    }


    private Optional<GraphInput> getFirstNode(List<GraphInput> graphElements) {
        return graphElements.stream().filter(i -> i.getType().equals(GraphInputType.NODE)).findFirst();
    }

    private Optional<Coordinate> getNextEdge(List<Coordinate> coordinates, Coordinate actualNode) {
        return edgeSearcher(coordinates, actualNode, null, new Coordinate(1, 0));
    }

    private Optional<Coordinate> getNextEdge(List<Coordinate> coordinates, Coordinate actualNode, Coordinate actualEdge) {
        return edgeSearcher(coordinates, actualNode, actualEdge, new Coordinate(1, 0));
    }

    // Busca las cuatro variaciones posibles empezando con (1,0)
    //
    // (1,0)->(0,1)->(-1,0)->(0,-1) esas transiciones la hace esta linea:
    // Coordinate(coordinateDiff.column()*(-1), coordinateDiff.row())
    // y la condicion de corte es el ultimo estado (columna -1)
    private Optional<Coordinate> edgeSearcher(List<Coordinate> coordinates, Coordinate actualNode, Coordinate actualEdge, Coordinate coordinateDiff) {
        final Coordinate newCoordinate = actualNode.plus(coordinateDiff);
        if (coordinates.contains(newCoordinate) && !newCoordinate.equals(actualEdge)) {
            return Optional.of(newCoordinate);
        }
        if (newCoordinate.column() == -1) {
            Optional.empty();
        }
        return edgeSearcher(coordinates, actualNode, actualEdge, new Coordinate(coordinateDiff.column() * (-1), coordinateDiff.row()));
    }

    // Si estas en un arista y venis de un nodo solo podes ir al proximo nodo
    // La posicion de la arista menos el nodo te da la direccion hacia donde esta el proximo nodo
    // le sumas esa direccion a la arista actual y te da el proximo nodo.
    // nNodo = arista + (arista-nodo) = 2arista -nodo
    private Optional<Coordinate> getNextNode(Coordinate actualEdge, Coordinate actualNode) {
        Integer newColumn = 2 * actualEdge.column() - actualNode.column();
        Integer newRow = 2 * actualEdge.row() - actualNode.row();
        if (newRow < 0 || newColumn < 0) {
            return Optional.empty();
        }
        return Optional.of(new Coordinate(newRow, newColumn));
    }
}
