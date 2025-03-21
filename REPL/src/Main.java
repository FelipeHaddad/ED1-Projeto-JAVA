/* 1° Felipe Bertacco Haddad - 10437372
 * 2° Ana Julia Yaguti - 10436655
 * 3° Beatriz Nobrega - 

Referencias Utilizadas:
https://how.dev/answers/what-is-characterisletter-in-java -> Como ver se o caractere se trata de uma letra
  
 */

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 import commands.vars.Vars;
 
 public class Main {
     public static void main(String[] args) {
         // Listas que vão armazenar as variáveis declaradas e seus valores
         List<String> listaVars = new ArrayList<String>();
         List<Integer> valores = new ArrayList<Integer>();
 
         // Valor que será utilizado para manter o loop ativo
         boolean valor = true;
         while (valor) {
             Scanner scanner = new Scanner(System.in);
             System.out.println("Menu de comandos:\n1. Expressão Matemática Infixa\n2. <VAR>=<VALUE>\n3. VARS\n4. RESET\n5. REC\n6. STOP\n7. PLAY\n8. ERASE\n9. EXIT");
 
             String opcao = scanner.nextLine();
 
 
 
             //Opcao expressao matematica infixa
             if (opcao.equalsIgnoreCase("Expressão Matemática Infixa")){
                 valor = false;
 
             }
 
             //Opcao VAR = VALUE
             if (Character.isLetter(opcao.charAt(0))){
                 Vars.alteracaoDaString(opcao, listaVars, valores);
                 for (int j = 0; j < listaVars; j++) {
                     System.out.println(listaVars[j]);
                     System.out.println(valores[j]);
                 }
                 valor = false;
 
             }
 
             if (opcao.equalsIgnoreCase("VARS")){
                 valor = false;
 
             }
 
 
 
             //Opcao de RESET
             if (opcao.equalsIgnoreCase("RESET")) {
                 valor = false;
 
 
             }
 
             if (opcao.equalsIgnoreCase("REC")){
                 valor = false;
 
             }
 
             if (opcao.equalsIgnoreCase("STOP")){
                 valor = false;
 
             }
 
 
 
             //Opcao de EXIT
             if (opcao.equalsIgnoreCase("EXIT")){
                 System.out.println("Programa Encerrado");
                 valor = false;
 
             }
 
 
 
 
 
         }
     }
 }
 