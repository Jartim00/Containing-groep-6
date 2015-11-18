<?php

	function Connection(){
		$server='localhost';
		$user='root';
		$pass='Timjar00';
		$db='containing';

		$connection = mysql_connect($server, $user, $pass);

		if (!$connection) {
	   	die('TEST ' . mysql_error());
		}

		mysql_select_db($db) or die( 'MySQL ERROR: '. mysql_error() );
		return $connection;
	}
?>