expense tracker JavaFX (Maven)

project ini berbasis bahasa pemrograman java
menggunakan software Apache NetBeans untuk IDE dan SceneBuilder untuk visual sederhananya.

---

Fitur Utama

- **Pencatatan Arus Kas:** Mencatat transaksi pemasukan dan pengeluaran secara fleksibel beserta tanggal dan catatan/keterangan.
- **Kategori Pengeluaran Terstruktur:** Dilengkapi opsi kategori menggunakan tipe data *Enum*:
  1. Makanan
  2. Jajan
  3. Bensin
  4. Biaya Tak Terduga
- **Kalkulasi Otomatis:**
  - Menghitung **Uang Harian Terpakai** secara real-time berdasarkan tanggal yang dipilih.
  - Menghitung **Uang Bulanan Terpakai** berdasarkan akumulasi bulan berjalan.
  - Menghitung **Total Pemasukan** dan **Sisa Saldo** keseluruhan.
- **Indikator Limit Harian Dinamis:** Sistem otomatis memberikan peringatan teks berwarna **merah** (*Over Limit*) apabila pengeluaran harian melampaui batas limit yang telah ditentukan.
- **Integrasi Antarmuka FXML:** Tisu antarmuka dirancang menggunakan **SceneBuilder** untuk tata letak yang bersih dan interaktif.

---

Panduan Instalasi & Menjalankan Proyek
Clone atau Download Repository Ini:

Bash
git clone https://github.com/username-kamu/ExpenseApp.git
Buka Proyek di NetBeans:

Buka NetBeans, pilih File > Open Project, lalu pilih folder ExpenseApp.

Sinkronisasi Maven:

Klik kanan pada nama proyek, lalu pilih Reload POM untuk mengunduh dependensi JavaFX secara otomatis.

Menjalankan Aplikasi (GUI):

Buka package main, klik kanan pada MainApp.java, lalu pilih Run File (Shift + F6).

Atau gunakan perintah Maven di terminal: mvn javafx:run.

---

Cara Penggunaan Aplikasi
Atur Limit Harian: Masukkan nominal batas pengeluaran harian pada kolom Limit Harian, lalu klik tombol Set Limit.

Tambah Pemasukan: Pilih tanggal, ubah jenis transaksi menjadi Pemasukan, masukkan nominal, lalu klik Simpan Transaksi.

Tambah Pengeluaran: Pilih tanggal, pilih jenis Pengeluaran beserta kategori opsinya (Makanan/Jajan/Bensin/Biaya Tak Terduga), masukkan nominal dan catatan, lalu klik Simpan Transaksi.

Pantau Indikator: Jika pengeluaran harian melewati batas limit, label uang harian terpakai akan otomatis berubah menjadi Merah disertai peringatan Melewati Limit Harian!.

---

**Scrennshot tampilan screen project Expense tracker**

<img width="347" height="446" alt="image" src="https://github.com/user-attachments/assets/e82d7473-8b8d-4845-80a6-e6f24651df8c" />
<img width="343" height="441" alt="image" src="https://github.com/user-attachments/assets/7548f16e-4d45-4737-b304-96f7369ec1ef" />

