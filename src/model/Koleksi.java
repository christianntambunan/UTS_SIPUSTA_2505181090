package model;

public abstract class Koleksi {
    private String kode;
    private String judul;
    private int tahunTerbit;
    private boolean sedangDipinjam;

    public Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }

    // Method abstract untuk aturan kelayakan pinjam (Soal 1)
    public abstract boolean isLayakDipinjam();
    
    // Method abstract untuk jenis koleksi
    public abstract String jenisKoleksi();

    // Method untuk alasan tidak layak
    public String alasanTidakLayak() {
        return "belum memenuhi syarat peminjaman";
    }

    // Method untuk lokasi arsip
    public String lokasiArsip() {
        return "Tidak ada (koleksi digital)";
    }
    
    // Method keterangan untuk ekspor
    public String keterangan() {
        return "-";
    }

    // Method deskripsi yang akan di-override oleh anak-anaknya
    public String deskripsi() {
        return String.format("%-7s | %-34s | %-13s | %-4d | %s",
                kode, judul, jenisKoleksi(), tahunTerbit,
                isLayakDipinjam() ? "Layak dipinjam" : "Tidak layak");
    }
}