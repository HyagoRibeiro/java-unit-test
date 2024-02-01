package com.universidadeiteris.javatestesintro;

import com.universidadeiteris.javatestesintro.testsIntro.Salario;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioTest {

    @ParameterizedTest
    @CsvSource(
            { "500, 1230.3, 684.55", "700, 150, 722.50", "1700, 1230.5, 1884.58" }
    )
    void Quando_PassadoValoresValidos_Deve_RetornarSalarioComBonus(
            Double salario,
            Double vendas,
            String esperado
    ) {
        String retorno = Salario.salarioComBonus(salario, vendas);

        assertThat(retorno).isEqualTo(esperado);
    }

    @ParameterizedTest
    @CsvSource({ "500, 0, 500.00", "700, 0, 700.00", "1700, 0, 1700.00" })
    void Quando_PassadoVendasZeradas_Deve_RetornarSalarioSemBonus(
            Double salario,
            Double vendas,
            String esperado
    ) {
        String retorno = Salario.salarioComBonus(salario, vendas);

        assertThat(retorno).isEqualTo(esperado);
    }

    @ParameterizedTest
    @CsvSource({ "500, -52564.45", "700, -1", "1700, -0.99" })
    void Quando_PassadoVendasInvalidas_Deve_RetornarExcecaoVendas(
            Double salario,
            Double vendas
    ) {
        String mensagemEsperada = "Vendas não podem ser negativas";

        assertThatThrownBy(() -> Salario.salarioComBonus(salario, vendas))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }

    @ParameterizedTest
    @CsvSource({ "-700, 1230.3", "0, 0", "499.999, 1230.5" })
    void Quando_PassadoSalarioInvalido_Deve_RetornarExcecaoSalario(
            Double salario,
            Double vendas
    ) {
        String mensagemEsperada = "Salário deve ser válido, acima do piso de 500";

        assertThatThrownBy(() -> Salario.salarioComBonus(salario, vendas))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(mensagemEsperada);
    }
}
