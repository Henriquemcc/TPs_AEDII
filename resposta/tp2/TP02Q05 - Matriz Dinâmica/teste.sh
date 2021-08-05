echo "Compilando o programa";
javac TP02Q05.java;
echo "Testando o programa";
java TP02Q05 <pub.in >saida.teste;
read -p 'Deseja visualizar as diferenças das saidas? (s/n) ' exibirDiferencasSaidas;
if [ "$exibirDiferencasSaidas" == "s" ]
then
echo "Exibindo a diferença das saidas";
gvimdiff saida.teste pub.out;
fi
echo "Deletando os lixos";
rm *.class;
#rm saida.teste;
