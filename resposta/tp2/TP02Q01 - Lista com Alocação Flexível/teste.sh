echo "Compilando o programa";
javac TP02Q01.java;
read -p 'Deseja extrair o arquivo presidente.zip para a pasta /tmp? (s/n) ' extrairPresidente;
if [ "$extrairPresidente" == "s" ]
then
unzip ../presidente.zip -d /tmp/;
fi
echo "Testando o programa";
java TP02Q01 <pub.in >saida.teste;
read -p 'Deseja visualizar as diferenças das saidas? (s/n) ' exibirDiferencasSaidas;
if [ "$exibirDiferencasSaidas" == "s" ]
then
echo "Exibindo a diferença das saidas";
vimdiff saida.teste pub.out;
fi
echo "Deletando os lixos";
rm *.class;
rm saida.teste;
