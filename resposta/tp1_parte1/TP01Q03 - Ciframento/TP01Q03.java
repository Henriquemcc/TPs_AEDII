/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-07
 */
public class TP01Q03 {
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
    }//fim do metodo main

    /**
     * Funcao do metodo: Este metodo serve para chamar o metodo encriptarCiframentoCesar sem a necessidade de ter que especificar a chave por parametro.
     *
     * @param s A String que sera encriptada.
     * @return String String encriptada resultante do retorno do metodo encriptarCiframentoCesar(String s, int chave).
     */
    public static String encriptarCiframentoCesar(String s) {
        return encriptarCiframentoCesar(s, 3);
    }//fim do metodo encriptarCiframentoCesar

    /**
     * Funcao do metodo: Este metodo serve para encriptar a String passada por parametro com a chave passada por parametro, utilizando do metodo encriptarCiframentoCesar(char c, int chave) para realizar a encriptacao de caractere por caractere.
     *
     * @param s     String que sera encriptada.
     * @param chave Chave de encriptacao.
     * @return String String encriptada resultado da encriptacao.
     */
    public static String encriptarCiframentoCesar(String s, int chave) {
        String encriptado = "";

        /*Este lastro de repeticao sera responsavel por chamar o metodo encriptarCiframentoCesar(char c, int chave) para cada caractere da String,
        alem de juntar todos os caracteres encriptados na String encriptado.*/
        for (int i = 0; i < s.length(); i++) {
            encriptado += encriptarCiframentoCesar(s.charAt(i), chave);
        }
        return encriptado;
    }//fim do metodo encriptarCiframentoCesar

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
                else
                    ehIgual = false;
                fimComparacao = true;
                i++;
            }

        }
        return ehIgual;
    }//fim do metodo stringEquals
}//fim da classe  TP01Q03