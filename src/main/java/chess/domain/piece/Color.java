package chess.domain.piece;

public enum Color {

    BLACK,
    WHITE,
    ;

    public boolean isBlack() {
        return this == BLACK;
    }

    public Color reverse() {
        if (this == BLACK) {
            return WHITE;
        }
        return BLACK;
    }
}
