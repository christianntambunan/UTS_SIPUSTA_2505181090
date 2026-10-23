package model;

public interface Terarsip {
    String nomorRak();
    String lokasiLantai();
    
    default String ringkasanArsip() {
        return String.format("Rak %s (%s)", nomorRak(), lokasiLantai());
    }
}