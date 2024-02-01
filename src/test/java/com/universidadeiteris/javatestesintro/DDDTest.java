package com.universidadeiteris.javatestesintro;

import com.universidadeiteris.javatestesintro.testsIntro.DDD;
import com.universidadeiteris.javatestesintro.testsIntro.Salario;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DDDTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "-11",
                    "-1",
                    "0",
                    "9",
                    "100"
            }
    )
    void Quando_PassadoDDDInvalido_Deve_RetornarException(String entrada) {
        String mensagemEsperada = "DDD inválido.";

        assertThatThrownBy(() -> DDD.AcharCidadeDDD(entrada))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }

    @ParameterizedTest
    @CsvSource(
            {
                "11,  São Paulo",
                "19, Campinas",
                "21, Rio de Janeiro",
                "27, Vitória",
                "31, Belo Horizonte",
                "32, Juiz de Fora",
                "61, Brasília",
                "71, Salvador",
            }
    )
    void Quando_PassarDDDValido_Deve_RetornarACidade(String entrada, String saidaEsperada) {
        String resultado = DDD.AcharCidadeDDD(entrada);
        assertThat(resultado).isEqualTo(saidaEsperada);
    }


    @ParameterizedTest
    @CsvSource(
            {
                "12",
                "13",
                "22",
                "23",
                "54"
            }
    )
    void Quando_NaoEncontrarDDD_Deve_RetornarNaoEncontrado(String entrada) {
        String mensagemEsperada = "DDD não encontrado";
        String resultado = DDD.AcharCidadeDDD(entrada);
        assertThat(resultado).isEqualTo(mensagemEsperada);
    }
}
