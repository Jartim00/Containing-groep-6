#include "stdafx.h"
#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <map>
#include <vector>

using namespace std;

int main()
{

	//database openen
	//query ophalen afstanden tussen punten
	//foreach(record in query)
	//afstanden[(make_pair(*puntA*, *puntB*))] = stoi(*afstand*);
	map<pair<string, string>, int> afstanden;
	map<pair<string, string>, string> routes;
	const int verweg = 1000000;
	vector<string> punten;
	for (auto n : punten){
		for (auto x : punten){
			if (n != x){
				auto search = afstanden.find(make_pair(n, x));
				if (search == afstanden.end())
					afstanden[make_pair(n, x)] = verweg;
			}
		}
	}
	for (auto a : punten)
	{
		for (auto b : punten)
		{
			if ((b != a) && (afstanden[make_pair(a, b)] != verweg))
			{
				for (auto c : punten)
				{
					if ((c != b) && (a != c) && (afstanden[make_pair(c, b)] != verweg))
					{
						string via = routes[make_pair(a, c)];
						if (afstanden[make_pair(a, b)] + afstanden[make_pair(b, c)] < afstanden[make_pair(a, c)])
						{
							afstanden[make_pair(a, c)] = afstanden[make_pair(a, b)] + afstanden[make_pair(b, c)];
							routes[make_pair(a, c)] = routes[make_pair(a, b)] + " " + b + " " + routes[make_pair(b, c)];
						}
						else
						{
							via = "";
						}
					}
				}
			}
		}
	}
	for (auto r : routes)
		cout << r.first.first << " " << r.first.second << " " << r.second << " " << endl;
	for (;;){}
	//into database statement.

	/*for (;;){
	string plaatsA;
	string plaatsB;
	cout << "Plaatsnaam A:" << endl;
	cin >> plaatsA;
	cout << "Plaatsnaam B:" << endl;
	cin >> plaatsB;
	cout << "Afstand tussen A en B: " << afstanden[make_pair(plaatsA, plaatsB)] << endl;
	cout << "Via:" << routes[make_pair(plaatsA, plaatsB)] << endl;
	}
	for (auto p : afstanden)
	cout << p.first.first << " " << p.first.second << " " << p.second << " " << endl;
	for (auto r : routes)
	cout << r.first.first << " " << r.first.second << " " << r.second << " " << endl;*/

}

