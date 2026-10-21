package model;

public interface Terarsip {
    String nomorRak();
    String lokasiLantai();
    
    default String ringkasanArsip() {
        return "Rak " + nomorRak() + " (" + lokasiLantai() + ")";
    }
}