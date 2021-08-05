/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-12
*/

#include <stdio.h>
#define boolean short
#define true 1
#define false 0


/**
 * Funcao da funcao: Esta funcao eh responsavel por determinar o tamanho da string, sendo equivalente a funcao .length() da lingugem Java.
 * @param string String que sera identificado o seu tamanho.
 * @return int Numero inteiro indicando a quantidade de caracteres presentes na string.
*/
int stringLength(char string[])
{
    int length=0;
    while(string[length]!='\0')
    {
        length++;
    }
    return length;
}

/**
* Funcao da funcao: Este metodo eh responsavel por verificar se a string passada por parametro eh palindromo, retornando um valor booleano.
* @param string String que sera analisada se eh ou nao palindromo.
* @return boolean Valor booleano indicando se eh ou nao palindromo.
*/
boolean ehPalindromo(char string[])
{
    int stringDotLength=stringLength(string);
    boolean ehPalindromoSim=true;
    
    

    //verificando se eh Palindromo
    int i=0;
    while(ehPalindromoSim&&i<=stringDotLength/2)
    {
        int cabecoteEsquerdo=i;
        int cabecoteDireito=stringDotLength-1-i;
        if(string[cabecoteEsquerdo]!=string[cabecoteDireito])
            ehPalindromoSim=false;
        i++;
    };
    return ehPalindromoSim;

}

/**
* Funcao da funcao: Este metodo serve para verificar se duas strings sao iguais, substituindo o metodo equals da class String nativa da linguagem Java.
* @param string1 String que sera comparada com a s2.
* @param string2 String que sera comparada com a s1.
* @return boolean Valor booleano relacionado ao fato das duas strings serem iguais.
*/
boolean stringEquals(char string1[], char string2[])
{
    boolean ehIgual=false;

    //Obtendo Comparando o tamanhos das strings
    int string1DotLength=stringLength(string1);
    int string2DotLength=stringLength(string2);

    if(string1DotLength==string2DotLength)
    {
        ehIgual=true;
        int i=0;
        while(ehIgual&&i<string1DotLength)
        {
            if(string1[i]!=string2[i]) 
                ehIgual=false;
            i++;

        }
    }
    return ehIgual;
    
}//fim da funcao stringEquals

/**
* Funcao da funcao: Este metodo eh responsavel por executar o programa.
* @return int Retorno padrao da linguagem C.
*/
int main()
{
    char dado[1024];
    do
    {
        gets(dado);
        if(!stringEquals(dado, "FIM"))
        {
            if(ehPalindromo(dado)) 
                printf("SIM\n");
            else 
                printf("NAO\n");
        }
            

    }
    while(!stringEquals(dado, "FIM"));
    return 0;
}