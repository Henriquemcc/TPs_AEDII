/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-12
 */

public class TP01Q13 {
    /**
     * Funcao do metodo: Este metodo eh responsavel por executar o programa.
     *
     * @param args Argumento padrao do metodo main.
     * @return void Nao ha metodo para receber o valor retornado.
     */
    public static void main(String[] args) {
        String dado = "";
        do {
            dado = MyIO.readLine();
            if (!stringEquals(dado, "FIM"))
                MyIO.println(encriptarCiframentoCesar(dado));

        }
        while (!stringEquals(dado, "FIM"));
    }

    /**
     * Funcao do metodo: Este metodo serve para chamar o metodo encriptarCiframentoCesar sem a necessidade de ter que especificar a chave por parametro.
     *
     * @param s A String que sera encriptada.
     * @return String String encriptada resultante do retorno do metodo encriptarCiframentoCesar(String s, int chave).
     */
    public static String encriptarCiframentoCesar(String s) {
        return encriptarCiframentoCesar(s, 3);
    }

    /**
     * Funcao do metodo: Este metodo serve para encriptar a String passada por parametro com a chave passada por parametro, utilizando do metodo encriptarCiframentoCesar(char c, int chave) para realizar a encriptacao de caractere por caractere.
     *
     * @param s     String que sera encriptada.
     * @param chave Chave de encriptacao.
     * @return String String encriptada resultado da encriptacao.
     */
    public static String encriptarCiframentoCesar(String s, int chave) {
        return encriptarCiframentoCesar(s, 3, 0);
    }

    /**
     * Funcao do metodo: Este metodo serve para encriptar a String passada por parametro com a chave passada por parametro, utilizando do metodo encriptarCiframentoCesar(char c, int chave) para realizar a encriptacao de caractere por caractere.
     *
     * @param s       String que sera encriptada.
     * @param chave   Chave de encriptacao.
     * @param posicao Posicao que a partir desta sera andado.
     * @return String String encriptada resultado da encriptacao.
     */
    public static String encriptarCiframentoCesar(String s, int chave, int posicao) {
        String encriptado = "";
        if (posicao < s.length()) {
            encriptado += encriptarCiframentoCesar(s.charAt(posicao), chave);
            encriptado += encriptarCiframentoCesar(s, chave, posicao + 1);
        }

        return encriptado;
    }

    /**
     * Funcao do metodo: Este metodo serve para encriptar o caractere passado por parametro com a chave passada por parametro.
     *
     * @param c     Caractere que sera encriptado.
     * @param chave Chave que sera utilizada para encriptar.
     * @return char Caractere encriptado.
     */
    public static char encriptarCiframentoCesar(char c, int chave) {
        //A variavel encriptado do tipo inteiro recebera a soma da chave com o caractere c transfromado em inteiro.
        int encriptado = chave + ((int) c);
        return (char) encriptado;
    }//fim do metodo encriptarCiframentoCesar

    /**
     * Funcao do metodo: Este metodo serve para verificar se duas strings sao iguais, substituindo o metodo equals da class String nativa da linguagem Java.
     *
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
     *
     * @param s1      String que sera comparada com a s2.
     * @param s2      String que sera comparada com a s1.
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