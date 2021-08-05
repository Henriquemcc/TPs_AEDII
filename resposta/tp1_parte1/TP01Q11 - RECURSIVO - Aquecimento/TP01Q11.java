/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-12
 */

public class TP01Q11 {
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
                MyIO.println(qtdCaracteresMaiusculos(dado));
        }
        while (!stringEquals(dado, "FIM"));
    }

    /**
     * Funcao do metodo: Este metodo eh responsavel por contar a quantidade de caracteres maiusculos presentes na string recebida por parametro, retornando a resposta para o metodo que o chamou.
     *
     * @param s String a qual devera ser contado a quantidade de letras maiusculas.
     * @return int Numero inteiro referente a quantidade de caracteres maiusculos presentes na string enviada por parametro.
     */
    public static int qtdCaracteresMaiusculos(String s) {
        return qtdCaracteresMaiusculos(s, 0);
    }

    /**
     * Funcao do metodo: Este metodo eh responsavel por contar a quantidade de caracteres maiusculos presentes na string recebida por parametro, retornando a resposta para o metodo que o chamou.
     *
     * @param s       String a qual devera ser contado a quantidade de letras maiusculas.
     * @param posicao Posicao que a partir dela sera contado a quantidade de caracteres maiusculos.
     * @return int Numero inteiro referente a quantidade de caracteres maiusculos presentes na string enviada por parametro.
     */
    public static int qtdCaracteresMaiusculos(String s, int posicao) {
        int quantidadeCaracteresMaiusculos = 0;

        //Verificando se ja chegou no final da String
        if (posicao < s.length()) {
            //Verificando se o caractere na atual posicao eh maiusculo
            if (caractereEhMaiusculo(s.charAt(posicao)))
                quantidadeCaracteresMaiusculos += 1;

            quantidadeCaracteresMaiusculos += qtdCaracteresMaiusculos(s, posicao + 1);
        }

        return quantidadeCaracteresMaiusculos;
    }

    /**
     * Funcao do metodo: Este metodo eh responsavel por verificar se o caractere passado por parametro eh maiusculo, retornado um valor booleano.
     *
     * @param c O caractere o qual devera ser verificado se eh ou nao maiusculo.
     * @return boolean Valor booleano relacionado ao fato do caractere ser maiusculo ou nao: true (caso seja maiusculo) ou false (se nao for maiusculo ou se nao for letra).
     */
    public static boolean caractereEhMaiusculo(char c) {
        boolean ehMaiusculo = false;

        //Verificando se o caractere esta dentro do limite das letras A ate Z, incluindo A e Z.
        if (c >= 'A' && c <= 'Z')
            ehMaiusculo = true;
        return ehMaiusculo;
    }//fim do metodo caractereEhMaiusculo

    /**
     * Funcao do metodo: Este metodo serve para verificar se duas strings sao iguais, substituindo o metodo equals da class String nativa da linguagem Java.
     *
     * @param s1 String que sera comparada com a s2.
     * @param s2 String que sera comparada com a s1.
     * @return boolean Valor booleano relacionado ao fato das duas strings serem iguais.
     */
    public static boolean stringEquals(String s1, String s2) {
        boolean ehIgual = false;
        if (s1.length() == s2.length()) {
            ehIgual = stringEquals(s1, s2, 0);
        }
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
            if (s1.charAt(posicao) == s2.charAt(posicao)) {
                ehIgual = stringEquals(s1, s2, posicao + 1);
            } else {
                ehIgual = false;
            }
        }

        return ehIgual;
    }

}