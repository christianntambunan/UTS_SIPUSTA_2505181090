package layanan;

import model.Koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi obj1, Koleksi obj2) {
        boolean statusLayak1 = obj1.isLayakDipinjam();
        boolean statusLayak2 = obj2.isLayakDipinjam();
        
        if (statusLayak1 != statusLayak2) {
            return statusLayak1 ? -1 : 1;
        }
        
        return obj1.getJudul().compareToIgnoreCase(obj2.getJudul());
    }
}