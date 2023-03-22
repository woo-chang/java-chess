package chess.domain.piece;

import static chess.domain.piece.Color.BLACK;
import static chess.util.SquareFixture.E_FOUR;
import static chess.util.SquareFixture.F_FIVE;
import static chess.util.SquareFixture.G_SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import chess.domain.board.BoardSnapShot;
import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class KingTest {

    @Nested
    class isMovable_메서드는 {

        @Test
        void 경로를_만들_수_없는_칸이면_예외를_던진다() {
            final King king = new King(BLACK);
            final BoardSnapShot boardSnapShot = BoardSnapShot.from(Map.of(E_FOUR, king));

            assertThatIllegalArgumentException()
                    .isThrownBy(() -> king.isMovable(E_FOUR, G_SIX, boardSnapShot))
                    .withMessage("해당 기물이 움직일 수 있는 경로가 아닙니다.");
        }

        @Test
        void 경로를_만들_수_있고_갈_수_있다면_true_반환한다() {
            final King king = new King(BLACK);
            final BoardSnapShot boardSnapShot = BoardSnapShot.from(Map.of(E_FOUR, king));

            assertThat(king.isMovable(E_FOUR, F_FIVE, boardSnapShot)).isTrue();
        }

        @Test
        void 경로를_만들_수_있고_갈_수_없다면_false_반환한다() {
            final King king = new King(BLACK);
            final BoardSnapShot boardSnapShot = BoardSnapShot.from(Map.of(
                    E_FOUR, king,
                    F_FIVE, new Rook(BLACK)
            ));

            assertThat(king.isMovable(E_FOUR, F_FIVE, boardSnapShot)).isFalse();
        }
    }

    @Test
    void 킹은_폰이_아니다() {
        final King king = new King(BLACK);

        assertThat(king.isPawn()).isFalse();
    }
}
