package com.universidadeiteris.javatestesintro;

import com.universidadeiteris.javatestesintro.testsIntro.Tautograma;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TautogramaTest {
    @ParameterizedTest
    @CsvSource(
            {
                "Palavra,",
                ",",
                "' '",
                "''",
            }
    )
    void Quando_FraseInvalida_Deve_RetornarException(String entrada) {
        String mensagemEsperada = "Frase inválida.";

        assertThatThrownBy(() -> Tautograma.ValidaTautograma(entrada))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }

    @ParameterizedTest
    @CsvSource(
            {
                "Flowers Flourish from France, S",
                "Sam Simmonds speaks softly, S",
                "Peter pIckEd pePPers, S",
                "truly tautograms triumph, S",
                "Isso não é um Tautograma, N",
            }
    )
    void Quando_FraseValida_RetornaSOuN(String entrada, String saidaEsperada) {
        String resposta = Tautograma.ValidaTautograma(entrada);

        assertThat(resposta).isEqualTo(saidaEsperada);
    }
}
