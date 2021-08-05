/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-13
 */
public class TP01Q06 {
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
            if (!stringEquals(dado, "FIM")) {
                if (contemSomenteVogais(dado))
                    MyIO.print("SIM ");
                else
                    MyIO.print("NAO ");

                if (contemSomenteConsoantes(dado))
                    MyIO.print("SIM ");
                else
                    MyIO.print("NAO ");

                if (contemSomenteNumeroInteiro(dado))
                    MyIO.print("SIM ");
                else
                    MyIO.print("NAO ");

                if (contemSomenteNumeroReal(dado))
                    MyIO.print("SIM\n");
                else
                    MyIO.print("NAO\n");

            }

        }
        while (!stringEquals(dado, "FIM"));
    }

    /*Metodos pedidos pelo enunciado:*/

    /**
     * Funcao do metodo: Este metodo serve para verificar se uma String contem somente letras vogais.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano relacionado ao fato de conter somente letras vogais.
     */
    public static boolean contemSomenteVogais(String s) {
        boolean ehVogal = true;

        //Verificando se contem consoante, numero, virgula ou ponto
        int i = 0;
        while (ehVogal && i < s.length()) {
            if (ehConsoante(s.charAt(i)) || ehNumero(s.charAt(i)) || ehVirgula(s.charAt(i)) || ehPonto(s.charAt(i)) || !ehLetra(s.charAt(i)))
                ehVogal = false;
            i++;
        }
        return ehVogal;

    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se uma String contem somente letras consoantes.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente letras consoantes.
     */
    public static boolean contemSomenteConsoantes(String s) {
        boolean ehConsoante = true;

        //Verificando se contem vogal, numero, virgula ou ponto
        int i = 0;
        while (ehConsoante && i < s.length()) {
            if (ehVogal(s.charAt(i)) || ehNumero(s.charAt(i)) || ehVirgula(s.charAt(i)) || ehPonto(s.charAt(i)))
                ehConsoante = false;
            i++;
        }
        return ehConsoante;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se uma String contem somente numeros inteiros.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente numeros inteiros.
     */
    public static boolean contemSomenteNumeroInteiro(String s) {
        boolean ehNumeroInteiro = true;

        //Verificando se contem ponto, virgula ou letra
        int i = 0;
        while (ehNumeroInteiro && i < s.length()) {
            if (ehPonto(s.charAt(i)) || ehVirgula(s.charAt(i)) || ehLetra(s.charAt(i)))
                ehNumeroInteiro = false;
            i++;
        }
        return ehNumeroInteiro;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se uma String contem somente numeros reais.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor Booleano relacionado ao fato da String conter somente numeros reais.
     */
    public static boolean contemSomenteNumeroReal(String s) {
        boolean ehNumeroReal = true;

        //Verificando se todos os caracteres sao numeros ponto ou virgula:
        int i = 0;
        while (ehNumeroReal && i < s.length()) {
            if (ehLetra(s.charAt(i)))
                ehNumeroReal = false;
            i++;
        }

        //Verificando se tem mais de um ponto ou mais de uma virgula
        i = 0;
        boolean pontoEncontrado = false;
        boolean virgulaEncontrada = false;
        while (ehNumeroReal && i < s.length()) {
            if (ehVirgula(s.charAt(i)) && !virgulaEncontrada)
                virgulaEncontrada = true;
            else if (ehVirgula(s.charAt(i)) && virgulaEncontrada)
                ehNumeroReal = false;
            else if (ehPonto(s.charAt(i)) && !pontoEncontrado)
                pontoEncontrado = true;
            else if (ehPonto(s.charAt(i)) && pontoEncontrado)
                ehNumeroReal = false;
            i++;
        }

        return ehNumeroReal;
    }

    /*Metodos de checagem de caracteres:*/

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh uma letra consoante.
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser uma letra consoante.
     */
    public static boolean ehConsoante(char c) {
        boolean ehConsoanteSim = false;
        if (ehLetra(c) && (!ehVogal(c)))
            ehConsoanteSim = true;
        return ehConsoanteSim;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh uma letra vogal.
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser uma letra vogal.
     */
    public static boolean ehVogal(char c) {
        boolean ehVogalSim = false;
        if (c == 'a' || c == 'e' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            ehVogalSim = true;
        return ehVogalSim;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh uma letra.
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser uma letra.
     */
    public static boolean ehLetra(char c) {
        boolean ehLetraSim = false;
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            ehLetraSim = true;
        return ehLetraSim;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser um numero.
     */
    public static boolean ehNumero(char c) {
        boolean ehNumeroSim = false;
        if (c >= '0' && c <= '9')
            ehNumeroSim = true;
        return ehNumeroSim;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser uma virgula.
     */
    public static boolean ehVirgula(char c) {
        boolean ehVirgulaSim = false;
        if (c == ',')
            ehVirgulaSim = true;
        return ehVirgulaSim;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser um ponto.
     */
    public static boolean ehPonto(char c) {
        boolean ehPontoSim = false;
        if (c == '.')
            ehPontoSim = true;
        return ehPontoSim;
    }

    /*Outros metodos:*/

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

}