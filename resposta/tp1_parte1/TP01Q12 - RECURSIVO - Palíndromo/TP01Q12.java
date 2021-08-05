/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-12
 */

public class TP01Q12 {
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
                if (ehPalindromo(dado))
                    MyIO.println("SIM");
                else
                    MyIO.println("NAO");
        }
        while (!stringEquals(dado, "FIM"));
    }

    /**
     * Funcao do metodo: Este metodo eh responsavel por verificar se a string passada por parametro eh palindromo, retornando um valor booleano.
     *
     * @param s String que sera analisada se eh ou nao palindromo.
     * @return boolean Valor booleano indicando se eh ou nao palindromo.
     */
    public static boolean ehPalindromo(String s) {
        return ehPalindromo(s, 0, s.length() - 1);
    }

    /**
     * Funcao do metodo: Este metodo eh responsavel por verificar se a string passada por parametro eh palindromo, retornando um valor booleano.
     *
     * @param s                String que sera analisada se eh ou nao palindromo.
     * @param cabecoteEsquerdo A posicao a partir da qual o cabecote esquerdo vai deslocar.
     * @param cabecoteDireito  A posicao a partir da qual o cabecote direito vai deslocar.
     * @return boolean Valor booleano indicando se eh ou nao palindromo.
     */
    public static boolean ehPalindromo(String s, int cabecoteEsquerdo, int cabecoteDireito) {
        boolean ehPalindromoSim = true;
        if (cabecoteEsquerdo < cabecoteDireito)
            if (s.charAt(cabecoteEsquerdo) == s.charAt(cabecoteDireito))
                ehPalindromoSim = ehPalindromo(s, cabecoteEsquerdo + 1, cabecoteDireito - 1);
            else
                ehPalindromoSim = false;

        return ehPalindromoSim;
    }

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