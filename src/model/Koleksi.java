package model;

public abstract class Koleksi {
    private String idKoleksi;
    private String namaJudul;
    private int tahun;
    private boolean statusPinjam;

    public Koleksi(String kode, String judul, int tahunTerbit) {
        this.idKoleksi = kode;
        this.namaJudul = judul;
        this.tahun = tahunTerbit;
        this.statusPinjam = false;
    }

    public String getKode() { return idKoleksi; }
    public String getJudul() { return namaJudul; }
    public int getTahunTerbit() { return tahun; }
    public boolean isSedangDipinjam() { return statusPinjam; }
    public void setSedangDipinjam(boolean statusPinjam) { this.statusPinjam = statusPinjam; }

    public abstract boolean isLayakDipinjam();
    public abstract String jenisKoleksi();

    public String alasanTidakLayak() {
        return "belum memenuhi syarat peminjaman";
    }

    public String lokasiArsip() {
        return "Tidak ada (koleksi digital)";
    }
    
    public String keterangan() {
        return "-";
    }

    public String deskripsi() {
        String statusLayak = isLayakDipinjam() ? "Layak dipinjam" : "Tidak layak";
        return String.format("%-7s | %-34s | %-13s | %-4d | %s",
                idKoleksi, namaJudul, jenisKoleksi(), tahun, statusLayak);
    }
}