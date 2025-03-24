/* 1° Felipe Bertacco Haddad - 10437372
 * 2° Ana Julia Yaguti - 10436655
 * 3° Beatriz Nobrega - 10435789

*/

package commands.vars;

public class Fila <T> {

    private T[] fila;
    private int ultPosicao;
    private int priPosicao;

    public Fila() {
        this.fila = (T[]) new Object[10];
        this.ultPosicao = 0;
        this.priPosicao = 0;
    }

    public boolean qIsFull() {
        if (this.ultPosicao == this.fila.length ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean qIsEmpty() {
        if (this.ultPosicao == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue (T element) {
        if (!qIsFull()) {
            fila[ultPosicao] = element;
            ultPosicao++;
        } else {
            System.out.print("Fila cheia!");
        }
    }

    public T dequeue () {
        T aux = null;
        fila[priPosicao] = aux;
        fila[priPosicao] = null;
        priPosicao--;
        return aux;
        }

    public T rear () {
        return fila[priPosicao];
    }

    public T front() {
        return fila[ultPosicao - 1];
    }

    public int size () {
        int count = 0;
        for (int i = 0; i < fila.length; i++) {
            if (fila[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void printAllElements () {
        System.out.println("[");
        for (int j = 0; j < 10; j++) {
            System.out.print(fila[j] + ",");
        } System.out.println("]");
    }


    public static void main (String[] args) {

    }
}
