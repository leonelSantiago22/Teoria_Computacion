#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <limits.h>
//#include "../include/automata_i.h"
//void extraer_cadena(char abc[], char reglas[]);

typedef struct names
{
        char name[100];
}name;

typedef struct arcs
{
        char from[100];
        char to[100];
        char alphabet[100];
        char numbers[100];
        char symbols[1];
}edge;

name letras[100];
name number[10];
int main(){
    char *token;
    int num, num2;
    //char matriz[];
    FILE *archivo = fopen("datos.txt","r");
    if (archivo==NULL)
    {
        printf("Archivo no detectado");
        return 0;
    }else{
        int i=0;
        char abc[100];
        fgets(abc, 100, archivo);
        token = strtok(abc, ",");
        while (token != NULL)
        {
            strcpy(letras[i].name, token);
            
            i++;
            token = strtok(NULL, ",");
        }
        token = strtok(letras[i-1].name, "\n");
        strcpy(letras[i-1].name, token);
        num = i;
        int j=0;
        fscanf(archivo, "%s\0", abc);
        i=0;
        token = strtok(abc, ",");
        while (token != NULL)
        {
            strcpy(number[i].name, token); i++;
            token = strtok(NULL, ",");
        }
        token = strtok(number[i-1].name, "\n");
        strcpy(number[i-1].name, token);
        num2 = i;
        for (int i = 0; i <=num2; i++)
        {
            printf("\n%s", number[i].name);
        }
        
        
    }
    
}