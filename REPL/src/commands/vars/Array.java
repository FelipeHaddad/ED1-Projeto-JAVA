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
 
     public void changeElement (int indice, T element) {
         this.array[posicao] = element;
     }
 
 
     public void addElement(T element) {
         if (!arrayFull()) {
             this.array[posicao] = element;
             posicao++;
         }
     }
 
     public void removeElement(int indice) {
         if (!arrayFull()) {
             this.array[indice] = null;
         }
     }
 
     public boolean searchElement (T element) {
         for (int i = 0; i < array.length; i++) {
             if (array[i] == element) {
                 return true;
             }
         } return false;
     }
 
     public int elementPosition (T element) {
         int pos = -1;
         for (int i = 0; i < array.length; i++) {
             if (array[i] == element) {
                 pos = i;
                 break;
             }
         } return pos;
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
 