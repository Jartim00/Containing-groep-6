#define _WINSOCK_DEPRECATED_NO_WARNINGS
#include "stdafx.h"

#include "Server.h"
#include <WS2tcpip.h>

using std::cout;
using std::string;
using std::runtime_error;
using std::endl;
using std::vector;
using std::to_string;
using std::stoi;
//using namespace std;



#define bufsize 4096

//server constructor
Server::Server(OpenXMLs* open)
{
	opdrachten = { "c/1/2/3/4/20", "c/2/301/302/303/20" };
	opdrachtcount = 0;
	XMLdata = open;
	//hier wordt bepaald dat het om de 2e versie van winsock gaat
	DLLVersion = MAKEWORD(2, 1);

	//de int succesvol gaat uiteindelijk het daadwerkelijk aantal bytes dat in de ontvangstbuffer zat vertegenwoordigen
	successful = WSAStartup(DLLVersion, &WinSockData);

	//Socket informatie, AF_INET = internetprotocol, sockstream = betekent een betrouwbare verbinding van TCPIP, NULL voor standaardprotocol
	//family = internet, sin_port = host to network byte order, past byte order aan aan netwerk
	//socket wordt gebonden aan adres
	sockConnection = socket(AF_INET, SOCK_STREAM, NULL);
	address.sin_addr.s_addr = inet_addr("127.0.0.1");
	address.sin_family = AF_INET;
	address.sin_port = htons(49876); // port
	addressSize = sizeof(address);
	sockListen = socket(AF_INET, SOCK_STREAM, NULL);
	bind(sockListen, (SOCKADDR*)&address, sizeof(address));
	listen(sockListen, SOMAXCONN);
}

//eerste poging om bepaalde vector elementen door te sturen naar de simulatie
string Server::getOpdracht(int index) // deze moet een index krijgen om de gewenste container informatie te kiezen
{
	vector<Containers> conta = XMLdata->getContainers();
	if (index < conta.size() - 1)
	{
		char c = conta[index].getAankomstvervoermiddel().at(0);
		switch (c)
			case 'z':
			case 't':
			case 'b':
			case 'v':

			cout << "index: " << index << " conta.size: " << conta.size() << endl;
			//string opdracht = conta[index].getAankomstvervoermiddel().front + "/";
			string containerID = conta[index].getContainernr();
			string opdracht = containerID + "/";
			string x = conta[index].getAankomstpositiex();
			opdracht.append(x + "/");
			string z = conta[index].getAankomstpositiez();
			opdracht.append(z + "/");
			string y = conta[index].getAankomstpositiey();
			opdracht.append(y + "/");
			opdracht.append(to_string(opdrachtcount));
			return opdracht;
	
	}// als er opslag plaatsvindt moet de tweede opdracht in de zelfde vector komen, middels een overload van containers constructor
}

string Server::getZeeschipOpdracht()
{
	return "";
}

string Server::getTreinOpdracht()
{
	return"";
}

string Server::getAGVOpdracht(int index){
	return "";
}

//de methode om van de opgezette socket gebruik te maken.
//characterarray MESSAGE dient als buffer.
//de hierboven opgezette verbinding wordt opengezet om clientconnectie te ontvangen op het adres dat ook hier boven aangegeven is
//als successful -1 teruggeeft was er geen correcte reactie ontvangen, en breakt de loop terug naar wachtend op een verbinding
//als er een boodschap goed binnen is gekomen wordt er op waarde succes een NULL geplaatst om aan te geven dat de boodschap daar ophoudt.
void Server::Communicate()
{
	//opdrachtcount houdt bij hoeveel containers er verstuurd zijn, onder meer voor het geval de verbinding uitvalt
	char receiveBuffer[bufsize];
	string opdracht;
	for (;;)
	{
		cout << "\n\tSERVER: Waiting for incoming connection...";

		if (sockConnection = accept(sockListen, (SOCKADDR*)&address, &addressSize))
		{
			cout << "\n\tA Connection was found!" << endl;
			for (;;)
			{
				cout << "\n\twaiting for message" << endl;
				successful = recv(sockConnection, receiveBuffer, sizeof(receiveBuffer), NULL);
				if (successful == -1) {
					cout << "error on recv" << endl;
					//cout << WSAGetLastError() << endl;
					break;
				}
				else {
					successful[receiveBuffer] = '\0';
					cout << receiveBuffer << endl;
				}
				if (opdrachten.size() > 0){
					opdracht = opdrachten[opdrachten.size() - 1];
					opdrachten.pop_back();
					int opdrachtLen = opdracht.size();
					if (opdrachtLen > bufsize - 1) throw runtime_error("ClientSocket::write - argument too large");
					char sendBuffer[bufsize];
					strcpy_s(sendBuffer, opdracht.c_str());
					sendBuffer[opdrachtLen++] = '\n';
					send(sockConnection, sendBuffer, opdrachtLen, 0);
					cout << "\n\tMessage received:\n\t" << endl;
					opdrachtcount++;
				}
			}
		}
	}
}