/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-13
 */
public class TP01Q16 {
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
        return contemSomenteVogais(s, 0);
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se uma String contem somente letras vogais.
     *
     * @param s       String que sera verificada.
     * @param posicao Posicao a qual a partir dela sera caminhada na String.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente letras vogais.
     */
    public static boolean contemSomenteVogais(String s, int posicao) {
        boolean ehVogal = true;
        if (posicao < s.length()) {
            if (ehConsoante(s.charAt(posicao)) || ehNumero(s.charAt(posicao)) || ehVirgula(s.charAt(posicao)) || ehPonto(s.charAt(posicao)) || !ehLetra(s.charAt(posicao)))
                ehVogal = false;
            else
                ehVogal = contemSomenteVogais(s, posicao + 1);
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
        return contemSomenteConsoantes(s, 0);
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s       String que sera verificada.
     * @param posicao Posicao a qual a partir dela sera caminhada na String.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente letras consoantes.
     */
    public static boolean contemSomenteConsoantes(String s, int posicao) {
        boolean ehConsoante = true;
        if (posicao < s.length()) {
            if (ehVogal(s.charAt(posicao)) || ehNumero(s.charAt(posicao)) || ehVirgula(s.charAt(posicao)) || ehPonto(s.charAt(posicao)))
                ehConsoante = false;
            else
                ehConsoante = contemSomenteConsoantes(s, posicao + 1);
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
        return contemSomenteNumeroInteiro(s, 0);
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s       String que sera verificada.
     * @param posicao Posicao a qual a partir dela sera caminhada na String.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente numeros inteiros.
     */
    public static boolean contemSomenteNumeroInteiro(String s, int posicao) {
        boolean ehNumeroInteiro = true;
        if (posicao < s.length()) {
            if (ehPonto(s.charAt(posicao)) || ehVirgula(s.charAt(posicao)) || ehLetra(s.charAt(posicao)))
                ehNumeroInteiro = false;
            else
                ehNumeroInteiro = contemSomenteNumeroInteiro(s, posicao + 1);
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
        return contemSomenteNumeroRealVerificacaoCaracteresSaoNumerosPontoOuVirgula(s) && quantidadePontos(s) <= 1 && quantidadeVirgulas(s) <= 1;
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente numeros reais(incluindo ponto e virgula).
     */
    public static boolean contemSomenteNumeroRealVerificacaoCaracteresSaoNumerosPontoOuVirgula(String s) {
        return contemSomenteNumeroRealVerificacaoCaracteresSaoNumerosPontoOuVirgula(s, 0);
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s       String que sera verificada.
     * @param posicao Posicao a qual a partir dela sera caminhada na String.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente numeros reais(incluindo ponto e virgula).
     */
    public static boolean contemSomenteNumeroRealVerificacaoCaracteresSaoNumerosPontoOuVirgula(String s, int posicao) {
        boolean ehNumeroReal = true;
        if (posicao < s.length()) {
            if (ehLetra(s.charAt(posicao)))
                ehNumeroReal = false;
            else
                ehNumeroReal = contemSomenteNumeroRealVerificacaoCaracteresSaoNumerosPontoOuVirgula(s, posicao + 1);
        }
        return ehNumeroReal;
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s String que sera verificada.
     * @return int Valor inteiro relacionado a quantidade de virgulas contidas na String.
     */
    public static int quantidadeVirgulas(String s) {
        return quantidadeVirgulas(s, 0);
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s       String que sera verificada.
     * @param posicao Posicao a qual a partir dela sera caminhada na String.
     * @return int Valor inteiro relacionado a quantidade de virgulas na String.
     */
    public static int quantidadeVirgulas(String s, int posicao) {
        int qtdVirgulas = 0;
        if (posicao < s.length()) {
            if (ehVirgula(s.charAt(posicao)))
                qtdVirgulas++;
            qtdVirgulas += quantidadeVirgulas(s, posicao + 1);
        }
        return qtdVirgulas;
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s String que sera verificada.
     * @return int Valor inteiro relacionado a quantidade de pontos na String.
     */
    public static int quantidadePontos(String s) {
        return quantidadePontos(s, 0);
    }

    /**
     * Funcao do metodo: Este metodo serve para
     *
     * @param s       String que sera verificada.
     * @param posicao Posicao a qual a partir dela sera caminhada na String.
     * @return int Valor inteiro relacionado a quantidade de pontos na String.
     */
    public static int quantidadePontos(String s, int posicao) {
        int qtdPontos = 0;
        if (posicao < s.length()) {
            if (ehPonto(s.charAt(posicao)))
                qtdPontos++;
            qtdPontos += quantidadePontos(s, posicao + 1);
        }
        return qtdPontos;
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