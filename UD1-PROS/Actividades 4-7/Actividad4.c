#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main()
{
pid_t pid1, pid2, pid3;
pid1=fork();
if(pid1 == -1)
{
    printf("No se ha podido crear el proceso hijo...");
    exit(-1);
}
else ////Nos encontramos en el proceso padre
{
    printf("Soy el hijo 1 Mi PID es %d, El PID de mi padre es: %d \n",pid1,getppid());
    pid2=fork();
    if(pid2 == -1)
    {
        printf("No se ha podido crear el proceso hijo...");
        exit(-1);
    }
    else ////Nos encontramos en el proceso padre
    {
        printf("Soy el hijo 2 Mi PID es %d, El PID de mi padre es: %d \n",pid2,getppid());
        pid3 = fork();
        if(pid3 == -1)
        {
            printf("No se ha podido crear el proceso hijo...");
            exit(-1);
        }
        else ////Nos encontramos en el proceso padre
        {
                printf("Soy el hijo 3 Mi PID es %d, El PID de mi padre es: %d \n",pid3,getppid());
        }
        exit(0);
        }
    }
}





