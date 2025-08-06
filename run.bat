@echo off
echo Compiling Pharmacy Management System...
javac -cp "src/main/java" src/main/java/com/pharmacy/Main.java src/main/java/com/pharmacy/model/*.java src/main/java/com/pharmacy/service/*.java src/main/java/com/pharmacy/util/*.java

if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful!
echo Starting Pharmacy Management System...
echo.

java -cp "src/main/java" com.pharmacy.Main

pause 