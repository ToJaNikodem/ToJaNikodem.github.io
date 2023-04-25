#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

unsigned long int fib(int n){
	switch(n){
		case 0: return 0; break;
		case 1: return 1; break;
	}
    return fib(n-2)+fib(n-1);
}

unsigned long long int silnia(int n){
    if (n==0 || n==1)
        return 1;
    return silnia(n-1)*n;
}

int main(int argc, char** argv) {
   
    for(int i=0; i<20; i++)
        cout<<fib(i)<<" ";
    cout<<endl;
    for(int i=0; i<20; i++)
        cout<<silnia(i)<<" ";
    cout<<endl;
   
    return 0;
}
