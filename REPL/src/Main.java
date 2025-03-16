import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            if (opcao.equalsIgnoreCase("<VAR>=<VALUE>")){
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
