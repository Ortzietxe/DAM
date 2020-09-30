//pipes2.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main ()
{ 
	int fd[2];
	char buffer[80];
	char saludoPadre[]="Hola hijo";
	pid_t pid;
	pipe(fd); // Se crea el pipe o tubería
	pid = fork();
	switch (pid) {
    	case -1: // error
		printf("No se ha podido crear el proceso hijo...\n");
		exit (-1);
		break;
    	case 0:   // Hijo recibe
		close(fd[1]); // Cierra el descriptor de escritura
		read (fd[0], buffer, sizeof(buffer)); // leo el pipe
		printf ("\tMensaje leído: %s\n", buffer);
		break;
	default: // Padre Envía
		close(fd[0]); // Cierra el descriptor de lectura
		write (fd[1], saludoPadre, sizeof(saludoPadre));
		printf ("El padre envía un mensaje al hijo,..\n");
		wait (NULL); // Espera al proceso hijo
		break;
	}
	exit(0);
}
