<?php
   	include("connect.php");
   	
   	$link=Connection();

	$query = 'SELECT agv FROM grafiek ORDER BY agv DESC LIMIT 1';
	$result = mysql_query($query,$link);
   	$agvArray = mysql_fetch_array($result);
	$agv = $agvArray[0];

	$query = 'SELECT kraan FROM grafiek ORDER BY kraan DESC LIMIT 1';
	$result = mysql_query($query,$link);
   	$kraanArray = mysql_fetch_array($result);
	$kraan = $kraanArray[0];
	
	$query = 'SELECT vrachtwagen FROM grafiek ORDER BY vrachtwagen DESC LIMIT 1';
	$result = mysql_query($query,$link);
   	$vrachtwagenArray = mysql_fetch_array($result);
	$vrachtwagen = $vrachtwagenArray[0];

	$query = 'SELECT boot FROM grafiek ORDER BY boot DESC LIMIT 1';
	$result = mysql_query($query,$link);
	$bootArray = mysql_fetch_array($result);
	$boot = $bootArray[0];
	
	$query = 'SELECT opslag FROM grafiek ORDER BY opslag DESC LIMIT 1';
	$result = mysql_query($query,$link);
	$opslagArray = mysql_fetch_array($result);
	$opslag = $opslagArray[0];
	
	//echo "$agv $kraan $vrachtwagen $boot $opslag";
	
	mysql_close($link);
	
	$data = Array();
	$data["agv"] = $agv;
	$data["kraan"] = $kraan;
	$data["vrachtwagen"] = $vrachtwagen;
	$data["boot"] = $boot;
	$data["opslag"] = $opslag;
	
	echo json_encode($data);
  
  //   	header("Location: index.php");
?>