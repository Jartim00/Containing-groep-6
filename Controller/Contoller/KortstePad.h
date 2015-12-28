#ifndef korstepad_h
#define korstepad_h

#include "stdafx.h"
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <map>
#include <vector>

using namespace std;

class KortstePad
{
private:
	map<pair<string, string>, int> afstanden;
	map<pair<string, string>, string> routes;
	int verweg;
	string fname;
	vector<string> punten;
public:
	KortstePad();
	void BerekenKortstePad();
};

#endif

