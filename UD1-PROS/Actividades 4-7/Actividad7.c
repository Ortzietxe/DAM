#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main()
{
    pid_t pid;
    pid = fork();
    int valor = 6;
    printf("Valor inicial de la variable: 6");

    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo...");
        exit(-1);
    }
    if (pid == 0)
    {
        int valorHijo = valor - 5;
        printf("Variable en proceso hijo: " + valor;
    }
    else
    {
        int valorPadre = valor + 5;
        printf("Variable en proceso Padre: " + valor;
    }
}





