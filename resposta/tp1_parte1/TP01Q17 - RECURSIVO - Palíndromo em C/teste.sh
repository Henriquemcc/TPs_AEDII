echo "Compilando o programa";
gcc TP01Q17.c -o TP01Q17.exe;
echo "Testando o programa";
./TP01Q17.exe <pub.in >saida.teste;
echo "Exibindo a diferença das saidas";
vimdiff saida.teste pub.out;
echo "Deletando os lixos";
rm *.exe;
rm saida.teste;