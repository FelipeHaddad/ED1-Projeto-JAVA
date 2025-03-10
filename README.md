# ED1-Projeto-JAVA
## Funcionamento do Programa
Desenvolver um programa em Java que implementa um REPL (Read-Evaluate-Print-Loop) que aceita entradas via teclado e que avalia e valida as entradas de acordo com os requisitos descritos a seguir.
### Expressões matemáticas
• Devem conter somente variáveis e operadores (ver abaixo).
• Podem conter espaços em branco, assim como não ter espaços em branco entre variáveis e operadores.
• Devem estar em notação infixa.
• Devem ser convertidas para a notação posfixa.
• O cálculo da expressão deve ser realizado usando a expressão posfixa, somente se todas as variáveis presentes na expressão possuem valores definidos.
• O programa deve validar as expressões matemáticas, isto é:
  - Aceitar somente as operações indicadas abaixo.
  - Aceitar somente variáveis como operandos, sendo que as variáveis possuem uma única letra, conforme indicado abaixo.
  - Considerar que uma expressão matemática na notação infixa pode conter parênteses que definem a prioridade das operações.
• Caso a expressão inserida seja inválida (por exemplo, a expressão contém algum operador que não seja um dos cinco indicados ou possui uma quantidade incorreta de parênteses, como ((((A * (B – C)), o programa deve exibir uma mensagem informando o erro.
### Operações suportadas
- Binárias: + - * / ^ (adição, subtração, multiplicação, divisão e exponenciação, respectivamente).
- Unária de negação (desafio opcional): -
- Parênteses: ( )
### Variáveis
- A-Z, case insensitive
### REPL: Comandos válidos (case insensitive)
![image](https://github.com/user-attachments/assets/594098df-5497-4414-a46a-c621021d8982)
![image](https://github.com/user-attachments/assets/17d461af-274d-49e9-b549-8700328943ae)
Quando estiver em modo REC (gravação), somente os quatro primeiros comandos da tabela acima são válidos. Ou seja, comandos relacionados à fila (REC, STOP, PLAY, ERASE) e encerramento do programa não são aceitos para gravação (não podem ser inseridos na fila de comandos).

## Algoritmo para conversão de expressão infixa para posfixa
Um algoritmo para conversão de uma expressão infixa qualquer para posfixa seria:
- Inicie com uma pilha vazia;
- Realize uma varredura na expressão infixa, copiando todos os identificadores encontrados diretamente para a expressão de saída.
a) Ao encontrar um operador:
1. Enquanto a pilha não estiver vazia e houver no seu topo um operador com prioridade maior ou igual ao encontrado, desempilhe o operador e copie-o na saída;
2. Empilhe o operador encontrado;
b) Ao encontrar um parêntese de abertura, empilhe-o;
c) Ao encontrar um parêntese de fechamento, remova um símbolo da pilha e copie-o na saída, até que seja desempilhado o parêntese de abertura correspondente.
- Ao final da varredura, esvazie a pilha, movendo os símbolos desempilhados para a saída.

Um exemplo de execução do algoritmo de conversão de infixa para posfixa, supondo a expressão A*(B+C)/D, é apresentado abaixo:
![image](https://github.com/user-attachments/assets/2fdfeaef-dc3a-4313-bb00-25bdcc5eb5b3)

## Algoritmo de avaliação de uma expressão na forma posfixa
Primeiramente, atribui-se valores numéricos às variáveis da expressão a ser avaliada;
- Inicia-se com uma pilha vazia;
- Varre-se a expressão e, para cada elemento encontrado:
a) Se for operando, então empilhar seu valor;
b) Se for operador, então desempilhar os dois últimos valores, efetuar a operação com eles e empilhar de volta o resultado obtido;
- No final do processo, o resultado da avaliação estará no topo da pilha.

Um exemplo de execução do algoritmo de avaliação de uma expressão na forma posfixa é apresentado abaixo, assumindo a expressão infixa (A+B)/(C-D)*E que foi convertida para a expressão posfixa AB+CD-/E* e que A=7, B=3, C=6, D=4 e E=9.
![image](https://github.com/user-attachments/assets/b530dcf1-c26f-4e4b-9fff-3f58e82eb174)


## Desenvolvimento 
A atividade deve ser realizada em grupo de, no máximo, 3 pessoas
- A solução deve ser implementada em linguagem Java e deve usar uma versão adaptada da implementação do TAD Pilha estática/sequencial realizada durante as aulas.
- Fica proibido o uso de estruturas de dados fornecidas pela linguagem Java (restrição inclui uso de Stack, Map, Hashtable, Vector, etc). Projetos que usarem tais estruturas serão desconsiderados – zero.
- Inclua a identificação do grupo (nome completo e RA de cada integrante) no início de cada arquivo de código, como comentário.
- Inclua todas as referências (livros, artigos, sites, vídeos, entre outros) consultadas para solucionar a atividade como comentário no arquivo .java que contém a main().

## Entrega
Compacte o código-fonte (somente projeto com arquivos *.java) no formato zip.
Entregar também repositório Git com os commits realizados pelo grupo (enviar em arquivo txt junto com o código .java)
Atenção: O arquivo zip não deve conter arquivos intermediários e/ou pastas geradas pelo compilador/IDE (ex. arquivos *.class, etc.).
