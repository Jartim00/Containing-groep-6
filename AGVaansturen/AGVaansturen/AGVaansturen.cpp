#include "stdafx.h"
#include <iostream>
#include <algorithm>
#include <sstream>
#include <cctype>
#include <fstream>
#include <string>
#include <map>
#include <vector>

using namespace std;

vector<string> split(const string a){
	stringstream xx(a);
	string item;
	vector<string> gesplit;
	while (getline(xx, item, ','))
		gesplit.push_back(item);
	return gesplit;
}

int main(){
	string huidigepositie;
	string gewenstepositie;
	//database openen
	//SELECT route FROM .. WHERE huidigepositie = huidigepositie AND gewenstepositie = gewenstepositie;
	//haal de via uitelkaar door splitten op de komma
	string via;
	vector<string> vias;
	cout << "via" << endl;
	cin >> via;
	vias = split(via);

	for (auto x : vias){
		cout << x << endl;
	}
}

