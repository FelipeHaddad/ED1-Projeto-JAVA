/* 1° Felipe Bertacco Haddad - 10437372
 * 2° Ana Julia Yaguti - 10436655
 * 3° Beatriz Nobrega - 10435789

*/

package commands.vars;

public class Array <T> {

    private T array[];
    private int posicao = 0;


    public void addElement(T element) {
        array[posicao] = element;
        posicao++;
    }

    public void seeElements() {
        for (int j = 0; j <= array.length; j++) {
            System.out.print(array[j]);
        }
    }

    public boolean arrayEmpty() {
        if (posicao == 0) {
            return true;
        }
        return false;
    }

    public boolean arrayFull () {
        if (posicao == array.length) {
            return true;
        }
        return false;
    }

    public static void main () {

    }
}
