#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

bool czyJuzByla(int liczba, int tab[], int ile)
{
   for (int i = 0; i < ile; i++)
   {
      if (tab[i] == liczba)
         return true;
   }
   return false;
}

int losuj(int a, int b)
{
   return (rand() % (b - a + 1) + a);
}

int main(int argc, char **argv)
{
   srand(time(NULL));
   int ileLiczb = 0;
   cout << "Podaj liczbe losowan: ";
   cin >> ileLiczb;
   int liczby[ileLiczb];
   int wylosowanych = 0;

   do
   {
      int los = losuj(1, 49);
      if (czyJuzByla(los, liczby, wylosowanych) == false)
      {
         liczby[wylosowanych] = los;
         wylosowanych += 1;
      }
   } while (wylosowanych < ileLiczb);

   for (int i = 0; i < ileLiczb; i++)
   {
      cout << liczby[i] << " ";
   }
   cout << endl;

   return 0;
}