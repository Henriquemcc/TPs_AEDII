echo "Compilando o programa";
javac TP01Q14.java;
echo "Testando o programa";
java TP01Q14 <pub.in >saida.teste;
echo "Exibindo a diferença das saidas";
vimdiff saida.teste pub.out;
echo "Deletando os lixos";
rm *.class;
rm saida.teste;