package examen;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int codigo = 0;
		char letra = ' ';
		boolean comprueba = false;
		boolean iguales = false;
		
		Criptograma.desordenaAbecedario();
		Criptograma.eligeFrase();
		Criptograma.codificaFrase();
		
		do {
			System.out.println(Criptograma.fraseCodificada);
			System.out.println("Inserte codigo");
			codigo = sc.nextInt();
			sc.nextLine();
			System.out.println("Inserte letra");
			letra = sc.next().charAt(0);
			
			comprueba = Criptograma.compruebaCodigo(letra, codigo);
			
			if(comprueba) {
				System.out.println("Has acertado");
			}else {
				System.out.println("No has acertado");
			}
			
			iguales = Criptograma.sonIguales();
		}while(!iguales);
		
		System.out.println("Enhorabuena!!");
		
		sc.close();
	}

}
