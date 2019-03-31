package br.com.alura.example.aluraviagem.Util;

import br.com.alura.example.aluraviagem.models.Pacote;

public class DiasUtil {

    public static String diasEmTexto(int dias) {
        if(dias > 1){
            return dias + " dias";
        }
        return dias + " dia";
    }
}
