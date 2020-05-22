# WFOBooker
In order to run the maven backend locally, all you need is [java development kit v1.8](https://tools.eu1.hana.ondemand.com/#cloud), [maven](https://maven.apache.org/download.cgi) and a mysql instance. Mysql can be either installed locally, or used in docker:
```
docker run --name wfob-mysql -e MYSQL_ROOT_PASSWORD=r00t -e MYSQL_DATABASE=wfob -e MYSQL_USER=username -e MYSQL_PASSWORD=password -p 3306:3306 -d mysql
```

To startup the backend, you need to run the command below in the root of the project:
```
mvn clean package azure-functions:run
```
