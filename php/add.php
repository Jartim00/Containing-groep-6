<?php
   	include("connect.php");
   	
   	$link=Connection();


	$temperatuur=$_POST["temperatuur"];
	$opbrengst=$_POST["opbrengst"];
	$luchtvochtigheid=$_POST["luchtvochtigheid"];
	$luchtdruk=$_POST["luchtdruk"];
	$windrichting=$_POST["windrichting"];
	$windsnelheid=$_POST["windsnelheid"];

   $query = "INSERT INTO `solarboat-weerstation`.`tb_Weerstation` (
`temperatuur` ,
`zon-opbrengst` ,
`luchtvochtigheid` ,
`luchtdruk` ,
`windrichting` ,
`windsnelheid`
)
VALUES (
'$temperatuur', '$opbrengst', '$luchtvochtigheid', '&luchtdruk', '$windrichting', '$windsnelheid'
)";
   	mysql_query($query,$link);
	  mysql_close($link);
  
  //   	header("Location: index.php");
?>