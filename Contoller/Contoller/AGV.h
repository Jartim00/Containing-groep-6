#ifndef agv_h
#define agv_h

#include <string>
#include <vector>

using std::vector;
using std::string;


class AGV
{
private:
	double positieX;
	double positieY;
	bool beschikbaar;
	vector<AGV> agvs;
public:
	AGV();
	void voegAGVtoe();
	void zoekVrijeAGV();
	void setPositieX(double positieX);
	double getPositieX();
	void setPositieY(double positieY);
	double getPositieY();
	void setBeschikbaar(bool beschik);
	bool getBeschikbaar();
};

#endif