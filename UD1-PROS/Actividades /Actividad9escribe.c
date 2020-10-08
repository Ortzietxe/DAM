//Actividad9escribe.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>

int main (void)
{
	int fp, p, bytesleidos;
	char saludo[] = "Un saludo \n", buffer [10];
	p=mknod("FIFO2", S_IFIFO|0666, 0); /// permiso de lectura y escritura
	
	fp = open ("FIFO2", 1); /// abro el pipe FIFO2 con permiso de escritura
	if (fp == -1) {
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}
	printf("Mandando información al FIFO...\n");
	write (fp, saludo, sizeof(saludo)); 	
	close (fp);
	return(0);
}