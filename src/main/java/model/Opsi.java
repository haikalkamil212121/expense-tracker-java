package model;

public enum Opsi {
    MAKANAN("1. Makanan"),
    JAJAN("2. Jajan"),
    BENSIN("3. Bensin"),
    BIAYA_TAK_TERDUGA("4. Biaya Tak Terduga");

    private final String label;

    Opsi(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}