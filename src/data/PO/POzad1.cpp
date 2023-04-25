#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int main(int argc, char** argv) {
	setlocale(LC_CTYPE,"Polish");
	
	for(int i=1;i<=100;i++){
		cout<<i<<" ";
	}
	cout<<endl;
	int j=1;
	while(j<=100){
		cout<<j<<" ";
		j++;
	}
	cout<<endl;
	int k=0;
	do{
		k++;
		cout<<k<<" ";
	}while(k<100);
	return 0;
}
