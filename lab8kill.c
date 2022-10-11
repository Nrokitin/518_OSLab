// 64050518
// q1 Received a SIGUSR1. The max n is 20! = 2432902008176640000
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main(void){
	pid_t pid = fork();
	if(pid == 0){
		printf("child created\n");
		while(1);
		printf("this line should not be shown\n");
		exit(0);
	} else {
		kill(pid,SIGKILL);
	}
	return 0;
}

