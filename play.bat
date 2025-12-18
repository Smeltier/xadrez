@echo off
echo Compilando o jogo...
if not exist "src\bin" mkdir "src\bin"
javac -d src/bin src/main/java/com/work/chess/Main.java src/main/java/com/work/chess/application/*.java src/main/java/com/work/chess/controller/*.java src/main/java/com/work/chess/enums/*.java src/main/java/com/work/chess/factories/*.java src/main/java/com/work/chess/interfaces/*.java src/main/java/com/work/chess/model/*.java src/main/java/com/work/chess/model/chess_pieces/*.java src/main/java/com/work/chess/model/factories/*.java src/main/java/com/work/chess/view/*.java

if %errorlevel% neq 0 (
    echo Erro na compilacao.
    pause
    exit /b %errorlevel%
)

echo Iniciando o Xadrez...
echo.
java -cp src/bin main.java.com.work.chess.application.Main
pause