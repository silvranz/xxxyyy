set Tomcatpath="D:\Programming\xampp\tomcat\webapps"
cd WEB-INF/classes/com/fresearch/oversign
javac -classpath ../../../../lib/* utility/*.java
TIMEOUT /T 10
javac -classpath ../../../../lib/* data/*.java
TIMEOUT /T 10
javac -classpath ../../../../lib/* parameter/*.java
TIMEOUT /T 10
javac -classpath ../../../../lib/* model/*.java
TIMEOUT /T 10
javac -classpath ../../../../lib/* controller/*.java
TIMEOUT /T 10
javac -classpath ../../../../lib/* handler/*.java
TIMEOUT /T 10
cd /d %Tomcatpath%
jar -cvf oversign.war *