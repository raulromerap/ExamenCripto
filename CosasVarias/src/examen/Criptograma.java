package examen;

import java.util.Random;

public class Criptograma {

	/**
	 * Atributo que guarda las letras del abecedario en 3x9
	 */
	 static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	/**
	 * Atributo que guarda las frases que hay que adivinar
	 */
	private static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	/**
	 * Atributo que guarda la frase real, sin codificar
	 */
	private static String fraseReal = "";

	/**
	 * Atributo que guarda la frase codificada
	 */
	public static String fraseCodificada = "";

	/**
	 * Metodo que desordena la tabla del abecedario cambiando una fila por otra
	 */
	public static void desordenaAbecedario() {
		Random aleatorio = new Random();
		int pos;
		char[] aux;

		for (int i = 0; i < abecedario.length; i++) {
			pos = aleatorio.nextInt(0, abecedario.length);
			aux = abecedario[i];
			abecedario[i] = abecedario[pos];
			abecedario[pos] = aux;

		}

	}

	/**
	 * Metodo que elige la frase para adivinar
	 */
	public static void eligeFrase() {
		Random aleatorio = new Random();
		int pos = aleatorio.nextInt(0, frases.length);
		fraseReal = frases[pos];
	}

	/**
	 * Metodo que codifica la frase para que se vea la cadena con su codigo de letra
	 */
	public static void codificaFrase() {
		char[] letras = fraseReal.toCharArray();

		for (char letra : letras) {
			for (int i = 0; i < abecedario.length; i++) {
				for (int j = 0; j < abecedario[i].length; j++) {
					if (letra == abecedario[i][j]) {
						fraseCodificada += i + "" + j + " ";
					} else if(letra == ' '){
						fraseCodificada += " ";
						break;
					}
				} // fin segundo for
			} // fin primer for
		} // fin for-each
	}

	/**
	 * Metodo que comprueba si la letra y el codigo son iguales, en caso de que lo
	 * sea lo cambia por la letra en la frase codificada y manda true, en caso
	 * contrario no se cambia y se manda false
	 * 
	 * @param letra Letra que inserta el usuario
	 * @param codigo Codigo de la letra de la frase codificada
	 * @return Devuelve true en caso de que la letra y el codigo coincida y false en caso contrario
	 */
	public static boolean compruebaCodigo(char letra, int codigo) {
		boolean correcto = false;
		int izq;
		int der;
		String cod ="";

		izq = codigo/10;
		der = codigo%10;
		cod = String.valueOf(izq + "" + der);
		
		if(letra == abecedario[izq][der]) {
			fraseCodificada = fraseCodificada.replace(cod, Character.toString(letra));
			correcto = true;
		}
		
		return correcto;
	}
	
	/**
	 * Metodo que comprueba si las dos frases son iguales
	 * 
	 * @return Devuelve true en caso de que las dos frases sean iguales y false en caso contrario
	 */
	public static boolean sonIguales() {
		boolean igual = true;
		String fraseCod  = "";
		String fraseR = "";
		char[] palabrasCod;
		char[] palabras;
		int i = 0;
		int pos = -1;

		fraseCod = fraseCodificada.replace(" ", "");
		fraseR = fraseReal.replace(" ", "");
		palabrasCod = fraseCod.toCharArray();
		palabras = fraseR.toCharArray();

		
		while (pos == -1) {

			if (i<palabras.length && palabras[i] != (palabrasCod[i])) {
				igual = false;
				pos = 0;
			}

			i++;
		}

		return igual;
	}
	
}
