#include "stdafx.h"
#include "Containers.h"

using namespace std;

Container::Container(){

}
void Container::setAankomstdag(string dagaankomst){
	aankomstdag = dagaankomst;
}
string Container::getAankomstdag(){
	return aankomstdag;
}
void Container::setAankomstmaand(string maandaankomst){
	aankomstmaand = maandaankomst;
}
string Container::getAaankomstmaand(){
	return aankomstmaand;
}
void Container::setAankomstjaar(string jaaraankomst){
	aankomstjaar = jaaraankomst;
}
string Container::getAankomstjaar(){
	return aankomstjaar;
}
void Container::setAankomstbegintijd(string begintijdaankomst){
	aankomstbegintijd = begintijdaankomst;
}
string Container::getAankomstbegintijd(){
	return aankomstbegintijd;
}
void Container::setAankomsteindtijd(string eindtijdaankomst){
	aankomsteindtijd = eindtijdaankomst;
}
string Container::getAankomsteindtijd(){
	return aankomsteindtijd;
}
void Container::setAankomstvervoersmiddel(string vervoersmiddelaankomst){
	aankomstvervoersmiddel = vervoersmiddelaankomst;
}
string Container::getAankomstvervoermiddel(){
	return aankomstvervoersmiddel;
}
void Container::setAankomstbedrijf(string bedrijfaankomst){
	aankomstbedrijf = bedrijfaankomst;
}
string Container::getAankomstbedrijf(){
	return aankomstbedrijf;
}
void Container::setAankomstpositiex(string xpositieaankomst){
	aankomstpositiex = xpositieaankomst;
}
string Container::getAankomstpositiex(){
	return aankomstpositiex;
}
void Container::setAankomstpositiey(string ypositieaankomst){
	aankomstpositiey = ypositieaankomst;
}
string Container::getAankomstpositiey(){
	return aankomstpositiey;
}
void Container::setAankomstpositiez(string zpositieaankomst){
	aankomstpositiez = zpositieaankomst;
}
string Container::getAankomstpositiez(){
	return aankomstpositiez;
}
void Container::setNaameigenaar(string eigenaarnaam){
	naameigenaar = eigenaarnaam;
}
string Container::getNaameigenaar(){
	return naameigenaar;
}
void Container::setContainernr(string nrcontainer){
	containernr = nrcontainer;
}
string Container::getContainernr(){
	return containernr;
}
void Container::setVertrekdag(string dagvertrek){
	vertrekdag = dagvertrek;
}
string Container::getVertrekdag(){
	return vertrekdag;
}
void Container::setVertrekmaand(string maandvertrek){
	vertrekmaand = maandvertrek;
}
std::string Container::getVertrekmaand(){
	return vertrekmaand;
}
void Container::setVertrekjaar(string jaarvertrek){
	vertrekjaar = jaarvertrek;
}
string Container::getVertrekjaar(){
	return vertrekjaar;
}
void Container::setVertrekbegintijd(string begintijdvertrek){
	vertrekbegintijd = begintijdvertrek;
}
string Container::getVertrekbegintijd(){
	return vertrekbegintijd;
}
void Container::setVertrekeindtijd(string eindtijdvertrek){
	vertrekeindtijd = eindtijdvertrek;
}
string Container::getVertrekeindtijd(){
	return vertrekeindtijd;
}
void Container::setVertrekvervoersmiddel(string vervoervertrek){
	vertrekvervoersmiddel = vervoervertrek;
}
string Container::getVertrekvervoersmiddel(){
	return vertrekvervoersmiddel;
}
void Container::setVertrekbedrijf(string bedrijfvertrek){
	vertrekbedrijf = bedrijfvertrek;
}
string Container::getVertrekbedrijf(){
	return vertrekbedrijf;
}
void Container::setLengtecontainer(string containerlengte){
	lengtecontainer = containerlengte;
}
string Container::getLengtecontainer(){
	return lengtecontainer;
}
void Container::setBreedtecontainer(string containerbreedte){
	breedtecontainer = containerbreedte;
}
string Container::getBreedtecontainer(){
	return breedtecontainer;
}
void Container::setHoogtecontainer(string containerhoogte){
	hoogtecontainer = containerhoogte;
}
string Container::getHoogtecontainer(){
	return hoogtecontainer;
}
void Container::setLeeggewicht(string gewichtleeg){
	leeggewicht = gewichtleeg;
}
string Container::getLeeggewicht(){
	return leeggewicht;
}
void Container::setVolgewicht(string gewichtvol){
	volgewicht = gewichtvol;
}
string Container::getVolgewicht(){
	return volgewicht;
}
void Container::setNaaminhoud(string inhoudnaam){
	naaminhoud = inhoudnaam;
}
string Container::getNaamInhoud(){
	return naaminhoud;
}
void Container::setSoortinhoud(string inhoudsoort){
	soortinhoud = inhoudsoort;
}
string Container::getSoortinhoud(){
	return soortinhoud;
}
void Container::setISO(string osi){
	iso = osi;
}
string Container::getISO(){
	return iso;
}
void Container::setGevaarinhoud(string inhoudgevaar){
	gevaarinhoud = inhoudgevaar;
}
string Container::getGevaarinhoud(){
	return gevaarinhoud;
}
