# MANUAL DO USUÁRIO - SISTEMA DE XADREZ (CLI)

## 1. Visão Geral
Este documento fornece as diretrizes para a execução e operação do sistema de Xadrez baseado em linha de comando (CLI), desenvolvido em linguagem Java. O sistema implementa as regras oficiais da FIDE (Federação Internacional de Xadrez), incluindo validação rigorosa de movimentos, detecção de estados de jogo (xeque/xeque-mate) e movimentos especiais, utilizando uma arquitetura orientada a objetos (MVC).

## 2. Requisitos do Sistema
Para a execução adequada do software, o ambiente deve possuir:
* **Java Development Kit (JDK):** Versão 8 ou superior instalada e configurada nas variáveis de ambiente.
* **Terminal de Comando:** Bash (Linux/macOS), PowerShell ou CMD (Windows).

## 3. Instalação e Execução

O projeto inclui scripts de automação na raiz do diretório para facilitar a compilação e execução do código fonte.

### 3.1. Execução no Windows
1.  Navegue até o diretório raiz do projeto via Explorador de Arquivos ou Terminal.
2.  Execute o arquivo de lote `play.bat`.
3.  O script criará automaticamente o diretório de binários, compilará o código fonte e iniciará a aplicação.

### 3.2. Execução no Linux / macOS
1.  Abra o terminal no diretório raiz do projeto.
2.  Conceda permissão de execução ao script (necessário apenas na primeira execução):
    ```bash
    chmod +x play.sh
    ```
3.  Execute o script:
    ```bash
    ./play.sh
    ```

### 3.3. Compilação Manual (Método Alternativo)
Caso opte por não utilizar os scripts de automação, utilize os comandos abaixo na raiz do projeto:

```bash
mkdir -p src/bin
javac -d src/bin $(find src/main/java -name "*.java")
java -cp src/bin main.java.com.work.chess.application.Main
````

## 4\. Configuração da Partida

Ao inicializar o sistema, será necessário configurar os parâmetros da partida:

1.  **Definição dos Jogadores:** Insira os nomes para o Jogador 1 e Jogador 2 conforme solicitado.
2.  **Sorteio de Cores:** O sistema solicitará a definição do condutor das peças BRANCAS.
      * Digite `1` para selecionar o Jogador 1.
      * Digite `2` para selecionar o Jogador 2.

## 5\. Interface e Comandos de Jogo

O tabuleiro é renderizado via console utilizando caracteres ASCII. O sistema de coordenadas segue o padrão internacional:

  * **Colunas:** Letras de **a** a **h**.
  * **Linhas:** Números de **1** a **8**.

### 5.1. Realizando Movimentos

A entrada de dados deve seguir a **Notação Algébrica Completa**, especificando a coordenada de origem e a coordenada de destino separadas por um espaço.

  * **Sintaxe:** `[origem] [destino]`
  * **Exemplo:** `e2 e4` (Move a peça da casa e2 para a casa e4).

### 5.2. Validação de Regras

O motor do jogo processa cada entrada verificando:

  * A existência de peça na origem e a correspondência de cor com o turno atual.
  * A geometria válida de movimento da peça específica.
  * A inexistência de obstruções no trajeto (exceto para o Cavalo).
  * A legalidade do movimento em relação à segurança do Rei (impossibilidade de auto-xeque).

## 6\. Movimentos Especiais

O sistema suporta manobras avançadas que requerem entradas específicas ou condições de contexto.

### 6.1. Roque (Castling)

Permite o movimento simultâneo do Rei e da Torre.

  * **Execução:** O jogador deve comandar o movimento do **Rei** por duas casas em direção à Torre escolhida.
  * **Comando (Brancas):** `e1 g1` (Roque Menor) ou `e1 c1` (Roque Maior).
  * **Comando (Pretas):** `e8 g8` (Roque Menor) ou `e8 c8` (Roque Maior).
  * *Nota: A Torre será movida automaticamente pelo sistema se a manobra for válida.*

### 6.2. En Passant

Captura especial de peões.

  * **Condição:** Ocorre quando um peão adversário avança duas casas a partir da posição inicial, parando ao lado do seu peão.
  * **Execução:** O jogador deve mover seu peão para a casa diagonal vazia imediatamente atrás do peão adversário.
  * **Comando:** Inserir as coordenadas de origem e da casa de destino (vazia).

### 6.3. Promoção (Promotion)
Transformação obrigatória de um peão que atinge a última fileira do tabuleiro.
* **Condição:** Um peão (Branco na linha 8 ou Preto na linha 1) conclui seu movimento.
* **Execução:** O sistema interromperá o fluxo automaticamente e apresentará um menu de seleção.
* **Opções:** O jogador deve digitar o número correspondente à peça desejada:
    * `1` - Rainha (Queen)
    * `2` - Torre (Rook)
    * `3` - Bispo (Bishop)
    * `4` - Cavalo (Knight)
* **Resultado:** O peão é imediatamente substituído pela peça escolhida na mesma casa.

## 7\. Estados do Jogo

O sistema fornece feedback em tempo real sobre o estado da partida:

  * **ALERTA DE XEQUE:** Indica que o Rei está sob ataque imediato. O jogador é obrigado a realizar um movimento defensivo.
  * **ERRO DE MOVIMENTO:** Informa tentativas de jogadas ilegais (geometria incorreta, obstrução ou exposição do Rei ao perigo).
  * **XEQUE-MATE:** Ocorre quando o Rei está em xeque e não existem movimentos legais disponíveis. O sistema encerra a execução e declara o vencedor.