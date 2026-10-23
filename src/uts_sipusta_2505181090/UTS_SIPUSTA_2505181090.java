package UTS_SIPUSTA_2505181090;

import eksepsi.PustakaException;
import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;

public class UTS_SIPUSTA_2505181090 {

    public static void main(String[] args) {
        KatalogPerpustakaan katalogPerpus = new KatalogPerpustakaan();

        // Mengisi data wajib
        katalogPerpus.tambah(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        katalogPerpus.tambah(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        katalogPerpus.tambah(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "A-05", true));
        katalogPerpus.tambah(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "A-06", false));
        katalogPerpus.tambah(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        katalogPerpus.tambah(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));

        // 1. Status awal
        System.out.println("\n1. STATUS AWAL KATALOG");
        katalogPerpus.cetakStatus();

        // 2. Urut berdasarkan judul (menggunakan lambda sebagai variasi penulisan)
        System.out.println("\n2. URUT BERDASARKAN JUDUL");
        katalogPerpus.urut((k1, k2) -> k1.getJudul().compareToIgnoreCase(k2.getJudul()));
        katalogPerpus.cetakStatus();

        // 3. Urut layak lalu judul
        System.out.println("\n3. URUT LAYAK DIPINJAM DAHULU, LALU JUDUL");
        katalogPerpus.urut(new UrutLayakLaluJudul());
        katalogPerpus.cetakStatus();

        // 4. Uji peminjaman + eksepsi
        System.out.println("\n4. UJI PEMINJAMAN");
        tesPeminjaman(katalogPerpus, "BK-001");
        tesPeminjaman(katalogPerpus, "BK-001");
        tesPeminjaman(katalogPerpus, "BK-002");
        tesPeminjaman(katalogPerpus, "MJ-001");
        tesPeminjaman(katalogPerpus, "MJ-002");
        tesPeminjaman(katalogPerpus, "BD-001");
        tesPeminjaman(katalogPerpus, "XX-999");

        // 5. Ekspor ke katalog.txt
        System.out.println("\n5. EKSPOR KATALOG");
        EksporKatalog eksportir = new EksporKatalog();
        eksportir.ekspor(katalogPerpus.getDaftarKoleksi());
        
        // 6. Status akhir
        System.out.println("\n6. STATUS AKHIR SETELAH PEMINJAMAN");
        katalogPerpus.cetakStatus();
    }

    // Method bantuan diubah namanya dan penamaan variabelnya disesuaikan
    private static void tesPeminjaman(KatalogPerpustakaan perpustakaan, String idKoleksi) {
        try {
            perpustakaan.pinjam(idKoleksi);
        } catch (PustakaException err) {
            System.out.println("GAGAL meminjam " + idKoleksi + " [" + err.getClass().getSimpleName() + "] -> " + err.getMessage());
        }
    }
}