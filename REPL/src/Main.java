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
  
 */

 import commands.vars.Array;
 import java.util.Scanner;
 
 public class Main {
     public static void main(String[] args) {
         // Listas que vão armazenar as variáveis declaradas e seus valores
         Array<Character> vars = new Array<>();
         Array<Integer> valores = new Array<>();
 
         Scanner scanner = new Scanner(System.in);
         // Valor que será utilizado para manter o loop ativo
         boolean valor = true;
         while (valor) {
 
             System.out.println("Menu de comandos:\n1. Expressão Matemática Infixa\n2. <VAR>=<VALUE>\n3. VARS\n4. RESET\n5. REC\n6. STOP\n7. PLAY\n8. ERASE\n9. EXIT");
 
             String opcao = scanner.nextLine();
 
 
 
             //Opcao expressao matematica infixa
             if (opcao.equalsIgnoreCase("Expressão Matemática Infixa")){
                 valor = false;
 
             }
 
 
 
 
 
             //Opcao VAR = VALUE
             else if (Character.isLetter(opcao.charAt(0))){
                 System.out.println("Palavra normal: " + opcao);
 
                 // Retira todos os espaços em branco
                 String aux = opcao.replaceAll("\\s", "");
                 // Transforma todas as letras em maíusculas
                 aux = aux.toUpperCase();
 
                 System.out.println("Palavra Alterada " + aux);
 
                 if (aux.charAt(0) >= 'A' && aux.charAt(0) <= 'Z') {
                     if (aux.charAt(1) == '=') {
                         if (Character.isDigit(aux.charAt(2))) {
                             vars.addElement(aux.charAt(0));
                             Integer number = Integer.valueOf(aux.charAt(2));
                             valores.addElement(number);
                             System.out.println(opcao);
                         }
                     }
                     vars.seeElements();
                     valores.seeElements();
                 } else {
                     System.out.println("Erro: comando inválido.");
                 }
             }
 
 
 
 
             else if (opcao.equalsIgnoreCase("VARS")){
                 valor = false;
 
             }
 
 
 
             //Opcao de RESET
             else if (opcao.equalsIgnoreCase("RESET")||opcao.equals("4")) {
                 valor = false;
 
 
             }
 
             else if (opcao.equalsIgnoreCase("REC")||opcao.equals("5")){
                 valor = false;
 
             }
 
             else if (opcao.equalsIgnoreCase("STOP")||opcao.equals("6")){
                 valor = false;
 
             }
             else if (opcao.equalsIgnoreCase("PLAY")||opcao.equals("7")){
                 valor = false;
 
             }
             else if (opcao.equalsIgnoreCase("ERASE")||opcao.equals("8")){
                 valor = false;
 
             }
 
 
 
             //Opcao de EXIT
             else if (opcao.equalsIgnoreCase("EXIT")||opcao.equals("9")){
                 System.out.println("Programa Encerrado");
                 valor = false;
 
             }
 
             else{
                 System.out.println("Erro: Comando Inválido");
                 valor = false;
             }
 
 
 
 
 
 
         }
         scanner.close();
     }
 }
 