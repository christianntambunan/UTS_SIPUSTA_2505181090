package model;

public class BukuCetak extends KoleksiFisik {
    private int jmlHalaman;
    private boolean isDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit, nomorRak);
        this.jmlHalaman = jumlahHalaman;
        this.isDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public String jenisKoleksi() { return "BukuCetak"; }

    @Override
    public boolean isLayakDipinjam() {
        return !isDiperbaiki;
    }

    @Override
    public String alasanTidakLayak() {
        return "buku ini sedang diperbaiki oleh petugas perpustakaan";
    }

    @Override
    public String keterangan() {
        String kondisi = isDiperbaiki ? "sedang diperbaiki" : "siap dipinjam";
        return jmlHalaman + " halaman, " + kondisi;
    }

    @Override
    public String deskripsi() {
        String kondisi = isDiperbaiki ? "sedang diperbaiki" : "siap dipinjam";
        return super.deskripsi() + " | " + jmlHalaman + " halaman | " + kondisi;
    }
}