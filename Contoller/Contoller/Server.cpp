#define _WINSOCK_DEPRECATED_NO_WARNINGS
#include "stdafx.h"
#include "Server.h"
#include <WS2tcpip.h>
#include <vector>
#include "OpenXML.h"



using std::cout;
using std::string;
using std::runtime_error;
using std::endl;
using std::vector;
using std::to_string;
using std::stoi;
//using namespace std;

#define bufsize 4096


Server::Server(OpenXMLs* open)
{
	XMLdata = open;

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

string Server::getOpdracht() // deze moet een index krijgen om de gewenste container informatie te kiezen
{
	vector<string> v1;
	std::vector<Containers> c1 = XMLdata->getContainers();
	int bedrijf = c1.size();
	string b = "";
	string containerID = c1[0].getContainernr();
	b.append(containerID + "/");
	string x = c1[0].getAankomstpositiex();
	b.append(x + "/");
	string y = c1[0].getAankomstpositiey();
	b.append(y + "/");
	string z = c1[0].getAankomstpositiez();
	b.append(z);
	//for each (Containers var in XMLdata->getContainers())
	//{
	//	v1.push_back(var.getAankomstbedrijf);
	//}
	return b;// als er opslag plaatsvindt moet de tweede opdracht in de zelfde vector komen, middels een overload van containers constructor
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
				string s2 = getOpdracht();
				int count = s2.size();
				if (count > bufsize - 1) throw runtime_error("ClientSocket::write - argument too large");
				char buffer[bufsize];
				strcpy_s(buffer, s2.c_str());
				buffer[count++] = '\n';
				send(sockCONNECTION, buffer, count, 0);
			}
		}
	}
}
