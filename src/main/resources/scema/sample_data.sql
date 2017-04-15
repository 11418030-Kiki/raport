-- PEGAWAI
INSERT INTO pegawai (nip, nama, gender, agama, ttl, hp, alamat) VALUES ("p001", "Pegawai satu", "laki-laki", "islam", "jogja 2016", "78598349", "Jogja bantul");
INSERT INTO pegawai (nip, nama, gender, agama, ttl, hp, alamat) VALUES ("p002", "Pegawai dua", "laki-laki", "islam", "jogja 2013", "99999997", "sleman");
INSERT INTO pegawai (nip, nama, gender, agama, ttl, hp, alamat) VALUES ("p003", "Pegawai tiga", "perempuan", "islam", "jogja 2012", "66666666", "solo");

-- KELAS
INSERT INTO kelas (kelas, keterangan, wali_kelas) VALUES ("k001", "kelas 001", "p001");
INSERT INTO kelas (kelas, keterangan, wali_kelas) VALUES ("k002", "kelas 002", "p002");
INSERT INTO kelas (kelas, keterangan, wali_kelas) VALUES ("k003", "kelas 003", "p003");

-- SISWA
INSERT INTO siswa (nis, nama, tempat_lahir, tanggal_lahir, gender, asal_sekolah, cita_cita, jumlah_saudara, nama_ayah, alamat, agama, kelas)
VALUES ("151052043", "siswa satu", "jogja", "desember 2015", "laki-laki", "TK", "Presiden", 3, "dani", "bantul", "islam", "k001");
INSERT INTO siswa (nis, nama, tempat_lahir, tanggal_lahir, gender, asal_sekolah, cita_cita, jumlah_saudara, nama_ayah, alamat, agama, kelas)
VALUES ("s002", "siswa tiga", "jogja", "desember 2015", "laki-laki", "TK", "Presiden", 3, "dani", "bantul", "islam", "k001");
INSERT INTO siswa (nis, nama, tempat_lahir, tanggal_lahir, gender, asal_sekolah, cita_cita, jumlah_saudara, nama_ayah, alamat, agama, kelas)
VALUES ("s003", "siswa tiga", "jogja", "desember 2015", "laki-laki", "TK", "Presiden", 3, "dani", "bantul", "islam", "k001");

-- AJARAN
INSERT INTO ajaran(ajaran) VALUES ("2015/2016");
INSERT INTO ajaran(ajaran) VALUES ("2016/2017");
INSERT INTO ajaran(ajaran) VALUES ("2017/2018");

-- SMESTER
INSERT INTO smester(smester, ajaran) VALUES (1, '2015/2016');
INSERT INTO smester(smester, ajaran) VALUES (2, '2015/2016');

-- kategori
INSERT INTO kategori(kategori) VALUES ("akademis");
INSERT INTO kategori(kategori) VALUES ("hafalan");
INSERT INTO kategori(kategori) VALUES ("kepribadian");
INSERT INTO kategori(kategori) VALUES ("kurikuler");
INSERT INTO kategori(kategori) VALUES ("pembiasaan");

-- PELAJARAN akademis
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Pendidikan Kewarganegaraan", "akademis", 70, "2015/2016");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Bahasa Indonesia", "akademis", 70, "2015/2016");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Bahasa Jawa", "akademis", 70, "2015/2016");
-- PELAJARAN hafalan
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("An Nas", "hafalan", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Al falaq", "hafalan", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Al Ikhlas", "hafalan", 0, "2016/2017");
-- PELAJARAN kepribadian
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Adil", "kepribadian", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Sabar", "kepribadian", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Empati dan suka menolong", "kepribadian", 0, "2016/2017");
-- PELAJARAN  kurikuler
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Tari", "kurikuler", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Melukis", "kurikuler", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Komputer", "kurikuler", 0, "2016/2017");
-- PELAJARAN  pembiasaan
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Shalat Dhuha", "pembiasaan", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Shalat Berjama'ah", "pembiasaan", 0, "2016/2017");
INSERT INTO pelajaran(pelajaran, kategori, kkm, ajaran) VALUES ("Tadarus", "pembiasaan", 0, "2016/2017");




-- NILAI siswa 1
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n001", 80, 1, "Pendidikan Kewarganegaraan", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n002", 40, 1, "Bahasa Indonesia", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n003", 50, 1, "Bahasa Jawa", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n004", 90, 1, "An Nas", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n005", 70, 1, "Al falaq", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n006", 90, 1, "Al Ikhlas", "2016/2017", "s001");

INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n016", 90, 1, "Adil", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n026", 90, 1, "Sabar", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n036", 90, 1, "Empati", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n046", 90, 1, "Tari", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n056", 90, 1, "Melukis", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n066", 90, 1, "Komputer", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n076", 90, 1, "Shalat Dhuha", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n086", 90, 1, "Shalat Berjama'ah", "2016/2017", "s001");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n096", 90, 1, "Tadarus", "2016/2017", "s001");

















-- NILAI siswa 2
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n007", 40, 1, "Pendidikan Kewarganegaraan", "2016/2017", "s002");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n008", 50, 1, "Bahasa Indonesia", "2016/2017", "s002");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n009", 60, 1, "Bahasa Jawa", "2016/2017", "s002");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0011", 70, 1, "An Nas", "2016/2017", "s002");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0012", 80, 1, "Al falaq", "2016/2017", "s002");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0063", 90, 1, "Al Ikhlas", "2016/2017", "s002");
-- NILAI siswa 3
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0013", 10, 1, "Pendidikan Kewarganegaraan", "2016/2017", "s003");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0023", 20, 1, "Bahasa Indonesia", "2016/2017", "s003");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0033", 30, 1, "Bahasa Jawa", "2016/2017", "s003");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0043", 50, 1, "An Nas", "2016/2017", "s003");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0053", 60, 1, "Al falaq", "2016/2017", "s003");
INSERT INTO nilai(id, nilai, smester, pelajaran, ajaran, siswa) VALUES ("n0064", 97, 1, "Al Ikhlas", "2016/2017", "s003");

-- KETERANGAN
INSERT INTO keterangan(id, ijin, sakit, tk, catatan_guru, siswa, ajaran, smester) VALUES ("k01", 3, 1, 9, "catatan di sini", "s001", "2016/2017", 1);
INSERT INTO keterangan(id, ijin, sakit, tk, catatan_guru, siswa, ajaran, smester) VALUES ("k02", 0, 11, 4, "catatan di sini", "s003", "2016/2017", 1);
INSERT INTO keterangan(id, ijin, sakit, tk, catatan_guru, siswa, ajaran, smester) VALUES ("k03", 0, 2, 3, "catatan di sini", "s002", "2016/2017", 1);

-- LAPANGAN
INSERT INTO lapangan(id, lokasi, nilai, tanggal, tema, siswa, ajaran, smester) VALUES ("l001", "jogja", 70, "1 desember 2016", "belajar bersama", "s001", "2016/2017", 1);
INSERT INTO lapangan(id, lokasi, nilai, tanggal, tema, siswa, ajaran, smester) VALUES ("l002", "jogja", 70, "1 desember 2016", "belajar bersama", "s002", "2016/2017", 1);
INSERT INTO lapangan(id, lokasi, nilai, tanggal, tema, siswa, ajaran, smester) VALUES ("l003", "jogja", 70, "1 desember 2016", "belajar bersama", "s003", "2016/2017", 1);


-- bp
INSERT INTO bp(id, waktu, pristiwa, tindakan, ajaran, smester, siswa) VALUES ("b01", "01/04/2017", "bolos", "tidak ada", "2016/2017", 1, "s001");


-- tadarus
INSERT INTO tadarus(id, surat, halaman, nilai, ajaran, smester, siswa) VALUES ("t01", "An Nas", 31, 60, "2016/2017", 1, "s001");