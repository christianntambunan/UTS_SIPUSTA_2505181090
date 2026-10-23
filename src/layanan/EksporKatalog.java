package layanan;

import model.Koleksi;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EksporKatalog {
    
    public void ekspor(List<Koleksi> dataKoleksi) {
        try (PrintWriter out = new PrintWriter(new FileWriter("katalog.txt"))) {
            
            String header = String.format("%-7s | %-34s | %-13s | %-4s | %-11s | %-27s | %s",
                    "KODE", "JUDUL", "JENIS", "THN", "STATUS", "LOKASI ARSIP", "KETERANGAN");
            out.println(header);
            out.println("-------------------------------------------------------------------------------------------------------------------------------------");

            for (Koleksi item : dataKoleksi) {
                String statusStr = item.isLayakDipinjam() ? "Layak" : "Tidak layak";
                out.printf("%-7s | %-34s | %-13s | %-4d | %-11s | %-27s | %s%n",
                        item.getKode(),
                        item.getJudul(),
                        item.jenisKoleksi(),
                        item.getTahunTerbit(),
                        statusStr,
                        item.lokasiArsip(),
                        item.keterangan());
            }
            System.out.println("Katalog berhasil diekspor ke berkas \"katalog.txt\".");
            
        } catch (IOException ex) {
            System.out.println("Gagal mengekspor katalog: " + ex.getMessage());
        }
    }
}