/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leonel
 */
public class cubo 
{
    public static void main(String[] args) {
        bloquedeTierra bloque = new bloquedeTierra("Rugosa", 10, "Tierra", "Lodo");
        bloquedeTierra bloque2 = new bloquedeTierra("Rasposa", 15, "Tierra", "Arena");
        
        tipodeCubo[] prueba = new tipodeCubo[2];
        prueba[0] = bloque;
        prueba[1] = bloque2;
        
        for(tipodeCubo estado : prueba)
        {
            System.out.println(estado);
        }
    }
}

abstract class tipodeCubo{ //clase general para la POO y polimorfismo que se redifine como abstracta
    //atributos generales
    private String tipodecubo;
    private int dimension;
    private String textura;
    
    public tipodeCubo(String tipo, int dimensionRecibida, String texturaRecibida)
    {
        tipodecubo = tipo;
        dimension = dimensionRecibida;
        textura = texturaRecibida;
    }
    public void setTipodecubo(String tipo)
    {
        if(tipo!=null)
        {
            tipodecubo = tipo;
        }else{
            System.out.println("Error tienes que especificar algo");
        }
    }
    public String getTipodecubo()
    {
        return tipodecubo;
    }
    public void setDimension(int dimensionRecibida)
    {
        if(dimensionRecibida >0)
        {
            dimension = dimensionRecibida;
        }else{
            System.out.println("La dimension tiene que ser positiva");
        }
    }
    public int getDimension()
    {
        return dimension;
    }
    public void setTextura(String texturaRecibido)
    {
        if(texturaRecibido!=null)
        {
            textura = texturaRecibido;
        }else{
            System.out.println("Especifica una textura");
        }
    }
    public String getTextura()
    {
        return textura;
    }
    @Override 
    public String toString()
    {
        return String.format("\n Tipo: %s Textura :%s Dimesion: %s", getTipodecubo(),getTextura(), getDimension());
    }
}

//Clase del bloque de tierra que hereda los metodos del tipo de cubo
class bloquedeTierra extends tipodeCubo
{
    private String tipodeTierra; //atributo de la clase Bloque de tierra
    public bloquedeTierra(String texturaRecibida, int dimensionRecibida, String tipodecuboRecibido, String tipodeTierra)
    {
        super(tipodecuboRecibido, dimensionRecibida, texturaRecibida); //mandamos a llamar el constructor de la clase tipo cubo
        setTipodeTierra(tipodeTierra);
    }
    public void setTipodeTierra(String tipodeTierraRecibida)
    {
        if(tipodeTierraRecibida!=null)
        {
            tipodeTierra = tipodeTierraRecibida;
        }else{
            System.out.println("tipo de tierra no valido");
        }
    }
    public String getTipodeTierra()
    {
        return tipodeTierra;
    }
    @Override
    public String toString()
    {
        return String.format("%s%s%s",super.toString(),"\tTierra de ", getTipodeTierra());
    }
}