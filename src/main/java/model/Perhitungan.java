package model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Perhitungan {
    private List<Transaksi> listTransaksi = new ArrayList<>();
    private double limitHarian = 50000; // Default limit Rp 50.000

    public void tambahData(Transaksi t) {
        listTransaksi.add(t);
    }

    public void setLimitHarian(double limitHarian) {
        this.limitHarian = limitHarian;
    }

    public double getLimitHarian() {
        return limitHarian;
    }

    // Menghitung uang harian terpakai pada tanggal yang dipilih
    public double hitungUangHarianTerpakai(LocalDate tanggal) {
        double total = 0;
        for (Transaksi t : listTransaksi) {
            if (t.getJenis().equals("Pengeluaran") && t.getTanggal().equals(tanggal)) {
                total += t.getNominal();
            }
        }
        return total;
    }

    // Menghitung uang bulanan terpakai pada bulan yang dipilih
    public double hitungUangBulananTerpakai(YearMonth bulan) {
        double total = 0;
        for (Transaksi t : listTransaksi) {
            YearMonth bulanTransaksi = YearMonth.from(t.getTanggal());
            if (t.getJenis().equals("Pengeluaran") && bulanTransaksi.equals(bulan)) {
                total += t.getNominal();
            }
        }
        return total;
    }

    // Menghitung total pemasukan
    public double hitungTotalPemasukan() {
        double total = 0;
        for (Transaksi t : listTransaksi) {
            if (t.getJenis().equals("Pemasukan")) {
                total += t.getNominal();
            }
        }
        return total;
    }

    // Menghitung pemasukan bulanan pada bulan yang dipilih
    public double hitungPemasukanBulanan(YearMonth bulan) {
        double total = 0;
        for (Transaksi t : listTransaksi) {
            YearMonth bulanTransaksi = YearMonth.from(t.getTanggal());
            if (t.getJenis().equals("Pemasukan") && bulanTransaksi.equals(bulan)) {
                total += t.getNominal();
            }
        }
        return total;
    }

    // Menghitung sisa uang / saldo keseluruhan
    public double hitungSisaSaldo() {
        double totalKeluar = 0;
        for (Transaksi t : listTransaksi) {
            if (t.getJenis().equals("Pengeluaran")) {
                totalKeluar += t.getNominal();
            }
        }
        return hitungTotalPemasukan() - totalKeluar;
    }

    // Cek apakah uang harian terpakai melewati limit harian
    public boolean isOverLimit(LocalDate tanggal) {
        return hitungUangHarianTerpakai(tanggal) > limitHarian;
    }
}