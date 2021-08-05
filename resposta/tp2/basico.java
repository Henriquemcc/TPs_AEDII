import java.io.File;
import java.time.*;
import java.util.Scanner;

/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-20
 */

class Utilitarios {
    /**
     * Funcao do metodo: Este metodo serve para verificar se o caractere passado por parametro eh numero.
     *
     * @param c Caractere que sera verificado.
     * @return Valor booleano indicando se o caractere eh numero.
     */
    public static boolean ehNumero(char c) {
        boolean ehNumero = false;
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
            ehNumero = true;
        return ehNumero;
    }//fim do metodo ehNumero

}//fim da classe Utilitarios

class Presidente {
    //Atributos
    private int id;
    private String nome;
    private int idade;
    private LocalDateTime dataNascimento;
    private String localNascimento;
    private LocalDateTime inicioMandato;
    private LocalDateTime fimMandato;
    private LocalDateTime dataMorte;
    private String localMorte;
    private String antecessor;
    private String sucessor;
    private String vice;
    private String pagina;
    private long paginaTam;

    //Sets

    /**
     * Funcao do metodo: Este metodo serve para construir um novo objeto do tipo Presidente.
     *
     * @param id              Valor para o atributo privado id.
     * @param nome            Valor para o atributo privado nome.
     * @param dataNascimento  Valor para o atributo privado dataNascimento.
     * @param localNascimento Valor para o atributo privado localNascimento.
     * @param inicioMandato   Valor para o atributo privado inicioMandato.
     * @param fimMandato      Valor para o atributo privado fimMandato.
     * @param dataMorte       Valor para o atributo privado dataMorte.
     * @param localMorte      Valor para o atributo privado localMorte.
     * @param antecessor      Valor para o atributo privado antecessor.
     * @param sucessor        Valor para o atributo privado sucessor
     * @param vice            Valor para o atributo privado vice.
     * @param pagina          Valor para o atributo privado pagina.
     * @param paginaTam       Valor para o atributo privado paginaTam.
     */
    Presidente(int id, String nome, int idade, LocalDateTime dataNascimento, String localNascimento, LocalDateTime inicioMandato, LocalDateTime fimMandato, LocalDateTime dataMorte, String localMorte, String antecessor, String sucessor, String vice, String pagina, long paginaTam) {
        this.setID(id);
        this.setNome(nome);
        this.setIdade(idade);
        this.setDataNascimento(dataNascimento);
        this.setLocalNascimento(localNascimento);
        this.setInicioMandato(inicioMandato);
        this.setFimMandato(fimMandato);
        this.setDataMorte(dataMorte);
        this.setLocalMorte(localMorte);
        this.setAntecessor(antecessor);
        this.setSucessor(sucessor);
        this.setVice(vice);
        this.setPagina(pagina);
        this.setPaginaTam(paginaTam);
    }//fim do construtor

    /**
     * Funcao do metodo: Este metodo serve para construir um novo objeto do tipo Presidente.
     */
    Presidente() {
        this.setID(0);
        this.setNome("");
        this.setIdade(-1);
        this.setDataNascimento(null);
        this.setLocalNascimento("");
        this.setInicioMandato(null);
        this.setFimMandato(null);
        this.setDataMorte(null);
        this.setLocalMorte("");
        this.setAntecessor("");
        this.setSucessor("");
        this.setVice("");
        this.setPagina("");
        this.setPaginaTam(0);
    }//fim do construtor

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado id.
     *
     * @return O valor do atributo privado id.
     */
    public int getID() {
        return this.id;
    }//fim do metodo getID

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado id.
     *
     * @param id Novo valor para o atributo privado id.
     */
    public void setID(int id) {
        this.id = id;
    }//fim do metodo setID

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado nome.
     *
     * @return O valor do atributo privado nome.
     */
    public String getNome() {
        return this.nome;
    }//fim do metodo getNome

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado nome.
     *
     * @param nome Novo valor para o atributo privado nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }//fim do metodo setNome

    /**
     * Funcao do metodo: Este metodo serve para calcular o valor do aributo idade da classe Presidente.
     */
    public void calcularIdade() {
        //Nascimento
        int diaNascimento = this.getDataNascimento().getDayOfYear();
        int anoNascimento = this.getDataNascimento().getYear();

        //Dia atual
        int diaHoje = LocalDateTime.now().getDayOfYear();
        int anoHoje = LocalDateTime.now().getYear();

        int idade = anoHoje - anoNascimento;

        this.setIdade(idade);

    }//fim do metodo calcularIdade

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado idade.
     *
     * @return O valor do atributo privado idade.
     */
    public int getIdade() {
        if (this.idade == -1)
            calcularIdade();

        return this.idade;
    }//fim do metodo getIdade

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado idade.
     *
     * @param idade Novo valor para o atributo privado idade.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }//fim do metodo setIdade

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado dataNascimento.
     *
     * @return O valor do atributo privado dataNascimento.
     */
    public LocalDateTime getDataNascimento() {
        return this.dataNascimento;
    }//fim do metodo getDataNascimento

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado dataNascimento.
     *
     * @param dataNascimento Novo valor para o atributo privado dataNascimento.
     */
    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }//fim do metodo setDataNascimento

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado localNascimento.
     *
     * @return O valor do atributo privado localNascimento.
     */
    public String getLocalNascimento() {
        return this.localNascimento;
    }//fim do metodo getLocalNascimento

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado localNascimento.
     *
     * @param localNascimento Novo valor para o atributo privado localNascimento.
     */
    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }//fim do metodo setLocalNascimento

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado inicioMandato.
     *
     * @return O valor do atributo privado inicioMandato.
     */
    public LocalDateTime getInicioMandato() {
        return this.inicioMandato;
    }//fim do metodo getInicioMandato

    //Gets

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado inicioMandato.
     *
     * @param inicioMandato Novo valor para o atributo privado inicioMandato.
     */
    public void setInicioMandato(LocalDateTime inicioMandato) {
        this.inicioMandato = inicioMandato;
    }//fim do metodo setInicioMandato

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado fimMandato.
     *
     * @return O valor do atributo privado fimMandato.
     */
    public LocalDateTime getFimMandato() {
        return this.fimMandato;
    }//fim do metodo getFimMandato

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado fimMandato
     *
     * @param fimMandato Novo valor para o atributo privado fimMandato.
     */
    public void setFimMandato(LocalDateTime fimMandato) {
        this.fimMandato = fimMandato;
    }//fim do metodo setFimMandato

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado dataMorte.
     *
     * @return O valor do atributo privado dataMorte.
     */
    public LocalDateTime getDataMorte() {
        return this.dataMorte;
    }//fim do metodo getDataMorte

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado dataMorte.
     *
     * @param dataMorte Novo valor para o atributo privado dataMorte.
     */
    public void setDataMorte(LocalDateTime dataMorte) {
        this.dataMorte = dataMorte;
    }//fim do metodo setDataMorte

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado localMorte.
     *
     * @return O valor do atributo privado localMorte.
     */
    public String getLocalMorte() {
        return this.localMorte;
    }//fim do metodo getLocalMorte

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado localMorte.
     *
     * @param localMorte Novo valor para o atributo privado localMorte.
     */
    public void setLocalMorte(String localMorte) {
        this.localMorte = localMorte;
    }//fim do metodo setLocalMorte

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado antecessor.
     *
     * @return O valor do atributo privado antecessor.
     */
    public String getAntecessor() {
        return this.antecessor;
    }//fim do metodo getAntecessor

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado antecessor.
     *
     * @param antecessor Novo valor para o atributo privado antecessor.
     */
    public void setAntecessor(String antecessor) {
        this.antecessor = antecessor;
    }//fim do metodo setAntecessor

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado sucessor.
     *
     * @return O valor do atributo privado sucessor.
     */
    public String getSucessor() {
        return this.sucessor;
    }//fim do metodo getSucessor

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado sucessor.
     *
     * @param sucessor Novo valor para o atributo privado sucessor.
     */
    public void setSucessor(String sucessor) {
        this.sucessor = sucessor;
    }//fim do metodo setSucessor

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado vice.
     *
     * @return O valor do atributo privado vice.
     */
    public String getVice() {
        return this.vice;
    }//fim do metodo getVice

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado svice.
     *
     * @param vice Novo valor para o atributo privado vice.
     */
    public void setVice(String vice) {
        this.vice = vice;
    }//fim do metodo setVice

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado pagina.
     *
     * @return O valor do atributo privado pagina.
     */
    public String getPagina() {
        return this.pagina;
    }//fim do metodo getPagina

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado pagina.
     *
     * @param pagina Novo valor para o atributo privado pagina.
     */
    public void setPagina(String pagina) {
        this.pagina = pagina;
    }//fim do metodo setPagina

    //Imprimir

    /**
     * Funcao do metodo: Este metodo serve para obter o valor do atributo privado paginaTam.
     *
     * @return O valor do atributo privado paginaTam.
     */
    public long getPaginaTam() {
        return this.paginaTam;
    }//fim do metodo getPaginaTam

    //Contrutor

    /**
     * Funcao do metodo: Este metodo serve para alterar o valor do atributo privado paginaTam.
     *
     * @param paginaTam Novo valor para o atributo privado paginaTam.
     */
    public void setPaginaTam(long paginaTam) {
        this.paginaTam = paginaTam;
    }//fim do metodo setPaginaTam

    /**
     * Funcao do metodo: Este metodo serve para imprimir na tela os valores dos atributos da classe Presidente.
     */
    public void imprimir() {
        // MyIO.setCharset("ISO-8859-1");
        MyIO.print(this.getID() + " ");
        MyIO.print("## ");
        MyIO.print(this.getNome() + " ");
        MyIO.print("## ");
        if (this.getInicioMandato() != null)
            MyIO.print(this.getInicioMandato().getDayOfMonth() + "/" + this.getInicioMandato().getMonthValue() + "/" + this.getInicioMandato().getYear() + " ");
        MyIO.print("(I) ");
        MyIO.print("## ");
        if (this.getFimMandato() != null)
            MyIO.print(this.getFimMandato().getDayOfMonth() + "/" + this.getFimMandato().getMonthValue() + "/" + this.getFimMandato().getYear() + " ");
        MyIO.print("(F) ");
        MyIO.print("## ");
        if (this.getDataNascimento() != null)
            MyIO.print(this.getDataNascimento().getDayOfMonth() + "/" + this.getDataNascimento().getMonthValue() + "/" + this.getDataNascimento().getYear() + " ");
        MyIO.print("em ");
        MyIO.print(this.getLocalNascimento() + " ");
        MyIO.print("(N) ");
        MyIO.print("## ");
        MyIO.print(this.getIdade() + " ");

        if (this.getDataMorte() != null) {
            MyIO.print("## ");
            MyIO.print(this.getDataMorte().getDayOfMonth() + "/" + this.getDataMorte().getMonthValue() + "/" + this.getDataMorte().getYear() + " ");
            MyIO.print("em ");
            MyIO.print(this.getLocalMorte() + " ");
            MyIO.print("(M) ");
        }

        MyIO.print("## ");
        MyIO.print(this.getPagina() + " ");
        MyIO.print("## ");
        MyIO.print(this.getPaginaTam() + " ");
        MyIO.print("## ");
        MyIO.print(this.getAntecessor() + " ");
        MyIO.print("## ");
        MyIO.print(this.getSucessor() + " ");
        MyIO.print("## ");
        MyIO.print(this.getVice());
        MyIO.print('\n');

    }//fim do metodo imprimir

    //Clone

    /**
     * Funcao do metodo: Este metodo serve para criar um novo objeto do tipo Presidente com atributos iguais ao Presidente atual.
     *
     * @return Objeto do tipo Presidente com atributos iguais a este.
     */
    public Presidente clone() {
        Presidente clonePresidente = new Presidente(this.getID(), this.getNome(), this.getIdade(), this.getDataNascimento(), this.getLocalNascimento(), this.getInicioMandato(), this.getFimMandato(), this.getDataMorte(), this.getLocalMorte(), this.getAntecessor(), this.getSucessor(), this.getVice(), this.getPagina(), this.getPaginaTam());
        return clonePresidente;
    }//fim do metodo clone

    /**
     * Funcao do metodo: Este metodo serve para ler os dados da classe Presidente da entrada padrao (geralmente teclado).
     */
    public void ler() {
        //ID
        int id = MyIO.readInt("Posicao ordinaria: ");
        this.setID(id);

        //Nome
        String nome = MyIO.readLine("Nome:");
        this.setNome(nome);

        //Idade
        int idade = MyIO.readInt("Idade: ");
        this.setIdade(idade);

        //Data Nascimento
        int diaNascimento = MyIO.readInt("Dia nascimento: ");
        int mesNascimento = MyIO.readInt("Numero do mes de nascimento: ");
        int anoNascimento = MyIO.readInt("Ano de nascimento: ");
        LocalDateTime dataNascimento = LocalDateTime.of(anoNascimento, mesNascimento, diaNascimento, 0, 0);
        this.setDataNascimento(dataNascimento);

        //Local Nascimento
        String localNascimento = MyIO.readLine("Local de nascimento:");
        this.setLocalNascimento(localNascimento);

        //Inicio Mandato
        int diaInicioMandato = MyIO.readInt("Dia de inicio de mandato: ");
        int mesInicioMandato = MyIO.readInt("Numero do mes de inicio de mandato: ");
        int anoInicioMandato = MyIO.readInt("Ano de inicio de mandato: ");
        LocalDateTime dataInicioMandato = LocalDateTime.of(anoInicioMandato, mesInicioMandato, diaInicioMandato, 0, 0);
        this.setInicioMandato(dataInicioMandato);

        //Fim Mandato
        int diaFimMandato = MyIO.readInt("Dia do fim do mandato: ");
        int mesFimMandato = MyIO.readInt("Numero do mes do fim do mandato: ");
        int anoFimMandato = MyIO.readInt("Ano do fim do mandato: ");
        LocalDateTime dataFimMandato = LocalDateTime.of(anoFimMandato, mesFimMandato, diaFimMandato, 0, 0);
        this.setFimMandato(dataFimMandato);

        boolean estaMorto = MyIO.readBoolean("O presidente esta morto? (true/false): ");
        if (estaMorto) {
            //Data Morte
            int diaMorte = MyIO.readInt("Dia da morte: ");
            int mesMorte = MyIO.readInt("Numero do mes da morte: ");
            int anoMorte = MyIO.readInt("Ano da morte: ");
            LocalDateTime dataMorte = LocalDateTime.of(anoMorte, mesMorte, diaMorte, 0, 0);
            this.setDataMorte(dataMorte);

            //Local Morte
            String localMorte = MyIO.readLine("Local da morte: ");
            this.setLocalMorte(localMorte);
        }

        //Antecessor
        boolean temAntecessor = MyIO.readBoolean("O presidente tem antecessor? (true/false): ");
        if (temAntecessor) {
            String antecessor = MyIO.readLine("Nome do antecessor: ");
            this.setAntecessor(antecessor);
        }

        //Sucessor
        boolean temSucessor = MyIO.readBoolean("O presidente tem sucessor? (true/false): ");
        if (temSucessor) {
            String sucessor = MyIO.readLine("Nome do sucessor: ");
            this.setSucessor(sucessor);
        }

        //Pagina
        String pagina = MyIO.readLine("Endereco do pagina: ");
        this.setPagina(pagina);

        //Pagina Tam
        int paginaTam = MyIO.readInt("Tamanho da pagina: ");
        this.setPaginaTam(paginaTam);
    }//fim do metodo ler

    /**
     * Funcao do metodo: Este metodo serve para obter o numero de um mes escrito por extenso.
     *
     * @param mes String com o mes escrito por extenso.
     * @return Numero intiero indicando o valor numerico do mes.
     */
    public int numeroMes(String mes) {
        mes = mes.toLowerCase();
        int numeroMes = 3;
        if (mes.contains("janeiro"))
            numeroMes = 1;
        else if (mes.contains("fevereiro"))
            numeroMes = 2;
        else if (mes.contains("março"))
            numeroMes = 3;
        else if (mes.contains("abril"))
            numeroMes = 4;
        else if (mes.contains("maio"))
            numeroMes = 5;
        else if (mes.contains("junho"))
            numeroMes = 6;
        else if (mes.contains("julho"))
            numeroMes = 7;
        else if (mes.contains("agosto"))
            numeroMes = 8;
        else if (mes.contains("setembro"))
            numeroMes = 9;
        else if (mes.contains("outubro"))
            numeroMes = 10;
        else if (mes.contains("novembro"))
            numeroMes = 11;
        else if (mes.contains("dezembro"))
            numeroMes = 12;

        return numeroMes;
    }//fim do metodo numeroMes


    /**
     * Funcao do metodo: Este metodo serve para remover as tags HTML de uma String.
     *
     * @param s String cujas tags serao removidas.
     * @return Uma String sem as tags.
     */
    public String removerTagHTML(String s) {
        return s.replaceAll("\\<.*?>", "");
    }//fim do metodo removerTagHTML

    /**
     * Funcao do metodo: Este metodo serve para obter o numero de uma String sem que ocorra erro de parseInt.
     *
     * @param s String que contem caracteres numericos.
     * @return Numero inteiro resultante da coleta dos numeros da String.
     */
    public int somenteNumeros(String s) {
        String numeros = "";
        for (int i = 0; i < s.length(); i++) {
            if (ehNumero(s.charAt(i)))
                numeros += s.charAt(i);
        }
        return Integer.parseInt(numeros);
    }//fim do metodo somenteNumeros

    /**
     * Funcao do metodo: Este metodo serve para verificar se o caractere passado por parametro eh numero.
     *
     * @param c Caractere que sera verificado.
     * @return Valor booleano indicando se o caractere eh numero.
     */
    public boolean ehNumero(char c) {
        return Utilitarios.ehNumero(c);
    }//fim do metodo ehNumero

    /**
     * Funcao do metodo: Este metodo serve para contar o numero de linhas presentes no arquivo.
     *
     * @param nomeArquivo Nome do arquivo que sera lido.
     * @return A quantidade de linhas do arquivo..
     */
    public int numeroLinhasArquivo(String nomeArquivo) {
        int qtdLinhas = 0;
        try {
            Scanner entrada = new Scanner(new File(nomeArquivo), "UTF-8");
            while (entrada.hasNextLine()) {
                qtdLinhas++;
                entrada.nextLine();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return qtdLinhas;
    }//fim do metodo numeroLinhasArquivo

    //Leitura do Arquivo

    /**
     * Funcao do metodo: Este metodo serve para preencher os atributos da classe Presidente com os dados contidos em um arquivo HTML.
     *
     * @param nomeArquivo O nome do arquivo, incluindo o seu respectivo caminho no disco.
     */
    public void lerArquivo(String nomeArquivo) {
        this.setPagina(nomeArquivo);
        Arq.openRead(nomeArquivo, "UTF-8");
        this.setPaginaTam(Arq.length());
        int qtdLinhas = numeroLinhasArquivo(nomeArquivo);
        String dados[] = new String[qtdLinhas];
        for (int i = 0; i < qtdLinhas; i++) {
            dados[i] = Arq.readLine();
        }
        boolean numeroOrdinarioEPeriodoEncontrado = false;
        boolean vicePresidenteEncontrado = false;
        boolean antecessorEncontrado = false;
        boolean sucessorEncontrado = false;
        boolean nomeCompletoEncontrado = false;
        boolean nascimentoEncontrado = false;
        boolean morteEncontrada = false;
        for (int i = 0; i < dados.length; i++) {

            if (!numeroOrdinarioEPeriodoEncontrado && i < dados.length - 3 && dados[i].contains("<tr>") && dados[i + 1].contains("<th colspan=\"2\" style=\"text-align:center; background-color: #E6E6FA\"><a href=\"/wiki/Lista_de_presidentes_do_Brasil\" title=\"Lista de presidentes do Brasil\">") && dados[i + 1].contains("title=\"Presidente do Brasil\">Presidente do Brasil</a>") && dados[i + 2].contains("</th></tr>")) {
                numeroOrdinarioEPeriodoEncontrado = true;
                //ID

                //Filtrando e lendo os dados de dados[i+1]
                String dadoASerTratado = dados[i + 1];
                dadoASerTratado = removerTagHTML(dadoASerTratado);
                int j = 0;
                String id = "";
                while (ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    id += dadoASerTratado.charAt(j);
                    j++;
                }
                this.setID(Integer.parseInt(id));

                //Periodo
                //Filtrando e lendo os dados de dados[i+6]
                dadoASerTratado = dados[i + 6];
                dadoASerTratado = removerTagHTML(dadoASerTratado);

                //Lendo o dia do inicio do mandato
                j = 0;
                while (ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                String diaInicioMandato = dadoASerTratado.substring(0, j);

                //Lendo o mes do inicio do mandato
                int esquerda = 3 + dadoASerTratado.indexOf("de");
                int direita = dadoASerTratado.indexOf(" de", esquerda);
                String mesInicioMandato = dadoASerTratado.substring(esquerda, direita);

                //Lendo o ano do inicio do mandato
                esquerda = j = direita + 4;
                while (ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                direita = j;
                String anoInicioMandato = dadoASerTratado.substring(esquerda, direita);

                //Salvando a data de inicio de mandato
                LocalDateTime dataDeInicioDoMandato = LocalDateTime.of(somenteNumeros(anoInicioMandato), numeroMes(mesInicioMandato), somenteNumeros(diaInicioMandato), 0, 0);
                this.setInicioMandato(dataDeInicioDoMandato);

                //Lendo o ano do fim do mandato
                j = dadoASerTratado.length() - 1;
                while (!(ehNumero(dadoASerTratado.charAt(j)) && ehNumero(dadoASerTratado.charAt(j - 1)) && ehNumero(dadoASerTratado.charAt(j - 2)) && ehNumero(dadoASerTratado.charAt(j - 3))) && j >= 0) {
                    j--;
                }
                direita = j + 1;
                while (ehNumero(dadoASerTratado.charAt(j)) && j >= 0) {
                    j--;
                }
                esquerda = j;

                String anoFimMandato = dadoASerTratado.substring(esquerda, direita);

                //Lendo o mes do fim do mandato
                direita = j = dadoASerTratado.lastIndexOf(" de");
                esquerda = j = 3 + dadoASerTratado.lastIndexOf("de ", j);
                String mesFimMandato = dadoASerTratado.substring(esquerda, direita);

                //Lendo o dia do fim do mandato
                while (!ehNumero(dadoASerTratado.charAt(j)) && j >= 0) {
                    j--;
                }
                direita = j + 1;

                while (ehNumero(dadoASerTratado.charAt(j)) && j >= 0) {
                    j--;
                }
                esquerda = j + 1;
                String diaFimMandato = dadoASerTratado.substring(esquerda, direita);

                //Salvando a data do fim do mandato
                LocalDateTime dataDeFimDoMandato = LocalDateTime.of(somenteNumeros(anoFimMandato), numeroMes(mesFimMandato), somenteNumeros(diaFimMandato), 0, 0);
                this.setFimMandato(dataDeFimDoMandato);

            }

            //Vice
            if (!vicePresidenteEncontrado && i < dados.length - 5 && dados[i].contains("<tr>") && dados[i + 1].contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Vice-presidente") && dados[i + 2].contains("</td>") && dados[i + 3].contains("<td style=\"vertical-align: top; text-align: left;\">") && dados[i + 4].contains("</td></tr>")) {
                vicePresidenteEncontrado = true;
                //Filtrando e lendo os dados de dados[i+3]
                String dadoASerTratado = dados[i + 3];
                dadoASerTratado = removerTagHTML(dadoASerTratado);
                this.setVice(dadoASerTratado);
            }

            //Antecessor
            if (!antecessorEncontrado && i < dados.length - 5 && dados[i].contains("<tr>") && dados[i + 1].contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Antecessor") && dados[i + 2].contains("</td>") && dados[i + 3].contains("<td style=\"vertical-align: top; text-align: left;\">") && dados[i + 4].contains("</td></tr>")) {
                antecessorEncontrado = true;
                //Filtrando e lendo os dados de dados[i+3]
                String dadoASerTratado = dados[i + 3];
                dadoASerTratado = removerTagHTML(dadoASerTratado);
                this.setAntecessor(dadoASerTratado);
            }

            //Sucessor
            if (!sucessorEncontrado && i < dados.length - 5 && dados[i].contains("<tr>") && dados[i + 1].contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Sucessor") && dados[i + 2].contains("</td>") && dados[i + 3].contains("<td style=\"vertical-align: top; text-align: left;\"><a href=\"") && dados[i + 4].contains("</td></tr>")) {
                sucessorEncontrado = true;
                //Filtrando e lendo os dados de dados[i+3]
                String dadoASerTratado = dados[i + 3];
                dadoASerTratado = removerTagHTML(dadoASerTratado);
                this.setSucessor(dadoASerTratado);
            }

            //Nome
            if (!nomeCompletoEncontrado && i < dados.length - 8 && dados[i].contains("<tr>") && dados[i + 1].contains("<th colspan=\"2\" style=\"text-align:center; background-color: #E6E6FA\">Dados pessoais") && dados[i + 2].contains("</th></tr>") && dados[i + 3].contains("<tr>") && dados[i + 4].contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nome completo") && dados[i + 5].contains("</td>") && dados[i + 6].contains("<td style=\"vertical-align: top; text-align: left;\">") && dados[i + 7].contains("</td></tr>")) {
                nomeCompletoEncontrado = true;
                //Filtrando e lendo os dados de dados[i+6]
                String dadoASerTratado = dados[i + 6];
                dadoASerTratado = removerTagHTML(dadoASerTratado);
                this.setNome(dadoASerTratado);
            }

            //Nascimento
            if (!nascimentoEncontrado && i < dados.length - 5 && dados[i].contains("<tr>") && dados[i + 1].contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nascimento") && dados[i + 2].contains("</td>") && dados[i + 3].contains("<td style=\"vertical-align: top; text-align: left;\"><a href=\"") && dados[i + 4].contains("</td></tr>")) {
                nascimentoEncontrado = true;
                //Filtrando e lendo os dados de dados[i+3]
                String dadoASerTratado = dados[i + 3];
                dadoASerTratado = removerTagHTML(dadoASerTratado);

                //Lendo o dia de nascimento
                int j = 0;
                while (!ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                int esquerda = j;
                while (ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                int direita = j;
                String diaNascimento = dadoASerTratado.substring(esquerda, direita);

                //Lendo o mes de nascimento
                esquerda = j = 3 + dadoASerTratado.indexOf("de", j);
                direita = j = dadoASerTratado.indexOf(" de", j);
                String mesNascimento = dadoASerTratado.substring(esquerda, direita);

                //Lendo o ano de nascimento
                esquerda = j = 3 + dadoASerTratado.indexOf("de", j);
                while (ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                direita = j;
                String anoNascimento = dadoASerTratado.substring(esquerda, direita);

                //Salvando a data do nascimento
                LocalDateTime dataDeNascimento = LocalDateTime.of(somenteNumeros(anoNascimento), numeroMes(mesNascimento), somenteNumeros(diaNascimento), 0, 0);
                this.setDataNascimento(dataDeNascimento);

                //Lendo o local de nascimento
                j = dadoASerTratado.length() - 1;
                while (!ehNumero(dadoASerTratado.charAt(j)) && j >= 0) {
                    j--;
                }
                esquerda = j + 2;
                String localNascimento = dadoASerTratado.substring(esquerda, dadoASerTratado.length());
                if (localNascimento.contains("anos) "))
                    localNascimento = localNascimento.replace("anos) ", "");
                this.setLocalNascimento(localNascimento);

            }

            //Morte
            if (!morteEncontrada && i < dados.length - 5 && dados[i].contains("<tr>") && dados[i + 1].contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Morte") && dados[i + 2].contains("</td>") && dados[i + 3].contains("<td style=\"vertical-align: top; text-align: left;\"><span style=\"white-space:nowrap;\"><a href=\"") && dados[i + 4].contains("</td></tr>")) {
                morteEncontrada = true;
                //Filtrando e lendo os dados de dados[i+3]
                String dadoASerTratado = dados[i + 3];
                dadoASerTratado = removerTagHTML(dadoASerTratado);

                //Lendo o dia da morte
                int j = 0;
                while (!ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                int esquerda = j;
                while (ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                int direita = j;
                String diaMorte = dadoASerTratado.substring(esquerda, direita);

                //Lendo o mes da morte
                esquerda = j = 3 + dadoASerTratado.indexOf("de", j);
                direita = j = dadoASerTratado.indexOf(" de", j);
                String mesMorte = dadoASerTratado.substring(esquerda, direita);

                //Lendo o ano da morte
                esquerda = j = 3 + dadoASerTratado.indexOf("de", j);
                while (ehNumero(dadoASerTratado.charAt(j)) && j < dadoASerTratado.length()) {
                    j++;
                }
                direita = j;
                String anoMorte = dadoASerTratado.substring(esquerda, direita);

                //Salvando a data da morte
                LocalDateTime dataDaMorte = LocalDateTime.of(somenteNumeros(anoMorte), numeroMes(mesMorte), somenteNumeros(diaMorte), 0, 0);
                this.setDataMorte(dataDaMorte);

                //Lendo o local da morte
                j = dadoASerTratado.length() - 1;
                while (!ehNumero(dadoASerTratado.charAt(j)) && j >= 0) {
                    j--;
                }
                esquerda = j + 2;
                String localMorte = dadoASerTratado.substring(esquerda, dadoASerTratado.length());
                if (localMorte.contains("anos) "))
                    localMorte = localMorte.replace("anos) ", "");
                this.setLocalMorte(localMorte);

            }


        }
    }//fim do metodo lerArquivo    

}//fim da classe Presidente