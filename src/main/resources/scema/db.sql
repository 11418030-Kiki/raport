
CREATE TABLE siswa(
  nis  TEXT PRIMARY KEY UNIQUE NOT NULL,
  nama TEXT,
  gender TEXT,
  alamat TEXT,
  kelas  TEXT,

  sakit INTEGER,
  ijin INTEGER,
  tk INTEGER,
  catatan  TEXT,

  tanggal TEXT,
  lokasi TEXT,
  tema TEXT,
  nilai_lapangan INTEGER,

  ajaran TEXT,
  smester INTEGER,

  wali_kelas TEXT,
  nip TEXT
);



CREATE TABLE nilai (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  pelajaran TEXT,
  kategori TEXT,
  nilai INTEGER,
  kkm INTEGER,
  siswa REFERENCES siswa(nis)
);


CREATE TABLE tadarus (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  halaman INTEGER,
  nilai INTEGER,
  surat TEXT,
  siswa REFERENCES siswa(nis)
);


CREATE TABLE bp (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  pristiwa TEXT,
  tindakan TEXT,
  waktu TEXT,
  siswa REFERENCES siswa(nis)
);