
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdbool.h>
#include "../include/curp.h"

bool fechanacimiento(char id[])
{
    for (int i = 0; i < 19; i++)
    {
        printf("%c", id[i]);
    }
    
      
    if (id[4]=='0'||id[4]== '1'||id[4]=='2'||id[4]=='3'|| id[4]=='4'||id[4]=='5'||id[4]=='6'||id[4]=='7'||id[4]=='8'||id[4]=='9') //Validar si el primer digito del anio es menor a 9
    {
        if (id[5]=='0'||id[5]== '1'||id[5]=='2'||id[5]=='3'|| id[5]=='4'||id[5]=='5'||id[5]=='6'||id[5]=='7'||id[5]=='8'||id[5]=='9') // Validar si el segundo digito del anio es menor a 9 para que sea menor a 99
        {
            printf("\nAnio de nacimiento valido %c%c", id[4], id[5]);
            matrizt[4][5] = 5;
            matrizt[5][5] = 6;
            if (id[6]=='0' || id[6]=='1')//Validar que el mes sea entre 01 y 12
            {
                if (id[6]=='1')//Si el primer digito del mes es 1 para que sea menor a 12
                {
                    if (id[7]=='0'||id[7]=='1'|| id[7]=='2')//Si el primer digito delValidar si el segundo digito del mes es 2 para que sea menor a 12
                    {
                        printf("\nEl mes de nacimiento es valido [3]%c%c", id[6], id[7]);
                        matrizt[6][5] = 7;
                        matrizt[7][5] = 8;
                        diasnacimiento(id);
                    }else{
                        printf("\nEl mes de nacimiento no es valido [444]");
                        return false;
                    }
                }else {
                        if (id[7]=='0'||id[7]== '1'||id[7]=='2'||id[7]=='3'|| id[7]=='4'||id[7]=='5'||id[7]=='6'||id[7]=='7'||id[7]=='8'||id[7]=='9')//Si el primer digito no es 1 entonces es 0 y el segundo puede ser 9
                        {
                            printf("\nEl mes de nacimiento es valido[123123] %c%c", id[6], id[7]);
                            matrizt[6][5] = 7;
                            matrizt[7][5] = 8;
                            diasnacimiento(id);
                        }
                    }
            }else {
                printf("\nEl mes de nacimiento no es valido[23]");
                return false;
            }
            
        }
           
    }else{
        printf("\nCurp no valida  por el anio de nacimiento malo[23423]"); 
        return false;
    }
    
    return true;
}

void diasnacimiento(char id[])
{
    if (id[8]=='0'|| id[8]== '1'|| id[8]=='2' || id[8]=='3')//Saber si el numero es menor a 3 para conocer el dia exacto
    {
        if (id[8]=='0'|| id[8]== '1'|| id[8]=='2')
        {
            if (id[9]=='0'||id[9]== '1'||id[9]=='2'||id[9]=='3'|| id[9]=='4'||id[9]=='5'||id[9]=='6'||id[9]=='7'||id[9]=='8'||id[9]=='9')
            {
                printf("\nFehca de nacimiento valida: %c%c\n", id[8], id[9]);
                matrizt[8][5] = 9;
                matrizt[9][5] = 10;
               
            }
        }else{
            if (id[9]=='0'||id[9]== '1')
            {
                printf("\nFehca de nacimiento valida : %c%c\n", id[8], id[9]);
                matrizt[8][5] = 9;
                matrizt[9][5] = 10;
                
            }else{
                printf("\nFehcha de nacimiento no valida[43]");
                exit(-1);
            }
        }        
        
    }else{
        printf("\nCurp no valida por dias de nacimiento malo[2323]");
        exit(-1);
    }
    
}

bool sexo(char id[])
{
    if (id[10]=='H') //Reconoconocimiento de sexo
    {
        printf("\nSexo Masculino%c", id[10]);
        matrizt[10][4] = 11;
        return true;
    }else if (id[10]=='M'){
        printf("\nSexo femenino%c", id[10]);
         matrizt[10][4] = 11;
        return true;
    }else{
        printf("\nEl sexo no es valido");
    }
    return true;
    
}

bool Diferenciador_Digito(char id[])
{
    if (isalpha(id[16]))
    {
        matrizt[15][1]=16;
        printf("\nDifenrenciador de homonomia y siglo valido %c", id[16]);
        return true;
    }else if (isdigit(id[16]))
    {
        matrizt[15][5]=16;
        printf("\nDifenrenciador de homonomia y siglo valido %c", id[16] );
        return true;
    }else{
        printf("\nDifenrenciador de homovia y siglo no valido");
        return false;
    }

    if (isdigit(id[17]))
    {
        matrizt[16][5]=17;
        printf("\nDigito Verificador %c", id[17]);
        return true;
    }else{
        printf("\nDigito Verificador no valido %c", id[17]);
        return false;
    }
    return true;   
}


bool consonantes(char poscons[],int i){
   
   if(poscons!=NULL){
	   if((poscons[i]=='B') || (poscons[i]=='C') || (poscons[i]=='D') || (poscons[i]=='F') || (poscons[i]=='G') || (poscons[i]=='H') || (poscons[i]=='J') || (poscons[i]== 'K') || (poscons[i]=='L') || (poscons[i]== 'M') || (poscons[i]=='N')){
	   
	   return true;
	   }
	if((poscons[i]=='P') || (poscons[i]=='Q') || (poscons[i]=='R')||(poscons[i]=='S') || (poscons[i]=='T') || (poscons[i]=='V') || (poscons[i]=='X') || (poscons[i]=='Y') || (poscons[i]=='S') || (poscons[i]=='Z')){
	   
	   return true;
     }
   }else{
	   return false;
   }
   return false;
}



bool vocal(char id[],int i){//se valida cada vocalcon la poscion que se manda
	
		if((id[i]=='A') || (id[i]=='E') || (id[i]=='I') || (id[i]=='O') || (id[i]=='U') ){
			return true;
		
		}else {
			return false;
		}
	
}

bool letras(char id[], int pos){

    if(isalpha(id[pos])){
		return true;
	}
    return false;
	
}

bool entidad_federativa(char id[],int i){
//primero se validan estas letras ya que se pasa la primera posicion que contiene ala inicial del estado de la curp leida por ejemplo: O de oaxaca
if((id[i]=='A') || (id[i]=='B') || (id[i]=='C') || (id[i]=='D') || (id[i]=='H') || (id[i]=='J') || (id[i]=='M') || (id[i]=='N') ||(id[i]=='T') || (id[i]=='P') || (id[i]=='Q') || (id[i]=='S') || (id[i]=='Y') || (id[i]=='V') || (id[i]=='Z') || (id[i]=='O')){
 i++;//luego se suma la posicion que se nos ingreso en la funcion y luego se valida si esta nueva posion coincide con alguna de stas letras para asi formar correstamente a la entidad federativa por ejempo= OC oaxaca
  if((id[i]=='C') || (id[i]=='E') || (id[i]=='F') || (id[i]=='G') || (id[i]=='H') || (id[i]=='T') || (id[i]=='L') || (id[i]=='S') || (id[i]=='R') || (id[i]=='N') || (id[i]=='M') || (id[i]=='C') || (id[i]=='P') || (id[i]=='Z')){
    return true;
  }	
}else{
	printf("\nCurp no valida");
	return false;
}
return false;
}

//funcion de imprimir para
void imprimir_matriz(){

    
	int i,j;
printf("\n");
	for(i=0;i<=17;i++){
		for(j=0;j<=5;j++){
			 printf(" : %i ",matrizt[i][j]);
		}
		printf("\n");
	}



}