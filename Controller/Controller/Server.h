//TCP SERVER header file

#ifndef server_h
#define server_h

#pragma comment(lib, "Ws2_32.lib")

//STD console header files
#include <sdkddkver.h>
#include <conio.h>
#include <stdio.h>
#include "Containers.h"
#include <vector>
#include <WS2tcpip.h>
#include "OpenXML.h"


//SOCKET header files

#include <WinSock2.h>
#include <Windows.h>
#include <iostream>

#define SCK_VERSION2 0x0202
#define _WINSOCK_DEPRECATED_NO_WARNINGS
#define bufsize 4096

class Server
{
private:

	int successful;
	int opdrachtcount;

	OpenXMLs* XMLdata;

	int SUCCESSFUL;
	int SUCCESSFUL2;
	WSAData WinSockData;
	WORD DLLVersion;

	//Socket structure
	SOCKADDR_IN address;
	int addressSize;

	//Socket Creation
	SOCKET sockListen;
	SOCKET sockConnection;

	vector<string> opdrachten;
public:
	std::string getOpdracht(int index);
	std::string getZeeschipOpdracht();
	std::string getTreinOpdracht();
	std::string getAGVOpdracht(int index);
	Server(OpenXMLs* open);
	SOCKET sockLISTEN;
	SOCKET sockCONNECTION;
	void Communicate();
};

#endif