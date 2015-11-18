<?php
   	include("connect.php");
   	
   	$link=Connection();

	$query = 'SELECT agv FROM grafiek ORDER BY id DESC LIMIT 1';
	$result = mysql_query($query,$link);
   	$agvArray = mysql_fetch_array($result);
	$agv = $agvArray[0];

	$query = 'SELECT binnenschip FROM grafiek ORDER BY id DESC LIMIT 1';
	$result = mysql_query($query,$link);
   	$binnenArray = mysql_fetch_array($result);
	$binnenschip = $binnenArray[0];
	
	$query = 'SELECT vrachtwagen FROM grafiek ORDER BY id DESC LIMIT 1';
	$result = mysql_query($query,$link);
   	$vrachtwagenArray = mysql_fetch_array($result);
	$vrachtwagen = $vrachtwagenArray[0];

	$query = 'SELECT zeeschip FROM grafiek ORDER BY id DESC LIMIT 1';
	$result = mysql_query($query,$link);
	$zeeArray = mysql_fetch_array($result);
	$zeeschip = $zeeArray[0];
	
	$query = 'SELECT opslag FROM grafiek ORDER BY id DESC LIMIT 1';
	$result = mysql_query($query,$link);
	$opslagArray = mysql_fetch_array($result);
	$opslag = $opslagArray[0];
	
	$query = 'SELECT trein FROM grafiek ORDER BY id DESC LIMIT 1';
	$result = mysql_query($query,$link);
	$treinArray = mysql_fetch_array($result);
	$trein = $treinArray[0];
	
	$query = 'SELECT diversen FROM grafiek ORDER BY id DESC LIMIT 1';
	$result = mysql_query($query,$link);
	$diversenArray = mysql_fetch_array($result);
	$diversen = $diversenArray[0];
	
	//echo "$agv $kraan $vrachtwagen $boot $opslag";
	
	mysql_close($link);
	
	$data = Array();
	$data["agv"] = $agv;
	$data["binnenschip"] = $binnenschip;
	$data["vrachtwagen"] = $vrachtwagen;
	$data["zeeschip"] = $zeeschip;
	$data["opslag"] = $opslag;
	$data["trein"] = $trein;
	$data["diversen"] = $diversen;
	
	echo json_encode($data);
  
  //   	header("Location: index.php");
?>