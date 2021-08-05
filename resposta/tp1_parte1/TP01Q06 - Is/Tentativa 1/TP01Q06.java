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
                if (contemSoVogais(dado))
                    MyIO.print("SIM ");
                else
                    MyIO.print("NAO ");

                if (contemSoConsoantes(dado))
                    MyIO.print("SIM ");
                else
                    MyIO.print("NAO ");

                if (contemSoNumerosInteiros(dado))
                    MyIO.print("SIM ");
                else
                    MyIO.print("NAO ");

                if (contemSoNumerosReais(dado))
                    MyIO.print("SIM\n");
                else
                    MyIO.print("NAO\n");

            }
        }
        while (!stringEquals(dado, "FIM"));
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se uma String contem somente vogais.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente vogais.
     */
    public static boolean contemSoVogais(String s) {
        boolean contemSomenteVogais = true;
        int i = 0;
        while (contemSomenteVogais && i < s.length()) {
            if (!ehVogal(s.charAt(i)))
                contemSomenteVogais = false;
            i++;
        }
        return contemSomenteVogais;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh uma letra vogal.
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser uma letra vogal.
     */
    public static boolean ehVogal(char c) {
        boolean ehVogal = false;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            ehVogal = true;
        }
        return ehVogal;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se uma String contem somente consoantes.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente consoantes.
     */
    public static boolean contemSoConsoantes(String s) {
        boolean contemSomenteConsoantes = true;
        int i = 0;
        while (contemSomenteConsoantes && i < s.length()) {
            if (ehVogal(s.charAt(i)) || !ehLetra(s.charAt(i)))
                contemSomenteConsoantes = false;
            i++;
        }
        return contemSomenteConsoantes;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se a string contem somente numeros inteiros.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano relacionado ao fato da String conter somente numeros inteiros.
     */
    public static boolean contemSoNumerosInteiros(String s) {
        boolean contemSomenteNumerosInteiros = true;
        int i = 0;
        while (contemSomenteNumerosInteiros && i < s.length()) {
            if (s.charAt(i) == '.' || s.charAt(i) == ',' || ehLetra(s.charAt(i)))
                contemSomenteNumerosInteiros = false;
            i++;
        }
        return contemSomenteNumerosInteiros;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se um caractere eh letra.
     *
     * @param c Caractere que sera verificado.
     * @return Boolean Valor booleano relacionado ao fato do caractere ser uma letra.
     */
    public static boolean ehLetra(char c) {
        boolean ehUmaLetra = false;
        if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
            ehUmaLetra = true;
        return ehUmaLetra;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se a string contem somente numeros reais.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor boleano relativo ao fato da String conter somente numeros reais.
     */
    public static boolean contemSoNumerosReais(String s) {
        boolean contemSomenteNumerosReais = true;

        if (contemVirgula(s)) {
            if (!virgulaPosicaoCorreta(s))
                contemSomenteNumerosReais = false;
            else if (contemMaisDeUmaVirgula(s))
                contemSomenteNumerosReais = false;

        }

        int i = 0;
        while (contemSomenteNumerosReais && i < s.length()) {
            if (ehLetra(s.charAt(i))/*||contemSoNumerosInteiros(""+s.charAt(i))*/)
                contemSomenteNumerosReais = false;
            i++;
        }
        return contemSomenteNumerosReais;
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

    /**
     * Funcao do metodo: Este metodo serve para verificar se a string contem virgula.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor boleano relacionado ao fato de conter ou nao virgula.
     */
    public static boolean contemVirgula(String s) {
        boolean contemSinalVirgula = false;
        int i = 0;
        while ((!contemSinalVirgula) && i < s.length()) {
            if (s.charAt(i) == ',')
                contemSinalVirgula = true;
            i++;
        }
        return contemSinalVirgula;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se a string contem mais de uma virgula.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor booleano realacionado ao fato de conter mais de uma virgula;
     */
    public static boolean contemMaisDeUmaVirgula(String s) {
        int i = 0;
        int qtdVirgula = 0;
        while (qtdVirgula <= 1 && i < s.length()) {
            if (s.charAt(i) == ',')
                qtdVirgula++;
            i++;
        }
        return qtdVirgula <= 1;
    }

    /**
     * Funcao do metodo: Este metodo serve para verificar se a virgula esta na posicao correta de um numero decimal de uma String.
     *
     * @param s String que sera verificada.
     * @return Boolean Valor boleano relacionado ao fato da virgula estar na posicao correta de um numero decimal.
     */
    public static boolean virgulaPosicaoCorreta(String s) {
        boolean virguleEstaNaPosicaoCorreta = true;
        if (s.charAt(0) == ',' || s.charAt(s.length() - 1) == ',')
            virguleEstaNaPosicaoCorreta = false;
        return virguleEstaNaPosicaoCorreta;
    }
}//fim da classe TP01Q06