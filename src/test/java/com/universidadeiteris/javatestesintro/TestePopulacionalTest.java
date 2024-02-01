package com.universidadeiteris.javatestesintro;

import com.universidadeiteris.javatestesintro.testsIntro.Tautograma;
import com.universidadeiteris.javatestesintro.testsIntro.TestePopulacional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestePopulacionalTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "-100, 150, 1.0, 1.2",
                    "100, -150, 1.0, 1.2",
                    "-100, -150, 1.0, 1.2"
            }
    )
    void Quando_ValorNegativo_Deve_RetornarExceoption(
            String populacaoA,
            String populacaoB,
            String crescimetoA,
            String crescimentoB
    ) {
        String mensagemEsperada = "População não pode ser negativa.";

        assertThatThrownBy(() -> TestePopulacional.CalcularAnosParaAPassarB(
                Integer.parseInt(populacaoA),
                Double.parseDouble(crescimetoA),
                Integer.parseInt(populacaoB),
                Double.parseDouble(crescimentoB)
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    "151, 150, 1.0, 1.2",
                    "1100, 150, 1.0, 1.2",
                    "100, 0, 1.0, 1.2"
            }
    )
    void Quando_AForMaiorOuIgualAB_Deve_RetornarExceoption(
            String populacaoA,
            String populacaoB,
            String crescimetoA,
            String crescimentoB
    ) {
        String mensagemEsperada = "População da cidade A já é maior.";

        assertThatThrownBy(() -> TestePopulacional.CalcularAnosParaAPassarB(
                Integer.parseInt(populacaoA),
                Double.parseDouble(crescimetoA),
                Integer.parseInt(populacaoB),
                Double.parseDouble(crescimentoB)
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "100, 150, 1.0, 1.2",
                    "149, 150, 1.0, 1.2",
                    "0, 0, 1.0, 1.2"
            }
    )
    void Quando_PorcentagemAForMenorOuIgualB_Deve_RetornarExceoption(
            String populacaoA,
            String populacaoB,
            String crescimetoA,
            String crescimentoB
    ) {
        String mensagemEsperada = "Cidade A nunca terá uma população maior que a cidade B.";

        assertThatThrownBy(() -> TestePopulacional.CalcularAnosParaAPassarB(
                Integer.parseInt(populacaoA),
                Double.parseDouble(crescimetoA),
                Integer.parseInt(populacaoB),
                Double.parseDouble(crescimentoB)
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }


    @ParameterizedTest
    @CsvSource(
            {
                    "100, 150, 1.0, 0, 51 anos.",
                    "90000, 120000, 5.5, 3.5, 16 anos.",
                    "56700, 72000, 5.2, 3.0, 12 anos.",
                    "123, 2000, 3.0, 2.0, Mais de 1 século.",
                    "100000, 110000, 1.5, 0.5, 10 anos.",
                    "62422, 484317, 3.1, 1.0, 100 anos.",
                    "100, 150, 4.5, 4.0, 95 anos.",
            }
    )
    void Quando_DadosValidos_Deve_RetornarQuantosAnosFaltam(
            String populacaoA,
            String populacaoB,
            String crescimetoA,
            String crescimentoB,
            String saidaEsperada
    ) {

        var resposta = TestePopulacional.CalcularAnosParaAPassarB(
                Integer.parseInt(populacaoA),
                Double.parseDouble(crescimetoA),
                Integer.parseInt(populacaoB),
                Double.parseDouble(crescimentoB)
        );

        assertThat(resposta).isEqualTo(saidaEsperada);
    }


}
