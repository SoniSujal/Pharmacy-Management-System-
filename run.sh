#!/bin/bash

echo "Compiling Pharmacy Management System..."
javac -cp "src/main/java" src/main/java/com/pharmacy/Main.java src/main/java/com/pharmacy/model/*.java src/main/java/com/pharmacy/service/*.java src/main/java/com/pharmacy/util/*.java

if [ $? -ne 0 ]; then
    echo "Compilation failed!"
    exit 1
fi

echo "Compilation successful!"
echo "Starting Pharmacy Management System..."
echo

java -cp "src/main/java" com.pharmacy.Main 