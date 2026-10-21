package layanan;

import model.Koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi a, Koleksi b) {
        // Tampilkan koleksi layak dipinjam lebih dulu
        int hasilLayak = Boolean.compare(b.isLayakDipinjam(), a.isLayakDipinjam());
        if (hasilLayak != 0) {
            return hasilLayak;
        }
        // Jika status layak sama, urutkan berdasarkan judul (A-Z)
        return a.getJudul().compareToIgnoreCase(b.getJudul());
    }
}