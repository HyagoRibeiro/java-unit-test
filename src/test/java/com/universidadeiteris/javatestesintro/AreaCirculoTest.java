package com.universidadeiteris.javatestesintro;

import com.universidadeiteris.javatestesintro.testsIntro.AreaCirculo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.universidadeiteris.javatestesintro.testsIntro.Media;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

class AreaCirculoTest {

  @ParameterizedTest
  @CsvSource({ "2, 12.5664", "100.64, 31819.3103", "150, 70685.7750" })
  void CalculoTest(Double entrada, String saida) {
    String retorno = AreaCirculo.Calculo(entrada);

    assertThat(retorno).isEqualTo(saida);
  }

  @Test
  void Quando_PassadoZero_Deve_RetornarZero() {
    Double entrada = 0.0;
    String esperado = "0";

    String retorno = AreaCirculo.Calculo(entrada);
    assertThat(retorno).isEqualTo(esperado);
  }

  @ParameterizedTest
  @CsvSource({"-2", "-2.564"})
  void Quando_PassadoValorInvalido_Deve_RetornarExcecao(Double entrada) {
    String mensagemEsperada = "Raio deve ser positivo.";

    assertThatThrownBy(() -> AreaCirculo.Calculo(entrada))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(mensagemEsperada);
  }
}
