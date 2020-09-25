//Actividad6.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main()
{
    pid_t hijo1, hijo2, hijo3;
    hijo1 = fork();
    if (hijo1 == -1)
    {
        printf("No se ha podido crear el proceso hijo...");
        exit(-1);
    }
    if (hijo1 == 0)////Nos encontramos en el proceso hijo
    {
        printf("Yo soy el hijo 1, mi padre es PID=%d, yo soy PID=%d\n",getppid(),getpid());
    }
    else////Nos encontramos en el proceso padre
    {
        hijo2 = fork();
        if (hijo2 == -1)
        {
        printf("No se ha podido crear el proceso hijo...");
        exit(-1);
        }
        if (hijo2 == 0)////Nos encontramos en el proceso hijo
        {
            printf("Yo soy el hijo 2, mi padre es PID=%d, yo soy PID=%d\n",getppid(),getpid());
            hijo3 = fork();
            if (hijo3 == -1)
            {
                printf("No se ha podido crear el proceso hijo...");
                exit(-1);
            }
            if (hijo3 == 0)////Nos encontramos en el proceso hijo
            {
                printf("Yo soy el hijo 3, mi padre es PID=%d, yo soy PID=%d\n",getppid(),getpid());
            }
        }
    }
}
