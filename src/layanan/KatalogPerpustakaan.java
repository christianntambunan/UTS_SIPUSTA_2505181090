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
    private List<Koleksi> himpunanKoleksi = new ArrayList<>();

    public void tambah(Koleksi itemBaru) {
        himpunanKoleksi.add(itemBaru);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return Collections.unmodifiableList(himpunanKoleksi);
    }

    public Koleksi cari(String idKoleksi) {
        for (Koleksi item : himpunanKoleksi) {
            if (item.getKode().equalsIgnoreCase(idKoleksi)) {
                return item;
            }
        }
        return null;
    }

    public void cetakStatus() {
        System.out.printf("%-7s | %-34s | %-13s | %-4s | %s%n", 
                "KODE", "JUDUL", "JENIS", "THN", "STATUS & DETAIL");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        
        for (Koleksi item : himpunanKoleksi) {
            String penandaPinjam = "";
            if (item.isSedangDipinjam()) {
                penandaPinjam = "  >> SEDANG DIPINJAM";
            }
            System.out.println(item.deskripsi() + penandaPinjam);
        }
        System.out.println("Total koleksi: " + himpunanKoleksi.size());
    }

    public void urut(Comparator<Koleksi> pembanding) {
        himpunanKoleksi.sort(pembanding);
    }

    public void pinjam(String idKoleksi) throws PustakaException {
        Koleksi target = cari(idKoleksi);

        if (target == null) {
            throw new PustakaException("Buku dengan kode " + idKoleksi + " tidak ditemukan. Silakan periksa kembali kode yang Anda masukkan.");
        }
        if (target.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException("Maaf, \"" + target.getJudul() + "\" sedang dipinjam oleh anggota lain. Silakan pinjam koleksi lain atau tunggu sampai koleksi tersebut dikembalikan.");
        }
        if (!target.isLayakDipinjam()) {
            throw new KoleksiTidakLayakException("Maaf, \"" + target.getJudul() + "\" belum dapat dipinjam karena " + target.alasanTidakLayak() + ".");
        }

        target.setSedangDipinjam(true);
        System.out.println("Berhasil! \"" + target.getJudul() + "\" (" + target.getKode() + ") berhasil dipinjam.");
    }
}