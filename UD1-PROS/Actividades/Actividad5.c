//Actividad5.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main()
{
    int cont = 0;
    void crearHijo()
    {
        if(cont < 5)
        {
            pid_t pid;
            pid=fork();
            if(pid == -1)
            {
                printf("No se ha podido crear el proceso hijo...");
                exit(-1);
            }
            if(pid == 0) ////Nos encontramos en el proceso hijo
            {
                printf("Soy el proceso hijo \n\t Mi PID es %d, el PID de mi padre es :  %d\n",getpid(),getppid());
                crearHijo();
            }
        }
        else{
            exit(0);
        }
        cont++;
    }
    crearHijo();
    exit(0);
}