/*---------------------------------*/
/* GML */
/*---------------------------------*/
CREATE TABLE Envelope (
	key INTEGER NOT NULL AUTO_INCREMENT,
	lowerCorner ST_POINTZ,
	upperCorner ST_POINTZ,
	srsDimension INTEGER,
	srsName VARCHAR(100),
	PRIMARY KEY (key) 
);

/*---------------------------------*/
/* CityGML Core Module */
/*---------------------------------*/
CREATE TABLE CityModel (
	key INTEGER NOT NULL AUTO_INCREMENT, 
	id VARCHAR(50), 
	name VARCHAR(100), 
	description VARCHAR(500), 
	envelopKey INTEGER,
	PRIMARY KEY (key)
);
