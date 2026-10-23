package model;

public class BerkasDigital extends Koleksi {
    private double sizeMB;
    private String urlUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.sizeMB = ukuranMB;
        this.urlUnduh = tautanUnduh;
    }

    @Override
    public String jenisKoleksi() { return "BerkasDigital"; }

    @Override
    public boolean isLayakDipinjam() { return true; }

    private String formatUkuran() {
        if (sizeMB % 1 == 0) {
            return String.format("%.0f MB", sizeMB);
        }
        return String.format("%.1f MB", sizeMB);
    }

    @Override
    public String keterangan() {
        return formatUkuran() + ", " + urlUnduh;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | " + formatUkuran() + " | " + urlUnduh;
    }
}