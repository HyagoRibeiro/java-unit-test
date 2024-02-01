package com.universidadeiteris.javatestesintro.testsIntro;

import java.util.Locale;

public class Salario {

    public static String salarioComBonus(Double salario, Double vendas) {
        validarSalario(salario);
        verificaVendasInvalidas(vendas);
        if (verificaSeVendasZerada(vendas)) {
            return String.format(Locale.US, "%.2f", salario);
        }
        Double bonus = calculaBonus(vendas);
        var salarioComBonus = salario + bonus;
        return String.format(Locale.US, "%.2f", salarioComBonus);
    }

    public static void validarSalario(Double salario) {
        if (salario < 500) {
            throw new IllegalArgumentException("Salário deve ser válido, acima do piso de 500");
        }
    }

    public static void verificaVendasInvalidas(Double vendas) {
        if (vendas < 0) {
            throw new IllegalArgumentException("Vendas não podem ser negativas");
        }
    }

    public static boolean verificaSeVendasZerada(Double vendas) {
        return vendas == 0;
    }

    public static Double calculaBonus(Double vendas) {
        Double porcentagemComissao = 0.15;
        return vendas * porcentagemComissao;
    }

}