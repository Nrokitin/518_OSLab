#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int input;
int msum;
int csum;

void *runner(void *param);

int main(int argc, char *argv[]){
	scanf("%d", &input);
	int lResult = 0;
	pthread_t tid;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	pthread_create(&tid, &attr, runner, argv[1]);
		
	msum = 0;
	for(int i = 1; i <= input; i++){
		msum += i;
	}	
	int result = csum-msum;	
	printf("csum:%d - msum:%d = %d\n", csum, msum, result);
	return 0;
}

void *runner(void *param){
	csum = 0;
	for(int i = 1; i <= input*2; i++){
		csum += i;
	}	
	pthread_exit(0);
}
