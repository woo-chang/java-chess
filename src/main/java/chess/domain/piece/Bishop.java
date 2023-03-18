package chess.domain.piece;

import static chess.domain.piece.DirectionVector.NORTHEAST;
import static chess.domain.piece.DirectionVector.NORTHWEST;
import static chess.domain.piece.DirectionVector.SOUTHEAST;
import static chess.domain.piece.DirectionVector.SOUTHWEST;

import chess.domain.board.Square;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    private static final List<DirectionVector> directions = List.of(NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST);

    public Bishop(final Color color) {
        super(color);
    }

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

    @Override
    public boolean isPawn() {
        return false;
    }
}
