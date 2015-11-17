<?php
   	include("connect.php");
   	
   	$link=Connection();

	$query = 'SELECT agv FROM grafiek';
   	$avg = mysql_query($query,$link);
	$query = 'SELECT kraan FROM grafiek';
	$kraan = mysql_query($query,$link);
	$query = 'SELECT vrachtwagen FROM grafiek';
	$vrachtwagen = mysql_query($query,$link);
	$query = 'SELECT boot FROM grafiek';
	$boot = mysql_query($query,$link);
	$query = 'SELECT opslag FROM grafiek';
	$opslag = mysql_query($query,$link);
	
	  mysql_close($link);
  
  //   	header("Location: index.php");
?>