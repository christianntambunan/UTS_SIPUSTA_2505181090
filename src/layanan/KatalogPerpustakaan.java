package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return Collections.unmodifiableList(daftarKoleksi);
    }

    public Koleksi cari(String kode) {
        for (Koleksi k : daftarKoleksi) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }

    public void cetakStatus() {
        System.out.printf("%-7s | %-34s | %-13s | %-4s | %s%n", 
                "KODE", "JUDUL", "JENIS", "THN", "STATUS & DETAIL");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        
        for (Koleksi k : daftarKoleksi) {
            String statusPinjam = k.isSedangDipinjam() ? "  >> SEDANG DIPINJAM" : "";
            System.out.println(k.deskripsi() + statusPinjam);
        }
        System.out.println("Total koleksi: " + daftarKoleksi.size());
    }

    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }

    public void pinjam(String kode) throws PustakaException {
        Koleksi k = cari(kode);

        if (k == null) {
            throw new PustakaException("Buku dengan kode " + kode + " tidak ditemukan. Silakan periksa kembali kode yang Anda masukkan.");
        }
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException("Maaf, \"" + k.getJudul() + "\" sedang dipinjam oleh anggota lain. Silakan pinjam koleksi lain atau tunggu sampai koleksi tersebut dikembalikan.");
        }
        if (!k.isLayakDipinjam()) {
            throw new KoleksiTidakLayakException("Maaf, \"" + k.getJudul() + "\" belum dapat dipinjam karena " + k.alasanTidakLayak() + ".");
        }

        k.setSedangDipinjam(true);
        System.out.println("Berhasil! \"" + k.getJudul() + "\" (" + k.getKode() + ") berhasil dipinjam.");
    }
}