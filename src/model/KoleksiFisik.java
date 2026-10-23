package model;

public abstract class KoleksiFisik extends Koleksi implements Terarsip {
    private String noRak;

    public KoleksiFisik(String kode, String judul, int tahunTerbit, String nomorRak) {
        super(kode, judul, tahunTerbit);
        this.noRak = nomorRak;
    }

    @Override
    public String nomorRak() {
        return noRak;
    }

    @Override
    public String lokasiLantai() {
        if (noRak == null || noRak.isBlank()) {
            return "Lantai belum ditentukan";
        }
        char hurufAwal = Character.toUpperCase(noRak.charAt(0));
        if (hurufAwal >= 'A' && hurufAwal <= 'C') return "Lantai 1";
        if (hurufAwal >= 'D' && hurufAwal <= 'F') return "Lantai 2";
        return "Lantai 3";
    }

    @Override
    public String lokasiArsip() {
        return ringkasanArsip();
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | " + ringkasanArsip();
    }
}