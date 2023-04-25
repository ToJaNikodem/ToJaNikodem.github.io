#include <iostream>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
for(int i=1;i<=100;i+=0){
if(i<=50){
cout<<i<<" ";
i++;
}
else{
cout<<100-i+51<<" ";
i++;
}
}
return 0;
}
