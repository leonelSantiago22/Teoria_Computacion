#include <iostream>
using namespace std; 
class Hora 
{
    friend ostream &operator <<(ostream &, const Hora &);
    private:
        int hora; 
        int minutos;
        int segundos;
    
    public:
    Hora (int h, int m, int s)
    {
       if (s>=60)
       {
           m++;
        s -= 60;
       }
       if (m>=60)
       {
           h++;
           m-=60;
       }
       if (h>=24)
       {
           h=0;
           m=0;
           s=0;
       }
       hora =h;
       minutos =m;
       segundos = s;
       
    }
    Hora(const Hora &copia)
    {
        hora =0;
        minutos =0;
        segundos =0;
        *this = copia;
    }
    void setHora(int h);
    int getHora();
    void setMinuto(int m);
    int getMinuto();
    void setSegundos(int s);
    int getSegundos();
    int operator +(int s) ;
    ~Hora()
    {
        if (hora != 0  && minutos!=0&& segundos!=0)
        {
            hora =0;
            minutos =0;
            segundos =0;
        }
        
    }
};
int Hora::operator+(int s )
{ 
    segundos +=s;
    return segundos;
}
//Falta por terminar
void Hora::setHora(int h)
{
        if(h<=24)
        {
            hora =h;
        }else{
            cout<<"No se pudo"<<endl;
        }
}
int Hora::getHora()
{
    return hora;
}
void Hora::setMinuto(int s)
{
    if (s<=60)
    {
        minutos = s;
    }else{
        cout<<"No aceptable"<<endl;
    }
}
int Hora::getMinuto()
{
    return minutos;
}
void Hora::setSegundos(int s)
{
    if (s<=60)
    {
        segundos = s;
    }else{
        cout<<"Tiene que ser menor a 60"<<endl;
    }
}
int Hora::getSegundos()
{
    return segundos;
}
ostream& operator<<(ostream &s, const Hora &cad)
{
    s<<"\n"<<cad.hora<<":"<<cad.minutos<<":"<<cad.segundos;
    return s;
}

int main()
{
       Hora h(10, 62, 65); 
       cout<<h;
       h+7;
       cout<<h;
}