#include "stdafx.h"
#include "KortstePad.h"


KortstePad::KortstePad()
{
	verweg = 1000000;
}

//0 t / m 76	links, meest rechts			beladen agv die naar het noorden gaat
//77 t / m 153	links, rechts			onbeladen agv die naar het noorden gaat
//154 tm 230	links, links			onbeladen agv die naar het zuiden gaat
//231 tm 307	links, meeste links			beladen agv die naar het zuiden gaat
//
//308 t / m 384	rechts, meest links			beladen agv die naar noorden gaat
//385 tm 461	rechts, links			onbeladen agv die naar het noorden gaat
//462 tm 538	rechts, rechts			onbeladen agv zuidwaarts
//539 tm 615	rechts, meest rechts			beladen agv zuidwaarts
//
//616 tm 619	zuidwest		hoek
//620 tm 623	noordwest		hoek
//624 tm 627	zuidoost		hoek
//628 tm 631	noordoost		hoek
//
//
//616 - 624	= 120.5
//617 - 625	= 121.78
//618 - 626	= 123.04
//619 - 627	= 124.3
//
//620 - 628	= 120.5
//621 - 629	= 121.78
//622 - 630	= 123.04
//623 - 631	= 124.3



void KortstePad::BerekenKortstePad(){
	cout << "Filename:";
	cin >> fname;
	ifstream file(fname.c_str());
	//Zolang er tekst staat in het bestand
	while (file)
	{
		string line;
		getline(file, line);
		stringstream l(line);
		istringstream iss(line);
		int count = 0;
		vector<string> temp;
		do
		{
			string sub;
			if (iss >> sub)
			{
				//stop de string in vector temp
				temp.push_back(sub);
				//
				if (find(punten.begin(), punten.end(), sub) == punten.end())
				{
					if (sub > "9")
						punten.push_back(sub);
				}
				count++;
				if (count == 3)
				{
					afstanden[(make_pair(temp[0], temp[1]))] = stoi(temp[2]);
					afstanden[(make_pair(temp[1], temp[0]))] = stoi(temp[2]);
					temp.clear();
					count == 0;
				}
			}
		} while (iss);
	}
	//Maken van afstanden tussen de punten die nog geen afstand hebben. 
	for (auto n : punten){
		for (auto x : punten){
			if (n != x){
				auto search = afstanden.find(make_pair(n, x));
				if (search == afstanden.end())
					afstanden[make_pair(n, x)] = verweg;
			}
		}
	}
	//Algoritme van Floyd uitvoeren
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
}
