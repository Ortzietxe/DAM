//funcionesforkwait.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main()
{
pid_t pid, Hijo_pid, pid2, Hijo_pid2;
pid = fork();
if(pid == -1)
{
	printf("No se ha podido crear el proceso hijo");
	exit(-1);
}
if(pid == 0)
{
	pid2 = fork();
	switch(pid2)
	{
		case -1:
			printf("No se ha podido crear el proceso hijo");
			exit(-1);
			break;
		case 0:
			printf("Soy el proceso nieto \n\t Mi PID es %d, El PID de mi padre es %d.\n",getpid(),getppid());	
			break;
		default:
			Hijo_pid2 = wait(NULL);
			printf("Soy el proceso hijo \n\t Mi PID es %d, El PID de mi padre es %d.\n\t Mi hijo: %d terminó. \n",getpid(),getppid(), Hijo_pid2);	
	}
}
else
{
	Hijo_pid = wait(NULL);
	printf("Soy el proceso padre \n\t Mi PID es %d, El PID de mi padre es %d\n\t Mi hijo: %d terminó. \n", getpid(), getppid(),pid);
}
exit(0);
}
