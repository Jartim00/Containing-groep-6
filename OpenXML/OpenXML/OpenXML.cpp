// OpenXML.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include "Containers.h"
#include "OpenXMLs.h"
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
	OpenXMLs xml = OpenXMLs();
	xml.Openen();
	Server s1 = Server();
	s1.Communicate();
}
