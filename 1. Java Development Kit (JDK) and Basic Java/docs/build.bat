Rem Turns off the output of the commands
@ECHO OFF

Rem Set path to the Java environment
set JAVA_HOME=C:jdk-21
set PATH=%JAVA_HOME%\bin;%PATH%

REM Check jdk version
javac -version

REM Navigate to the current folder
cd ..

REM Setting folder variables to for project directories
echo Setting folder variables
set PRAC_BIN=.\bin
set PRAC_DOCS=.\docs
set PRAC_SRC=.\src\acsse\csc2a

REM Compile code
echo Compiling code...
javac -d %PRAC_BIN% %PRAC_SRC%\Twang.java
REM -d option specifies the destination directory for compiled class files

REM Run the code
echo Running code
java -cp %PRAC_BIN% acsse.csc2a.Twang 50

REM Decompile the class file in the bin folder
REM Save the output to a file called ByteCode.txt
REM The ByteCode.txt file should be placed in the docs folder
echo Decompiling class file
echo Saving the output to a file called ByteCode.txt
javap -c %PRAC_BIN%\acsse\csc2a\Twang.class > %PRAC_DOCS%\ByteCode.txt

PAUSE

