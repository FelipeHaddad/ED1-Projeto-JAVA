/* 1° Felipe Bertacco Haddad - 10437372
 * 2° Ana Julia Yaguti - 10436655
 * 3° Beatriz Nobrega - 10435789

 */

 package commands.vars;

 public class Pilha <T> {
 
     private T[] pilha;
     private int posicao;
     private int quantidade;
 
     public Pilha () {
         this.pilha = (T[]) new Object[15];
         this.posicao = 0;
         this.quantidade = 0;
     }
 
     public boolean isEmpty () {
         if (quantidade == 0) {
             return true;
         } return false;
     }
 
     public boolean isFull () {
         if (quantidade == pilha.length) {
             return true;
         } return false;
     }
 
     public T topo () throws Exception {
         if (!isEmpty()) {
             return pilha[posicao - 1];
         } throw new Exception("Pilha vazia!");
     }
 
     public void push (T element) throws Exception {
         if (!isFull()) {
             pilha[posicao] = element;
             posicao++;
         } throw new Exception("Pilha cheia!");
     }
 
     public T pop () throws Exception {
         if (!isEmpty()) {
             T aux;
             aux = pilha[posicao - 1];
             pilha[posicao - 1] = null;
             posicao--;
             return aux;
         } throw new Exception("Pilha vazia!");
     }
 
 
     public static void main (String[] args) {
 
     }
 }
 