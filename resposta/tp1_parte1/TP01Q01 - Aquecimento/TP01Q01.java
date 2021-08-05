/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-06
 */
public class TP01Q01 {
    /**
     * Funcao do metodo: Este metodo eh responsavel por executar o programa.
     *
     * @param args Argumento padrao do metodo main.
     * @return void Nao ha metodo para receber o valor retornado.
     */
    public static void main(String[] args) {
        String dado = "";
        /*Este lastro de repeticao DO-WHILE sera responsavel por ler a String digitada e imprimir
        a quantidade de letras maiusculas persentes em cada String. Caso a String digitada for "FIM"
        a condicao if sera responsavel por impedir que seja impresso na tela a quantidade de caracteres
        maiusculos (evitando de dar uma resposta incompativel com o pub.out), e a condicao da repeticao sera
        falsa, termianado o looping.*/
        do {
            dado = MyIO.readLine();
            if (!stringEquals(dado, "FIM"))
                MyIO.println(qtdCaracteresMaiusculos(dado));
        }
        while (!stringEquals(dado, "FIM"));
    }//fim do metodo main

    /**
     * Funcao do metodo: Este metodo eh responsavel por contar a quantidade de caracteres maiusculos presentes na string recebida por parametro, retornando a resposta para o metodo que o chamou.
     *
     * @param s String a qual devera ser contado a quantidade de letras maiusculas.
     * @return int Numero inteiro referente a quantidade de caracteres maiusculos presentes na string enviada por parametro.
     */
    public static int qtdCaracteresMaiusculos(String s) {
        int qtdLetrasMaiusculas = 0;

        /*Contando a quantidade de caracteres maiusculos, utilizando do metodo caractereMaiusculo para verificar se
        o caractere eh maiusculo.*/
        for (int i = 0; i < s.length(); i++)
            if (caractereEhMaiusculo(s.charAt(i)))
                qtdLetrasMaiusculas++;
        return qtdLetrasMaiusculas;
    }//fim do metodo qtdCaracteresMaiusculos

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
}//fim da classe TP01Q01