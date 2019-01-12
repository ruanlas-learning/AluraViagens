package com.example.ruan.aluraviagens.util;

import android.support.annotation.NonNull;

import com.example.ruan.aluraviagens.model.Pacote;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int quantidadeDeDias) {
//        early return => url: http://blog.alura.com.br/quanto-mais-simples-melhor/
        if (quantidadeDeDias > 1){
            return quantidadeDeDias + PLURAL;
        }
        return quantidadeDeDias + SINGULAR;
    }
}
