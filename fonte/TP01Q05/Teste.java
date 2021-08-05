import java.io.*;
import java.util.Random;

public class Teste{
	
	public static void main(String args[]){
		Random gerador = new Random();
		gerador.setSeed(4);
		System.out.println(Math.abs(gerador.nextInt()%26));
		System.out.println(Math.abs(gerador.nextInt()%26));
		System.out.println(Math.abs(gerador.nextInt()%26));
		System.out.println(Math.abs(gerador.nextInt()%26));
		System.out.println(Math.abs(gerador.nextInt()%26));
		System.out.println(Math.abs(gerador.nextInt()%26));
	}
}
