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
 */

 import java.util.Scanner;

 import commands.vars.*;
 
 import static java.lang.Integer.parseInt;
 
 public class Main {
     public static void main(String[] args) {
         // Listas que vão armazenar as variáveis declaradas e seus valores
         Array<Character> vars = new Array<>();
         Array<Integer> valores = new Array<>();
 
         // Fila que vai armazenar o REC
         Fila<String> rec = new Fila<>();
 
         // Pilha para as expressões matemática infixas
         Pilha<Character> pilha = new Pilha<>();
 
         // String saida que vai armazenar a expressão posfixa
         String saida = "";
 
 
         Scanner scanner = new Scanner(System.in);
         // Valor que será utilizado para manter o loop ativo
         boolean valor = true;
         while (valor) {
 
             /* System.out.print("Menu de comandos:\n1. Expressão Matemática Infixa\n2. <VAR>=<VALUE>\n3. VARS\n4. " +
                             "RESET\n5. REC\n6. STOP\n7. PLAY\n8. ERASE\n9. EXIT\nDigite sua opção: ");
             */
 
 
             String user = scanner.nextLine();
             // Deixa tudo em letra Maiúscula
             user = user.toUpperCase();
             String opcao = user;
             // Remove todos os espaços
             opcao = opcao.replaceAll("\\s", "");
 
             /*
             opcao.charAt(i) == '+' || opcao.charAt(i) == '(' || opcao.charAt(i) == ')' || opcao.charAt(i) == '-' || opcao.charAt(i) == '/'
              */
 
             //Opcao expressao matematica infixa transformando para posfixa
             for (int i = 0; i < opcao.length(); i++) {
                 if (opcao.charAt(i) == '(') {
                     try {
                         pilha.push(opcao.charAt(i));
                     } catch (Exception e) {
                         System.out.print("Erro: " + e.getMessage());
                     }
                 }
 
                 else if (opcao.charAt(i) == ')') {
                     try {
                         for (int j = 0; j < opcao.length(); j++) {
                             if (opcao.charAt(i) == ')') {
                                 break;
                             } else {
                                 saida += pilha.pop();
                             }
                         }
                     } catch (Exception e) {
                         System.out.println("Erro: " + e.getMessage());
                     }
                 }
                 
                 else if (Character.isLetter(opcao.charAt(i))) {
                     saida += opcao.charAt(i);
                 }
             }
 
 
             // Opção VARS
             if (opcao.equalsIgnoreCase("VARS")){
                 // Se a lista de variáveis estiver vazia imprime que não foi definida nenhuma variável
                 if (vars.arrayEmpty()) {
                     System.out.println("Nenhuma variável definida.");
                 } else {
                     // Usa loop for e vai imprimindo cada variável com seu respectivo valor até o momento que ele
                     // encontrar um null
                     for (int i = 0; i < 15; i++) {
                         if (vars.seeElement(i) != null) {
                             System.out.println(vars.seeElement(i) + "=" + valores.seeElement(i));
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
                 System.out.print("Variáveis reiniciadas.");
             }
 
             // Opção REC
             else if (opcao.equals("REC")){
                 if (!rec.qIsEmpty()) {
                     for (int i = 0; i < 10; i++) {
                         rec.dequeue();
                     }
                 }
                 System.out.println("Iniciando gravação... (REC: 0/10)");
                 int count = 1;
                 boolean recLoop = true;
                 while (recLoop) {
                     if (count != 10) {
                         Scanner REC = new Scanner(System.in);
                         String word = REC.nextLine();
                         String element = word;
                         element = element.replaceAll("\\s", "");
                         element = element.toUpperCase();
                         if (element.equals("STOP")) {
                             System.out.println("Encerrando gravação... (REC: " + count + "/10)");
                             recLoop = false;
                         } else if (element.equals("PLAY") || element.equals("ERASE") || element.equals("REC")  ) {
                             System.out.println("Erro: comando inválido para gravação");
                         }
                         else {
                             System.out.println("(REC: " + count + "/10) " + word);
                             rec.enqueue(word);
                             ++count;
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
                     
 
                 }
 
             }
 
             // Opção ERASE
             else if (opcao.equals("ERASE")){
                 if (!rec.qIsEmpty()) {
                     for (int i = 0; i < 10; i++) {
                         rec.dequeue();
                     }
                 } else {
                     System.out.println("Gravação apagada.");
                 }
 
             }
 
 
 
             //Opcao de EXIT
             else if (opcao.equals("EXIT")){
                 System.out.println("Programa Encerrado");
                 break;
             }
 
             //Opcao VAR = VALUE
             else if (opcao.charAt(0) >= 'A' && opcao.charAt(0) <= 'Z') {
 
                 // Caso o segundo caractere seja =
                 if (opcao.charAt(1) == '=') {
                     if (Character.isDigit(opcao.charAt(2))) {
                         vars.addElement(opcao.charAt(0));
                         int number = Character.getNumericValue(opcao.charAt(2));
                         valores.addElement(number);
                         System.out.println(user);
                     } else {
                         System.out.println("Erro comando inválido");
                         continue;
                     }
                 }
                 else {
                     System.out.println("Erro: comando inválido.");
                     continue;

                 }
             }
 
             else {
                 System.out.println("Erro: Comando Inválido");
                 continue;
             }
 
 
 
 
 
 
 
 
         }
         scanner.close();
     }
 }
 