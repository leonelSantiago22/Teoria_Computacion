/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonel
 * 
 */

/*
Desktop Usario Area Volumen
Laptop Modelo Area Volumen
*/
public class Ejercicio1 {
    public static void main(String[] args) {
        Desktop desktop = new Desktop("Leo", 10, 15);
        Laptop laptop = new Laptop("Asus", 50,35);
        System.out.println(laptop.getArea()+" "+laptop.getVolumen()+" "+laptop.getModelo());
        System.out.println(desktop.getArea()+" "+desktop.getVolumen()+" "+desktop.getUsuario());
        desktop.usuario("Leo 2");
        laptop.setModelo("Leenovo");
        Computadora[] prueba = new Computadora[2];
        prueba[0] = desktop;
        prueba[1] = laptop;
        
        System.out.println("Imprimimos Polimorficamente ");
        for(Computadora estado : prueba)
        {
            System.out.println(estado); //Manda a traer el toString
            if(estado instanceof Laptop)
            {
                Laptop estadito = (Laptop) estado;
                estadito.Area(1 * estadito.getArea());
                System.out.printf("\nNueva Area %s\n", estadito.getArea());
            }
        }
        for(int i =0; i<prueba.length; i++)
        {
            System.out.println( prueba[i]);
            
        }
    }
}

interface IComputadora {
    public void Area(int A);
    public int getArea();
    public void Volumen(int v);
    public int getVolumen();
}

abstract class Computadora implements IComputadora{
    private int Area;
    private int Volumen;
    private final CPU objetoCPU = new CPU();
    public Computadora(int A, int V)
    {
        Area = A;
        Volumen = V;
    }
    public void Area(int A)
    {
        Area = A*A;
    }
    public int getArea()
    {
        return Area;
    }
    public void Volumen(int v)
    {
        if(v >0 )
        {
            Volumen = v;
        }else{
            System.out.println("Volumen no valido");
        }
    }
    public int getVolumen()
    {
        return Volumen;
    }
    @Override
    public String toString()
    {
        return String.format("%s volumen %s Area",getArea(), getVolumen());
    }
    public abstract String Usuario();
}

class CPU
{
    private String cpu;
    public void setCPU(String c)
    {
        if(c!=null)
        {
            cpu = c;
        }else {
            System.out.println("Error");
        }
    }
    public String getCPU()
    {
       return cpu;
    }
}

class Desktop extends Computadora
{
    private String usuario;
    public Desktop(String usu, int A, int V)
    {
        super(A,V);
        usuario(usu);
    }
    public void usuario(String usu)
    {
        if(usu != null)
        {
            usuario = usu;
        }else{
            System.out.println("Usuario invalido");
        }
    }
    public String getUsuario()
    {
        return usuario;
    }
    @Override
    public String Usuario()
    {
        return getUsuario();
    }
    @Override
    public String toString()
    {
        return String.format("%s%s",super.toString(),"\tUsuario\t%s",getUsuario());
    }
}

class Laptop extends Computadora
{
    private String modelo;
    public Laptop(String model, int A, int V)
    {
        super(A,V);
        setModelo(model);
    }
    public void setModelo(String Modelo)
    {
        modelo = Modelo;
    }
    public String getModelo()
    {
        return modelo;
    }
    @Override
    public String Usuario()
    {
        return getModelo();
    }
    @Override 
   public String toString()
    {
     return String.format("%s%s",super.toString(),"\tModelo \t",getModelo());
    }
}
