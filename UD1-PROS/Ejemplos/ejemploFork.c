//ejemploFork.c
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main()
{
    int status;
    pid_t pid;

    pid = fork();
    if(pid > 0){
        printf("Soy el proceso padre /n");
        sleep(60);
    }
    else{
        exit(0);
    }
    return 0;
}
