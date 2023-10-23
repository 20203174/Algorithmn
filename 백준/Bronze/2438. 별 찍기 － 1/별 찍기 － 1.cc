/*
 * 2438.c
 *
 *  Created on: 2022. 1. 6.
 *  첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 */
#include <stdio.h>

int main()
{
	int n;
	scanf("%d",&n);

	for(int i=0;i<n;i++){
		for(int j=0;j<i+1;j++){
			printf("*");
		}
		printf("\n");
	}
}

