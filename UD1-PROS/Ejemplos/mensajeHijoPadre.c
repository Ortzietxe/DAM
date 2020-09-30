//pipes.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main ()
{ 
	int fd[2];
	char buffer[30];
	pid_t pid;
	pipe(fd); // Se crea el pipe o tubería
	pid = fork();
	switch (pid) {
    	case -1: // error
		printf("No se ha podido crear el proceso hijo...\n");
		exit (-1);
		break;
    	case 0:   // Hijo
		printf ("El hijo escribe en el pipe...\n");
		write (fd[1], "Hola padre", 10);
		break;
	default: // Padre
		wait (NULL);
		printf ("El padre lee del pipe...\n");
		read (fd[0], buffer, 10);
		printf ("\tMensaje leído: %s\n", buffer);
		break;
	}
	exit(0);
}
