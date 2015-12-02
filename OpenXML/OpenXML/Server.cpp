#include "stdafx.h"
#include "Server.h"

using std::cout;
using std::string;
using std::runtime_error;
using std::endl;
//using namespace std;

#define bufsize 4096


Server::Server()
{
	DLLVERSION = MAKEWORD(2, 1);

	SUCCESSFUL = WSAStartup(DLLVERSION, &WinSockData);
	SUCCESSFUL2 = WSAStartup(DLLVERSION, &WinSockData);

	//Socket arguments
	sockCONNECTION = socket(AF_INET, SOCK_STREAM, NULL);
	ADDRESS.sin_addr.s_addr = inet_addr("127.0.0.1");
	ADDRESS.sin_family = AF_INET;
	ADDRESS.sin_port = htons(49876); // port
	AddressSize = sizeof(ADDRESS);

	sockLISTEN = socket(AF_INET, SOCK_STREAM, NULL);
	bind(sockLISTEN, (SOCKADDR*)&ADDRESS, sizeof(ADDRESS));
	listen(sockLISTEN, SOMAXCONN);
}

void Server::Communicate()
{
	char MESSAGE[bufsize];
	for (;;)
	{
		cout << "\n\tSERVER: Waiting for incoming connection...";

		if (sockCONNECTION = accept(sockLISTEN, (SOCKADDR*)&ADDRESS, &AddressSize))
		{
			cout << "\n\tA Connection was found!" << endl;
			for (;;)
			{
				SUCCESSFUL2 = recv(sockCONNECTION, MESSAGE, sizeof(MESSAGE), NULL);
				if (SUCCESSFUL2 == -1) {
					cout << "error on recv" << endl;
					Sleep(1000);
					break;
				}
				else {
					SUCCESSFUL2[MESSAGE] = '\0';
					cout << MESSAGE << endl;
				}

				//dick's code

				string s = "Hello World!";
				int count = s.size();
				if (count > bufsize - 1) throw runtime_error("ClientSocket::write - argument too large");
				char buffer[bufsize];
				strcpy_s(buffer, s.c_str());
				buffer[count++] = '\n';
				send(sockCONNECTION, buffer, count, 0);
			}
		}
	}
}
