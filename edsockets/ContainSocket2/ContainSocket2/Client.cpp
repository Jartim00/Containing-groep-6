//TCP Client source file

#include "Client.h"

using namespace std;

void main()
{
	//locals
	long SUCCESSFUL;
	WSAData WinSockData;
	WORD DLLVersion;
	DLLVersion = MAKEWORD(2, 1);
	SUCCESSFUL = WSAStartup(DLLVersion, &WinSockData);

	string RESPONSE;
	string CONVERTER;
	char MESSAGE[200];

	SOCKADDR_IN ADDRESS;

	SOCKET sock;
	sock = socket(AF_INET, SOCK_STREAM, NULL);

	ADDRESS.sin_addr.s_addr = inet_addr("127.0.0.1");
	ADDRESS.sin_family = AF_INET;
	ADDRESS.sin_port = htons(9876);

	cout << "\n\tCLIENT: Do You want to connect to this server? (Y/N)";
	cin >> RESPONSE;

	RESPONSE[0] = tolower(RESPONSE[0]);

	if (RESPONSE == "n")
	{
		cout << (MESSAGE);
		cout << "\n\tOk. Quitting instead.";
	}
	else if (RESPONSE == "y")
	{
		connect(sock, (SOCKADDR*)&ADDRESS, sizeof(ADDRESS));
		cout << "\n\tWSAGET" << WSAGetLastError() << endl;

		SUCCESSFUL = recv(sock, MESSAGE, sizeof(MESSAGE), NULL);
		
		//int b = connect(sock, (SOCKADDR*)&ADDRESS, sizeof(ADDRESS));
		CONVERTER = MESSAGE;

		//cout << "\n\tB = " << b << endl;

		cout << "\n\tMessage from SERVER:\n\n\t" << CONVERTER << endl;
		cout << "\n\tWSAGET" << WSAGetLastError() << endl;
	}

	cout << "\n\n\t";
	system("PAUSE");
	exit(1);
}