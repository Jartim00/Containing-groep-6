#include <mysql.h>
#include <iostream>
int main(int argc, char **argv)
{
	//std::cout << " mysql : " << mysql_get_client_info();

	MYSQL *con = mysql_init(NULL);


	if (con == NULL) {
	    return -1;
	}

	if (mysql_real_connect(con, "217.120.103.158", "admin", "admin", 
          "containing", 0, NULL, 0) == NULL) 
  	{
	
	std::cout << mysql_error(con) << "\n";
      	mysql_close(con);
	return -1;
  	}  

        if (mysql_query(con, "INSERT INTO grafiek(agv,binnenschip,vrachtwagen,zeeschip,opslag,trein,diversen) VALUES(24,120,23,14000,9000,40,23)"))
        {
	std::cout << "connection established\n"<< con;
        std::cout << mysql_error(con) << "\n";
        mysql_close(con);
	std::cout << "hello world";
        return -1;
        }
        std::cout << "SQL injectie succesvol\n";
        mysql_close(con);

}
