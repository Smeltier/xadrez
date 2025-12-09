#!/bin/bash
echo "Compilando o jogo..."
mkdir -p src/bin
javac -d src/bin $(find src/main/java -name "*.java")

if [ $? -eq 0 ]; then
    echo "Iniciando o Xadrez..."
    echo ""
    java -cp src/bin main.java.com.work.chess.application.Main
else
    echo "Erro na compilação."
fi