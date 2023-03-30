#include <iostream>
#include <fstream>

using namespace std;

int main()
{
   fstream plik;
   plik.open("liczby.txt", ios::in);
   if (plik.good() == false)
   {
      cout << "Nie mozna otworzyc pliku!";
   }
   int suma = 0;
   int liczba;

   while (plik >> liczba)  
   {
      suma += liczba;
   }
   cout << "Suma liczb: " << suma;

   plik.close();

   return 0;
}
