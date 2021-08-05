/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-07
 */
public class TP01Q02 {
    /**
     * Funcao do metodo: Este metodo eh responsavel por executar o programa.
     *
     * @param args Argumento padrao do metodo main.
     * @return void Nao ha metodo para receber o valor retornado.
     */
    public static void main(String[] args) {
        String dado = "";
        /*Este lastro de repeticao sera responsavel por repetir a leitura e a escrita (nas suas respectivas entrada/saida padrao) da resposta
        de se eh ou nao palindromo. Caso aparece na String dado o valor "FIM" o primeiro if sera responsavel por impedir que seja verificado se eh ou nao
        palindromo, impedindo tambem a escrita de SIM ou NAO.*/
        do {
            dado = MyIO.readLine();
            if (!stringEquals(dado, "FIM"))
                if (ehPalindromo(dado))
                    MyIO.println("SIM");
                else
                    MyIO.println("NAO");
        }
        while (!stringEquals(dado, "FIM"));
    }//fim do metodo main

    /**
     * Funcao do metodo: Este metodo eh responsavel por verificar se a string passada por parametro eh palindromo, retornando um valor booleano.
     *
     * @param s String que sera analisada se eh ou nao palindromo.
     * @return boolean Valor booleano indicando se eh ou nao palindromo.
     */
    public static boolean ehPalindromo(String s) {
        boolean ehPalindromoSim = true;
        int i = 0;

        /*Verificando se a string passada por parametro eh ou nao palindromo.
        Quando em uma comparacao for descoberto que os caracteres sao diferentes, a variavel booleana ehPalindromoSim
        tornara falsa e isso terminara a comparacao, evitando de chegar ao resultado errado e continuar comparando inutilmente a string.*/
        while (ehPalindromoSim && i <= s.length() / 2) {
            int cabecoteEsquerdo = i;
            int cabecoteDireito = s.length() - 1 - i;
            if (s.charAt(cabecoteEsquerdo) != s.charAt(cabecoteDireito))
                ehPalindromoSim = false;
            i++;
        }
        return ehPalindromoSim;

    }//fim do metodo ehPalindromo

    /**
     * Funcao do metodo: Este metodo serve para verificar se duas strings sao iguais, substituindo o metodo equals da class String nativa da linguagem Java.
     *
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
}//fim da classe TP01Q02