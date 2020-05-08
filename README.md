## Assigment

Assignment project is a small project, which basically built using spring Boot, Spring Tool Suite 4, MySql and Java 11.

Installation
Use the git clone to clone this project and download the Spring Tool Suite from https://spring.io/tools site. Make sure you have JDK 11 installed on your system before importing into this project into STS(Spring Tool Suite). You can download campatible JDK from https://www.oracle.com/java/technologies/javase-jdk11-downloads.html.

More over that to check the function you also required postman tool(Rest API testing tool), You can download https://www.postman.com/downloads/ and install on your local machine.

This assignment project is tested on Windows environment using postman.

#Note: assigment database need to be created in mysql and username must be root and password must be root, otherwise database connection will not established. hence project will not run.

Once you have imported the project and start project from spring boot dashboard tables and demo data will be created automatically. with the specified username and password.

## Usage

This small assignment is the part of test before selection. This is a stateless basic authectication based project, where user has to be authenticated on every request using basic authentication.

Spring Boot (Assigment)

To fetch datasource used in this assignment and their config, you can hit below Get request and provide authentication as basic Auth in "Authorization Tab" on postman. You also need to provide admin@gmail.com as username and password as password, otherwise you may get 403/401 error depending upon missing authentication information.

http://localhost:8080/api/getconfigdetails

To fetch product details, you can hit below Get request and provide authentication as basic Auth in "Authorization Tab" on postman. You also need to provide manoj@gmail.com as username and 123456 as password, otherwise you may get 403/401 error depending upon missing authentication information.
http://localhost:8080/api/getconfigdetails

both apis will return config related to datasource only in json format.

Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

License
M
