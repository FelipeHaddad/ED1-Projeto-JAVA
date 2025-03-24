/* 1° Felipe Bertacco Haddad - 10437372
 * 2° Ana Julia Yaguti - 10436655
 * 3° Beatriz Nobrega - 10435789

*/

package commands.vars;

public class Array <T> {

    private T array[];
    private int posicao = 0;

    public Array(int tamanho) {
        this.array = (T[]) new Object[tamanho];
        this.posicao = 0;
    }

    public Array() {
        this.array = (T[]) new Object[15];
        this.posicao = 0;
    }

    public T seeElement (int indice) {
        return array[indice];
    }


    public void addElement(T element) {
        if (!arrayFull()) {
            this.array[posicao] = element;
            posicao++;
        }
    }

    public void seeElements() {
        System.out.print("[");
        for (int j = 0; j < array.length; j++) {
            if (j == ((array.length) - 1)) {
                System.out.print(array[j]);
            } else {
                System.out.print(array[j] + ", ");
            }
        }
        System.out.print("]");
    }

    public boolean arrayEmpty() {
        if (posicao == 0) {
            return true;
        }
        return false;
    }

    public boolean arrayFull () {
        if (posicao == this.array.length) {
            return true;
        }
        return false;
    }

    public static void main () {

    }
}
