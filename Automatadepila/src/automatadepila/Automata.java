import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.sampled.SourceDataLine;

public class Automata{

    
	/*
	 * ATRIBUTOS
	 */
	
	private ArrayList<String> conjuntoQ;
	private ArrayList<String> conjuntoSigma;
	private ArrayList<String> conjuntoR;
	private ArrayList<String> conjuntoF;
	private ArrayList<String[]> conjuntoTransiciones;
	private String estadoInicial;
	private String simboloInicialPila;
	private String estadoActual;
	private Stack<String> pila;

	/*
	 * CONSTRUCTOR
	 */

	public Automata() throws IOException {

		conjuntoQ = new ArrayList<String>();
		conjuntoSigma = new ArrayList<String>();
		conjuntoR = new ArrayList<String>();
		conjuntoF = new ArrayList<String>();
		conjuntoTransiciones = new ArrayList<String[]>();
		pila = new Stack<String>();
		
		String nombreFichero;
		File ruta;
		Scanner imputNombreFichero = new Scanner(System.in);
		// Pedir el fichero al usuario
		System.out.println("Introduzca el nombre del fichero con los datos del autómata:");
		nombreFichero = imputNombreFichero.nextLine(); //(para versión final)
		ruta = new File(nombreFichero);//"C:\\Users\\hp\\Documents\\Automatawcw.txt"
		// Almacenar la informacion del fichero//""
		String textoFichero;  //"C:\\Users\\hp\\Documents\\A1.txt"
		//FileReader leerFichero = new FileReader("C:\\Users\\hp\\Documents\\Automatawcw.txt");
		//FileReader leerFichero = new FileReader("C:\\Users\\hp\\Documents\\Automatawcw.txt");
		FileReader leerFichero = new FileReader("C:\\Users\\hp\\Documents\\Automata010.txt");
		BufferedReader bufferLectura = new BufferedReader(leerFichero);
		int linea = 0;
		while ((textoFichero = bufferLectura.readLine()) != null) {
			if (textoFichero.matches("#.*"))
				continue;
			else if (textoFichero.matches("\b*"))
				continue;
			else {
				if (linea >= 6) {
					String separarEspacios[] = textoFichero.split(" ");
					conjuntoTransiciones.add(separarEspacios);
				} else {
					String separarEspacios[] = textoFichero.split(" ");
					for (int i = 0; i < separarEspacios.length; i++) {
						if (separarEspacios[i].matches("#.*"))
							break;
						else {
							if (linea == 0)
								conjuntoQ.add(separarEspacios[i]);
							else if (linea == 1)
								conjuntoSigma.add(separarEspacios[i]);
							else if (linea == 2)
								conjuntoR.add(separarEspacios[i]);
							else if (linea == 3)
								estadoInicial = separarEspacios[i];
							else if (linea == 4)
								simboloInicialPila = separarEspacios[i];
							else if (linea == 5)
								conjuntoF.add(separarEspacios[i]);
						}
					}
				}// END IF ELSE INTERIOR
				linea++;
			}// END IF ELSE EXTERIOR
		}// END WHILE
		bufferLectura.close();
	}

	/*
	 * MOSTRAR INFORMACION DEL AUTOMATA
	 */
	
	public void mostrarInformacionAutomata() {
		System.out.println("Información del autómata con pila");
		System.out.println();
		System.out.println("Estado inicial: " + estadoInicial);
		System.out.println("Símbolo inicial de la pila: " + simboloInicialPila);
		System.out.println("Conjunto de estados: " + conjuntoQ.toString());
		System.out.println("Alfabeto del lenguaje: " + conjuntoSigma.toString());
		System.out.println("Alfabeto de la pila: " + conjuntoR.toString());
		System.out.println("Conjunto de estados finales: " + conjuntoF.toString());
		System.out.println("Conjunto de transiciones:");
		for (int i = 0; i < conjuntoTransiciones.size(); i++)
			System.out.println(Arrays.toString(conjuntoTransiciones.get(i)));
		System.out.println("");
	}

	/*
	 * EJECUTAR AUTOMATA
	 */
	
	public void ejecutarAutomata() {
		
		String cadenaEntrada;
		pila.clear();
		pila.push(simboloInicialPila);
		estadoActual = estadoInicial;
		// El usuario inserta la cadena
		System.out.println("Inserte la cadena a probar:");
		System.out.println("(Introduzca siempre '@' al final)");
		Scanner imputUsuario = new Scanner(System.in);
		cadenaEntrada = imputUsuario.nextLine();
		imputUsuario.close();
		
		// Empezamos a evaluar la cadena de entrada
		boolean noTransiciones = true;
		int numeroIteraciones =cadenaEntrada.length();//hacemos esto porque vamos a ir eliminando la entrada
		for (int i = 0; i < numeroIteraciones; i++) {
			String simboloTratado = cadenaEntrada.substring(0, 1);
				cadenaEntrada = cadenaEntrada.substring(1);
			if (noTransiciones == true) { //si existen transiciones sigue
				//vamos eliminando el elemento de la cadena tratado 
				
				
				//System.out.println("Simbolo tratado: "+simboloTratado);//son los elementos de la cadena 
				for (int j = 0; j < conjuntoTransiciones.size(); j++) {
					//si encuentra alguna transicion entra
					
					if (estadoActual.equals(conjuntoTransiciones.get(j)[0])
							&& simboloTratado.equals(conjuntoTransiciones.get(j)[1])
							&& pila.peek().equals(conjuntoTransiciones.get(j)[2])) {
						//ir al otro estado dependiendo de las transiciones:
						estadoActual = conjuntoTransiciones.get(j)[3];
							String aux = conjuntoTransiciones.get(j)[4];
                                                        String aux1 = aux.substring(0,1);
								System.out.println(": "+aux1);
								System.out.println(": "+simboloTratado);
								System.out.println(pila.pop());
								
								
						 
				}
                
			} 
		}//END FOR (NO QUEDAN TRANSICIONES)
      
	}
        System.out.println("Ea: "+estadoActual);
        System.out.println("Pila : "+pila);

		cadenaEsAceptada(cadenaEntrada);
	
	}
	
	/*
	 * COmMPRUEBA SI LA CADENA ES ACEPTADA POR EL AUTÓMATA
	 */
	
	public void cadenaEsAceptada(String cadenaEntrada){
		if(conjuntoF.get(0).equals("@")){//autmata vaciado de pila
			if(cadenaEntrada.isEmpty() && pila.isEmpty()){
				System.out.println("Cadena aceada!");
			}else
				System.out.println("Cadena no aceptada!");
		}else{
			for(int i = 0; i < conjuntoF.size(); i++){
				if(cadenaEntrada.isEmpty() && estadoActual.equals(conjuntoF.get(i))){
					System.out.println("Cadena aceptada!");
					break;
				}else
					System.out.println("Cadena no aceptada");
			}
		}
	}





}