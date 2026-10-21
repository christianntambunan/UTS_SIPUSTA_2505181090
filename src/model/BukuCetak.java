package model;

public class BukuCetak extends KoleksiFisik {
    private int jumlahHalaman;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit, nomorRak);
        this.jumlahHalaman = jumlahHalaman;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public String jenisKoleksi() {
        return "BukuCetak";
    }

    @Override
    public boolean isLayakDipinjam() {
   
        return !sedangDiperbaiki;
    }

    @Override
    public String alasanTidakLayak() {
        return "buku ini sedang diperbaiki oleh petugas perpustakaan";
    }

    @Override
    public String keterangan() {
        return jumlahHalaman + " halaman, " + (sedangDiperbaiki ? "sedang diperbaiki" : "siap dipinjam");
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | " + jumlahHalaman + " halaman | " 
                + (sedangDiperbaiki ? "sedang diperbaiki" : "siap dipinjam");
    }
}