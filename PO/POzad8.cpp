#include <cstdlib>
#include <ctime>
#include <iostream>

using namespace std;

// zad1
void wpisz_do_wskaznika(int n, int *w) { 
   *w = n; 
}

// zad2
void zamien(int *wsk, int &ref) {
   int temp = *wsk;
   *wsk = ref;
   ref = temp;
}

// zad3
double *przygotuj_double() {
   double *ptr = new double;
   *ptr = 1.5;
   return ptr;
}

// zad4
double srednia(double *tablica, int rozmiar) {
   double suma = 0.0;
   for (int i = 0; i < rozmiar; i++) {
      suma += tablica[i];
   }
   return suma / rozmiar;
}

int main() {
   // zad1
   int w = 0;
   int n = 5;
   cout << w << " " << n << endl;
   wpisz_do_wskaznika(n, &w);
   cout << w << " " << n << endl << endl;

   // zad2
   int wsk = 3;
   int ref = 5;

   cout << wsk << " " << ref << endl;
   zamien(&wsk, ref);
   cout << wsk << " " << ref << endl << endl;

   // zad3
   cout << przygotuj_double() << endl;
   cout << *przygotuj_double() << endl << endl;

   // zad4
   srand(time(0));
   int dlugosc_tablicy = rand();
   double *tablica = new double[dlugosc_tablicy];
   for (int i = 0; i < dlugosc_tablicy; i++) {
      tablica[i] = rand() % 100 + 1;
   }

   cout << endl;
   cout << srednia(tablica, sizeof(tablica)) << endl;
   delete[] tablica;

   int dlugosc_tablicy2 = rand();
   double *tablica2 = new double[dlugosc_tablicy2];
   for (int i = 0; i < dlugosc_tablicy2; i++) {
      tablica2[i] = rand() % 50 + 1;
   }

   cout << endl;
   cout << srednia(tablica2, sizeof(tablica2)) << endl;
   delete[] tablica2;
   return 0;
}