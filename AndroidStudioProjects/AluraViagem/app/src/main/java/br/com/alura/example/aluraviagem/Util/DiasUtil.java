package br.com.alura.example.aluraviagem.Util;

public class DiasUtil {

    public static final String DIAS = " dias";
    public static final String DIA = " dia";

    public static String diasEmTexto(int dias) {
        if(dias > 1){
            return dias + DIAS;
        }
        return dias + DIA;
    }
}
