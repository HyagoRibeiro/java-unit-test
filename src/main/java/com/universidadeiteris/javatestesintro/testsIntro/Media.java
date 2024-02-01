package com.universidadeiteris.javatestesintro.testsIntro;

import java.util.List;
import java.util.Locale;

public class Media {
    public static String Calculo(List<Double> listaNumeros) {
        ValidationNumber(listaNumeros);

        int numeroDeElementos = listaNumeros.size();
        Double somaDeNumeros = SumNumbers(listaNumeros);

        Double resultado = somaDeNumeros / numeroDeElementos;

        return String.format(Locale.US, "%.1f", resultado);
    }

    private static void ValidationNumber(List<Double> listaNumeros) {
        for (Double numero : listaNumeros) {
            if (numero < 0) {
                throw new IllegalArgumentException("Todos os números de entrada devem ser positivos.");
            }
        }
    }

    private static Double SumNumbers(List<Double> listaNumeros) {
        Double somaDeNumeros = 0.0;
        for (Double numero : listaNumeros) {
            somaDeNumeros = somaDeNumeros + numero;
        }
        return somaDeNumeros;
    }
}
