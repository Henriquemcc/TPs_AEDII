/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-12
 */

import java.util.Random;

public class TP01Q14 {
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
        return alteracaoAleatoria(s, 0, caractereRemovido, caractereAdicionado);
    }

    /**
     * Funcao do metodo: Este metodo serve para alterar aleatoriamente uma string passada por parametro.
     * @param aleatorio Um objeto do tipo Random que será utlizado para escolher os caracteres a serem adicionados e removidos.
     * @param s String que sera alterada.
     * @param posicao A posicao que a partir desta sera percorrida.
     * @param caractereRemovido O caractere que sera removido.
     * @param caractereAdicionado O caractere que sera colocado no lugar do caractere que foi removido.
     * @return String A string modificada.
     */
    public static String alteracaoAleatoria(String s, int posicao, char caractereRemovido, char caractereAdicionado) {
        String stringAlterada = "";
        if (posicao < s.length()) {
            if (s.charAt(posicao) == caractereRemovido)
                stringAlterada += caractereAdicionado;
            else
                stringAlterada += s.charAt(posicao);

            stringAlterada += alteracaoAleatoria(s, posicao + 1, caractereRemovido, caractereAdicionado);
        }
        return stringAlterada;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se duas strings sao iguais, substituindo o metodo equals da class String nativa da linguagem Java.
     * @param s1 String que sera comparada com a s2.
     * @param s2 String que sera comparada com a s1.
     * @return boolean Valor booleano relacionado ao fato das duas strings serem iguais.
     */
    public static boolean stringEquals(String s1, String s2) {
        boolean ehIgual = false;
        if (s1.length() == s2.length())
            ehIgual = stringEquals(s1, s2, 0);

        return ehIgual;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se duas strings sao iguais, substituindo o metodo equals da class String nativa da linguagem Java.
     * @param s1 String que sera comparada com a s2.
     * @param s2 String que sera comparada com a s1.
     * @param posicao A posicao que comecara a verificar se os caracteres sao iguais.
     * @return boolean Valor booleano relacionado ao fato das duas strings serem iguais.
     */
    public static boolean stringEquals(String s1, String s2, int posicao) {
        boolean ehIgual = true;

        //Verificando se a posicao atual eh menor que s1.length
        if (posicao < s1.length()) {
            //Verificando se os caracteres da posicao atual sao iguais
            if (s1.charAt(posicao) == s2.charAt(posicao))
                ehIgual = stringEquals(s1, s2, posicao + 1);
            else
                ehIgual = false;
        }

        return ehIgual;
    }
}