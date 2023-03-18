package chess.domain.piece.strategy;

import chess.domain.board.Square;
import chess.domain.piece.KnightVector;
import java.util.ArrayList;
import java.util.List;

public class KnightStrategy implements Strategy {

    @Override
    public List<Square> findRoute(final Square source, final Square destination) {
        final int distanceFile = destination.calculateDistanceFile(source);
        final int distanceRank = destination.calculateDistanceRank(source);
        if (!KnightVector.isExistMovableVector(distanceFile, distanceRank)) {
            throw new IllegalArgumentException("해당 기물이 움직일 수 있는 경로가 아닙니다.");
        }
        return new ArrayList<>(List.of(destination));
    }
}
