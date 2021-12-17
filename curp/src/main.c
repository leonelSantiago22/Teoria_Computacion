#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<stdbool.h>
#include"../include/curp.h"


int main()
{
	char id[18]={0};
	int indice;
	
	printf("ingrese un identificador  ");
    scanf("%s", id);
	for (indice = 0; id[indice] != '\0'; ++indice)
	{
	 id[indice] = toupper(id[indice]);
	}
	printf("\ncadena convertida %s",id);
	bool validacion = true;

	if(letras(id,0)==true){//solo se pasa la primera posicion ya que se valida la inicial del primer apellido que es una letra
			matrizt[0][1]=1;
			printf("\nes una letra %c",id[0]);
	}else{
	printf("\nno es valida la letra");
	}
		
		if(vocal(id,1)==true){//valida si la segunda posicion del arreglo es una vocal del primer apellido
			matrizt[1][0]=2;
			printf("\n es vocal %c",id[1]);
		}else{
			printf("\nno es valida la vocal");
		}
		
		if(letras(id,2)==true){//valida la primera letra  del segundo apellido  y la letra del primer nombre
			matrizt[2][1]=3;
			if(letras(id,3)==true){
				matrizt[3][1]=4;
				printf("\nson las iniciales del segundo apellido  %c y e inicial del nombre %c ",id[2],id[3]);
			}
		}else{
			printf("\nno son validas las letras");
		}

		

	if (validacion)
	{
	 validacion = fechanacimiento(id);
	 if (validacion)
	 {
		 validacion = sexo(id);
		 //if(validacion)//A qui va el del estado
		 //{

		if(entidad_federativa(id,11)==true){
			matrizt[11][3]=12;
			printf("\n entidad federativa valido ");
	}else{
		printf("\n La entidad federativa  No valido");
	} 
		if (validacion){
			if(consonantes(id,13)==true){//aqui valida las posiciones de 13-14 que son las consonantes del primer apellido,segundo apellido y primer nombre
			 matrizt[12][2]=13;
			 if(consonantes(id,14)==true){
				 matrizt[13][2]=14;
			   if(consonantes(id,15)==true){
				   matrizt[14][2]=15;
				    printf("\nes una consonates %c",id[13]);
					printf("\nes una consonates %c",id[14]);
				    printf("\nes una consonates %c",id[15]);
					//printf("\nCURP valida");
					Diferenciador_Digito(id);
			      }
			 }
		}else{
				printf("\nnCURP no valida ");
			}
			 }
		 //}
	 } else {
		 return 0 ;
	 }
	}
	
	imprimir_matriz();

	printf("\n");
	return 0;
}
