package main;

import java.time.LocalDate;
import java.time.YearMonth;
import model.Opsi;
import model.Perhitungan;
import model.Transaksi;

public class DemoTerminalMode {
    public static void main(String[] args) {
        Perhitungan hitung = new Perhitungan();
        hitung.setLimitHarian(50000);
        LocalDate hariIni = LocalDate.now();

        hitung.tambahData(new Transaksi("Pemasukan", null, 200000, hariIni, "Uang Saku"));
        hitung.tambahData(new Transaksi("Pengeluaran", Opsi.MAKANAN, 25000, hariIni, "Makan Siang"));
        hitung.tambahData(new Transaksi("Pengeluaran", Opsi.BENSIN, 30000, hariIni, "Isi Pertamax"));

        System.out.println("=== DEMO TERMINAL EXPENSE TRACKER ===");
        System.out.println("Total Pemasukan       : Rp " + hitung.hitungTotalPemasukan());
        System.out.println("Uang Harian Terpakai  : Rp " + hitung.hitungUangHarianTerpakai(hariIni));
        System.out.println("Uang Bulanan Terpakai : Rp " + hitung.hitungUangBulananTerpakai(YearMonth.now()));
        System.out.println("Sisa Saldo            : Rp " + hitung.hitungSisaSaldo());
        System.out.println("Status Limit Harian   : " + (hitung.isOverLimit(hariIni) ? "MERAH (OVER LIMIT)" : "AMAN"));
    }
}