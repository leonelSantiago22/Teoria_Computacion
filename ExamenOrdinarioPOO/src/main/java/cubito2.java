/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonel
 */
public class cubito2 {
        public static void main(String[] args) {
            carbon c = new carbon();
            diamante d = new diamante();
            c.Destruir();
            d.Destruir();
            System.out.println("");
    }
}
abstract class cubote
{
    protected int dimension;
    protected String nombre;
    
    public void Destruir()
    {
        System.out.println("Me rompi pero no te dare nada");
    }
}

class carbon extends cubote
{
    public void Destruir()
    {
        System.out.println("Te dare un carbon");
    }
}

class diamante extends cubote 
{
    public void Destruir()
    {
        System.out.println("Me rompi ten un diamante");
    }
}