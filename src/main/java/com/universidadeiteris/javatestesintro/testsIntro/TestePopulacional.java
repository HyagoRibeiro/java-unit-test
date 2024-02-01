package com.universidadeiteris.javatestesintro.testsIntro;

public class TestePopulacional {
    public static String CalcularAnosParaAPassarB(
            int populacaoA,
            double crescimentoA,
            int populacaoB,
            double crescimentoB
            ) {

        validarPopulacaoNegativa(populacaoA, populacaoB);
        validarPopulacaoAMaior(populacaoA, populacaoB);
        validarCrescimentoPopulacao(crescimentoA, crescimentoB);

        int ano = 0;

        while (populacaoA <= populacaoB) {
            populacaoA += (int) (populacaoA * (crescimentoA/100));
            populacaoB += (int) (populacaoB * (crescimentoB/100));
            ano++;

            if (ano > 100){
                return "Mais de 1 século.";
            }
        }

        return ano + " anos.";
    }

    private static void validarPopulacaoNegativa(int populacaoA, int populacaoB) {
        if(populacaoA < 0 || populacaoB < 0) {
            throw new IllegalArgumentException("População não pode ser negativa.");
        }
    }

    private static void validarPopulacaoAMaior(int populacaoA, int populacaoB) {
        if(populacaoA > populacaoB) {
            throw new IllegalArgumentException("População da cidade A já é maior.");
        }
    }

    private static void validarCrescimentoPopulacao(double crescimentoA, double crescimentoB) {
        if(crescimentoA <= crescimentoB) {
            throw new IllegalArgumentException("Cidade A nunca terá uma população maior que a cidade B.");
        }
    }
}
