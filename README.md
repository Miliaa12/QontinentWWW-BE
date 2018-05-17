Scen
POST@localhost:8080/scen/add?scenName=test1
GET@localhost:8080/scen/all

Artist
POST@localhost:8080/artist/add?name=test&time=1&scenId=1
GET@localhost:8080/artist/artistByScen/1
GET@localhost:8080/artist/all

lägg in det i typ postman, curl eller i en browser. 
Gjorde för java 1.8 och jenkins ska lira out of the box
