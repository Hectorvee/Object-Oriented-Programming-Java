@ECHO OFF
REM CLear the screen to show only the output
cls

REM Display details
ECHO ~~ Details ~~
ECHO Author: Ma******* VH 22******
ECHO Practical: 02 CSC02A2
ECHO CSC02A2

REM set path for JDK
SET JAVA_HOME=C:\jdk-21
SET PATH=%JAVA_HOME%\bin;%PATH%

REM Display Java version
ECHO ~~ Checking Java Version ~~
javac -version

REM Set practical directory variables
ECHO ~~ Setting practical directory variables ~~
cd ..
SET PRAC_BIN=.\bin
SET PRAC_DOCS=.\docs
SET PRAC_JDC=.\docs\JavaDoc
SET PRAC_SRC=.\src

REM Deleting old class files
ECHO ~~ Deleting old class files ~~
DEL /S /Q %PRAC_BIN%\*.class
DEL /S /Q %PRAC_BIN%\acsse\csc2a\*.class

PAUSE

REM Compile source files
ECHO ~~ Trying to Compile ~~
javac -sourcepath %PRAC_SRC% -classpath %PRAC_BIN% -d %PRAC_BIN% %PRAC_SRC%\*.java

REM Generate JavaDoc
ECHO ~~ Generating JavaDoc ~~
REM javadoc -sourcepath %PRAC_SRC% -classpath %PRAC_BIN%\acsse\csc2a -d %PRAC_JDC% %PRAC_SRC%\*.java
javadoc -sourcepath %PRAC_SRC% -classpath %PRAC_BIN% -d %PRAC_JDC% -subpackages acsse

REM Pause to view any error messages
PAUSE

REM Run code
cls
ECHO ~~ Running code
java -classpath %PRAC_BIN% Main

REM Disassembling class
ECHO ~~ Trying to disassemble ~~
java -classpath %PRAC_BIN% Main > %PRAC_DOCS%\ByteCode.txt

REM Go back to docs folder
cd %PRAC_DOC%

PAUSE











