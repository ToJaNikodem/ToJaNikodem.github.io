<!DOCTYPE html>
<html lang="pl">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Produkty</title>
	<style>
		* {
			margin: 0;
			padding: 0;
		}

		#right {
			width: 50%;
			float: left;
		}

		#right2 {
			width: 50%;
			float: left;
		}

		#left {
			width: 50%;
			float: left;
		}
	</style>
</head>

<body>
	<div id="main">
		<div id="left">
			<?php
			//$mysqli = new mysqli('localhost', 'baza_zstu', 'baza@', 'klasa3c');

			if ($mysqli->connect_error) {
				die("Błąd połączenia z bazą: " . $mysqli->connect_error);
			}
			$qr = 'SELECT COUNT(*) AS total FROM pr_product;';
			$result = $mysqli->query($qr);

			while ($row = $result->fetch_assoc()) {

				echo "<br>Ilość produktów: " . $row['total'];
			}
			$qr = 'SELECT COUNT(*) AS total FROM pr_product WHERE active=1;';
			$result = $mysqli->query($qr);

			while ($row = $result->fetch_assoc()) {

				echo "<br>Ilość produktów aktywnych: " . $row['total'];
			}

			$qr = 'SELECT COUNT(*) AS total FROM pr_product WHERE active=0;';
			$result = $mysqli->query($qr);

			while ($row = $result->fetch_assoc()) {

				echo "<br>Ilość produktów nieaktywnych: " . $row['total'];
			}
			?>
			<form action="index.php" method="post">
				<br>
				<p>Kategoria: </p>
				<select name="kat">
					<?php
					$qr = 'SELECT name, id_category AS id FROM pr_category_lang GROUP BY name ASC;';
					$result = $mysqli->query($qr);

					while ($row = $result->fetch_assoc()) {
						echo "<option value=" . $row['id'] . ">" . $row['name'] . "</option>";
					}
					?>
				</select><br>
				<p>Poducent: </p>
				<select name="pro">
					<?php
					$qr = 'SELECT name, id_manufacturer AS id FROM pr_manufacturer GROUP BY name ASC;';
					$result = $mysqli->query($qr);

					while ($row = $result->fetch_assoc()) {
						echo "<option value=" . $row['id'] . ">" . $row['name'] . "</option>";
					}
					?>
				</select><br><br>
				<input type="submit" value="Wyślij">
			</form><br>
			<?php
			$qr = "SELECT cl.id_category AS id, cl.name AS nazwa, count(*) AS ilosc FROM pr_product p, pr_category_lang cl WHERE p.id_category_default=cl.id_category GROUP BY `id_category_default` ORDER BY ilosc ASC;";

			$result = $mysqli->query($qr);
			while ($row = $result->fetch_assoc()) {
				echo "<p>" . $row['nazwa'] . " - " . $row['ilosc'] . "</p>" . $row['id'];
			}
			?>
			<br><br>
			<h4>Produkty bez zdjęć</h4>
			<form action="index.php" method="post">
				<button type="submit" name="aktywny">Zmień na aktywne</button>
				<button type="submit" name="nieaktywny">Zmień na nieaktywne</button>
			</form>
			<br>
			<?php
			if (isset($_POST['aktywny'])) {
				$qr = "UPDATE pr_product SET active = 1 WHERE id_product IN (SELECT p.id_product FROM pr_product p LEFT JOIN pr_image i ON p.id_product=i.id_product WHERE i.id_product IS NULL)";
				$mysqli->query($qr);
			}
			if (isset($_POST['nieaktywny'])) {
				$qr = "UPDATE pr_product SET active = 0 WHERE id_product IN (SELECT p.id_product FROM pr_product p LEFT JOIN pr_image i ON p.id_product=i.id_product WHERE i.id_product IS NULL)";
				$mysqli->query($qr);
			}

			$qr = "SELECT p.name AS nazwa FROM pr_product_lang p WHERE p.id_product IN (SELECT p.id_product FROM pr_product p LEFT JOIN pr_image i ON p.id_product=i.id_product WHERE p.active = 1 AND i.id_product IS NULL);";

			$result = $mysqli->query($qr);
			while ($row = $result->fetch_assoc()) {
				echo "<p>" . $row['nazwa'] . "</p>";
			}
			?>
		</div>
		<div id="right">
			<?php
			if (isset($_POST['kat']) && isset($_POST['pro'])) {
				$id1 = $_POST['kat'];
				$id2 = $_POST['pro'];

				$qr = "SELECT pl.name AS nazwa, p.price AS cena FROM pr_product_lang pl, pr_product p WHERE pl.id_product=p.id_product AND p.id_category_default='$id1' AND p.id_manufacturer='$id2' GROUP BY nazwa ASC;";
				$result = $mysqli->query($qr);
				while ($row = $result->fetch_assoc()) {
					echo $row['nazwa'] . "<br>" . $row['cena'] . "<br>";
				}
			}
			?>
		</div>
		<div id="right2">
			<form action="index.php" method="post">
				<p>Z kategori: </p>
				<select name="kat1">
					<?php
					$qr = 'SELECT name, id_category AS id FROM pr_category_lang GROUP BY name ASC;';
					$result = $mysqli->query($qr);

					while ($row = $result->fetch_assoc()) {
						echo "<option value=" . $row['id'] . ">" . $row['name'] . "</option>";
					}
					?>
				</select><br>
				<br>
				<p>Do kategori: </p>
				<select name="kat2">
					<?php
					$qr = 'SELECT name, id_category AS id FROM pr_category_lang GROUP BY name ASC;';
					$result = $mysqli->query($qr);

					while ($row = $result->fetch_assoc()) {
						echo "<option value=" . $row['id'] . ">" . $row['name'] . "</option>";
					}
					?>
				</select><br><br>
				<input type="submit" value="Wyślij">
			</form>
			<?php
			if (isset($_POST['kat1']) && $_POST['kat2']) {
				$kat1 = $_POST['kat1'];
				$kat2 = $_POST['kat2'];

				echo "<br>Przenosisz z kategori: $kat1 do kategori $kat2";

				$qr = "UPDATE pr_product SET `id_category_default`= '$kat2' WHERE id_product IN (SELECT id_product FROM pr_product WHERE id_category_default='$kat1')";

				$mysqli->query($qr);
			}
			?>
		</div>
	</div>
</body>

</html>
<?php
$mysqli->close();
?>