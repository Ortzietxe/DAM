#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>

int main()
{
    int status;
    pid_t pid;

    pid = fork();
    if(pid == 0){
        printf("Soy el proceso padre /n");
        sleep(5);
    }
    else{
        pid = wait(NULL);
        exit(0);
    }
    return 0;
}

