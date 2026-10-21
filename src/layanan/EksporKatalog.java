package layanan;

import model.Koleksi;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EksporKatalog {
    
    public void ekspor(List<Koleksi> daftarKoleksi) {
        try (PrintWriter penulis = new PrintWriter(new FileWriter("katalog.txt"))) {
            
            penulis.printf("%-7s | %-34s | %-13s | %-4s | %-11s | %-27s | %s%n",
                    "KODE", "JUDUL", "JENIS", "THN", "STATUS", "LOKASI ARSIP", "KETERANGAN");
            penulis.println("-------------------------------------------------------------------------------------------------------------------------------------");

            for (Koleksi k : daftarKoleksi) {
                penulis.printf("%-7s | %-34s | %-13s | %-4d | %-11s | %-27s | %s%n",
                        k.getKode(),
                        k.getJudul(),
                        k.jenisKoleksi(),
                        k.getTahunTerbit(),
                        k.isLayakDipinjam() ? "Layak" : "Tidak layak",
                        k.lokasiArsip(),
                        k.keterangan());
            }
            System.out.println("Katalog berhasil diekspor ke berkas \"katalog.txt\".");
            
        } catch (IOException e) {
            System.out.println("Gagal mengekspor katalog: " + e.getMessage());
        }
    }
}