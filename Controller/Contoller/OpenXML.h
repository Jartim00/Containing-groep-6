#ifndef openxmls_h
#define openxmls_h

#include "Containers.h"
#include <iostream>
#include <algorithm>
#include <sstream>
#include <cctype>
#include <fstream>
#include <string>
#include <map>
#include <vector>

using std::string;
using std::map;
using std::pair;
using std::vector;

class OpenXMLs{
private:
	vector<string> containergegevens;
	map<string, string> container;
	map<pair<string, string>, string> treinposities;
	map<pair<string, string>, string> binnenschipposities;
	map<pair<string, string>, string> zeeschipposities;
	vector<Containers> containers;
	int index;
	vector<string> fname;
	string tempdag;
	string tempmaand;
	string tempvan;
	string tempx;
	string tempy;
	string errorstr;
	void Openen();
	static bool vergelijkAankomstMoment(const Containers &a, const Containers &b);
public:
	OpenXMLs();
	string split(string a);
	bool checkVervoersoort(string a);
	bool checkTime(string time);
	bool checkTimes(string starttime, string endtime);
	bool checkDatum(string a, string b, string c);
	bool checkData(string a, string b, string c, string d, string e, string f, string g, string h);
	bool checkStringOnlyDigits(string a);
	bool checkPositie(string x, string y, string z, map<pair<string, string>, string> map);
	map<pair<string, string>, string> checkNieuweAankomst(map<pair<string, string>, string> map, string aankomst, string aankomsttijd, string vertrektijd);
	vector<Containers> getContainers();
};

#endif

