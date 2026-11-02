package model;

import java.time.LocalDate;

public class Transaksi {
    private String jenis; // "Pemasukan" atau "Pengeluaran"
    private Opsi opsi;    // Pilihan kategori pengeluaran
    private double nominal;
    private LocalDate tanggal;
    private String keterangan;

    public Transaksi(String jenis, Opsi opsi, double nominal, LocalDate tanggal, String keterangan) {
        this.jenis = jenis;
        this.opsi = opsi;
        this.nominal = nominal;
        this.tanggal = tanggal;
        this.keterangan = keterangan;
    }

    public String getJenis() {
        return jenis;
    }

    public Opsi getOpsi() {
        return opsi;
    }

    public double getNominal() {
        return nominal;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    @Override
    public String toString() {
        String infoOpsi = (opsi != null) ? " - " + opsi.toString() : "";
        return tanggal + " | " + jenis + infoOpsi + " | Rp " + String.format("%,.0f", nominal)
                + (keterangan.isEmpty() ? "" : " (" + keterangan + ")");
    }
}