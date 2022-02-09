/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Leonel
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        File ruta;
                  Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        
        while (!salir) {
            System.out.println();
            System.out.println("1. Opcion lenguaje {0n1n| n >=0}");
            System.out.println("2. Opcion lenguaje reflejo ");
            System.out.println("3. Salir");
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Has seleccionado la opcion 1");
                        ruta = new File("C://Users//Leonel//Documents//UTM//semestre3//Computacion//Automatadepila//src//automatadepila//data_er1.txt");
                        Automata automata = new Automata(ruta); 
                        automata.mostrarInformacionAutomata();
                        automata.ejecutarAutomata();
                    }
                    case 2 -> {
                        System.out.println("Has seleccionado la opcion 2");
                        ruta = new File("C://Users//Leonel//Documents//UTM//semestre3//Computacion//Automatadepila//src//automatadepila//data_er1.txt");
                        Automata automata2 = new Automata(ruta); 
                        automata2.mostrarInformacionAutomata();
                        automata2.ejecutarAutomata();
                    }
                    case 3 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 3");
                }
                //opcion =0;
            } catch (IllegalStateException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    
    
    }
}
