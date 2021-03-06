#ifndef containers_h
#define containers_h

#include <iostream>
class Containers
{
private:
	std::string aankomstdag;
	std::string aankomstmaand;
	std::string aankomstjaar;
	std::string aankomstbegintijd;
	std::string aankomsteindtijd;
	std::string aankomstvervoersmiddel;
	std::string aankomstbedrijf;
	std::string aankomstpositiex;
	std::string aankomstpositiey;
	std::string aankomstpositiez;
	std::string naameigenaar;
	std::string containernr;
	std::string vertrekdag;
	std::string vertrekmaand;
	std::string vertrekjaar;
	std::string vertrekbegintijd;
	std::string vertrekeindtijd;
	std::string vertrekvervoersmiddel;
	std::string vertrekbedrijf;
	std::string lengtecontainer;
	std::string breedtecontainer;
	std::string hoogtecontainer;
	std::string leeggewicht;
	std::string volgewicht;
	std::string naaminhoud;
	std::string soortinhoud;
	std::string gevaarinhoud;
	std::string iso;
public:
	void setAankomstdag(std::string dagaankomst);
	std::string getAankomstdag();
	void setAankomstmaand(std::string maandaankomst);
	std::string getAaankomstmaand();
	void setAankomstjaar(std::string jaaraankomst);
	std::string getAankomstjaar();
	void setAankomstbegintijd(std::string begintijdaankomst);
	std::string getAankomstbegintijd();
	void setAankomsteindtijd(std::string eindtijdaankomst);
	std::string getAankomsteindtijd();
	void setAankomstvervoersmiddel(std::string vervoersmiddelaankomst);
	std::string getAankomstvervoermiddel();
	void setAankomstbedrijf(std::string bedrijfaankomst);
	std::string getAankomstbedrijf();
	void setAankomstpositiex(std::string xpositieaankomst);
	std::string getAankomstpositiex();
	void setAankomstpositiey(std::string ypositieaankomst);
	std::string getAankomstpositiey();
	void setAankomstpositiez(std::string zpositieaankomst);
	std::string getAankomstpositiez();
	void setNaameigenaar(std::string eigenaarnaam);
	std::string getNaameigenaar();
	void setContainernr(std::string nrcontainer);
	std::string getContainernr();
	void setVertrekdag(std::string dagvertrek);
	std::string getVertrekdag();
	void setVertrekmaand(std::string maandvertrek);
	std::string getVertrekmaand();
	void setVertrekjaar(std::string jaarvertrek);
	std::string getVertrekjaar();
	void setVertrekbegintijd(std::string begintijdvertrek);
	std::string getVertrekbegintijd();
	void setVertrekeindtijd(std::string eindtijdvertrek);
	std::string getVertrekeindtijd();
	void setVertrekvervoersmiddel(std::string vervoervertreksmiddel);
	std::string getVertrekvervoersmiddel();
	void setVertrekbedrijf(std::string bedrijfvertrek);
	std::string getVertrekbedrijf();
	void setLengtecontainer(std::string containerlengte);
	std::string getLengtecontainer();
	void setBreedtecontainer(std::string containerbreedte);
	std::string getBreedtecontainer();
	void setHoogtecontainer(std::string containerhoogte);
	std::string getHoogtecontainer();
	void setLeeggewicht(std::string gewichtleeg);
	std::string getLeeggewicht();
	void setVolgewicht(std::string gewichtvol);
	std::string getVolgewicht();
	void setNaaminhoud(std::string inhoudnaam);
	std::string getNaamInhoud();
	void setSoortinhoud(std::string inhoudsoort);
	std::string getSoortinhoud();
	void setGevaarinhoud(std::string inhoudgevaar);
	std::string getGevaarinhoud();
	void setISO(std::string osi);
	std::string getISO();
	Containers();
};

#endif
