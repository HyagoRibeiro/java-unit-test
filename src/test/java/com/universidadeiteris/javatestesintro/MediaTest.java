package com.universidadeiteris.javatestesintro;

import com.universidadeiteris.javatestesintro.testsIntro.AreaCirculo;
import com.universidadeiteris.javatestesintro.testsIntro.Media;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MediaTest {
    @ParameterizedTest
    @CsvSource({"'10,10', '10.0'", "'10,10,10', '10.0'", "'4,23,33', '20.0'", "'45,27', '36.0'"})
    void Calculo_Teste(String entrada, String saidaEsperada) {
        List<Double> numeros = converteStringParaLista(entrada);
        String retorno = Media.Calculo(numeros);
        assertThat(retorno).isEqualTo(saidaEsperada);
    }

    private List<Double> converteStringParaLista(String entrada) {
        String[] partes = entrada.split(",");
        List<Double> numeros = new ArrayList<>();

        for (String parte : partes) {
            numeros.add(Double.parseDouble(parte));
        }

        return numeros;
    }

    @ParameterizedTest
    @CsvSource({"'-10,10'", "'-10,10,-10'", "'-4,-23,-33'", "'-45,-27'"})
    void Quando_Passar_NumeroNegativo_Deve_Retornar_Excessao(String entrada) {
        String mensagemEsperada = "Todos os números de entrada devem ser positivos.";

        assertThatThrownBy(() -> Media.Calculo(converteStringParaLista(entrada)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }
}
