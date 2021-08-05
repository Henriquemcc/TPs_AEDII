/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-07
 */

import java.util.Random;

public class TP01Q04 {
    /**
     * Funcao do metodo: Este metodo eh responsavel por executar o programa.
     * @param args Argumento padrao do metodo main.
     * @return void Nao ha metodo para receber o valor retornado.
     */
    public static void main(String[] args) {
        Random aleatorio = new Random();
        aleatorio.setSeed(4);
        String dado = "";
        do {
            dado = MyIO.readLine();
            if (!stringEquals(dado, "FIM"))
                MyIO.println(alteracaoAleatoria(aleatorio, dado));

        }
        while (!stringEquals(dado, "FIM"));
    }

    /**
     * Funcao do metodo: Este metodo serve para alterar aleatoriamente uma string passada por parametro.
     * @param aleatorio Um objeto do tipo Random que será utlizado para escolher os caracteres a serem adicionados e removidos.
     * @param s String que sera alterada.
     * @return String A string modificada.
     */
    public static String alteracaoAleatoria(Random aleatorio, String s) {
        char caractereRemovido = (char) ('a' + (Math.abs(aleatorio.nextInt()) % 26));
        char caractereAdicionado = (char) ('a' + (Math.abs(aleatorio.nextInt()) % 26));
        String stringAlterada = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == caractereRemovido)
                stringAlterada += caractereAdicionado;
            else
                stringAlterada += s.charAt(i);
        }
        return stringAlterada;
    }//fim do metodo alteracaoAleatoria

    /**
     * Funcao do metodo: Este metodo serve para verificar se duas strings sao iguais, substituindo o metodo equals da class String nativa da linguagem Java.
     * @param s1 String que sera comparada com a s2.
     * @param s2 String que sera comparada com a s1.
     * @return boolean Valor booleano relacionado ao fato das duas strings serem iguais.
     */
    public static boolean stringEquals(String s1, String s2) {
        boolean ehIgual = false;
        
        /*Verificando se ambas strings possuem a mesma quantidade de caracteres.
        Caso elas não possuam a mesma quantidade de caracteres, essa condicao evitara ter que percorrer
        a string inutilmente.*/
        if (s1.length() == s2.length()) {
            /*Comparando caractere por caractere da string. Caso haja caracteres diferentes, a variavel booleana
            fimComparacao finalizara com a comparacao obtendo o resultado correto e evitando ter que percorrer o restante da string.*/
            int i = 0;
            boolean fimComparacao = false;
            while ((!fimComparacao) && (i < s1.length())) {
                if (s1.charAt(i) == s2.charAt(i))
                    ehIgual = true;
                else {
                    ehIgual = false;
                    fimComparacao = true;
                }

                i++;
            }
        }
        return ehIgual;
    }//fim do metodo stringEquals
}//fim da classe TP01Q04