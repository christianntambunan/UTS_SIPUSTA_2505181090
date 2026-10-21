package model;

public abstract class KoleksiFisik extends Koleksi implements Terarsip {
    private String nomorRak;

    public KoleksiFisik(String kode, String judul, int tahunTerbit, String nomorRak) {
        super(kode, judul, tahunTerbit);
        this.nomorRak = nomorRak;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        if (nomorRak == null || nomorRak.isEmpty()) {
            return "Lantai belum ditentukan";
        }
        char awal = Character.toUpperCase(nomorRak.charAt(0));
        if (awal >= 'A' && awal <= 'C') {
            return "Lantai 1";
        }
        if (awal >= 'D' && awal <= 'F') {
            return "Lantai 2";
        }
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