#include <iostream>

using namespace std;

int main() {
    int n;
    int *dane = new int[n];
    int w = 1;
    while (w==1)
    {
        cout<<"Podaj liczbe n: ";
        cin >> n;
    if (n>0){
    
    for (int i = 0; i < n; i++)
    {
        cout << "Podaj liczbe calkowita: ";
        cin >> dane[i];
        if (dane[i] == 0)
        {
            exit(0);
        }
        
    }
    for (int j = 0; j < n; j++)
    {
        cout << dane[n-j-1] << " ";
    }
    cout << endl;
    }else{
        w=0;
    }
    }
    return 0;
}