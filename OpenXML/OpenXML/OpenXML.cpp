// OpenXML.cpp : Defines the entry point for the console application.
//
#include "stdafx.h"
#include "Containers.h"
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

string split(const string a){
	int count = 0;
	//checken of een string splitbaar is.
	for (auto n : a)
		if (n == '>')
			count++;
	if (count == 2)
	{
		stringstream xx(a);
		string item;
		vector<string> gesplit;
		//split de string twee keer bij de >
		while (getline(xx, item, '>'))
			gesplit.push_back(item);
		//pak de tweede split
		string test2 = gesplit[1];
		stringstream yy(test2);
		vector<string> temp;
		//split bij de < 
		while (getline(yy, item, '<'))
			temp.push_back(item);
		return temp[0];
	}
	else
		return a;
}

bool checkVervoersoort(string a){
	a = split(a);
	vector<string> vervoerssoorten = { "zeeschip", "trein", "binnenschip", "vrachtauto" };
	for (auto x : vervoerssoorten)
		if (a == x)
			return true;
	return false;
};

bool checkTime(string time){
	time = split(time).c_str();
	//kijk op welke index de . zit.
	int temp = time.find('.');
	//kijk op welke positie de eerste char is welke geen getal of punt is.
	size_t found = time.find_first_not_of("0123456789.");
	//als de gevonden positie 
	if (found != string::npos) 
		return false;
	if (atoi(time.substr(0, temp).c_str()) < 12 && (atoi(time.substr(temp + 1).c_str()) <= 60)) return true;
	if (atoi(time.substr(0, temp).c_str()) == 12 && atoi(time.substr(temp + 1).c_str()) == 0) return true;
	return false;
}

bool checkTimes(string starttime, string endtime)
{
	starttime = split(starttime).c_str();
	endtime = split(endtime).c_str();
	//bekijkt de positie van de punt.
	int starttemp = starttime.find('.');
	int endtemp = endtime.find('.');
	//bij de 0,starttemp pakt hij stukje voor de punt, bij starttemp + 1, stukje na de punt.
	if (atoi(starttime.substr(0, starttemp).c_str()) > atoi(endtime.substr(0, endtemp).c_str())) return false;
	if (atoi(starttime.substr(0, starttemp).c_str()) < atoi(endtime.substr(0, endtemp).c_str())) return true;
	if (atoi(starttime.substr(0, starttemp).c_str()) == atoi(endtime.substr(0, endtemp).c_str()))
	{
		if (atoi(starttime.substr(starttemp + 1).c_str()) >= atoi(endtime.substr(endtemp + 1).c_str())) return false;
	}
	return true;
}

bool checkDatum(string a, string b, string c){
	vector<string> datum = { a, b, c };
	//check of datum bestaat uit getallen
	for (auto x : datum){
		x = split(x).c_str();
		if (any_of(x.begin(), x.end(), isalpha)) return false;
	}
	int dag = atoi(split(a).c_str()); int maand = atoi(split(b).c_str()); int jaar = atoi(split(c).c_str());
	if (maand == 0 || maand > 12) return false;
	if (jaar > 99) return false;
	if (dag == 0 || dag > 31) return false;
	else return true;
}

bool checkData(string a, string b, string c, string d, string e, string f, string g, string h)
{
	int aankomstdag = atoi(split(a).c_str()); int vertrekdag = atoi(split(d).c_str());
	int aankomstmaand = atoi(split(b).c_str()); int aankomstjaar = atoi(split(c).c_str());
	int vertrekmaand = atoi(split(e).c_str()); int vertrekjaar = atoi(split(f).c_str());
	if (aankomstjaar > vertrekjaar) return false;
	if (aankomstjaar < vertrekjaar) return true;
	if (aankomstjaar == vertrekjaar)
	{
		if (aankomstmaand > vertrekmaand) return false;
		if (aankomstmaand < vertrekjaar) return true;
		if (aankomstmaand == vertrekmaand)
		{
			if (aankomstdag > vertrekdag) return false;
			if (aankomstdag < aankomstdag) return true;
			if (aankomstdag == vertrekdag)
			{
				return checkTimes(g, h);
			}
		}
	}
}

//Kijken of alle tekens getallen zijn.
bool checkStringOnlyDigits(string a){
	a = split(a).c_str();
	if (all_of(a.begin(), a.end(), isdigit)) return true;
	else return false;
}

bool checkPositie(string x, string y, string z, map<pair<string, string>, string> map, string vervoersmiddel){
	//check of de positie x,y,z al in de map staat.
	for (auto a : map)
		if (a.first.first == x && a.first.second == y && a.second == z) return false;
	return true;
}
int main()
{
	vector<string> containergegevens = { "aankomstdag", "aankomstmaand", "aankomstjaar", "aankomstbegintijd", "aankomsteindtijd",
		"aankomstvervoersmiddel", "aankomstpositiex", "aankomstpositiey", "aankomstpositiez",
		"containernr", "vertrekdag", "vertrekmaand", "vertrekjaar", "vertrekbegintijd", "vertrekeindtijd", "vertrekvervoersmiddel", };

	//"aankomstbedrijf", "naameigenaar", "vertrekbedrijf", "lengtecontainer", "breedtecontainer", "hoogtecontainer", "leeggewicht", "volgewicht",
	//"naaminhoud", "soortinhoud", "gevaarinhoud", "iso"
	map<string, string> container;
	map<pair<string, string>, string> treinposities;
	map<pair<string, string>, string> binnenschipposities;
	map<pair<string, string>, string> zeeschipposities;

	vector<Container> containers;
	int index = 0;
	Container temp;
	//aanmaken van een map met een gegeven uit de vector containergegevens en een lege string.
	for (auto x : containergegevens)
		container[x] = "";
	vector<string> fname = { "xml1.xml" };//, "xml2.xml", "xml3.xml", "xml4.xml",  "xml5.xml", "xml6.xml", "xml7.xml" };
	cout << "press any key to start" << endl;
	cin.get();

	//voor alle bestanden in de vector fname.
	for (auto x : fname)
	{
		ifstream file(x.c_str());
		string tempdag;
		string tempmaand;
		string tempvan;
		string tempx;
		string tempy;
		bool error = false;
		bool aankomst = true;
		bool eigenaar = true;
		//zolang er tekst in de file zit
		while (file)
		{
			string line;
			getline(file, line);
			stringstream l(line);
			istringstream iss(line);
			do
			{
				string sub;
				//elke regel wordt één voor één behandeld.
				if (iss >> sub)
				{
					if (sub.find("<aankomst") != string::npos)
						aankomst = true;
					if (sub.find("<vertrek") != string::npos)
						aankomst = false;
					if (sub.find("<containernr>") != string::npos)
						//check of containernr alleen getallen bevat.
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
							container["containernr"] = sub;
					/*if (sub.find("<bedrijf") != string::npos)
						if (aankomst)
							container["aankomstbedrijf"] = sub;
						else
							container["vertrekbedrijf"] = sub;*/
					if (sub.find("<d>") != string::npos)
						tempdag = sub;
					if (sub.find("<m>") != string::npos)
						tempmaand = sub;
					if (sub.find("<j>") != string::npos)
					{
						//check de datum.
						if (!checkDatum(tempdag, tempmaand, sub))
							error = true;
						else
						{
							if (aankomst)
							{
								container["aankomstdag"] = tempdag;
								container["aankomstmaand"] = tempmaand;
								container["aankomstjaar"] = sub;
							}
							else
							{
								container["vertrekdag"] = tempdag;
								container["vertrekmaand"] = tempmaand;
								container["vertrekjaar"] = sub;
							}
						}
						tempdag = "", tempmaand = "";
					}
					if (sub.find("<van>") != string::npos)
						//Check de tijdnotering
						if (!checkTime(sub))
							error = true;
						else
							tempvan = sub;
					if (sub.find("<tot>") != string::npos)
					{
						//Check de tijdsnotering
						if (!checkTime(sub))
							error = true;
						else
						{
							//Check of de tijden van de aankomst ofwel vertrek kloppen.
							if (checkTimes(tempvan, sub))
								if (aankomst)
								{
									container["aankomstbegintijd"] = tempvan;
									container["aankomsteindtijd"] = sub;
								}
								else
								{
									//Check of het vertrek moment na het aankomst moment ligt.
									if (checkData(container["aankomstdag"], container["aankomstmaand"], container["aankomstjaar"], container["vertrekdag"], container["vertrekmaand"], container["vertrekjaar"], container["aankomsteindtijd"], tempvan))
									{
										container["vertrekbegintijd"] = tempvan;
										container["vertrekeindtijd"] = sub;
									}
									else
										error = true;
								}
							else
								error = true;
						}
						tempvan = "";
					}
					if (sub.find("<soort_vervoer>") != string::npos)
						//Check of de vervoerssoort geldig is.
						if (!checkVervoersoort(sub))
							error = true;
						else
						{
							if (aankomst)
								container["aankomstvervoersmiddel"] = sub;
							else
								container["vertrekvervoersmiddel"] = sub;
						}
					if (sub.find("<x>") != string::npos)
						//Check of de string alleen getallen bevat.
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
							tempx = sub;
					if (sub.find("<y>") != string::npos)
						//Check of de string alleen getallen bevat.
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
							tempy = sub;
					if (sub.find("<z>") != string::npos)
						//Check of de string alleen getallen bevat.
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
						{
							//Kijk eerste welke vervoerssoort het is, vervolgens de maximale coördinaten, dan kijken of positie reeds bezet is. 
							//Indien niet bezet stop de coordinaten in de map van de vervoerssoort.
							if (container["aankomstvervoersmiddel"] == "<soort_vervoer>vrachtauto</soort_vervoer>")
								if (tempx != "<x>1</x>" || tempy != "<y>0</y>" || sub != "<z>0</z>")
									error = true;
							if (container["aankomstvervoersmiddel"] == "<soort_vervoer>trein</soort_vervoer>")
							{
								int check = atoi(split(tempx).c_str());
								if (atoi(split(tempx).c_str()) > 17 || tempy != "<y>0</y>" || sub != "<z>0</z>")
									error = true;
								if (!checkPositie(tempx, tempy, sub, treinposities, "trein"))
									error = true;
								else
									treinposities[make_pair(tempx, tempy)] = sub;
							}
							if (container["aankomstvervoersmiddel"] == "<soort_vervoer>zeeschip</soort_vervoer>")
							{
								if (atoi(split(tempx).c_str()) > 19 || atoi(split(tempy).c_str()) > 15 || atoi(split(sub).c_str()) > 5)
									error = true;
								if (!checkPositie(tempx, tempy, sub, zeeschipposities, "zeeschip"))
									error = true;
								else
									zeeschipposities[make_pair(tempx, tempy)] = sub;
							}
							if (container["aankomstvervoersmiddel"] == "<soort_vervoer>binnenschip</soort_vervoer>")
							{
								if (atoi(split(tempx).c_str()) > 5 || atoi(split(tempy).c_str()) > 3 || atoi(split(sub).c_str()) > 2)
									error = true;
								if (!checkPositie(tempx, tempy, sub, binnenschipposities, "binnenschip"))
									error = true;
								else
									binnenschipposities[make_pair(tempx, tempy)] = sub;
							}
							container["aankomstpositiez"] = sub;
							container["aankomstpositiex"] = tempx;
							container["aankomstpositiey"] = tempy;
							tempx = "";
							tempy = "";
					    }
					/*if (sub.find("<eigenaar>") != string::npos)
						eigenaar = true;
					if (sub.find("<naam>") != string::npos)
						if (eigenaar)
						{
							container["naameigenaar"] = sub;
							eigenaar = false;
						}
						else
							container["naaminhoud"] = sub;
					if (sub.find("<l>") != string::npos)
						container["lengtecontainer"] = sub;
					if (sub.find("<b>") != string::npos)
						container["breedtecontainer"] = sub;
					if (sub.find("<h>") != string::npos)
						container["hoogtecontainer"] = sub;
					if (sub.find("<leeg>") != string::npos)
						container["leeggewicht"] = sub;
					//if regel bevat <inhoud>, maar de hele regel bevat meer dan <inhoud>
					if (sub.find("<inhoud>") != string::npos && sub != ("<inhoud>"))
						container["volgewicht"] = sub;
					if (sub.find("<soort>") != string::npos)
						container["soortinhoud"] = sub;
					if (sub.find("<gevaar>") != string::npos)
						container["gevaarinhoud"] = sub;
					if (sub.find("<ISO>") != string::npos)
						container["iso"] = sub;*/
					//bij </record> is alle informatie van de container binnengehaald.
					if (sub.find("</record>") != string::npos)
					{
						for (auto x : container)
						{
							x.second = split(x.second);
							container[x.first] = x.second;
							//loop alle informatie door per container en kijk of er informatie niet beschikbaar is, indien niet beschikbaar --> container fout.
							if (x.second == "")
							{
								cout << "Fout in de containerinformatie" << endl;
								error = true;
							}
						}
						if (!error)
						{
							//voeg een nieuwe container toe aan de vector met containers.
							containers.push_back(temp);
							//Zet alle informatie in de container class.
							containers[index].setAankomstbegintijd(container["aankomstbegintijd"]);
							containers[index].setAankomstdag(container["aankomstdag"]);
							containers[index].setAankomsteindtijd(container["aankomsteindtijd"]);
							containers[index].setAankomstjaar(container["aankomstjaar"]);
							containers[index].setAankomstmaand(container["aankomstmaand"]);
							containers[index].setAankomstpositiex(container["aankomstpositiex"]);
							containers[index].setAankomstpositiey(container["aankomstpositiey"]);
							containers[index].setAankomstpositiez(container["aankomstpositiez"]);
							containers[index].setAankomstvervoersmiddel(container["aankomstvervoersmiddel"]);
							//containers[index].setAankomstbedrijf(container["aankomstbedrijf"]);
							//containers[index].setBreedtecontainer(container["breedtecontainer"]);
							containers[index].setContainernr(container["containernr"]);
							//containers[index].setHoogtecontainer(container["hoogtecontainer"]);
							//containers[index].setISO(container["iso"]);
							//containers[index].setLeeggewicht(container["leeggewicht"]);
							//containers[index].setLengtecontainer(container["lengtecontainer"]);
							//containers[index].setNaameigenaar(container["naameigenaar"]);
							//containers[index].setSoortinhoud(container["soortinhoud"]);
							//containers[index].setNaaminhoud(container["naaminhoud"]);
							//containers[index].setGevaarinhoud(container["gevaarinhoud"]);
							containers[index].setVertrekvervoersmiddel(container["vertrekvervoersmiddel"]);
							//containers[index].setVertrekbedrijf(container["vertrekbedrijf"]);
							containers[index].setVertrekbegintijd(container["vertrekbegintijd"]);
							containers[index].setVertrekdag(container["vertrekdag"]);
							containers[index].setVertrekeindtijd(container["vertrekeindtijd"]);
							containers[index].setVertrekjaar(container["vertrekjaar"]);
							containers[index].setVertrekmaand(container["vertrekmaand"]);
							//containers[index].setVolgewicht(container["volgewicht"]);
							cout << "good container" << index << endl;
							//index verhogen om de volgende container op de goede positie toe te voegen. 
							index++;
						}
						else
						{
							cout << "error container" << endl;
							error = false;
						}
						//informatie weer uit de containermap halen, zodat deze klaar is voor de volgende container.
						for (auto x : container)
							x.second = "";
					}
				}
			} while (iss);
		}
	}
	//bool checkPosities
	/*for (int i = 0; i < containers.size(); i++){
		cout << containers[i].getVolgewicht() << endl;
	}
	for (auto x : zeeschipposities){
		cout << x.first.first << " " << x.first.second << " " << x.second << endl;
	}*/
	cout << "end" << endl;

	Server s1 = Server();
	s1.Communicate();
}
