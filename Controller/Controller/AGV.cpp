#include "stdafx.h"
#include "AGV.h"


AGV::AGV(){

}
void AGV::voegAGVtoe(){
	AGV temp;
	double posY = 154.25;
	double posX = -60.25; 
	int countBeschikbarePlekken = 0;
	//voeg 100 AGV's toe op waypoints voor de parkeerplekken. Steeds 6 AGV's per opslaglaan, 50 per zijde.
	for (int i = 0; i < 100; i++){
		agvs.push_back(temp);
		agvs[i].setBeschikbaar(true);
		if (i < 50){
			if (countBeschikbarePlekken == 6){
				posY -= 4;
				countBeschikbarePlekken = 0;
			}
		}
		else{
			if (i == 50){
				posX = 60.25;
				countBeschikbarePlekken = 0;
			}
			if (countBeschikbarePlekken == 6){
				posX -= 4;
				countBeschikbarePlekken = 0;
			}
		}
		agvs[i].setPositieX(posX);
		agvs[i].setPositieY(posY);
		
		countBeschikbarePlekken++;
	}
}

void AGV::zoekVrijeAGV(){
	vector<AGV> beschikbareAGVs;
	for (auto x : agvs){
		if (x.getBeschikbaar() == true)
			beschikbareAGVs.push_back(x);
	}
	for (auto x : beschikbareAGVs){
		//iets met korste route?
	}

}
void AGV::setPositieX(double posX){
	positieX = posX;
}
double AGV::getPositieX(){
	return positieX;
}
void AGV::setPositieY(double posY){
	positieY = posY;
}
double AGV::getPositieY(){
	return positieY;
}
void AGV::setBeschikbaar(bool beschik){
	beschikbaar = beschik;
}
bool AGV::getBeschikbaar(){
	return beschikbaar;
}