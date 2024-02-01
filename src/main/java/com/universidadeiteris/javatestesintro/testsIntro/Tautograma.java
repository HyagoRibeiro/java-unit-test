package com.universidadeiteris.javatestesintro.testsIntro;

public class Tautograma {

    public static String ValidaTautograma(String frase) {
        if (frase == null || frase.isEmpty()) {
            ExceptionFraseInvalida();
        }

        frase = frase.toLowerCase();

        String[] palavras = frase.split(" ");

        if(palavras.length < 2) {
            ExceptionFraseInvalida();
        }

        char primeirLetra = palavras[0].charAt(0);
        for (String palavra : palavras) {
            if(palavra.charAt(0) != primeirLetra) {
                return "N";
            }
        }
        return "S";
    }

    private static void ExceptionFraseInvalida() {
        throw new IllegalArgumentException("Frase inválida.");
    }
}
