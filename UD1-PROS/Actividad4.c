#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main()
{
pid_t pid1, pid2, pid3;
pid1=fork();
pid2=fork();
pid3=fork();
if(pid1 == -1)
{
printf("No se ha podido crear el proceso hijo...");
exit(-1);
}
if(pid1 == 0) ////Nos encontramos en el proceso hijo
{
printf("Soy el proceso hijo \n\t Mi PID es %d, el PID de mi padre es :  %d\n",getpid(),getppid());
}
else ////Nos encontramos en el proceso padre
{
printf("Soy el proceso padre \n\t Mi PID es %d, El PID de mi padre es: %d \n",getpid(),getppid());
}

if(pid2 == -1)
{
printf("No se ha podido crear el proceso hijo...");
exit(-1);
}
if(pid2 == 0) ////Nos encontramos en el proceso hijo
{
printf("Soy el proceso hijo \n\t Mi PID es %d, el PID de mi padre es :  %d\n",getpid(),getppid());
}
else ////Nos encontramos en el proceso padre
{
printf("Soy el proceso padre \n\t Mi PID es %d, El PID de mi padre es: %d \n",getpid(),getppid());
}

if(pid3 == -1)
{
printf("No se ha podido crear el proceso hijo...");
exit(-1);
}
if(pid3 == 0) ////Nos encontramos en el proceso hijo
{
printf("Soy el proceso hijo \n\t Mi PID es %d, el PID de mi padre es :  %d\n",getpid(),getppid());
}
else ////Nos encontramos en el proceso padre
{
printf("Soy el proceso padre \n\t Mi PID es %d, El PID de mi padre es: %d \n",getpid(),getppid());
}
exit(0);
}

