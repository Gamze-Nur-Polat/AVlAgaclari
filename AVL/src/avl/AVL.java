
package avl;


public class AVL {

    public static void main(String[] args) {
       AvlAgaci agac = new AvlAgaci();

        agac.kok = agac.ekle(agac.kok, 10);
        agac.kok = agac.ekle(agac.kok, 20);
        agac.kok = agac.ekle(agac.kok, 30);
        agac.kok = agac.ekle(agac.kok, 40);
        agac.kok = agac.ekle(agac.kok, 50);
        agac.kok = agac.ekle(agac.kok, 25);

        System.out.println("AVL Ağacının sıralı yazımı:");
        agac.yazdir(agac.kok);
    }
    
}
