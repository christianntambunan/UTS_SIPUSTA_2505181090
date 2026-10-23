package eksepsi;

 public class PustakaException extends Exception {
    public PustakaException(String pesanError) {
        super(pesanError);
    }
}