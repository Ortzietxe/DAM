//Actividad7.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main()
{
    pid_t pid , hijo_pid;
    int valor = 6;
    printf("Valor inicial de la variable: 6 \n");
    pid = fork();

    if(pid == -1)
    {
        printf("No se ha podido crear el proceso hijo...");
        exit(-1);
    }
    if (pid == 0)
    {
        valor = valor - 5;
        printf("Variable en proceso hijo: %d \n", valor);
    }
    else
    {
        hijo_pid = wait(NULL);
        valor = valor + 5;
        printf("Variable en proceso Padre: %d \n", valor);
    }
    exit(0);
}





