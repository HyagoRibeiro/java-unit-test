package com.universidadeiteris.javatestesintro.testsIntro;

import java.util.Locale;

public class AreaCirculo {
  
  private static final Double PI = 3.14159;

  public static String Calculo(double raio)
        {
            if (raio == 0) {
                return "0";
            }
            if (raio < 0) {
                throw new IllegalArgumentException("Raio deve ser positivo.");
            }

            Double resultado = PI * Math.pow(raio, 2);
            //Formata o valor de 'resultado' para conter 4 casas decimais e converte de Double para String
            return String.format(Locale.US, "%.4f", resultado);
        }
}
