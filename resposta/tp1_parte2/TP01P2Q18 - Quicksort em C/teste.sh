echo "Compilando o programa";
g++ TP01P2Q18.c -g -ggdb
read -p 'Deseja extrair o arquivo presidente.zip para a pasta /tmp? (s/n) ' extrairPresidente;
if [ "$extrairPresidente" == "s" ]
then
unzip ../presidente.zip -d /tmp/;
fi
echo "Testando o programa";
./a.out <pub.in >saida.teste;
read -p 'Deseja visualizar as diferenças das saidas? (s/n) ' exibirDiferencasSaidas;
if [ "$exibirDiferencasSaidas" == "s" ]
then
echo "Exibindo a diferença das saidas";
gvimdiff saida.teste pub.out;
fi
echo "Deletando os lixos";
rm ./a.out;
#rm saida.teste;
