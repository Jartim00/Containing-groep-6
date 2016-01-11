#include "stdafx.h"
#include "AGV.h"
#include "KortstePad.h"


KortstePad::KortstePad()
{
	verweg = 10000;
	xCor = 0;
	yCor = 0;
	noChangeWaypoints = { "714", "715", "651", "650", "640", "641", "716", "717", "807", "808", "809", "810" };
}

void KortstePad::VoegAfstandenToe(){
	//linksboven --> uitgang trein boven
	afstanden[make_pair("620", "646")] = .25;
	//uitgang trein boven --> buitenbocht boven uitgang trein
	afstanden[make_pair("646", "651")] = 6.45;
	//uitgang trein boven --> ingang trein boven
	afstanden[make_pair("646", "642")] = 1;
	//ingang trein boven --> binnenbocht boven ingang trein
	afstanden[make_pair("642", "650")] = 5.75;
	//ingang trein boven --> uitgang trein beneden
	afstanden[make_pair("642", "632")] = 306;
	//uitgang trein beneden --> binnenbocht beneden uitgang trein
	afstanden[make_pair("632", "640")] = 6.45;
	//uitgang trein beneden --> ingang trein beneden
	afstanden[make_pair("632", "636")] = 1;
	//ingang trein beneden --> buitenbocht boven ingang trein
	afstanden[make_pair("636", "641")] = 5.75;
	//ingang trein beneden --> hoek linksbeneden
	afstanden[make_pair("636", "616")] = .25;
	//hoek linksbeneden --> ingang zeeschip platform
	afstanden[make_pair("616", "714")] = 7.95;
	afstanden[make_pair("616", "715")] = 7.95;
	//hoek linksbeneden --> hoek rechtsbeneden;
	afstanden[make_pair("616", "624")] = 120.5;
	//linksboven --> rechtsboven
	afstanden[make_pair("620", "628")] = 120.5;
	afstanden[make_pair("624", "716")] = 8.65;
	afstanden[make_pair("624", "717")] = 8.65;
	afstanden[make_pair("624", "803")] = .25;
	afstanden[make_pair("803", "799")] = 1;
	afstanden[make_pair("803", "808")] = 8.75;
	afstanden[make_pair("799", "807")] = 8.05;
	afstanden[make_pair("799", "811")] = 151;
	afstanden[make_pair("811", "815")] = 1;
	afstanden[make_pair("811", "809")] = 8.05;
	afstanden[make_pair("815", "810")] = 8.75;
	afstanden[make_pair("628", "815")] = 155.25;
}

void KortstePad::VoegPuntenToe(){
	punten.push_back("620");
	punten.push_back("646");
	punten.push_back("642");
	punten.push_back("651");
	punten.push_back("650");
	punten.push_back("640");
	punten.push_back("641");
	punten.push_back("632");
	punten.push_back("636");
	punten.push_back("616");
	punten.push_back("714");
	punten.push_back("715");
	punten.push_back("716");
	punten.push_back("717");
	punten.push_back("624");
	punten.push_back("803");
	punten.push_back("808");
	punten.push_back("799");
	punten.push_back("807");
	punten.push_back("811");
	punten.push_back("809");
	punten.push_back("815");
	punten.push_back("810");
	punten.push_back("628");
}

void KortstePad::VoegCoordinatenToe(){
	coordinatenWaypoints[make_pair(-66.7, -154)] = "651";
	coordinatenWaypoints[make_pair(-66, -153)] = "650";
	coordinatenWaypoints[make_pair(-66.7, 154)] = "641";
	coordinatenWaypoints[make_pair(-66, 153)] = "640";
	coordinatenWaypoints[make_pair(-60.25, -153)] = "642";
	coordinatenWaypoints[make_pair(-60.25, 153)] = "632";
	coordinatenWaypoints[make_pair(-60.89, 162.9)] = "715";
	coordinatenWaypoints[make_pair(-60.25, 162.2)] = "714";
	coordinatenWaypoints[make_pair(60.25, 162.2)] = "716";
	coordinatenWaypoints[make_pair(60.89, 162.9)] = "717";
	coordinatenWaypoints[make_pair(60.25, 153)] = "799";
	coordinatenWaypoints[make_pair(68.3, 153)] = "807";
	coordinatenWaypoints[make_pair(69, 154)] = "808";
	coordinatenWaypoints[make_pair(68.3, 2)] = "809";
	coordinatenWaypoints[make_pair(69, 1)] = "810";
	coordinatenWaypoints[make_pair(60.25, 2)] = "811";
	coordinatenWaypoints[make_pair(60.25, 1)] = "815";
	coordinatenWaypoints[make_pair(60.25, -154.25)] = "628";
}

void KortstePad::CoordinatenNieuweWaypoint(string huidigewaypointnr, int agvwaypoint, int laannr){
	punten.push_back(huidigewaypointnr);
	while (true){
		if ((laannr - 77) < 0)
			break;
		else
			laannr -= 77;
	}
	if (agvwaypoint < 77){
		xCor = -60.25;
		yCor = 152 - (laannr * 4);
	}
	if (agvwaypoint > 307 && agvwaypoint < 385){
		xCor = 60.25;
		yCor = 152 - (laannr * 4);
	}
	if (agvwaypoint > 651 && agvwaypoint < 682){
		xCor = -66;
		yCor = 2.8 + ((681 - agvwaypoint)*2.495);
	}
	if (agvwaypoint > 681 && agvwaypoint < 712){
		xCor = -66.7;
		yCor = 2.8 + ((681 - agvwaypoint)*2.495);
	}
	if (agvwaypoint > 717 && agvwaypoint < 738){
		xCor = -58.2 + ((737 - agvwaypoint) * 2.4);
		yCor = 162.2;
	}
	if (agvwaypoint > 737 && agvwaypoint < 758){
		xCor = 12.5 + ((757 - agvwaypoint) * 2.4);
		yCor = 162.2;
	}
	if (agvwaypoint > 757 && agvwaypoint < 778){
		xCor = -58.2 + ((777 - agvwaypoint) * 2.4);
		yCor = 162.9;
	}
	if (agvwaypoint > 777 && agvwaypoint < 798){
		xCor = 12.5 + ((797 - agvwaypoint) * 2.4);
		yCor = 162.9;
	}
	if (agvwaypoint > 818 && agvwaypoint < 825){
		xCor = 69;
		yCor = 123.2 - (2.4 * (824 - agvwaypoint));
	}
	if (agvwaypoint > 824 && agvwaypoint < 831){
		xCor = 69;
		yCor = 45 - (2.4 * (830 - agvwaypoint));
	}
	if (agvwaypoint > 830 && agvwaypoint < 837){
		xCor = 68.3;
		yCor = 123.2 - (2.4 * (836 - agvwaypoint));
	}
	if (agvwaypoint > 836 && agvwaypoint < 843){
		xCor = 68.3;
		yCor = 68.3 - (2.4 * (842 - agvwaypoint));
	}
	if (agvwaypoint > 836 && agvwaypoint < 843){
		xCor = 68.3;
		yCor = 68.3 - (2.4 * (842 - agvwaypoint));
	}
	if (agvwaypoint > 842 && agvwaypoint < 863){
		xCor = 69.1;
		yCor = -8 - (4 * (862 - agvwaypoint));
	}
	//Maak afstanden tussen nieuwe waypoint en bestaande waypoints die in de zelfde x-lijn liggen.
	for (auto q : coordinatenWaypoints){
		if (q.first.first == xCor){
			if (q.first.second > yCor)
				afstanden[make_pair(huidigewaypointnr, q.second)] = q.first.second - yCor;
			else
				afstanden[make_pair(huidigewaypointnr, q.second)] = fabs(q.first.second) + yCor;
		}
	}
}

void KortstePad::AfstandenTussenAllePunten(){
	for (auto x : afstanden){
		afstanden[make_pair(x.first.second, x.first.first)] = x.second;
	}
	//Maken van afstanden tussen de punten die nog geen afstand hebben. 
	for (auto n : punten){
		for (auto x : punten){
			if (n != x){
				auto search = afstanden.find(make_pair(n, x));
				if (search == afstanden.end()){
					afstanden[make_pair(n, x)] = verweg;
				}
			}
		}
	}
}

void KortstePad::Floyd(){
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
							routes[make_pair(a, c)] = routes[make_pair(a, b)] + b + "," + routes[make_pair(b, c)];
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
void KortstePad::BepalenWeg(int agvwaypoint, bool beladen, string huidigewaypointnr, string bestemmingwaypointnr){
	waypointsOpRoute.push_back(huidigewaypointnr);
	stringstream ss(routes[make_pair(huidigewaypointnr, bestemmingwaypointnr)]);
	string word;
	while (getline(ss, word, ',')){
		waypointsOpRoute.push_back(word);
	}
	int wegnummer = 0;
	//eerste if voor links, tweede voor rechts
	if (agvwaypoint < 77 || agvwaypoint == 651 || agvwaypoint == 650 || agvwaypoint == 640 || agvwaypoint == 641 || agvwaypoint == 715 || agvwaypoint == 714){
		//als de agv het zuiden gaat
		if (agvwaypoint > atoi(waypointsOpRoute[0].c_str()))
			//1 is meest rechts, 4 meest links
			if (beladen == true)
				wegnummer = 1;
			else
				wegnummer = 2;
		else
			if (beladen == true)
				wegnummer = 4;
			else
				wegnummer = 3;
	}
	if ((agvwaypoint > 307 && agvwaypoint < 385) || agvwaypoint == 810 || agvwaypoint == 809 || agvwaypoint == 807 || agvwaypoint == 808 || agvwaypoint == 716 || agvwaypoint == 717){
		//als de agv naar het zuiden gaat
		if (agvwaypoint > atoi(waypointsOpRoute[0].c_str()))
			if (beladen == true)
				//1 is meest rechts, 4 meest links.
				wegnummer = 4;
			else
				wegnummer = 3;
		else
			if (beladen == true)
				wegnummer = 1;
			else
				wegnummer = 2;
	}
	if (wegnummer == 1){
		for (auto x : waypointsOpRoute){
			endRouteWaypoints.push_back(x);
		}
	}
	else{
		string tempwaypoint = waypointsOpRoute[0];
		endRouteWaypoints.push_back(tempwaypoint);
		for (auto x : waypointsOpRoute){
			if (x != waypointsOpRoute[0]){
				for (auto y : noChangeWaypoints){
					if (x == y){
						endRouteWaypoints.push_back(x);
						break;
					}
				}
				if (wegnummer == 2){
					endRouteWaypoints.push_back(to_string(atoi(x.c_str()) + 1));
				}
				else if (wegnummer == 3){
					endRouteWaypoints.push_back(to_string(atoi(x.c_str()) + 2));
				}
				else if (wegnummer == 4){
					endRouteWaypoints.push_back(to_string(atoi(x.c_str()) + 3));
				}
			}
		}
	}
	endRouteWaypoints.push_back(bestemmingwaypointnr);
	for (auto x : endRouteWaypoints){
		cout << x << endl;
	}
}
void KortstePad::BerekenKortstePad(string huidigewaypointnr, string bestemmingwaypointnr, bool beladen){
	int agvwaypoint = atoi(huidigewaypointnr.c_str());
	int laannr = atoi(huidigewaypointnr.c_str());
	VoegAfstandenToe();
	VoegPuntenToe();
	VoegCoordinatenToe();
	CoordinatenNieuweWaypoint(huidigewaypointnr, agvwaypoint, laannr);
	AfstandenTussenAllePunten();
	Floyd();
	BepalenWeg(agvwaypoint, beladen, huidigewaypointnr, bestemmingwaypointnr);
}
