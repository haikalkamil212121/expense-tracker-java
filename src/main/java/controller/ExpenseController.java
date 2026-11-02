package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Opsi;
import model.Perhitungan;
import model.Transaksi;

public class ExpenseController implements Initializable {

    @FXML private DatePicker dpTanggal;
    @FXML private ComboBox<String> cbJenis;
    @FXML private ComboBox<Opsi> cbOpsi;
    @FXML private TextField tfNominal;
    @FXML private TextField tfKeterangan;
    @FXML private TextField tfLimit;

    @FXML private Label lblHarianTerpakai;
    @FXML private Label lblBulananTerpakai;
    @FXML private Label lblPemasukanBulanan;
    @FXML private Label lblPemasukan;
    @FXML private Label lblSisaSaldo;
    @FXML private Label lblStatusLimit;
    @FXML private ListView<String> lvRiwayat;

    private Perhitungan perhitungan = new Perhitungan();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dpTanggal.setValue(LocalDate.now());
        tfLimit.setText("50000");

        cbJenis.setItems(FXCollections.observableArrayList("Pengeluaran", "Pemasukan"));
        cbJenis.getSelectionModel().selectFirst();

        cbOpsi.setItems(FXCollections.observableArrayList(Opsi.values()));
        cbOpsi.getSelectionModel().selectFirst();

        // Matikan pilihan Opsi jika yang dipilih adalah Pemasukan
        cbJenis.setOnAction(e -> {
            boolean isPengeluaran = cbJenis.getValue().equals("Pengeluaran");
            cbOpsi.setDisable(!isPengeluaran);
        });

        // Perbarui angka jika tanggal diganti
        dpTanggal.setOnAction(e -> updateInfo());

        updateInfo();
    }

    @FXML
    private void handleAturLimit(ActionEvent event) {
        try {
            double limit = Double.parseDouble(tfLimit.getText().trim());
            perhitungan.setLimitHarian(limit);
            updateInfo();
        } catch (NumberFormatException e) {
            tampilPesan("Masukkan angka limit harian yang benar!");
        }
    }

    @FXML
    private void handleTambah(ActionEvent event) {
        try {
            String jenis = cbJenis.getValue();
            Opsi opsi = jenis.equals("Pengeluaran") ? cbOpsi.getValue() : null;
            double nominal = Double.parseDouble(tfNominal.getText().trim());
            LocalDate tanggal = dpTanggal.getValue();
            String ket = tfKeterangan.getText().trim();

            Transaksi tr = new Transaksi(jenis, opsi, nominal, tanggal, ket);
            perhitungan.tambahData(tr);
            lvRiwayat.getItems().add(0, tr.toString());

            tfNominal.clear();
            tfKeterangan.clear();
            updateInfo();
        } catch (NumberFormatException e) {
            tampilPesan("Nominal uang harus berupa angka!");
        }
    }

    private void updateInfo() {
        LocalDate tgl = dpTanggal.getValue();
        YearMonth bln = YearMonth.from(tgl);

        double harian = perhitungan.hitungUangHarianTerpakai(tgl);
        double bulanan = perhitungan.hitungUangBulananTerpakai(bln);
        double pemasukanBulanan = perhitungan.hitungPemasukanBulanan(bln);
        double pemasukan = perhitungan.hitungTotalPemasukan();
        double saldo = perhitungan.hitungSisaSaldo();

        lblHarianTerpakai.setText("Rp " + String.format("%,.0f", harian));
        lblBulananTerpakai.setText("Rp " + String.format("%,.0f", bulanan));
        lblPemasukanBulanan.setText("Rp " + String.format("%,.0f", pemasukanBulanan));
        lblPemasukan.setText("Rp " + String.format("%,.0f", pemasukan));
        lblSisaSaldo.setText("Rp " + String.format("%,.0f", saldo));

        // Ubah teks jadi MERAH jika uang harian terpakai melewati limit
        if (perhitungan.isOverLimit(tgl)) {
            lblHarianTerpakai.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            lblStatusLimit.setText("Melewati Limit Harian!");
            lblStatusLimit.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        } else {
            lblHarianTerpakai.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            lblStatusLimit.setText("Aman (Di bawah limit)");
            lblStatusLimit.setStyle("-fx-text-fill: green;");
        }
    }

    private void tampilPesan(String pesan) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}