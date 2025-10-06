# MC322

Esse será o repositorio para o projeto que faremos na disciplina MC 322 na Unicamp.


### Instruções para executar o código

**Todos os comandos devem ser executados a partir do diretório raiz do projeto (`tarefa5`).**

**1. Gerar as Listas de Arquivos:**
Este passo cria/atualiza os arquivos que listam todo o código-fonte para o compilador.

* **Para Linux / macOS:**
    ```sh
    find src/com/rpg/game -name "*.java" > src/sources_game.txt
    find src/com/rpg/test -name "*.java" > src/sources_test.txt
    ```
* **Para Windows (Prompt de Comando):**
    ```cmd
    dir /s /b src\com\rpg\game\*.java > src\sources_game.txt
    dir /s /b src\com\rpg\test\*.java > src\sources_test.txt
    ```

**2. Compilar o Código do Jogo:**
```sh
javac -d out -encoding UTF-8 -sourcepath src @src/sources_game.txt 
```
**3. Compilar o Código de Teste:**
```sh
javac -d out -encoding UTF-8 -sourcepath src -cp out @src/sources_test.txt
```
**4. Executar o Jogo Principal:**
```sh
java -cp out com.rpg.game.Main
```
**5. Executar os Testes:**
```sh
java -cp out com.rpg.test.GeradorFixoTest
```
**6. Gerar o Javadoc**
```sh
javadoc -d docs -encoding UTF-8 -sourcepath src -subpackages com.rpg.game -author -version
```

