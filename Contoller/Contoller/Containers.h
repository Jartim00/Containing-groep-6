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
	std::string getAankomstdag() const;
	void setAankomstmaand(std::string maandaankomst);
	std::string getAankomstmaand() const;
	void setAankomstjaar(std::string jaaraankomst);
	std::string getAankomstjaar() const;
	void setAankomstbegintijd(std::string begintijdaankomst);
	std::string getAankomstbegintijd() const;
	void setAankomsteindtijd(std::string eindtijdaankomst);
	std::string getAankomsteindtijd() const;
	void setAankomstvervoersmiddel(std::string vervoersmiddelaankomst);
	std::string getAankomstvervoermiddel() const;
	void setAankomstbedrijf(std::string bedrijfaankomst);
	std::string getAankomstbedrijf() const;
	void setAankomstpositiex(std::string xpositieaankomst);
	std::string getAankomstpositiex() const;
	void setAankomstpositiey(std::string ypositieaankomst);
	std::string getAankomstpositiey() const;
	void setAankomstpositiez(std::string zpositieaankomst);
	std::string getAankomstpositiez() const;
	void setNaameigenaar(std::string eigenaarnaam);
	std::string getNaameigenaar() const;
	void setContainernr(std::string nrcontainer);
	std::string getContainernr() const;
	void setVertrekdag(std::string dagvertrek);
	std::string getVertrekdag() const;
	void setVertrekmaand(std::string maandvertrek);
	std::string getVertrekmaand() const;
	void setVertrekjaar(std::string jaarvertrek);
	std::string getVertrekjaar() const;
	void setVertrekbegintijd(std::string begintijdvertrek);
	std::string getVertrekbegintijd() const;
	void setVertrekeindtijd(std::string eindtijdvertrek);
	std::string getVertrekeindtijd() const;
	void setVertrekvervoersmiddel(std::string vervoervertreksmiddel);
	std::string getVertrekvervoersmiddel() const;
	void setVertrekbedrijf(std::string bedrijfvertrek);
	std::string getVertrekbedrijf() const;
	void setLengtecontainer(std::string containerlengte);
	std::string getLengtecontainer() const;
	void setBreedtecontainer(std::string containerbreedte);
	std::string getBreedtecontainer() const;
	void setHoogtecontainer(std::string containerhoogte);
	std::string getHoogtecontainer() const;
	void setLeeggewicht(std::string gewichtleeg);
	std::string getLeeggewicht() const;
	void setVolgewicht(std::string gewichtvol);
	std::string getVolgewicht() const;
	void setNaaminhoud(std::string inhoudnaam);
	std::string getNaamInhoud() const;
	void setSoortinhoud(std::string inhoudsoort);
	std::string getSoortinhoud() const;
	void setGevaarinhoud(std::string inhoudgevaar);
	std::string getGevaarinhoud() const;
	void setISO(std::string osi);
	std::string getISO() const;
	Containers();
};

#endif
