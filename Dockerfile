FROM openjdk:17-jdk-alpine@sha256:a996cdcc040704ec6badaf5fecf1e144c096e00231a29188596c784bcf858d05
RUN apk update && apk upgrade && apk add bash
WORKDIR /home/ERideRent_User_Management
ADD target/E-RideRent_User_Management.jar /home/ERideRent_User_Management/
CMD java -jar /home/ERideRent_User_Management/E-RideRent_User_Management.jar --spring.datasource.url=jdbc:mysql://UserManagementServiceDB:3311/user_management_service_db