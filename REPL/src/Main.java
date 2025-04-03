/* 1° Felipe Bertacco Haddad - 10437372
 * 2° Ana Julia Yaguti - 10436655
 * 3° Beatriz Nobrega - 10435789

 Referencias Utilizadas:
Como ver se o caractere se trata de uma letra
    https://how.dev/answers/what-is-characterisletter-in-java
Como remover os espaços em branco em uma String
    https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
Como ver se um caractere é um numero
    https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a-character-is-a-letter-or-number-in-java-withou
Como transformar caractere em inteiro, mostrando o valor numerico e não em ASCII
https://www.scaler.com/topics/char-to-int-in-java/
Como criar a prioridade de operação - CHAT GPT
Pergunta: Estou tentando fazer um avaliador de expressão infixa. No momento preciso transformar uma expressão infixa
para posfixa, mas não consigo pensar em uma forma de comparar as prioridades de operadores
Resposta:
precedencia = {
    '+': 1,
    '-': 1,
    '*': 2,
    '/': 2,
    '^': 3
}

 */

import java.util.Scanner;

import commands.vars.*;


public class Main {
    public static void main(String[] args) {
        // Listas que vão armazenar as variáveis declaradas e seus valores
        Array<Character> vars = new Array<>();
        Array<Integer> valores = new Array<>();

        // Fila que vai armazenar o REC
        Fila<String> rec = new Fila<>();

        // Pilha para as expressões matemática infixas
        Pilha<Character> pilha = new Pilha<>();

        // Pilha para cálculo das expressões posfixas
        Pilha<Integer> pilhaPosfixa = new Pilha<>();

        // String saida que vai armazenar a expressão posfixa
        String saida = "";


        Scanner scanner = new Scanner(System.in);
        // Valor que será utilizado para manter o loop ativo
        boolean valor = true;
        // Valor que será utilizado para verificar se deve roda a opção PLAY
        boolean play = false;
        // Inicializa a opcao
        String opcao = "";
        // Valor que será utilizado para dizer que a expressão infixa está invalida
        boolean infixaErro = false;
        // Valor que será utilizado para calcular a expressão posfixa
        boolean posFixa = false;

        while (valor) {

            pilha.seeElements();
            System.out.println("Saida: " + saida);

            /* Condicional para caso o play seja ativado */
            if (play) {
                if (!rec.qIsEmpty()) {
                    opcao = rec.dequeue();
                } else {
                    System.out.println("Reprodução finalizada...");
                    play = false;
                    continue;
                }
            }
            // Após o play finalizar, o programa espera para o usuário digitar novamente
            else {
                String user = scanner.nextLine();
                // Deixa tudo em letra Maiúscula
                user = user.toUpperCase();
                opcao = user;
                // Remove todos os espaços
                opcao = opcao.replaceAll("\\s", "");
            }

            //Opcao VAR = VALUE
            if (opcao.charAt(0) >= 'A' && opcao.charAt(0) <= 'Z') {

                // Caso o segundo caractere seja =
                if (opcao.charAt(1) == '=') {
                    if (Character.isDigit(opcao.charAt(2))) {
                        String numero = "";
                        numero += opcao.charAt(2);
                        for (int j = 3; j < opcao.length(); j++) {
                            numero += opcao.charAt(j);
                        }

                        // Percorre a lista vars para ver se o caractere já existe
                        if (vars.searchElement(opcao.charAt(0))) {
                            // Caso encontre a variável, guarda sua posição
                            int pos = vars.elementPosition(opcao.charAt(0));
                            // Pega o valor numérico da string
                            valores.changeElement(pos, Integer.parseInt(numero));
                            // Imprime o que o usuário digitou
                            System.out.println(opcao);
                            continue;

                        } else { // Caso não encontre a variável já definida na lista
                            // Adiciona a variável na lista
                            vars.addElement(opcao.charAt(0));
                            // Adiciona o valor numérico na lista dos números
                            valores.addElement(Integer.parseInt(numero));
                            // Imprime o que o usuário digitou
                            System.out.println(opcao);
                            continue;
                        }
                    } else { System.out.print("Erro comando inválido"); }
                } else {continue;}
            } else {continue;}

            //Opcao expressao matematica infixa transformando para posfixa
            // A*(B+C)/D -> ABC+*D/

            for (int i = 0; i <= opcao.length(); i++) {
                char simbolo = opcao.charAt(i);

                pilha.seeElements();
                System.out.println("Saida: " + saida);

                // Verifica se já está no final da opcao
                if (i == (opcao.length() - 1) ) {
                    // Se tiver verifica se o caractere atual é um dígito e adiciona ele
                    if (Character.isLetterOrDigit(simbolo)) {
                        saida += simbolo;
                    }
                    // Esvazia toda a pilha
                    while(!pilha.isEmpty()) {
                        try {
                            saida += pilha.pop();
                        } catch (Exception ignored) { }
                    }
                    // Verifica se tem algum ( sem fechamento e caso tenha invalida a expressão
                    for (int j = 0; j < opcao.length(); j++ ) {
                        if (opcao.charAt(j) == '(' || opcao.charAt(j) == ')') {
                            System.out.println("Erro: expressão inválida.");
                            infixaErro = true;
                            break;
                        }
                    }
                    if (infixaErro) {
                        posFixa = false;
                        break;
                    } else {
                        posFixa = true;
                        break;
                    }
                }

                else if (Character.isLetter(simbolo)) {
                    saida += simbolo;
                }

                else if (Character.isDigit(simbolo)) {
                    System.out.println("Erro: não deve ter números na expressão infixa");
                    infixaErro = true;
                    break;
                }

                else if (simbolo == '(') {
                    try {
                        pilha.push(simbolo);
                    } catch (Exception ignored) { }
                }

                else if (simbolo == ')') {
                    try {
                        while (!pilha.isEmpty() && pilha.topo() != '(') {
                                saida += pilha.pop();
                        }
                        pilha.pop();


                    } catch (Exception ignored) { }
                }

                else if (pilha.isEmpty()) {
                    try {
                        pilha.push(simbolo);
                    } catch (Exception ignored) { }
                }

                else if (simbolo == '+' || simbolo == '-') {
                        try {
                            if (pilha.topo() == '(' || pilha.topo() == ')') {
                                pilha.push(simbolo);
                                continue;
                            } else {
                                saida += pilha.pop();
                                pilha.push(simbolo);
                                continue;
                            }
                        } catch (Exception ignored) { }
                    }

                else if (simbolo == '*' || simbolo == '/') {
                        try {
                            if (pilha.topo() != '*' || pilha.topo() != '/' || pilha.topo() != '^') {
                                saida += pilha.pop();
                                pilha.push(simbolo);
                                continue;
                            } else {
                                pilha.push(simbolo);
                                continue;
                            }
                        } catch (Exception ignored) { }
                    }
                else if (simbolo == '^') {
                        try {
                            if (pilha.topo() != '^') {
                                pilha.push(simbolo);
                                continue;
                            } else {
                                saida += pilha.pop();
                                pilha.push(simbolo);
                                continue;
                            }
                        } catch (Exception ignored) { }
                    }
            }

            if (infixaErro) {
                System.out.println("Erro na expressão infixa!");
                infixaErro = false;
                break;
            }

            // Cálculo das expressões Posfixas
            if (posFixa) {

                // Resultado vai armazenar a operação entre o valor 1 e o valor 2
                int resultado = 0, valor1, valor2;

                // Vai percorrer cada caractere da saida adquirida na expressão posfixa
                for (int i = 0; i < saida.length(); i++){

                    if (i == saida.length() - 1) {
                        System.out.println(resultado);
                    }
                    // Armazena o caractere atual na variável caractere
                    char caractere = saida.charAt(i);

                    // Verifica se o caractere da saida é uma letra
                    if (Character.isLetter(caractere)) {

                        // Verifica se o caractere existe
                        if (vars.searchElement(caractere)) {
                            int pos = vars.elementPosition(caractere);
                            pilhaPosfixa.push(valores.seeElement(pos));
                        } else {
                            System.out.print("Variável " + caractere + " não definida");
                        }

                    }
                    else if (caractere == '+') {
                        try {
                            valor1 = pilhaPosfixa.pop();
                            valor2 = pilhaPosfixa.pop();
                            resultado = valor1 + valor2;
                            pilhaPosfixa.push(resultado);
                        } catch (Exception ignored) {}
                    }
                    else if (caractere == '-') {
                        try {
                            valor1 = pilhaPosfixa.pop();
                            valor2 = pilhaPosfixa.pop();
                            resultado = valor1 - valor2;
                            pilhaPosfixa.push(resultado);
                        } catch (Exception ignored) {}
                    }
                    else if (caractere == '*') {
                        try {
                            valor1 = pilhaPosfixa.pop();
                            valor2 = pilhaPosfixa.pop();
                            resultado = valor1 * valor2;
                            pilhaPosfixa.push(resultado);
                        } catch (Exception ignored) {}
                    }
                    else if (caractere == '/') {
                        try {
                            valor1 = pilhaPosfixa.pop();
                            valor2 = pilhaPosfixa.pop();
                            resultado = valor1 / valor2;
                            pilhaPosfixa.push(resultado);
                        } catch (Exception ignored) {}
                    }
                    else if (caractere == '^') {
                        try {
                            valor1 = pilhaPosfixa.pop();
                            valor2 = pilhaPosfixa.pop();
                            resultado = 1;
                            for (int j = 1; j <= valor2; j++) {
                                resultado *= valor1;
                            }
                            pilhaPosfixa.push(resultado);
                        } catch (Exception ignored) {}
                    }
                }
            }


            // Opção VARS
            else if (opcao.equalsIgnoreCase("VARS")){
                // Se a lista de variáveis estiver vazia imprime que não foi definida nenhuma variável
                if (vars.arrayEmpty()) {
                    System.out.println("Nenhuma variável definida.");
                } else {
                    // Usa loop for e vai imprimindo cada variável com seu respectivo valor até o momento que ele
                    // encontrar um null
                    for (int i = 0; i < 15; i++) {
                        if (vars.seeElement(i) != null) {
                            System.out.println(vars.seeElement(i) + " = " + valores.seeElement(i));
                        };
                    }
                }

            }



            //Opcao de RESET
            else if (opcao.equalsIgnoreCase("RESET")) {
                for (int i = 0; i < 10; i++) {
                    vars.removeElement(i);
                    valores.removeElement(i);
                }
                System.out.println("Variáveis reiniciadas.");
            }

            // Opção REC
            else if (opcao.equals("REC")){

                // Apaga o rec anterior sempre que se escreve um rec
                if (!rec.qIsEmpty()) {
                    for (int i = 0; i < 10; i++) {
                        rec.dequeue();
                    }
                }
                System.out.println("Iniciando gravação... (REC: 0/10)");
                int count = 0;
                boolean recLoop = true;

                while (recLoop) {
                    if (count != 10) {
                        // Inicia o Scanner
                        Scanner REC = new Scanner(System.in);
                        // Armazena a string em word
                        String word = REC.nextLine();
                        // Transforma a string para maiusculo
                        word = word.toUpperCase();
                        // Armazena em element a string word
                        String element = word;
                        // Retira todos os espaçoes de element
                        element = element.replaceAll("\\s", "");
                        if (element.equals("STOP")) {
                            System.out.println("Encerrando gravação... (REC: " + count + "/10)");
                            break;
                        } else if (element.equals("PLAY") || element.equals("ERASE") || element.equals("REC")  ) {
                            System.out.println("Erro: comando inválido para gravação");
                        }
                        else {
                            count++;
                            System.out.println("(REC: " + count + "/10) " + word);
                            rec.enqueue(element);
                        }
                    } else {
                        System.out.println("REC CHEIO");
                        recLoop = false;
                    }
                }

            }

            // Opção STOP
            else if (opcao.equalsIgnoreCase("STOP")){
                System.out.println("Não há gravação para ser encerrada");
            }

            // Opção PLAY
            else if (opcao.equalsIgnoreCase("PLAY")){

                if (!rec.qIsEmpty()) {
                    System.out.println("Reproduzindo gravação...");
                    play = true;
                } else {
                    System.out.println("Não há gravação para ser reproduzida");
                }

            }

            // Opção ERASE
            else if (opcao.equals("ERASE")){
                while (!rec.qIsEmpty()) {
                    rec.dequeue();
                }
                System.out.println("Gravação apagada.");
            }

            //Opcao de EXIT
            else if (opcao.equals("EXIT")){
                System.out.println("Programa Encerrado");
                break;
            }
        }
        scanner.close();
    }
}
