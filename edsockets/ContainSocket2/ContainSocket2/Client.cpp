//TCP Client source file

#include "Client.h"

using namespace std;

void main()
{
	//locals
	long SUCCESSFUL;
	long SUCCESSFUL2;
	WSAData WinSockData;
	WORD DLLVersion;
	DLLVersion = MAKEWORD(2, 1);
	SUCCESSFUL = WSAStartup(DLLVersion, &WinSockData);
	SUCCESSFUL2 = WSAStartup(DLLVersion, &WinSockData);

	string CONVERTER;
	char MESSAGE[200];

	SOCKADDR_IN ADDRESS;

	SOCKET sock;
	sock = socket(AF_INET, SOCK_STREAM, NULL);

	ADDRESS.sin_addr.s_addr = inet_addr("127.0.0.1");
	ADDRESS.sin_family = AF_INET;
	ADDRESS.sin_port = htons(49876);

	connect(sock, (SOCKADDR*)&ADDRESS, sizeof(ADDRESS));
	cout << "\n\tWSAGET" << WSAGetLastError() << endl;
	while (true)
	{
		string respose;

	SUCCESSFUL2 = send(sock, "\n\tbiep\n", sizeof(MESSAGE), NULL);
	SUCCESSFUL = recv(sock, MESSAGE, sizeof(MESSAGE), NULL);

	int b = (int) SUCCESSFUL;


	for (int i = 0; i < b - 1; i++)
	{
		cout << "nieuwe print" << MESSAGE[i] << endl;
	}
		
	//int b = connect(sock, (SOCKADDR*)&ADDRESS, sizeof(ADDRESS));
	//CONVERTER = MESSAGE;

	//cout << "\n\tB = " << b << endl;

	cout << "\n\tMessage from SERVER:\n\n\t" << MESSAGE << endl;
	cout << "\n\tSuccesful:\n\n\t" << SUCCESSFUL << endl; //inhoud van succesful = lengte van boodschap +1 "test" = 5
	cout << "\n\tWSAGET" << WSAGetLastError() << endl;

		cout << "\n\tmore?";
		cin >> respose;
		if (respose[0] == 'y')
		{
			continue;
		}
		else break;
	}

	cout << "\n\n\t";
	system("PAUSE");
	exit(1);
}