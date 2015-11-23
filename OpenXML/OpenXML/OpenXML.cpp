// OpenXML.cpp : Defines the entry point for the console application.
//
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

string split(const string a){
	int count = 0;
	for (auto n : a){
		if (n == '>')
			count++;
	}
	if (count == 2)
	{
		stringstream xx(a);
		string item;
		vector<string> gesplit;
		while (getline(xx, item, '>'))
			gesplit.push_back(item);
		string test2 = gesplit[1];
		stringstream yy(test2);
		vector<string> temp;
		while (getline(yy, item, '<'))
			temp.push_back(item);
		return temp[0];
	}
	else
	{
		return a;
	}
}

bool checkVervoer(string a){
	a = split(a);
	vector<string> vervoerssoorten = { "zeeschip", "trein", "binnenschip", "vrachtauto" };
	for (auto x : vervoerssoorten)
		if (a == x)
			return true;
	return false;
};

bool checkTime(string time){
	time = split(time).c_str();
	int temp = time.find('.');
	if (temp == -1) return false;
	size_t found = time.find_first_not_of("0123456789.");
	if (found != string::npos) return true;
	if (atoi(time.substr(0, temp).c_str()) < 12 && (atoi(time.substr(temp + 1).c_str()) <= 60)) return true;
	if (atoi(time.substr(0, temp).c_str()) == 12 && atoi(time.substr(temp + 1).c_str()) == 0) return true;
	return false;
}

bool checkTimes(string starttime, string endtime)
{
	starttime = split(starttime).c_str();
	endtime = split(endtime).c_str();
	int starttemp = starttime.find('.');
	int endtemp = endtime.find('.');
	if (atoi(starttime.substr(0, starttemp).c_str()) > atoi(endtime.substr(0, endtemp).c_str())) return false;
	if (atoi(starttime.substr(0, starttemp).c_str()) < atoi(endtime.substr(0, endtemp).c_str())) return true;
	if (atoi(starttime.substr(0, starttemp).c_str()) == atoi(endtime.substr(0, endtemp).c_str()))
	{
		if (atoi(starttime.substr(starttemp + 1).c_str()) >= atoi(endtime.substr(endtemp + 1).c_str())) return false;
		else return true;
	}
	return false;
}

bool checkDatum(string a, string b, string c){
	vector<string> datum = { a, b, c };
	for (auto x : datum){
		x = split(x).c_str();
		if (any_of(x.begin(), x.end(), isalpha)) return false;
	}
	int dag = atoi(split(a).c_str()); int maand = atoi(split(b).c_str()); int jaar = atoi(split(c).c_str());
	if (maand == 0 || maand > 12) return false;
	if (jaar > 99) return false;
	if (dag > 31) return false;
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

bool checkStringOnlyDigits(string a){
	a = split(a).c_str();
	if (all_of(a.begin(), a.end(), isdigit)) return true;
	else return false;
}

int main()
{
	vector<string> containergegevens = { "aankomstdag", "aankomstmaand", "aankomstjaar", "aankomstbegintijd", "aankomsteindtijd",
		"aankomstvervoersmiddel", "aankomstbedrijf", "aankomstpositiex", "aankomstpositiey", "aankomstpositiez", "naameigenaar",
		"containernr", "vertrekdag", "vertrekmaand", "vertrekjaar", "vertrekbegintijd", "vertrekeindtijd", "vertrekvervoersmiddel",
		"vertrekbedrijf", "lengtecontainer", "breedtecontainer", "hoogtecontainer", "leeggewicht", "volgewicht",
		"naaminhoud", "soortinhoud", "gevaarinhoud", "iso" };
	map<string, string> container;
	for (auto x : containergegevens)
		container[x] = "";
	vector<string> fname = { "xml1.xml", "xml2.xml", /* "xml3.xml", "xml4.xml", "xml5.xml", "xml6.xml", "xml7.xml" */};
	cout << "press any key to start" << endl;
	cin.get();

	for (auto x : fname)
	{
		ifstream file(x.c_str());
		string tempdag;
		string tempmaand;
		string tempvan;
		bool error = false;
		bool aankomst = true;
		bool eigenaar = true;
		bool goodContainer = true;
		while (file)
		{
			string line;
			getline(file, line);
			stringstream l(line);
			istringstream iss(line);
			do
			{
				string sub;
				if (iss >> sub)
				{
					if (sub.find("<aankomst") != string::npos)
						aankomst = true;
					if (sub.find("<vertrek") != string::npos)
						aankomst = false;
					if (sub.find("<containernr>") != string::npos)
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
							container["containernr"] = sub;
					if (sub.find("<bedrijf") != string::npos)
						if (aankomst)
							container["aankomstbedrijf"] = sub;
						else
							container["vertrekbedrijf"] = sub;
					if (sub.find("<d>") != string::npos)
						tempdag = sub;
					if (sub.find("<m>") != string::npos)
						tempmaand = sub;
					if (sub.find("<j>") != string::npos)
					{
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
						if (!checkTime(sub))
							error = true;
						else
							tempvan = sub;
					if (sub.find("<tot>") != string::npos)
					{
						if (!checkTime(sub))
							error = true;
						else
						{
							if (aankomst)
							{
								container["aankomstbegintijd"] = tempvan;
								container["aankomsteindtijd"] = sub;
							}
							else
							{
								if (checkData(container["aankomstdag"], container["aankomstmaand"], container["aankomstjaar"], container["vertrekdag"], container["vertrekmaand"], container["vertrekjaar"], container["aankomsteindtijd"], tempvan))
								{
									container["vertrekbegintijd"] = tempvan;
									container["vertrekeindtijd"] = sub;
								}
								else
								{
									error = true;
								}
							}
						}
						tempvan = "";
					}
					if (sub.find("<soort_vervoer>") != string::npos)
						if (!checkVervoer(sub))
							error = true;
						else
						{
							if (aankomst)
								container["aankomstvervoersmiddel"] = sub;
							else
								container["vertrekvervoersmiddel"] = sub;
						}
					if (sub.find("<x>") != string::npos)
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
							container["aankomstpositiex"] = sub;
					if (sub.find("<y>") != string::npos)
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
							container["aankomstpositiey"] = sub;
					if (sub.find("<z>") != string::npos)
						if (!checkStringOnlyDigits(sub))
							error = true;
						else
							container["aankomstpositiez"] = sub;
					if (sub.find("<eigenaar>") != string::npos)
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
					if (sub.find("<inhoud>") != string::npos && sub != ("<inhoud>"))
						container["volgewicht"] = sub;
					if (sub.find("<soort>") != string::npos)
						container["soortinhoud"] = sub;
					if (sub.find("<gevaar>") != string::npos)
						container["gevaarinhoud"] = sub;
					if (sub.find("<ISO>") != string::npos)
						container["iso"] = sub;
					if (sub.find("</record>") != string::npos)
					{
						for (auto x : container)
						{
							x.second = split(x.second);
							container[x.first] = x.second;
							if (x.second == ""){
								cout << "Fout in de containerinformatie" << endl;
								goodContainer = false;
							}
						}
						if (!error & goodContainer){
							
						}
						else
						{
							cout << "error container" << endl;
							error = false;
							goodContainer = true;
						}
						for (auto x : container)
							x.second = "";
					}
				}
			} while (iss);
		}
	}
	cout << "end" << endl;
	for (;;){}
}
