//Actividad10.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/wait.h>
/* --------------------------------------------------*/
/* gestion de señales en proceso HIJO                */
void userSignal (int signal)
{
	printf ("Hijo recibe señal...%d\n", signal);
}

void killSignal (int signal)
{
	printf ("Terminado(killed)");
}
/*****************************************************/
void main ()
{ 
	int pid_padre, pid_hijo;
	pid_padre = getpid();
	pid_hijo = fork(); // creamos el hijo
	switch (pid_hijo) {
    	case -1: // error
		printf("No se ha podido crear el proceso hijo...\n");
		exit (-1);
		break;

    	case 0:   // El hijo envia 3 señales
		wait(NULL);
		kill (pid_padre, SIGUSR1); //Envía señal al padre
		sleep (2);
		kill (pid_padre, SIGUSR1); //Envía señal al padre
		sleep(8);
		kill (pid_padre, SIGKILL); //Envía señal al padre
		break;

		default: // El padre 
		signal (SIGUSR1, userSignal); // Manejador de señal en padre
		sleep(1);
		signal (SIGUSR1, userSignal); // Manejador de señal en padre
		sleep (8);
		signal (SIGUSR1, killSignal); // Manejador de señal en padre
		while(1) {}; // Bucle infinito
		break;
	}
	exit(0);
}