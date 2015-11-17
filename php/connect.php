<?php

	function Connection(){
		$server='raspberry ip:3306';
		$user='jaron';
		$pass='containing';
		$db='naam van de database';

		$connection = mysql_connect($server, $user, $pass);

		if (!$connection) {
	   	die('TEST ' . mysql_error());
		}

		mysql_select_db($db) or die( 'MySQL ERROR: '. mysql_error() );
		return $connection;
	}
?>