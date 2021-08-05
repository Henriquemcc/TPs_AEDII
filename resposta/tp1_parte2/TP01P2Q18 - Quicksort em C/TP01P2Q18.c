#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <locale.h>
#include <time.h>
#include <stdbool.h>
#include <iconv.h>
#define MAXTAM 100
#define TAMANHO_PADRAO_STRING 100
#define TAMANHO_GRANDE_STRING 500
bool debug=false;

/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-03-01
*/

typedef struct Data
{
    int dia;
    int mes;
    int ano;
}Data;

typedef struct Presidente
{
    int id;
    char nome[TAMANHO_PADRAO_STRING];
    int idade;
    Data dataNascimento;
    char localNascimento[TAMANHO_PADRAO_STRING];
    Data inicioMandato;
    Data fimMandato;
    Data dataMorte;
    char localMorte[TAMANHO_PADRAO_STRING];
    char antecessor[TAMANHO_PADRAO_STRING];
    char sucessor[TAMANHO_PADRAO_STRING];
    char vice[TAMANHO_PADRAO_STRING];
    char pagina[TAMANHO_PADRAO_STRING];
    long paginaTam;

}Presidente;

int n=0;
Presidente presidentes[MAXTAM];

/**
 * Funcao da funcao: Esta funcao serve para converter um arranjo de caracteres em UTF-8 para ISO8859-1.
 * @param *strUTF8 Ponteiro apontando para um arranjo de caracteres em UTF-8 que sera convertido para ISO8859-1.
 * @return Ponteiro apontando para um arranjo de caracteres em ISO8859-1.
*/
char *UTF8toISO88591(char *strUTF8)
{
    iconv_t cd = iconv_open("ISO_8859-1:1987", "UTF-8");
    if(cd==(iconv_t)-1)
    {
        perror("iconv_open failed!");
        exit(1);
    }

    char input[100];
    strcpy(input, strUTF8);
    char *in_buf=&input[0];
    size_t in_left=strlen(strUTF8);
    

    char output[100];
    char *out_buf=&output[0];
    size_t out_left=sizeof(output)-1;

    do
    {
        if(iconv(cd, &in_buf, &in_left, &out_buf, &out_left) == (size_t)-1)
        {
            perror("iconv failed!");
            exit(1);
        }
    } while(in_left>0 && out_left>0);
    *out_buf= 0;
    iconv_close(cd);
    return strdup(output);
}//fim da funcao UTF8toISO88591

/**
 * Funcao da funcao: Esta funcao serve para imprimir os dados de uma struct Presidente.
 * @param presidente Struct Presidente que sera impressa
*/
void imprimir(Presidente presidente)
{
    printf("%d ", presidente.id);
    printf("## ");
    printf("%s ", UTF8toISO88591(presidente.nome));
    printf("## ");
    printf("%d/%d/%d ", presidente.inicioMandato.dia, presidente.inicioMandato.mes, presidente.inicioMandato.ano);
    printf("(I) ");
    printf("## ");
    printf("%d/%d/%d ", presidente.fimMandato.dia, presidente.fimMandato.mes, presidente.fimMandato.ano);
    printf("(F) ");
    printf("## ");
    printf("%d/%d/%d ", presidente.dataNascimento.dia, presidente.dataNascimento.mes, presidente.dataNascimento.ano);
    printf("em ");
    printf("%s ", UTF8toISO88591(presidente.localNascimento));
    printf("(N) ");
    printf("## ");
    printf("%d ", presidente.idade);
    if(presidente.dataMorte.dia!=0 && presidente.dataMorte.mes!=0 && presidente.dataMorte.ano!=0)
    {
        printf("## ");
        printf("%d/%d/%d ", presidente.dataMorte.dia, presidente.dataMorte.mes, presidente.dataMorte.ano);
        printf("em ");
        printf("%s ", UTF8toISO88591(presidente.localMorte));
        printf("(M) ");
    }
    printf("## ");
    printf("%s ", UTF8toISO88591(presidente.pagina));
    printf("## ");
    printf("%ld ", presidente.paginaTam);
    printf("## ");
    printf("%s ", UTF8toISO88591(presidente.antecessor));
    printf("## ");
    printf("%s ", UTF8toISO88591(presidente.sucessor));
    printf("## ");
    printf("%s", UTF8toISO88591(presidente.vice));    
    printf("\n");
}//fim da funcao imprimir

//Funcoes para trabalhar com Strings:

/**
 * Funcao da Funcao: Esta funcao serve para obter um segmento de um arranjo de caracteres, informando onde que sera cortado.
 * @param *str Ponteiro apontando para o arranjo de caracteres original que sera cortado.
 * @param begin Indice de inicio.
 * @param length Indice de fim nao incluindo o elemento do fim.
 * @return Ponteiro apontando para o arranjo de caracteres resultante.
*/
char *str_substring(char *str, int begin, int length)
{
    int len_result=length-begin+1;
    char result[len_result];
    int i, j;
    for(i=begin, j=0; i<length ; i++, j++)
    {
        result[j]=str[i];
    }
    result[j]='\0';

    //Colocando NULL para todos os ponteiros exceto result
    char *resp=(char*)calloc(1+strlen(result), sizeof(char));
    strcpy(resp, result);
   
    return resp;
}//fim da funcao str_substring

/**
 * Funcao da Funcao: Esta funcao serve para obter a menor posicao da primeira ocorrencia de um segmento de um arranjo de caracteres em um arranjo de caracteres.
 * @param *string Ponteiro apontando para um arranjo de caracteres que nele sera procurada por um segmento.
 * @param *key Ponteiro apontando para um segmento de arranjo de caracteres que sera procurado no arranjo de caracteres.
 * @return A menor posicao da primeira ocorrencia de um segmento de um arranjo de caracteres no arranjo de caracteres.
*/
int str_indexOf(char *string, char *key)
{    
    int position=-1;
    int i=0;
    while(i<strlen(string))
    {
        if(string[i]==key[0])
        {
            int j=1;
            i++;
            while(string[i]==key[j] && j<strlen(key) && i<strlen(string))
            {
                i++;
                j++;
            }
            if(j==strlen(key))
            {
                position=i-strlen(key);
                i=strlen(string);//<-finalizando o looping
            }
        }
        else
            i++;
    }

    //Colocando NULL para todos os ponteiros
    string=NULL;
    key=NULL;

    return position;
}//fim da funcao str_indexOf

/**
 * Funcao da Funcao: Esta funcao serve para obter a menor posicao da primeira ocorrencia de um segmento de um arranjo de caracteres em um arranjo de caracteres.
 * @param *string Ponteiro apontando para um arranjo de caracteres no qual sera feita a busca pelo segmento.
 * @param *key Ponteiro apontando para um segmento de arranjo de caracteres que sera procurado no arranjo de caracteres.
 * @param begin Posicao limite a esquerda.
 * @return A menor posicao da primeira ocorrencia do segmento de arranjo de caracteres no arranjo de caracteres.
*/
int str_indexOfBegin(char *string, char *key, int begin)
{
    char *copy_string=(char*)calloc(1+strlen(string), sizeof(char));
    strcpy(copy_string, string);
    strcpy(copy_string, str_substring(copy_string, begin, strlen(copy_string)));

    int resp=str_indexOf(copy_string, key)+begin;

    return resp;
}//fim do metodo str_indexOfBegin

/**
 * Funcao da Funcao: Esta funcao serve para obter a maior posicao da primeira ocorrencia de um segmento de um arranjo de caracteres em um arranjo de caracteres.
 * @param *string Ponteiro apontando para um arranjo de caracteres no qual sera realizado a busca pelo segmento.
 * @param *key Ponteiro apontando para o segmento de arranjo de caracteres que sera procurado no arranjo de caracteres.
 * @return A maior posicao da primeira ocorrencia do segmento no arranjo de caracteres.
*/
int str_lastIndexOf(char *string, char *key)
{
    const int len_string=strlen(string);
    const int len_key=strlen(key);
    int position=-1;
    int i=len_string-1;
    while(i>=0)
    {
        if(string[i]==key[len_key-1])
        {
            int j=len_key-2;
            i--;
            while(string[i]==key[j] && j>=0 && i>=0)
            {
                i--;
                j--;
            }
            if(j==-1)
            {
                position=i+1;
                i=-1;//<-finalizando o looping
            }
        }
        else
            i--;
    }

    //Colocando NULL para todos os ponteiros
    string=NULL;
    key=NULL;

    return position;
}//fim da funcao str_lastIndexOf

/**
 * Funcao da Funcao: Esta funcao serve para obter a maior posicao da primeira ocorrencia de um segmento de um arranjo de caracteres em um arranjo de caracteres.
 * @param *string Ponteiro apontando para um arranjo de caracteres no qual sera realizado a busca pelo segmento.
 * @param *key Ponteiro apontando para o segmento de um arranjo de caracteres que sera procurado no arranjo de caracteres.
 * @param end Posicao limite a esquerda.
 * @return A maior posicao da primeira ocorrencia da substring na String.
*/
int str_lastIndexOfEnd(char *string, char *key, int end)
{
    char *copy_string=(char*)calloc(1+strlen(string), sizeof(char));
    strcpy(copy_string, string);
    copy_string=str_substring(copy_string, 0, end+1);

    //Colocando NULL para todos os ponteiros exceto copy_String e key
    string=NULL;

    int resp=str_lastIndexOf(copy_string, key);

    return resp;
}//fim da funcao str_lastIndexOfEnd

/**
 * Funcao da funcao: Esta funcao serve para realizar a substituicao de um segmento arranjo de caracteres contido dentro de outro arranjo de caracteres por outro segmento de arranjo de caracteres.
 * @param *original Ponteiro apontando para o arranjo de caracteres original que sera modificado, resultando no retorno.
 * @param *replace Ponteiro apontando para o arranjo de caracteres que sera removido.
 * @param *replacement Ponteiro apontando para o arranjo de caracteres que sera adicionado no lugar do segmento de arranjo de caracteres que foi removido.
 * @return Ponteiro apontando para o novo arranjo de caracteres gerado a partir da substituicao.
*/
char *str_replaceAll(char *original, char *replace, char *replacement)
{
    char *copia_original=(char*)calloc(1+strlen(original), sizeof(char));
    strcpy(copia_original, original);
    bool retornoNulo=false;
    char *result;//A String resultante
    char *ins;//O proximo ponto de insercao
    char *tmp;//Variavel temporaria
    int len_replace;//tamanho de replace (String a ser removida)
    int len_replacement;//tamanho de replacement(String a ser colocada no lugar de replace)
    int len_front;//distancia entre o inicio e o fim de replace
    int count;//numero de substituicoes

    //Chacando se eh possivel inicializar a substituicao
    if(copia_original && replace)
    {
        len_replace=strlen(replace);
        if(len_replace!=0)
        {
            if(!replacement)
            {
                replacement=(char*)calloc(1, sizeof(char));
                strcpy(replacement, "");
            }

            len_replacement=strlen(replacement);

            //Contando o numero de substituicoes que deverao ser realizadas
            ins=copia_original;
            for(count=0;tmp=strstr(ins, replace); count++)
                ins=tmp+len_replace;

            tmp=result=(char*)calloc(1+strlen(copia_original)+(len_replacement-len_replace)*count+1, sizeof(char));

            if(result)
            {
                while(count--)
                {
                    ins=strstr(copia_original, replace);
                    len_front=ins-copia_original;
                    tmp=strncpy(tmp, copia_original, len_front)+len_front;
                    tmp=strcpy(tmp, replacement)+len_replacement;
                    copia_original+=len_front+len_replace;
                }
                strcpy(tmp, copia_original);
            }
            else retornoNulo=true;
        }
        else retornoNulo=true;

    }
    else retornoNulo=true;

    char *retorno=result;
    if(retornoNulo)
    {
        *retorno=*copia_original;
        copia_original=NULL;
    }

    //Colocando NULL em todos os ponteiros exceto retorno
    replace=NULL;
    replacement=NULL;
    copia_original=NULL;
    result=NULL;
    ins=NULL;
    tmp=NULL;

    return retorno;
}//fim da funcao str_replaceAll


/**
 * Funcao da funcao: Esta funcao serve para verificar se um segmento de arranjo de caracteres esta contido em uma posicao do arranjo de arranjo de caracteres.
 * @param *str[] Um arranjo de ponteiros apontando para os arranjos de caracteres.
 * @param len_str Numero de elementos no arranjo de ponteiros str.
 * @param *key Ponteiro apontando para para o arranjo de caracteres chave da pesquisa.
 * @return Valor booleano indicando se o elemento procurado encontra-se no arranjo de arranjos de caracteres.
*/
bool str_arr_contains(char *str[], int len_str, char *key)
{
    bool contains=false;
    int i=0;
    while(i<len_str)
    {
        if(strcmp(str[i], key)==0)
        {
            contains=true;
            i=len_str;
        }
        i++;
    }

    //Colocando NULL em todos os ponteiros
    str=NULL;
    key=NULL;

    return contains;
}//fim da funcao str_arr_contains

/**
 * Funcao da funcao: Esta funcao serve para converter um arranjo de caracteres para minusculo.
 * @param *string Ponteiro apontando para o arranjo de caracteres cujos caracteres serao convertidos para maiusculo.
 * @return Ponteiro apontando para o novo arranjo de caracteres resultante do processo de conversao para minusculo.
*/
char *str_toLowerCase(char *string)
{    
    char copy_string[strlen(string)];
    strcpy(copy_string, string);
    for(int i=0;i<strlen(string);i++)
    {
        copy_string[i]=tolower(copy_string[i]);
    }

    //Colocando NULL para todos os ponteiros exceto copy_String
    string=NULL;

    char *resp=(char*)calloc(1+strlen(copy_string), sizeof(char));
    strcpy(resp, copy_string);

    return resp;
}//fim da funcao str_toLowerCase

/**
 * Funcao da funcao: Esta funcao serve para remover todas as Tgs HTML de um arranjo de caracteres.
 * @param *stringOriginal Ponteiro apontando para o arranjo de caracteres original que sera modificado.
 * @return Ponteiro apontando para o arranjo de caracteres resultante do processo de remocao das tags HTML.
*/
char *removerTagHTML(char *s)
{    
    char *resp=(char*)calloc(1+strlen(s), sizeof(char));

      for(int i=0;i<strlen(s);i++)
      {

         //Perguntas: (1) Pq o while abaixo? (2) Pq as clausulas do while abaixo nao podem ser invertidas?
         while(i<strlen(s) && s[i]=='<')
         {
            for(i++;s[i]!='>';i++);
            i++;

            //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
            while(i<strlen(s) && s[i]=='&')
            {
               for(i++;s[i]!=';';i++);
               i++;
            }
         }

         //Pergunta: (1) Qual seria um exemplo da utilidade do laco abaixo?
         while(i<strlen(s) && s[i]=='&')
         {
            for (i++;s[i]!=';';i++);
            i++;
            //strcat(resp, ' ');
            sprintf(resp, "%s ", resp);
         }

         //Perqunta: Pq nao colocamos apenas resp += s.charAt(i)?
         if(i<strlen(s))
         {
            //strcat(resp, s[i]);
            sprintf(resp, "%s%c", resp, s[i]);
         }
      }

      while(strlen(resp)>0 && resp[0]==' ')
      {
        strcpy(resp, str_substring(resp, 1, strlen(resp)));
      }

      return resp;
}//fim da funcao removerTagHTML

/**
 * Funcao da funcao: Esta funcao serve para remover todos os \n de um arranjo de caracteres.
 * @param *s Ponteiro apontando para o arranjo de caracteres que sera removido o \n.
 * @return Ponteiro apontando para o arranjo de caracteres resultante do processo de remocao do \n.
*/
char *removerBarraN(char *s)
{
    char string[strlen(s)];
    strcpy(string, s);
    
    //Contando a quantidade de \n
    int qtd=0;
    for(int i=0;i<strlen(string);i++)
    {
        if(string[i]=='\n')
        {
            qtd++;
        }
    }

    //Removendo os \n
    for(int i=0;i<qtd;i++)
    {
        //Encontrando o \n
        int posicao=0;
        while(string[posicao]!='\n')
        {
            posicao++;
        }

        //Empurrando os elementos

        for(int j=posicao;j<strlen(string);j++)
        {
            string[j]=string[j+1];
        }
    }


    char *resp=(char*)calloc(1+strlen(s), sizeof(char));
    strcpy(resp, string);    

    return resp;
}//fim da funcao removerBarraN

/**
 * Funcao da funcao: Esta funcao serve para converter o nome do mes escrito por extenso no numero do mes.
 * @param *mes Ponteiro apontando para um arranjo de caracteres que contem um mes escrito por extenso.
 * @return Numero inteiro representando o numero do mes.
*/
int numeroMes(char *mes)
{
    mes=str_toLowerCase(mes);
    int numero=-1;
    if(strstr(mes, "janeiro")!=NULL)
        numero=1;
    else if(strstr(mes, "fevereiro")!=NULL)
        numero=2;
    else if(strstr(mes, "março")!=NULL)
        numero=3;
    else if(strstr(mes, "abril")!=NULL)
        numero=4;
    else if(strstr(mes, "maio")!=NULL)
        numero=5;
    else if(strstr(mes, "junho")!=NULL)
        numero=6;
    else if(strstr(mes, "julho")!=NULL)
        numero=7;
    else if(strstr(mes, "agosto")!=NULL)
        numero=8;
    else if(strstr(mes, "setembro")!=NULL)
        numero=9;
    else if(strstr(mes, "outubro")!=NULL)
        numero=10;
    else if(strstr(mes, "novembro")!=NULL)
        numero=11;
    else if(strstr(mes, "dezembro")!=NULL)
        numero=12;
    
    return numero;
}//fim da funcao numeroMes

/**
 * Funcao da funcao: Esta funcao serve para verificar se um determinado caractere eh um numero
 * @param c Caractere que sera verificado se eh um numero.
 * @return Valor booleano indicando se eh um numero.
*/
bool ehNumero(char c)
{
    bool ehNumeroSim=false;
    if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
        ehNumeroSim=true;

    return ehNumeroSim;
}//fim da funcao ehNumero

/**
 * Funcao da funcao: Esta funcao serve para ler um arquivo HTML contendo informacoes sobre um presidente, retoranando uma struct Presidente com os dados preenchidos.
 * @param *nomeArquivo Ponteiro apontendo para um arranjo de caracteres contendo o nome do arquivo HTML que sera lido.
 * @return Struct Presidente preenchida com os dados lido do arquivo.
*/
Presidente lerArquivo(char *nomeArquivo)
{
    FILE *arquivo=fopen(nomeArquivo, "r");
    Presidente presidente;
    if(arquivo!=NULL)
    {
        strcpy(presidente.pagina, nomeArquivo);
        //Obtendo o tamanho do arquivo
        fseek(arquivo, 0L, SEEK_END);
        presidente.paginaTam = ftell(arquivo);
        rewind(arquivo);
        //Obtendo a quantidade de linhas do arquivo
        int tmpInt;
        int qtdLinhasArquivo=0;
        do
        {
            tmpInt=fgetc(arquivo);
            if(tmpInt=='\n')
            {
                qtdLinhasArquivo++;
            }
        }
        while(tmpInt!=EOF);

        //Obtendo o tamanho das linhas
        rewind(arquivo);
        int tamanhoLinhas[qtdLinhasArquivo];
        for(int i=0;i<qtdLinhasArquivo;i++)
        {
            tamanhoLinhas[i]=0;
        }
        for(int i=0;i<qtdLinhasArquivo;i++)
        {
            tmpInt=fgetc(arquivo);
            if(tmpInt!='\n')
            {
                tamanhoLinhas[i]++;
            }
        }

        //Lendo os dados do arquivo
        rewind(arquivo);
        char *dadosArquivo[qtdLinhasArquivo];
        size_t len=0;
        for(int i=0;i<qtdLinhasArquivo;i++)
        {
            len=0;
            dadosArquivo[i]=(char*)calloc(tamanhoLinhas[i]+1, sizeof(char));
            getdelim(&dadosArquivo[i], &len, '\n', arquivo);

        }

        bool numeroOrdinarioEPeriodoEncontrado=false;
        bool vicePresidenteEncontrado=false;
        bool antecessorEncontrado=false;
        bool sucessorEncontrado=false;
        bool nomeCompletoEncontrado=false;
        bool nascimentoEncontrado=false;
        bool morteEncontrada=false;
        for(int i=0;i<qtdLinhasArquivo;i++)
        {
            
            if(!numeroOrdinarioEPeriodoEncontrado && i<qtdLinhasArquivo-3 && strstr(dadosArquivo[i], "<tr>")!=NULL && strstr(dadosArquivo[i+1], "<th colspan=\"2\" style=\"text-align:center; background-color: #E6E6FA\"><a href=\"/wiki/Lista_de_presidentes_do_Brasil\" title=\"Lista de presidentes do Brasil\">")!=NULL && strstr(dadosArquivo[i+1], "title=\"Presidente do Brasil\">Presidente do Brasil</a>")!=NULL && strstr(dadosArquivo[i+2], "</th></tr>")!=NULL && strstr(dadosArquivo[i+3], "<tr>")!=NULL && strstr(dadosArquivo[i+4], "<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Período")!=NULL && strstr(dadosArquivo[i+5], "</td>")!=NULL && strstr(dadosArquivo[i+6], "<td style=\"vertical-align: top; text-align: left;\"><a href=\"")!=NULL && strstr(dadosArquivo[i+7], "</td></tr>")!=NULL)
            {
                //ID
                numeroOrdinarioEPeriodoEncontrado=true;
                //Filtrando e lendo os dados de dadosArquivo[i+1]
                char *dadoASerTratado=(char*)calloc(1+strlen(dadosArquivo[i+1]), sizeof(char));
                dadoASerTratado=removerBarraN(removerTagHTML(dadosArquivo[i+1]));

                int len_dadoASerTratado=strlen(dadoASerTratado);
                int j=0;
                while(!ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                int esquerda=j;
                while(ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                int direita=j;
                presidente.id=atoi(str_substring(dadoASerTratado, esquerda, direita));

                //Periodo
                //Filtrando e lendo os dados de dadosArquivo[i+6]
                free(dadoASerTratado);
                dadoASerTratado=NULL;
                dadoASerTratado=removerBarraN(removerTagHTML(dadosArquivo[i+6]));
                len_dadoASerTratado=strlen(dadoASerTratado);

                //  Inicio mandato
                //      Dia
                j=0;
                while(!ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                esquerda=j;
                while(ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                direita=j;
                presidente.inicioMandato.dia=atoi(str_substring(dadoASerTratado, esquerda, direita));

                //      Mes
                esquerda=3+str_indexOf(dadoASerTratado, strdup("de"));
                direita=str_indexOfBegin(dadoASerTratado, strdup(" de"), esquerda);
                presidente.inicioMandato.mes=numeroMes(str_substring(dadoASerTratado, esquerda, direita));
                
                //      Ano
                esquerda=j=direita+4;
                while(ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                direita=j;
                presidente.inicioMandato.ano=atoi(str_substring(dadoASerTratado, esquerda, direita));

                //  Fim mandato
                //      Ano
                j=len_dadoASerTratado-1;
                while(!(ehNumero(dadoASerTratado[j]) && ehNumero(dadoASerTratado[j-1]) && ehNumero(dadoASerTratado[j-2]) && ehNumero(dadoASerTratado[j-3])) && j>=0)
                    j--;
                direita=j+1;
                while(ehNumero(dadoASerTratado[j]) && j>=0)
                {
                    j--;
                }
                esquerda=j;
                presidente.fimMandato.ano=atoi(str_substring(dadoASerTratado, esquerda, direita));
                
                //      Mes
                direita=j=str_lastIndexOf(dadoASerTratado, strdup(" de"));
                esquerda=j=3+str_lastIndexOfEnd(dadoASerTratado, strdup("de "), j);
                presidente.fimMandato.mes=numeroMes(str_substring(dadoASerTratado, esquerda, direita));
                
                //      Dia
                while(!ehNumero(dadoASerTratado[j]) && j>=0)
                    j--;
                direita=j+1;
                while(ehNumero(dadoASerTratado[j]) && j>=0)
                    j--;
                esquerda=j+1;
                presidente.fimMandato.dia=atoi(str_substring(dadoASerTratado, esquerda, direita));

                //Liberando espaco
                //Colocando NULL para todos os ponteiros
                dadoASerTratado=NULL;
            }

            //Vice
            if(!vicePresidenteEncontrado && i<qtdLinhasArquivo-5 && strstr(dadosArquivo[i], "<tr>")!=NULL && strstr(dadosArquivo[i+1], "<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Vice-presidente")!=NULL && strstr(dadosArquivo[i+2], "</td>")!=NULL && strstr(dadosArquivo[i+3], "<td style=\"vertical-align: top; text-align: left;\">")!=NULL && strstr(dadosArquivo[i+4], "</td></tr>")!=NULL)
            {
                vicePresidenteEncontrado=true;
                //Filtrando e lendo os dados de dadosArquivo[i+3]
                char *dadoASerTratado=(char*)calloc(1+strlen(dadosArquivo[i+3]), sizeof(char));
                dadoASerTratado=removerBarraN(removerTagHTML(dadosArquivo[i+3]));
                strcpy(presidente.vice, dadoASerTratado);

                //Colocando NULL para todos os ponteiros
                dadoASerTratado=NULL;
            }

            //Antecessor
            if(!antecessorEncontrado && i<qtdLinhasArquivo-5 && strstr(dadosArquivo[i], "<tr>")!=NULL && strstr(dadosArquivo[i+1], "<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Antecessor")!=NULL && strstr(dadosArquivo[i+2], "</td>")!=NULL && strstr(dadosArquivo[i+3], "<td style=\"vertical-align: top; text-align: left;\">")!=NULL && strstr(dadosArquivo[i+4], "</td></tr>")!=NULL)
            {
                antecessorEncontrado=true;
                //Filtrando e lendo os dados de dadosArquivo[i+3]
                char *dadoASerTratado=(char*)calloc(1+strlen(dadosArquivo[i+3]), sizeof(char));
                dadoASerTratado=removerBarraN(removerTagHTML(dadosArquivo[i+3]));
                strcpy(presidente.antecessor, dadoASerTratado);

                //Colocando NULL para todos os ponteiros
                dadoASerTratado=NULL;
            }

            //Sucessor
            if(!sucessorEncontrado && i<qtdLinhasArquivo-5 && strstr(dadosArquivo[i], "<tr>")!=NULL && strstr(dadosArquivo[i+1], "<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Sucessor")!=NULL && strstr(dadosArquivo[i+2], "</td>")!=NULL && strstr(dadosArquivo[i+3], "<td style=\"vertical-align: top; text-align: left;\"><a href=\"")!=NULL && strstr(dadosArquivo[i+4], "</td></tr>")!=NULL)
            {
                sucessorEncontrado=true;
                //Filtrando e lendo os dados de dadosArquivo[i+3]
                char *dadoASerTratado=(char*)calloc(1+strlen(dadosArquivo[i+3]), sizeof(char));
                dadoASerTratado=removerBarraN(removerTagHTML(dadosArquivo[i+3]));
                strcpy(presidente.sucessor, dadoASerTratado);

                //Colocando NULL para todos os ponteiros
                dadoASerTratado=NULL;
            }

            //Nome
            if(!nomeCompletoEncontrado && i<qtdLinhasArquivo-8 && strstr(dadosArquivo[i], "<tr>")!=NULL && strstr(dadosArquivo[i+1], "<th colspan=\"2\" style=\"text-align:center; background-color: #E6E6FA\">Dados pessoais")!=NULL && strstr(dadosArquivo[i+2], "</th></tr>") !=NULL && strstr(dadosArquivo[i+3], "<tr>")!=NULL && strstr(dadosArquivo[i+4], "<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nome completo")!=NULL && strstr(dadosArquivo[i+5], "</td>")!=NULL && strstr(dadosArquivo[i+6], "<td style=\"vertical-align: top; text-align: left;\">")!=NULL && strstr(dadosArquivo[i+7], "</td></tr>")!=NULL)
            {
                nomeCompletoEncontrado=true;
                //Filtrando e lendo os dados de dadosArquivo[i+6]
                char *dadoASerTratado=(char*)calloc(1+strlen(dadosArquivo[i+6]), sizeof(char));
                dadoASerTratado=removerBarraN(removerTagHTML(dadosArquivo[i+6]));
                strcpy(presidente.nome, dadoASerTratado);

                //Colocando NULL para todos os ponteiros
                dadoASerTratado=NULL;
            }

            //Nascimento
            if(!nascimentoEncontrado && i<qtdLinhasArquivo-5 && strstr(dadosArquivo[i], "<tr>")!=NULL && strstr(dadosArquivo[i+1], "<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nascimento")!=NULL && strstr(dadosArquivo[i+2], "</td>")!=NULL && strstr(dadosArquivo[i+3], "<td style=\"vertical-align: top; text-align: left;\"><a href=\"")!=NULL && strstr(dadosArquivo[i+4], "</td></tr>")!=NULL)
            {
                nascimentoEncontrado=true;
                //Filtrando e lendo os dados de dadosArquivo[i+3]
                char *dadoASerTratado=(char*)calloc(1+strlen(dadosArquivo[i+3]), sizeof(char));
                dadoASerTratado=removerTagHTML(dadosArquivo[i+3]);
                int len_dadoASerTratado=strlen(dadoASerTratado);

                //Lendo o dia de nascimento
                int j=0;
                while(!ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                int esquerda=j;
                while(ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                int direita=j;
                presidente.dataNascimento.dia=atoi(str_substring(dadoASerTratado, esquerda, direita));

                //Lendo o mes de nascimento
                esquerda=j=3+str_indexOfBegin(dadoASerTratado, strdup("de"), j);
                direita=j=str_indexOfBegin(dadoASerTratado, strdup(" de"), j);
                char *mes=(char*)calloc(1+direita-esquerda, sizeof(char));
                mes=str_substring(dadoASerTratado, esquerda, direita);
                presidente.dataNascimento.mes=numeroMes(mes);
                
                //Lendo o ano de nascimento
                esquerda=j=3+str_indexOfBegin(dadoASerTratado, strdup("de"), j);
                while(ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                direita=j;
                presidente.dataNascimento.ano=atoi(str_substring(dadoASerTratado, esquerda, direita));

                //Lendo o local de nascimento
                j=len_dadoASerTratado-1;
                while(!ehNumero(dadoASerTratado[j]) && j>=0)
                    j--;
                esquerda=j+2;
                char *localNascimento=(char*)calloc(1+len_dadoASerTratado-esquerda, sizeof(char));
                localNascimento=removerBarraN(str_substring(dadoASerTratado, esquerda, len_dadoASerTratado));
                if(strstr(localNascimento, "anos) ")!=NULL)
                {
                    char *tmp=(char*)calloc(1+strlen(localNascimento), sizeof(char));
                    tmp=str_replaceAll(localNascimento, strdup("anos) "), strdup("\0"));//ATENCAO
                    free(localNascimento);
                    localNascimento=NULL;
                    localNascimento=tmp;

                    //Colocando NULL para todos os ponteiros
                    tmp=NULL;
                }
                    
                strcpy(presidente.localNascimento, localNascimento);

                //Liberando espaco e colocando NULL para os ponteiros
                free(dadoASerTratado);
                dadoASerTratado=NULL;
                localNascimento=NULL;
                mes=NULL;
            }

            //Morte
            if(!morteEncontrada && i<qtdLinhasArquivo-5 && strstr(dadosArquivo[i], "<tr>")!=NULL && strstr(dadosArquivo[i+1], "<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Morte")!=NULL && strstr(dadosArquivo[i+2], "</td>")!=NULL && strstr(dadosArquivo[i+3], "<td style=\"vertical-align: top; text-align: left;\"><span style=\"white-space:nowrap;\"><a href=\"")!=NULL && strstr(dadosArquivo[i+4], "</td></tr>")!=NULL)
            {
                morteEncontrada=true;
                //Filtrando e lendo os dados de dadosArquivo[i+3]
                char *dadoASerTratado=(char*)calloc(1+strlen(dadosArquivo[i+3]), sizeof(char));
                dadoASerTratado=removerBarraN(removerTagHTML(dadosArquivo[i+3]));
                int len_dadoASerTratado=strlen(dadoASerTratado);

                //Lendo o dia da morte
                int j=0;
                while(!ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                int esquerda=j;
                while(ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                int direita=j;
                presidente.dataMorte.dia=atoi(str_substring(dadoASerTratado, esquerda, direita));
                
                //Lendo o mes da morte
                esquerda=j=3+str_indexOfBegin(dadoASerTratado, strdup("de"), j);
                direita=j=str_indexOfBegin(dadoASerTratado, strdup(" de"), j);
                char *mes=(char*)calloc(1+direita-esquerda, sizeof(char));
                mes=str_substring(dadoASerTratado, esquerda, direita);
                presidente.dataMorte.mes=numeroMes(mes);

                //Lendo o ano
                esquerda=j=3+str_indexOfBegin(dadoASerTratado, strdup("de"), j);
                while(ehNumero(dadoASerTratado[j]) && j<len_dadoASerTratado)
                    j++;
                direita=j;
                presidente.dataMorte.ano=atoi(str_substring(dadoASerTratado, esquerda ,direita));
                
                //Lendo o local da morte
                j=len_dadoASerTratado-1;
                while(!ehNumero(dadoASerTratado[j]) && j>=0)
                    j--;
                esquerda=j+2;
                char *localMorte=(char*)calloc(1+len_dadoASerTratado-esquerda, sizeof(char));
                localMorte=str_substring(dadoASerTratado, esquerda, len_dadoASerTratado);
                if(strstr(localMorte, "anos) ")!=NULL)
                {
                    char *tmp=(char*)calloc(1+strlen(localMorte), sizeof(char));
                    tmp=str_replaceAll(localMorte, strdup("anos) "), strdup("\0"));//<-ATENCAO
                    free(localMorte);
                    localMorte=NULL;
                    localMorte=tmp;

                    //Colocando NULL para todos os ponteiros
                    tmp=NULL;
                }
                    
                strcpy(presidente.localMorte, localMorte);

                //Liberando espaco e Colocando NULL para todos os ponteiros
                free(dadoASerTratado);
                dadoASerTratado=NULL;
                mes=NULL;
                localMorte=NULL;
                
            }
        }
        if(!vicePresidenteEncontrado)
        {
            presidente.vice[0]='\0';
        }
        if(!antecessorEncontrado)
        {
            presidente.antecessor[0]='\0';
        }
        if(!sucessorEncontrado)
        {
            presidente.sucessor[0]='\0';
        }
        if(!morteEncontrada)
        {
            presidente.dataMorte.dia=0;
            presidente.dataMorte.mes=0;
            presidente.dataMorte.ano=0;
            presidente.localMorte[0]='\0';
        }

        //Calculando a idade
        time_t timer;
        struct tm* tm_info;
        char ano[5];
        time(&timer);
        tm_info = localtime(&timer);
        strftime(ano, 5, "%Y", tm_info);
        presidente.idade=atoi(ano)-presidente.dataNascimento.ano;
        tm_info=NULL;
        fclose(arquivo);
        
            
    }
    else
    {
        printf("\nErro: O arquivo eh nulo!\n");
        printf("\nNome do arquivo: %s\n", nomeArquivo);
    }

    //Colocando NULL para todos os ponteiros
    nomeArquivo=NULL;
    arquivo=NULL;

    return presidente;
}//fim da funcao lerArquivo

/**
 * Funcao da funcao: Esta funcao serve para inserir uma Struct Presidente no inicio da lista de alocacao sequencial.
 * @param x Struct Presidente que sera adicionada no inicio da lista de alocacao sequencial.
*/
void inserirInicio(Presidente x)
{
    int i;
    //Validar insercao
    if(n>=MAXTAM)
    {
        printf("Erro ao inserir: Nao tem mais espaco!");
        exit(1);
    }

    //Levando elementos para o fim do array
    for(i=n;i>0;i--)
        presidentes[i]=presidentes[i-1];

    presidentes[0]=x;
    n++;
}//fim da funcao inserirInicio

/**
 * Funcao da funcao: Esta funcao serve para inserir uma Struct Presidente no final da lista de alocacao sequencial.
 * @param x Struct Presidente que sera adicionada no final da lista de alocacao sequencial.
*/
void inserirFim(Presidente x)
{
    //Validar insercao
    if(n>=MAXTAM)
    {
        printf("Erro ao inserir: Nao tem mais espaco!");
        exit(1);
    }

    presidentes[n]=x;
    n++;
}//fim da funcao inserirFim

/**
 * Funcao da funcao: Esta funcao serve para inserir uma Struct Presidente em uma posicao espefica da lista de alocacao sequencial.
 * @param x Struct Presidente que sera adicionada em uma posicao especifica da lista de alocacao sequencial.
 * @param posicao Posicao a qual a Struct Presidente sera inserida na lista da alocacao sequencial.
*/
void inserir(Presidente x, int posicao)
{
    int i;
    //Validar insercao
    if(n>=MAXTAM || posicao<0 || posicao>n)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    //levar elementos para o fim do array
    for(i=n;i>posicao;i--)
        presidentes[i]=presidentes[i-1];

    presidentes[posicao]=x;
    n++;
}//fim da funcao inserir

/**
 * Funcao da funcao: Esta funcao serve para remover uma Struct Presidente da posicao inicial da lista de alocacao sequencial.
 * @return Struct Presidente que foi removida da lista de alocacao sequencial.
*/
Presidente removerInicio()
{
    int i;
    Presidente resposta;

    //validar remocao
    if(n==0)
    {
        printf("Erro ao remover: Nao ha presidente para remover!");
    }

    resposta=presidentes[0];
    n--;

    for(i=0;i<n;i++)
        presidentes[i]=presidentes[i+1];

    return resposta;
}//fim da funcao removerInicio

/**
 * Funcao da funcao: Esta funcao serve para remover uma Struct Presidente da posicao final da lista de alocacao sequencial.
 * @return Struct Presidente que foi removida da lista de alocacao sequencial.
*/
Presidente removerFim()
{
    //validando remocao
    if(n==0)
    {
        printf("Erro ao remover: Nao ha presidente para remover!");
        exit(1);
    }

    return presidentes[--n];
}//fim da funcao removerFim

/**
 * Funcao da funcao: Esta funcao serve para remover uma Struct Presidente de uma posicao especifica da lista de alocacao sequencial.
 * @param posicao Posicao da lista de alocacao sequencial que sera removida.
 * @return Struct Presidente que foi removida da lista de alocacao sequencial.
*/
Presidente remover(int posicao)
{
    int i;
    Presidente resposta;

    //validar remocao
    if(n==0 || posicao<0 || posicao>=n)
    {
        printf("Erro ao remover!");
        exit(1);
    }

    resposta=presidentes[posicao];
    n--;

    for(i=posicao;i<n;i++)
    {
        presidentes[i]=presidentes[i+1];
    }

    return resposta;
}//fim da funcao remover

/**
 * Funcao da funcao: Esta funcao serve para imprimir os dados de todos os presidentes da lista de alocacao sequencial.
*/
void mostrar()
{
    for(int i=0;i<n;i++)
    {
        //printf("[%d] ", i);
        imprimir(presidentes[i]);
    }
}//fim da funcao mostrar

/**
 * Funcao da funcao: Esta funcao serve para verificar se um caractere eh uma letra.
 * @param c Caractere que sera verificado se eh letra.
 * @return Valor booleano indicando se o caractere eh uma letra.
*/
bool ehLetra(char c)
{
    bool ehLetra=false;
    if((c>='a' && c<='z') || (c>='A' && c<='Z'))
    {
        ehLetra=true;
    }
    return ehLetra;
}//fim da funcao ehLetra

/**
 * Funcao da funcao: Esta funcao serve para comparar duas datas diferentes
 * @param x Data que sera comparada com a data y.
 * @param y Data que sera comparada com a data x.
 * @return Numero inteiro: 0 se for igual, 1 se data x for maior que data x, -1 se data y for maior que data x.
*/
int compareToData(Data x, Data y)
{
    int comparacao=0;

    //Comparando os anos
    if(x.ano<y.ano)
    {
        comparacao=-1;
    }
    else if(x.ano>y.ano)
    {
        comparacao=1;
    }
    else
    {
        //Comparando os meses
        if(x.mes<y.mes)
        {
            comparacao=-1;
        }
        else if(x.mes>y.mes)
        {
            comparacao=1;
        }
        else
        {
            //Comparando os dias
            if(x.dia<y.dia)
            {
                comparacao=-1;
            }
            else if(x.dia>y.dia)
            {
                comparacao=1;
            }
            else
            {
                comparacao=0;
            }
        }
    }

    return comparacao;
}//fim do metodo compareToData

/**
 * Funcao da funcao: Esta funcao serve para trocar elementos do arranjo de duas posicoes diferentes.
 * @param index1 Posicao do arranjo que sera trocada com index2.
 * @param index2 Posicao do arranjo que sera trocada com index1.
*/
void swap(int index1, int index2)
{
    Presidente tmp=presidentes[index1];
    presidentes[index1]=presidentes[index2];
    presidentes[index2]=tmp;
}//fim do metodo swap

/**
 * Funcao da funcao: Esta funcao serve para ordenar os objetos do tipo Presidente do arranjo utilizando como chave a data de inicio do mandato.
 * @param inicio Inicio do arranjo a ser ordenado.
 * @param fim Fim do arranjo a ser ordenado.
*/
void quickSort(int inicio, int fim)
{
    int i=inicio;
    int k=fim;
    if(fim-inicio>=1)
    {
        Data pivo=presidentes[inicio].inicioMandato;
        while(k>i)
        {
            while(compareToData(presidentes[i].inicioMandato, pivo)<=0 && i<=fim && k>i)
            {
                i++;
            }
            while(compareToData(presidentes[k].inicioMandato, pivo)>0 && k>=inicio && k>=i)
            {
                k--;
            }
            if(k>i)
            {
                swap(i, k);
            }
        }
        swap(inicio, k);
        quickSort(inicio, k-1);
        quickSort(k+1, fim);
    }
}//fim da funcao quickSort

/**
 * Funcao da funcao: Esta funcao serve para ordenar os objetos do tipo Presidente do arranjo utilizando como chave a data de inicio do mandato.
*/
void quickSortInicio()
{
    quickSort(0, n-1);
}//fim da funcao quickSortInicio

/**
 * Funcao da funcao: Esta funcao serve para ordenar todos os elementos do arranjo presidentes tendo como chave a data de inicio de mandato de cada presidente e utilizando o quickSort.
*/
void ordenar()
{
    srand(time(NULL));
    clock_t comeco=clock();
    quickSortInicio();
    clock_t fim=clock();
    double total=(clock() - comeco) / (double)CLOCKS_PER_SEC / 1000.0;
    FILE *arquivo =fopen("618557_quicksort.txt", "a");
    fprintf(arquivo, "Tempo para ordenar: %lf milisegundos.\n", total);
    fclose(arquivo);
}//fim da funcao ordenar

/**
 * Funcao da funcao: Esta funcao serve para obter o numero da posicao da ultima letra em um arranjo de caracteres.
 * @param *s Ponteiro apontando para um arranjo de caracteres o qual devera ser retornada a posicao da ultima letra.
 * @return Posicao da ultima leta do arranjo de caracteres.
*/
int posicaoUltimaLetra(char *s)
{
    int i=strlen(s)-1;
    while(!(ehLetra(s[i])) && i>=0)
    {
        i--;
    }
    return i;    
}//fim da funcao posicaoUltimaLetra 

/**
 * Funcao do metodo: Este metodo serve para iniciar o programa.
 * @return Numero inteiro indicando se o programa finalizou de forma correta. 0-> Finalizou de forma correta 1-> Ocorreu erro.
*/
int main()
{
    char *arquivo[MAXTAM];
    for(int i=0;i<MAXTAM;i++)
        arquivo[i]=(char*)calloc(TAMANHO_PADRAO_STRING, sizeof(char));
    
    //Lendo os arquivos dos presidentes    
    int i=0;
    do
    {
        scanf("%s", arquivo[i]);
    }
    while(strncmp(arquivo[i++], "FIM", 3)!=0 && i<MAXTAM);
    
    //Carregando os arquivos presidentes para a lista
    i=0;
    while(strncmp(arquivo[i], "FIM", 3)!=0 && i<MAXTAM)
    {
        Presidente x;
        x=lerArquivo(arquivo[i]);
        inserirFim(x);
        i++;
    }

    ordenar();
    mostrar();
    printf("\n");

    return 0;
}//fim da funcao main