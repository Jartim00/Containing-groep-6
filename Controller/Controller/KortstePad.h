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
	map<pair<string, string>, double> afstanden;
	map<pair<string, string>, string> routes;
	map <pair<double, double>, string>  coordinatenWaypoints;
	vector<string> noChangeWaypoints;
	vector<string> endRouteWaypoints;
	vector<string> waypointsOpRoute;
	vector<string> punten;
	int verweg;
	double xCor;
	double yCor;
public:
	KortstePad();
	void VoegAfstandenToe();
	void VoegPuntenToe();
	void VoegCoordinatenToe();
	void AfstandenTussenAllePunten();
	void Floyd();
	void CoordinatenNieuweWaypoint(string huidigewaypointnr, int agvwaypoint, int laannr);
	void BepalenWeg(int agvwaypoint, bool beladen, string huidigewaypointnr, string bestemmingwaypointnr);
	void BerekenKortstePad(string huidigewaypointnr, string bestemmingwaypointnr, bool beladen);
};

#endif


