//Actividad8.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main ()
{ 
	int fd[2],fd2[2];
	char buffer[80];
	char saludoAbuelo[]="Saludo del abuelo";
	char saludoPadre[]="Saludo del padre";
	char saludoHijo[]="Saludo del hijo";
	char saludoNieto[]="Saludo del nieto";
	pid_t pid,pid2;
	pipe(fd);  
	
	pid = fork();

	switch (pid) {
    	case -1: // error
			printf("No se ha podido crear el proceso Padre...\n");
			exit (-1);
		break;
    	case 0:   // Padre recibe	


// *********************Crea el 2º pipe por delante de fork()
            pipe(fd2);
			pid2 = fork();
			
			

			switch (pid2) {
				case -1: // error
					printf("No se ha podido crear el proceso hijo...\n");
					exit (-1);
				break;

				case 0:   // Hijo recibe
					close(fd2[1]); // Cierra el descriptor de escritura
					
					read (fd2[0], buffer, sizeof(buffer)); // leo el pipe
					printf ("\t\tEl hijo recibe un mensaje del padre: %s\n", buffer);

					close(fd[0]);
					write (fd[1], saludoHijo, sizeof(saludoHijo));
					printf ("\t\tEl hijo envía un mensaje al padre,..\n");
					
					break;

				default: // Padre Envía
					//recibe
					close(fd[1]); // Cierra el descriptor de escritura

					read (fd[0], buffer, sizeof(buffer)); // leo el pipe
					printf ("\tEl padre recibe un mensaje del abuelo: %s\n", buffer);
					
					//envio
					close(fd2[0]); // Cierra el descriptor de lectura
					write (fd2[1], saludoPadre, sizeof(saludoPadre));
					printf ("\tEl padre envía un mensaje al hijo,..\n");

					wait (NULL); // Espera al proceso hijo
					
					close(fd[1]); // Cierra el descriptor de escritura

					read (fd[0], buffer, sizeof(buffer)); // leo el pipe
					printf ("\tEl padre recibe un mensaje del hijo: %s\n", buffer);
									
					break;
			}
			break;
		default: // abuelo Envía
			close(fd[0]); // Cierra el descriptor de lectura
			write (fd[1], saludoAbuelo, sizeof(saludoAbuelo));
			printf ("El abuelo envía un mensaje al padre,..\n");
			wait (NULL); // Espera al proceso padre
			
			//abuelo lee
			read (fd[0], buffer, sizeof(buffer)); // leo el pipe
			printf ("\tEl abuelo recibe un mensaje del hijo: %s\n", buffer);
			break;
	}
	exit(0);
}