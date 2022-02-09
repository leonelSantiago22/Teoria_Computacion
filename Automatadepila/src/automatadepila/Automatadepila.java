/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package automatadepila;
//import Automatap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Leonel
 */
public class Automatadepila {

	/*
	 * ATRIBUTOS
	 */
	  Stack pila= new Stack();
            int contador;
        static char[] cadena;
        boolean cadenavalida;
        char x;
        public void inicio(){
        contador=0;
        cadenavalida=false;
        q0();
    }
    public void q0(){
        cadenavalida=false;
        if(contador<cadena.length){
            //si viene un 0 en la cadena leida se añade en la pila
            if(cadena[contador]=='0'){
                contador++;
                pila.push('0');
                  //y nos quedamos en el mismo estado
                q0();
            }else if(cadena[contador]=='1'){
                //si viene un 1 en la cadena leida se añade en la pila
                contador++;
                pila.push('1');
                //y nos quedamos en el mismo estado
                q0();
            }else if(cadena[contador]=='c'){
                //cuando venga una c entonces nos vamos al siguiente estado
                contador++;
                q1();
            }

        }
   }

   public void q1(){
	//validar que sean los mismos 1´s y 0´s
    if(contador<cadena.length){
        //a x se le asigna el valor de tope de la pila
        x=(char)pila.peek();
        if(cadena[contador]==x){//si el valor del tope de la
           //pila es igual al valor que sigue en la cadena 
           //entonces se elimina
            pila.pop();
            contador++;//Se avanza un lugar en la cadena 
            q1();//se mantiene en el estado q1()
        }
    }
    //si la pila esta vacia entonces la cadena es valida
    if(pila.isEmpty()){
     cadenavalida=true;
    }
   }
        
	private ArrayList<String> conjuntoEstados;
	private ArrayList<String> conjuntoSigma;
	private ArrayList<String> conjuntoR;
	private ArrayList<String> conjuntoF;
	private ArrayList<String[]> transiciones;
        private String estadoInicial;
	private String q0;
	private String Si;

	private String estadoActual;
	private Stack<String> pilaLenguaje2;

	public Automatadepila() throws IOException {
                
		conjuntoEstados = new ArrayList<String>();
		conjuntoSigma = new ArrayList<String>();
		conjuntoR = new ArrayList<String>();
		conjuntoF = new ArrayList<String>();
		transiciones = new ArrayList<String[]>();
		pilaLenguaje2 = new Stack<String>();
		
		String nombreFichero;
		File ruta;                                                                                                                                  //Automata0102 | test
		ruta = new File("C://Users//Leonel//Documents//UTM//semestre3//Computacion//pry3-1-automatapila-equipo5//Automatadepila//src//automatadepila//test.txt");
		// Almacena la informacion del fichero
		String textoFichero;
		FileReader leerFichero = new FileReader(ruta);
		BufferedReader bufferLectura = new BufferedReader(leerFichero);
		int linea = 0;
		while ((textoFichero = bufferLectura.readLine()) != null) {//Extreaemos lo que contiene el fichero
			if (textoFichero.matches("#.*"))
				continue;
			else if (textoFichero.matches("\b*"))
				continue;
			else {
				if (linea >= 6) {
					String separarEspacios[] = textoFichero.split(" ");
					transiciones.add(separarEspacios);
				} else {
					String separarEspacios[] = textoFichero.split(" ");
					for (int i = 0; i < separarEspacios.length; i++) {
						if (separarEspacios[i].matches("#.*"))
							break;
						else {
							if (linea == 0)
								conjuntoEstados.add(separarEspacios[i]);
							else if (linea == 1){
								conjuntoSigma.add(separarEspacios[i]);
                                                        }else if (linea == 2){
								conjuntoR.add(separarEspacios[i]);
                                                        }else if (linea == 3){
                                                         	q0 = separarEspacios[i];
                                                        }else if (linea == 4){
								Si = separarEspacios[i];
                                                        }else if (linea == 5){
								conjuntoF.add(separarEspacios[i]);
                                                        }
						}
					}
				}// END IF ELSE INTERIOR
				linea++;
			}// END IF ELSE EXTERIOR
		}// END WHILE
		bufferLectura.close();
	}
    public void ejecutarAutomatadani() throws IOException
        {
         Automatadepila A1= new Automatadepila();//crear un objeto de automata de pila
        Scanner entrada =  new Scanner(System.in);
        String cadenaleida;
        //leer la cadena ah validar
        System.out.println("Ingresa la cadena a valiadar: ");
        cadenaleida= entrada.nextLine();
        cadena=cadenaleida.toCharArray();//copiar la cadena leida a un arreglo de tipo char 
        A1.inicio();//iniciar con los estados de transicion del automata empezando con el metodo inicio()
        if(A1.cadenavalida){//validar si la cadena es valida
            System.out.println("Cadena valida ");
        }else{
            System.out.println("Cadena No es valida");
        }
    }

	public void mostrarInformacionAutomata() {
		System.out.println("Información del autómata con pila");
		System.out.println();
		System.out.println("Estado inicial: " + q0);
		System.out.println("Símbolo inicial de la pila: " + Si);
		System.out.println("Conjunto de estados: " + conjuntoEstados.toString());
		System.out.println("Alfabeto del lenguaje: " + conjuntoSigma.toString());
		System.out.println("Alfabeto de la pila: " + conjuntoR.toString());
		System.out.println("Conjunto de estados finales: " + conjuntoF.toString());
		System.out.println("Conjunto de transiciones:");
		for (int i = 0; i < transiciones.size(); i++)
			System.out.println(Arrays.toString(transiciones.get(i)));
		System.out.println("");
	}
        
	public void ejecutarAutomata() {
		String cadenaEntrada;
		pilaLenguaje2.clear();
		pilaLenguaje2.push(Si);
		estadoActual = q0;
		// El usuario inserta la cadena
		System.out.println("Inserte la cadena a probar:");
		Scanner imputUsuario = new Scanner(System.in);
		cadenaEntrada = imputUsuario.nextLine();
		imputUsuario.close();
		// Empezamos a evaluar la cadena de entrada
		boolean noTransiciones = true;
		int numeroIteraciones = cadenaEntrada.length();//hacemos esto porque vamos a ir eliminando la entrada
		for (int i = 0; i < numeroIteraciones; i++) {
			if(noTransiciones==true){
			 //si existen transiciones sigue
				//vamos eliminando el elemento de la cadena tratado 
				String simboloTratado = cadenaEntrada.substring(0, 1);
				cadenaEntrada = cadenaEntrada.substring(1);
				noTransiciones = false;//suponemos, a priori, que no hay transiciones
				
				for (int j = 0; j < transiciones.size(); j++) {
					//si encuentra alguna transicion entra
					if (estadoActual.equals(transiciones.get(j)[0])
							&& simboloTratado.equals(transiciones.get(j)[1])
							&& pilaLenguaje2.peek().equals(transiciones.get(j)[2])) {
						estadoActual = transiciones.get(j)[3];
                                                System.out.println(estadoActual);
						System.out.println(pilaLenguaje2.pop());
						//Si la pila tiene mas de un elemento hay que meterlos uno a uno separados
						if(transiciones.get(j)[4].length() > 1){
							String aux = transiciones.get(j)[4];
							for(int k = 0; k < transiciones.get(j)[4].length(); k++){
								String aux1 = aux.substring(aux.length()-1);
								aux = aux.substring(0,aux.length()-1);
                                                                    pilaLenguaje2.push(aux1);
							}
						}else{//si no, no hace falta separar
								
								if(transiciones.get(j)[4].equals(".")){
                                                                    
								//si es un, vacío no hacer nada
							}else{	
								pilaLenguaje2.push(transiciones.get(j)[4]);
							}
							
                                                }
                                               
						noTransiciones = true;
						break;//si se encuentra la transicion pasa al siguiente simbolo de la cadena
					}
				}
                        }else{
                            break;
                        }
		}//END FOR (NO QUEDAN TRANSICIONES)
		cadenaEsAceptada(cadenaEntrada);
	}
	public void cadenaEsAceptada(String cadenaEntrada){
		if(conjuntoF.get(0).equals(".")){//autmata vaciado de pila
			if(cadenaEntrada.isEmpty() &&  pilaLenguaje2.isEmpty()){
				System.out.println("Cadena pertenece al lenguaje "+conjuntoSigma.toString());
			}else
				System.out.println("Cadena no aceptada!");
		}else{
				if(cadenaEntrada.isEmpty() && estadoActual.equals(conjuntoF.get(0))){
					System.out.println("Cadena que pertene al lenguaje fue validada por vaciar la pila "+conjuntoSigma.toString());
					
				}else{
                                    
                                        System.out.println("Cadena no perteneciente al lenguaje");
                                }
					
			
		}
	}
        
        
        public static void main(String[] args) throws IOException {
         Automatadepila automata = new Automatadepila(); 
         Automatadepila automata2 = new Automatadepila();
         automata.mostrarInformacionAutomata();
         automata.ejecutarAutomata();
         
    
    }
}