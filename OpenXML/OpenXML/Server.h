//TCP SERVER header file

#pragma comment(lib, "Ws2_32.lib")

//STD console header files
#include <sdkddkver.h>
#include <conio.h>
#include <stdio.h>

//SOCKET header files

#include <WinSock2.h>
#include <Windows.h>
#include <iostream>

#define SCK_VERSION2 0x0202

#define bufsize 4096

class Server
{
private:
	int SUCCESSFUL;
	int SUCCESSFUL2;
	WSAData WinSockData;
	WORD DLLVERSION;

	//Socket structure
	SOCKADDR_IN ADDRESS;
	int AddressSize;

	//Socket Creation
	SOCKET sockLISTEN;
	SOCKET sockCONNECTION;
	
public:
	Server();
	void Communicate();
};
