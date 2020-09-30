//funcionesPipeSinNombre.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>
#include <string.h>

void main()
{
	int fd, fd2, numbytes;
	char buffer[900];
	char saludo[] = "Un saludo!!!";

	///Escritura
	fd = open("texto.txt", 1);///fichero se abre solo para escritura
	if(fd == -1)
	{
		printf("Error al abrir el fichero...\n");
		exit(-1);
	}
	printf("Escribo el saludo...\n");
	write(fd, saludo, strlen(saludo));
	close(fd);

	///lectura
	printf("Contenido del fichero \n");
	fd2 = open("texto.txt", 0);
	while((numbytes = read(fd2, buffer, sizeof(char)))> 0)
	{
		printf("%s", buffer);
	}
	close(fd2);
}
