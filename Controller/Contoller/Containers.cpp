#include "stdafx.h"
#include "Containers.h"

using namespace std;

Containers::Containers(){

}
void Containers::setAankomstdag(string dagaankomst){
	aankomstdag = dagaankomst;
}
string Containers::getAankomstdag() const{
	return aankomstdag;
}
void Containers::setAankomstmaand(string maandaankomst){
	aankomstmaand = maandaankomst;
}
string Containers::getAankomstmaand()  const{
	return aankomstmaand;
}
void Containers::setAankomstjaar(string jaaraankomst){
	aankomstjaar = jaaraankomst;
}
string Containers::getAankomstjaar()  const{
	return aankomstjaar;
}
void Containers::setAankomstbegintijd(string begintijdaankomst){
	aankomstbegintijd = begintijdaankomst;
}
string Containers::getAankomstbegintijd() const{
	return aankomstbegintijd;
}
void Containers::setAankomsteindtijd(string eindtijdaankomst){
	aankomsteindtijd = eindtijdaankomst;
}
string Containers::getAankomsteindtijd() const{
	return aankomsteindtijd;
}
void Containers::setAankomstvervoersmiddel(string vervoersmiddelaankomst){
	aankomstvervoersmiddel = vervoersmiddelaankomst;
}
string Containers::getAankomstvervoermiddel() const{
	return aankomstvervoersmiddel;
}
void Containers::setAankomstbedrijf(string bedrijfaankomst){
	aankomstbedrijf = bedrijfaankomst;
}
string Containers::getAankomstbedrijf() const{
	return aankomstbedrijf;
}
void Containers::setAankomstpositiex(string xpositieaankomst){
	aankomstpositiex = xpositieaankomst;
}
string Containers::getAankomstpositiex() const{
	return aankomstpositiex;
}
void Containers::setAankomstpositiey(string ypositieaankomst){
	aankomstpositiey = ypositieaankomst;
}
string Containers::getAankomstpositiey() const{
	return aankomstpositiey;
}
void Containers::setAankomstpositiez(string zpositieaankomst){
	aankomstpositiez = zpositieaankomst;
}
string Containers::getAankomstpositiez() const{
	return aankomstpositiez;
}
void Containers::setNaameigenaar(string eigenaarnaam){
	naameigenaar = eigenaarnaam;
}
string Containers::getNaameigenaar() const{
	return naameigenaar;
}
void Containers::setContainernr(string nrcontainer){
	containernr = nrcontainer;
}
string Containers::getContainernr() const{
	return containernr;
}
void Containers::setVertrekdag(string dagvertrek){
	vertrekdag = dagvertrek;
}
string Containers::getVertrekdag() const{
	return vertrekdag;
}
void Containers::setVertrekmaand(string maandvertrek){
	vertrekmaand = maandvertrek;
}
std::string Containers::getVertrekmaand() const{
	return vertrekmaand;
}
void Containers::setVertrekjaar(string jaarvertrek){
	vertrekjaar = jaarvertrek;
}
string Containers::getVertrekjaar() const{
	return vertrekjaar;
}
void Containers::setVertrekbegintijd(string begintijdvertrek){
	vertrekbegintijd = begintijdvertrek;
}
string Containers::getVertrekbegintijd() const{
	return vertrekbegintijd;
}
void Containers::setVertrekeindtijd(string eindtijdvertrek){
	vertrekeindtijd = eindtijdvertrek;
}
string Containers::getVertrekeindtijd() const{
	return vertrekeindtijd;
}
void Containers::setVertrekvervoersmiddel(string vervoervertrek){
	vertrekvervoersmiddel = vervoervertrek;
}
string Containers::getVertrekvervoersmiddel() const{
	return vertrekvervoersmiddel;
}
void Containers::setVertrekbedrijf(string bedrijfvertrek){
	vertrekbedrijf = bedrijfvertrek;
}
string Containers::getVertrekbedrijf() const{
	return vertrekbedrijf;
}
void Containers::setLengtecontainer(string containerlengte){
	lengtecontainer = containerlengte;
}
string Containers::getLengtecontainer() const{
	return lengtecontainer;
}
void Containers::setBreedtecontainer(string containerbreedte){
	breedtecontainer = containerbreedte;
}
string Containers::getBreedtecontainer() const{
	return breedtecontainer;
}
void Containers::setHoogtecontainer(string containerhoogte){
	hoogtecontainer = containerhoogte;
}
string Containers::getHoogtecontainer() const{
	return hoogtecontainer;
}
void Containers::setLeeggewicht(string gewichtleeg){
	leeggewicht = gewichtleeg;
}
string Containers::getLeeggewicht() const{
	return leeggewicht;
}
void Containers::setVolgewicht(string gewichtvol){
	volgewicht = gewichtvol;
}
string Containers::getVolgewicht() const{
	return volgewicht;
}
void Containers::setNaaminhoud(string inhoudnaam){
	naaminhoud = inhoudnaam;
}
string Containers::getNaamInhoud() const{
	return naaminhoud;
}
void Containers::setSoortinhoud(string inhoudsoort){
	soortinhoud = inhoudsoort;
}
string Containers::getSoortinhoud() const{
	return soortinhoud;
}
void Containers::setISO(string osi){
	iso = osi;
}
string Containers::getISO() const{
	return iso;
}
void Containers::setGevaarinhoud(string inhoudgevaar){
	gevaarinhoud = inhoudgevaar;
}
string Containers::getGevaarinhoud() const{
	return gevaarinhoud;
}
