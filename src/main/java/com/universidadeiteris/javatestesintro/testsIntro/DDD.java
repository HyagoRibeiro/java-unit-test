package com.universidadeiteris.javatestesintro.testsIntro;

import java.util.HashMap;
import java.util.Map;

public class DDD {

    public static String AcharCidadeDDD(String ddd) {
        ValidarDDD(ddd);
        Map<String, String> cidades = ListaDeCidades();
        String cidadeEncontrada = cidades.get(ddd);

        if (cidadeEncontrada == null) {
            return "DDD não encontrado";
        }

        return cidadeEncontrada;
    }

    private static void ValidarDDD(String ddd) {
        VerificarDDDNegativo(ddd);
        VerificarDDDMenorQueDoisCaracteres(ddd);
        VerificarDDDMaiorQueDois(ddd);
    }

    private static void VerificarDDDNegativo(String ddd) {
        if (ConverterParaNumeroInteiro(ddd) < 0) {
            ExceptionDDDInvalido();
        }
    }

    private static void VerificarDDDMenorQueDoisCaracteres(String ddd){
        if (ddd.length() < 2) {
            ExceptionDDDInvalido();
        }
    }

    private static void VerificarDDDMaiorQueDois(String ddd) {
        if (ddd.length() > 2) {
            ExceptionDDDInvalido();
        }
    }

    private static int ConverterParaNumeroInteiro(String ddd) {
        return Integer.parseInt(ddd);
    }

    private static int ExceptionDDDInvalido() {
        throw new IllegalArgumentException("DDD inválido.");
    }

    private static Map<String, String> ListaDeCidades() {
        Map<String, String> cidades = new HashMap<String, String>();
        cidades.put("11", "São Paulo");
        cidades.put("19", "Campinas");
        cidades.put("21", "Rio de Janeiro");
        cidades.put("27", "Vitória");
        cidades.put("31", "Belo Horizonte");
        cidades.put("32", "Juiz de Fora");
        cidades.put("61", "Brasília");
        cidades.put("71", "Salvador");

        return cidades;
    }
}
