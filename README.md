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
