package chess.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class KnightVectorTest {

    @ParameterizedTest
    @CsvSource(value = {"-1:2:true", "-2:2:false"}, delimiter = ':')
    void 이동_가능한_벡터가_존재하는지_확인한다(final int x, final int y, final boolean expected) {
        assertThat(KnightVector.isExistMovableVector(x, y)).isEqualTo(expected);
    }
}
