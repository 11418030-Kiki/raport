INSERT INTO pegawai(nip, nama, gender, agama, ttl, hp, alamat) VALUES ("n001", "Ahmad Yadi", "pria", "Islam", "Sumbawa", "03583048", "Indonesia");


INSERT INTO kelas(kelas, keterangan, wali_kelas) VALUES ("1A", "Kelas Paling Belakang", "n001");


INSERT INTO ajaran(ajaran) VALUES ("2016/2017");


INSERT INTO smester(smester, ajaran) VALUES (1, "2016/2017");

INSERT INTO kategori(kategori)VALUES ("akademis");

INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran, smester) VALUES ("Bahasa Indonesia", "akademis", 10, "2016/2017", 1);

INSERT INTO siswa(nis, nama, tempat_lahir, tanggal_lahir, gender, asal_sekolah, cita_cita, jumlah_saudara, nama_ayah, alamat, agama, kelas)
 VALUES ("s001", "Agus Suhardi", "jurumapin", "1 agustus", "pria", "smk", "programming", 6, "ahmad", "Sumbawa", "islam", "1A");

INSERT INTO nilai(id, nilai, pelajaran, ajaran, smester, siswa) VALUES ("n01", 40, "Bahasa Indonesia", "2016/2017", 1, "s001");


insert into nilai (ajaran, nilai, pelajaran, siswa, smster, id) values (?, ?, ?, ?, ?, ?)
