#include <stdio.h>
#include <string.h>
#define boolean short
#define true 1
#define false 0

/**
 * @author Henrique Mendonca Castelar Campos
 * @version 1.0
 * @since 2019-02-18
*/

/**
 * Funcao da funcao: Esta funcao serve para contar a quantidade de caracteres validos um um arranjo de caracteres.
 * @param s Arranjo de caracteres que sera analisado.
 * @param posicao Posicao que a partir dela sera andado e verificado no arranjo.
 * @return int Valor Inteiro com o numero de caracteres presentes no arranjo de caracteres.
*/
int stringLengthCharInt(char s[], int posicao)
{
    int length=0;
    if(s[posicao]!='\0')
    {
        //printf("Variavel posicao: %d", posicao);
        length++;
        length+=stringLengthCharInt(s, posicao+1);
    }
    return length;
}

/**
 * Funcao da funcao: Esta funcao serve para contar a quantidade de caracteres validos um um arranjo de caracteres.
 * @param s Arranjo de caracteres que sera analisado.
 * @return int Valor Inteiro com o numero de caracteres presentes no arranjo de caracteres.
*/
int stringLengthChar(char s[])
{
    return stringLengthCharInt(s, 0);
}

/**
 * Funcao da funcao: Esta funcao serve para verificar se um arranjo de caracteres eh palindromo ou nao.
 * @param s Arranjo de caracteres que sera analisado.
 * @param cabecoteEsquerdo Posicao do arranjo na esquerda que verificara com o caractere da string na posicao cabecoteDireito se eh ou nao um palindromo. 
 * @param cabecoteDireito Posicao do arranjo na direita que verificara com  o caractere de String na posicao cabecoteEsquerdo se eh ou nao um palindromo.
 * @return Boolean Valor Booleano indicando se a string eh um palindromo.
*/
boolean ehPalindromoCharInt(char s[], int cabecoteEsquerdo, int cabecoteDireito)
{
    boolean ehPalindromo=true;
    if(cabecoteEsquerdo<cabecoteDireito)
    {
        if(s[cabecoteEsquerdo]==s[cabecoteDireito])
            ehPalindromo=ehPalindromoCharInt(s, cabecoteEsquerdo+1, cabecoteDireito-1);
        else
            ehPalindromo=false;
    }
    return ehPalindromo;
}

/**
 * Funcao da funcao: Esta funcao serve para verificar se um arranjo de caracteres eh palindromo ou nao.
 * @param s Arranjo de caracteres que sera analisado.
 * @return Boolean Valor Booleano indicando se a string eh um palindromo.
*/
boolean ehPalindromoChar(char s[])
{
    return ehPalindromoCharInt(s, 0, stringLengthChar(s)-2);
}

/**
 * Funcao da funcao: Esta funcao serve para verificar se duas strings sao iguais.
 * @param s1 Arranjo de caracteres que sera verificado se eh igual com o arranjo s2.
 * @param s2 Arranjo de caracteres que sera verificado se eh igual com o arranjo s1.
 * @param posicao Posicao que sera verificado se eles sao iguais.
 * @return boolean Valor booleano indicando se elas sao ou nao iguais.
*/
boolean stringEqualsCharCharInt(char s1[], char s2[], int posicao)
{
    boolean ehIgual=true;
    if(posicao<stringLengthChar(s1))
    {
        if(s1[posicao]==s2[posicao])
            ehIgual=stringEqualsCharCharInt(s1, s2, posicao+1);
        else
            ehIgual=false;
    }
    return ehIgual;
}

/**
 * Funcao da funcao: Esta funcao serve para verificar se duas strings sao iguais.
 * @param s1 Arranjo de caracteres que sera verificado se eh igual com o arranjo s2.
 * @param s2 Arranjo de caracteres que sera verificado se eh igual com o arranjo s1.
 * @return boolean Valor booleano indicando se elas sao ou nao iguais.
*/
boolean stringEqualsCharChar(char s1[], char s2[])
{
    boolean ehIgual=false;
    if(stringLengthChar(s1)==stringLengthChar(s2))
        ehIgual=stringEqualsCharCharInt(s1, s2, 0);

    return ehIgual;
}

/**
* Funcao da funcao: Este metodo eh responsavel por executar o programa.
* @return int Retorno padrao da linguagem C.
*/
int main()
{

    char dado[1024];
    do
    {
        //gets(dado);
        fgets(dado, 1024, stdin);
        //printf("%s\n", dado);
        if(strncmp(dado, "FIM",3) != 0)
        {
            if(ehPalindromoChar(dado)) 
                printf("SIM\n");
            else 
                printf("NAO\n");

        }
            

    }
    while(strncmp(dado, "FIM",3) != 0);
    return 0;
}