package chess.domain.piece.strategy;

import static chess.domain.piece.DirectionVector.EAST;
import static chess.domain.piece.DirectionVector.NORTH;
import static chess.domain.piece.DirectionVector.SOUTH;
import static chess.domain.piece.DirectionVector.WEST;

import chess.domain.board.Square;
import chess.domain.piece.DirectionVector;
import java.util.ArrayList;
import java.util.List;

public class RookStrategy implements Strategy {

    private static final List<DirectionVector> directions = List.of(NORTH, SOUTH, EAST, WEST);

    @Override
    public List<Square> findRoute(final Square source, final Square destination) {
        final DirectionVector directionVector = findDirectionVector(source, destination);
        return generateRoute(directionVector, source, destination);
    }

    private DirectionVector findDirectionVector(final Square source, final Square destination) {
        final int distanceFile = destination.calculateDistanceFile(source);
        final int distanceRank = destination.calculateDistanceRank(source);
        return directions.stream()
                .filter(directions -> directions.isOnMyWay(distanceFile, distanceRank))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 기물이 움직일 수 있는 경로가 아닙니다."));
    }

    private List<Square> generateRoute(final DirectionVector direction, final Square source, final Square destination) {
        final List<Square> route = new ArrayList<>();
        Square currentSquare = source;
        while (!currentSquare.equals(destination)) {
            currentSquare = currentSquare.next(direction);
            route.add(currentSquare);
        }
        return route;
    }
}
