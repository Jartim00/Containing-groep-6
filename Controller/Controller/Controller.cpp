#include "stdafx.h"
#include "Containers.h"
#include "OpenXML.h"
#include "AGV.h"
#include "Server.h"
#include <iostream>
#include <algorithm>
#include <sstream>
#include <cctype>
#include <fstream>
#include <string>
#include <map>
#include <vector>

using namespace std;


int main()
{
	OpenXMLs xml;
	Server server(&xml);
	server.Communicate();
	//for (;;){}
}

