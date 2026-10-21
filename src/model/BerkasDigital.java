package model;

public class BerkasDigital extends Koleksi {
    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kode, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public String jenisKoleksi() {
        return "BerkasDigital";
    }

    @Override
    public boolean isLayakDipinjam() {
        // Berkas digital selalu layak dipinjam
        return true;
    }

    private String ukuranTeks() {
        if (ukuranMB == Math.rint(ukuranMB)) {
            return String.format("%.0f MB", ukuranMB);
        }
        return String.format("%.1f MB", ukuranMB);
    }

    @Override
    public String keterangan() {
        return ukuranTeks() + ", " + tautanUnduh;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | " + ukuranTeks() + " | " + tautanUnduh;
    }
}