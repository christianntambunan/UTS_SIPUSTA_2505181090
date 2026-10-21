package UTS_SIPUSTA_2505181090;

import eksepsi.PustakaException;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Koleksi;
import model.Majalah;

import java.util.Comparator;

public class UTS_SIPUSTA_2505181090 {

    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        katalog.tambah(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        katalog.tambah(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        katalog.tambah(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "A-05", true));
        katalog.tambah(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "A-06", false));
        katalog.tambah(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        katalog.tambah(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));

        // 1. Status awal
        System.out.println("\n1. STATUS AWAL KATALOG");
        katalog.cetakStatus();

        // 2. Urut berdasarkan judul (menggunakan Comparator)
        System.out.println("\n2. URUT BERDASARKAN JUDUL");
        katalog.urut(Comparator.comparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER));
        katalog.cetakStatus();

        // 3. Urut layak lalu judul
        System.out.println("\n3. URUT LAYAK DIPINJAM DAHULU, LALU JUDUL");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // 4. Uji peminjaman + eksepsi
        System.out.println("\n4. UJI PEMINJAMAN");
        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-001");
        cobaPinjam(katalog, "BK-002");
        cobaPinjam(katalog, "MJ-001");
        cobaPinjam(katalog, "MJ-002");
        cobaPinjam(katalog, "BD-001");
        cobaPinjam(katalog, "XX-999");

        // 5. Ekspor ke katalog.txt
        System.out.println("\n5. EKSPOR KATALOG");
        new EksporKatalog().ekspor(katalog.getDaftarKoleksi());
        
        // 6. Status akhir
        System.out.println("\n6. STATUS AKHIR SETELAH PEMINJAMAN");
        katalog.cetakStatus();
    }

    // Method bantuan untuk menguji eksepsi
    private static void cobaPinjam(KatalogPerpustakaan katalog, String kode) {
        try {
            katalog.pinjam(kode);
        } catch (PustakaException e) {
            System.out.println("GAGAL meminjam " + kode + " [" + e.getClass().getSimpleName() + "] -> " + e.getMessage());
        }
    }
}