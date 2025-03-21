/* 1° Felipe Bertacco Haddad - 10437372
   2° Ana Julia Yaguti - 10436655
   3° Beatriz Nobrega -

Referencias Utilizadas:
Como remover os espaços em branco em uma String
https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
Como ver se um caractere é um numero
https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a-character-is-a-letter-or-number-in-java-withou
*/


package commands.vars;

public class Vars {

    // Aqui vamos tratar a string, removendo os espaços e deixando tudo em UpperCase
    // X = 4
    public static String alteracaoDaString(String palavra) {

        System.out.println("Palavra normal: " + palavra);
        // Retira todos os espaços
        String aux = palavra.replaceAll("\\s", "");
        // Transforma todas as letras em maíusculas
        aux = aux.toUpperCase();

        System.out.println("Palavra Alterada " + aux);

        if (aux.charAt(0) >= 'A' && aux.charAt(0) <= 'Z') {
            if (aux.charAt(1) == '=') {
                if(Character.isDigit(aux.charAt(2))) {

                    // Adicionando variável e valor nos arrays
                    var[-1] = aux.charAt(0);
                    valores[-1] = aux.charAt(2);

                    // Verificando se adicionou certo nos arrays
                    for (int i = 0; i <= var.length; i++) {
                        System.out.println(var[i]);
                        System.out.println(valores[i]);
                    }

                    return palavra;
                }
            }
        } else {
            return ("Erro: comando inválido.");
        }

        return palavra;
    }
    public static void main (String[] args) {

    }
}

