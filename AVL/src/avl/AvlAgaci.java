
package avl;

public class AvlAgaci {
    Dugum kok;

    // Sağ rotasyon
    Dugum sagDondur(Dugum y) {
        Dugum x = y.sol;
        Dugum T2 = x.sag;

        x.sag = y;
        y.sol = T2;

        y.yukseklik = 1 + Math.max((y.sol != null ? y.sol.yukseklik : 0), (y.sag != null ? y.sag.yukseklik : 0));
        x.yukseklik = 1 + Math.max((x.sol != null ? x.sol.yukseklik : 0), (x.sag != null ? x.sag.yukseklik : 0));

        return x;
    }

    // Sol rotasyon
    Dugum solDondur(Dugum x) {
        Dugum y = x.sag;
        Dugum T2 = y.sol;

        y.sol = x;
        x.sag = T2;

        x.yukseklik = 1 + Math.max((x.sol != null ? x.sol.yukseklik : 0), (x.sag != null ? x.sag.yukseklik : 0));
        y.yukseklik = 1 + Math.max((y.sol != null ? y.sol.yukseklik : 0), (y.sag != null ? y.sag.yukseklik : 0));

        return y;
    }

    // Dengeli olup olmadığını kontrol et
    int denge(Dugum dugum) {
        if (dugum == null) return 0;
        return (dugum.sol != null ? dugum.sol.yukseklik : 0) - (dugum.sag != null ? dugum.sag.yukseklik : 0);
    }

    // AVL ağacına ekleme
    Dugum ekle(Dugum dugum, int anahtar) {
        if (dugum == null)
            return new Dugum(anahtar);

        if (anahtar < dugum.anahtar)
            dugum.sol = ekle(dugum.sol, anahtar);
        else if (anahtar > dugum.anahtar)
            dugum.sag = ekle(dugum.sag, anahtar);
        else
            return dugum;

        dugum.yukseklik = 1 + Math.max((dugum.sol != null ? dugum.sol.yukseklik : 0), (dugum.sag != null ? dugum.sag.yukseklik : 0));

        int d = denge(dugum);

        // Sol-Sol
        if (d > 1 && anahtar < dugum.sol.anahtar)
            return sagDondur(dugum);

        // Sağ-Sağ
        if (d < -1 && anahtar > dugum.sag.anahtar)
            return solDondur(dugum);

        // Sol-Sağ
        if (d > 1 && anahtar > dugum.sol.anahtar) {
            dugum.sol = solDondur(dugum.sol);
            return sagDondur(dugum);
        }

        // Sağ-Sol
        if (d < -1 && anahtar < dugum.sag.anahtar) {
            dugum.sag = sagDondur(dugum.sag);
            return solDondur(dugum);
        }

        return dugum;
    }

    // Ağaç sıralı olarak yazdırılır
    void yazdir(Dugum dugum) {
        if (dugum != null) {
            System.out.print(dugum.anahtar + " ");
            yazdir(dugum.sol);
            yazdir(dugum.sag);
        }
}
}
