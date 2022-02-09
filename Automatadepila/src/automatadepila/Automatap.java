
import java.util.Stack;
import java.util.Scanner;

public class Automatap {
    Stack pila= new Stack();
    int contador;
    static char[] cadena;
    boolean cadenavalida;
    char x;

    public static void main(String[] args) {
        Automatap A1= new Automatap();//crear un objeto de automata de pila
        Scanner entrada =  new Scanner(System.in);
        String cadenaleida;
        //leer la cadena ah validar
        System.out.println("Ingresa la cadena a valiadar: ");
        cadenaleida= entrada.nextLine();
        cadena=cadenaleida.toCharArray();//copiar la cadena leida a un arreglo de tipo char 
        A1.inicio();//iniciar con los estados de transicion del automata empezando con el metodo inicio()
        if(A1.cadenavalida){//validar si la cadena es valida
            System.out.println("Cadena valida HDSPTM ");
        }else{
            System.out.println("Cadena No es valida");
        }
    }
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
    
}
