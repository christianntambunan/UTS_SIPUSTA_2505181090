package model;

public class Majalah extends KoleksiFisik {
    private int edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRak, boolean edisiTerbaru) {
        super(kode, judul, tahunTerbit, nomorRak);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public String jenisKoleksi() {
        return "Majalah";
    }

    @Override
    public boolean isLayakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String alasanTidakLayak() {
        return "majalah ini merupakan edisi terbaru sehingga hanya boleh dibaca di tempat";
    }

    @Override
    public String keterangan() {
        return "Edisi " + edisi + ", terbit " + bulanTerbit + (edisiTerbaru ? " (edisi terbaru)" : " (bukan edisi terbaru)");
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Edisi " + edisi + " (" + bulanTerbit + ") | " 
                + (edisiTerbaru ? "edisi terbaru" : "bukan edisi terbaru");
    }
}
