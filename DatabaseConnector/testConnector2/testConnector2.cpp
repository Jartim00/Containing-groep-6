// testConnector2.cpp : Defines the entry point for the console application.
// Database connector

#include "stdafx.h"
#include <iostream>
//#include <cstdlib>

#include <SQLAPI.h>


int _tmain(int argc, _TCHAR* argv[])
{
	SAConnection con;

	try
	{
		con.Connect(
			"217.120.103.158@",
			"admin",
			"admin",
			SA_MySQL_Client
			);

		printf("We are connected!\n");
		con.Disconnect();
		printf("disconnected");
	}

	catch (SAException &x)
	{
		try
		{
			con.Rollback();
		}
		catch (SAException &x)
		{
		}
		printf("%s\n", (const char*)x.ErrText());
	}
	return 0;
}

