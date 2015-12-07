#ifndef agv_h
#define agv_h

#include <string>

using std::string;

class AGV
{
private:
	string positie;
	bool beschikbaar;
public:
	AGV();
	void setPositie(string pos){
		positie = pos;
	}
	string getPositie(){
		return positie;
	}
	void setBeschikbaar(bool beschik){
		beschikbaar = beschik;
	}
	bool getBeschikbaar(){
		return beschikbaar;
	}
};

#endif