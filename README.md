# Aws_Ec2_Demo
Aws_Ec2_Deployment demo

* This project is Normal Java Springboot based Project.In here we are gonna deploye our project on aws 

#  Project summary
* In this project We design simple one class post.
* here we performe Two Operations 1. Creating post 
                                  2. Getposts
# Flow
* Cotroller
flow Is Simple Here we are Gonna use Swagger instead of postman. So request  make from swagger and based on request and end points the method in cotroller is called.


* Service 
Form contoller serviice class methods are called. service class is class where we write our buisness logic. 

* Repository/dao

From service class repository interface has benn clled which exctend jpa repository and we are use jpa repository inbuild methods form grt post and create post. And with hte help of JPA We are connect our application with database.

#  Deployment Process

* Today In this Project we are gonna deploye the project on Aws.

Step : 1 We have to create instance in Aws Ec2(we have ti create machine).

Step 2: After creating instance we have to give permission to all. U can do this by going in security.

step 3: Now Start connect our instance

step 4:  We have to create user in our local machine for that u have to use this queries

CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON *.* TO 'username'@'localhost' WITH GRANT OPTION;

CREATE USER 'username'@'%' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON *.* TO 'username'@'%' WITH GRANT OPTION;

FLUSH PRIVILEGES;

Here we create user in our local database with name of username

step 5:  after creating database in local machine now go on terminus/ or u can directly connect through ec2.And make host in terminus using our your ec2 instance ip adress and keypair(which is download during making instance in you local).and now make connection

step 6: Now you are in the machine which u make in ec2. Here u have to install mysql and java for run your application. for installing mysql and java follow this commands
  1 sudo apt install mysql-server
  2 for java based on your version u havce to performe a command
    sudo apt install openjdk-11-jre-headless  
    sudo apt install default-jre              
    sudo apt install openjdk-13-jre-headless  
    sudo apt install openjdk-16-jre-headless  
    sudo apt install openjdk-8-jre-headless 
    
step 7:  after installing mysql u have to do some changes so go to this files etc/mysql/mysql.conf.d/mysqld.cnf
go in last file using command sudo nano filename(mysqld.cnf)
and change binding to 0.0.0.0
     
step 8 :  now login in mysql root user and creat user using same lines which we use in out lacl database to create user
     
after that try to ligi  with username user
and then create database with the name which u give in application properties in  application
     
step 9 now create jar after wriet currect info in application .properties and then go to the ec2
in terminus)
     
step 10 : now go to the sftp option in terminus and paste that jar from your local to ec2 machin
     
step 11: after pasting we have to give permission to  jar so go on location of jar and write this command sudo chmod 777 jarname
     
     
step 12 : now we have to create a service so got  into etc/systemd/system
and now create new service useing key sudo nano servicename 
ans write this
     
[Unit]
Description=Spring boot deployment
After=syslog.target

[Service]
User=ubuntu
ExecStart=give a path of jar file which u paste in new machine 
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target


a
Step 13  after creating service give permission to service and reload the system  By using this two commands(sudo chmod 777 service name , sudo systemctl daemon_reload)

step 14 and now  start your service sudo service name start and 
after that chech status by using commnd : sudo service name status 
if all is fine so you can se you servu=ice is running 

and u can use you swagger url or any request from other device

MyProject swagger url :  http://16.170.246.164:8080/swagger-ui/index.html







