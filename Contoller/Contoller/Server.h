//TCP SERVER header file

#ifndef server_h
#define server_h

#pragma comment(lib, "Ws2_32.lib")

//STD console header files
#include <sdkddkver.h>
#include <conio.h>
#include <stdio.h>
#include "Containers.h"

//SOCKET header files

#include <WinSock2.h>
#include <Windows.h>
#include <iostream>

#define SCK_VERSION2 0x0202
#define _WINSOCK_DEPRECATED_NO_WARNINGS
#define bufsize 4096

class OpenXMLs;

class Server
{
private:
	int SUCCESSFUL;
	int SUCCESSFUL2;

	OpenXMLs* XMLdata;
	WSAData WinSockData;
	WORD DLLVERSION;

	//Socket structure
	SOCKADDR_IN ADDRESS;
	int AddressSize;

	//Socket Creation
	SOCKET sockLISTEN;
	SOCKET sockCONNECTION;
public:
	std::string getOpdracht();
	Server(OpenXMLs* open);
	void Communicate();
};

#endif