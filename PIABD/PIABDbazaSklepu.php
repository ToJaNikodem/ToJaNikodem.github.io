<!DOCTYPE html>
<html lang="pl">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="style.css">
   <title>Produkty</title>
</head>

<body>
   <div id="main">
      <div id="left">
         <?php
         $mysql = new mysqli('localhost', 'root', '', 'klasa3c');
         if ($mysql->connect_error) {
            die("Błąd połączenia z bazą: " . $mysql->connect_error);
         }
         $qr = 'SELECT COUNT(*) AS total FROM pr_product;';
         $result = $mysql->query($qr);

         while ($row = $result->fetch_assoc()) {

            echo "<br>Ilość produktów: " . $row['total'];
         }
         $qr = 'SELECT COUNT(*) AS total FROM pr_product WHERE active=1;';
         $result = $mysql->query($qr);

         while ($row = $result->fetch_assoc()) {

            echo "<br>Ilość produktów aktywnych: " . $row['total'];
         }

         $qr = 'SELECT COUNT(*) AS total FROM pr_product WHERE active=0;';
         $result = $mysql->query($qr);

         while ($row = $result->fetch_assoc()) {

            echo "<br>Ilość produktów nieaktywnych: " . $row['total'];
         }
         ?>
         <form action="index.php" method="post">
            <p>Kategoia: </p>
            <select name="kat">
               <?php
               $qr = 'SELECT name, id_category AS id FROM pr_category_lang GROUP BY name ASC;';
               $result = $mysql->query($qr);

               while ($row = $result->fetch_assoc()) {

                  echo "<option value=" . $row['id'] . ">" . $row['name'] . "</option>";
               }
               ?>
            </select><br>
            <p>Poducent: </p>
            <select name="pro">
               <?php
               $qr = 'SELECT name, id_manufacturer AS id FROM pr_manufacturer GROUP BY name ASC;';
               $result = $mysql->query($qr);

               while ($row = $result->fetch_assoc()) {

                  echo "<option value=" . $row['id'] . ">" . $row['name'] . "</option>";
               }
               ?>
            </select><br><br>
            <input type="submit" value="Wyślij">
         </form>
      </div>
      <div id="right">
         <?php
         if (isset($_POST['kat']) && isset($_POST['pro'])) {
            $id1 = $_POST['kat'];
            $id2 = $_POST['pro'];

            $qr = "SELECT pl.name AS nazwa, p.price AS cena FROM pr_product_lang pl, pr_product p WHERE pl.id_product=p.id_product AND p.id_category_default='$id1' AND p.id_manufacturer='$id2' GROUP BY nazwa ASC;";
            $result0 = $mysql->query($qr);
            while ($row = $result0->fetch_assoc()) {
                  echo $row['nazwa'] . "<br>" . $row['cena'] . "<br>";
            }
         }
         ?>
      </div>
   </div>
</body>

</html>