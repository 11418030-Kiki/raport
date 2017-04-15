



CREATE TABLE pegawai(
  nip TEXT PRIMARY KEY UNIQUE NOT NULL,
  nama TEXT,
  gender TEXT,
  agama TEXT,
  ttl TEXT,
  hp TEXT,
  alamat TEXT
);


CREATE TABLE kelas(
  kelas  TEXT PRIMARY KEY UNIQUE NOT NULL,
  keterangan TEXT,
  wali_kelas REFERENCES pegawai(nip)
);


CREATE TABLE siswa(
  nis  TEXT PRIMARY KEY UNIQUE NOT NULL,
  nama TEXT,
  tempat_lahir TEXT,
  tanggal_lahir TEXT,
  gender TEXT,
  asal_sekolah TEXT,
  cita_cita TEXT,
  jumlah_saudara INTEGER,
  nama_ayah TEXT,
  alamat TEXT,
  agama TEXT,
  kelas  TEXT REFERENCES kelas(kelas)
);


CREATE TABLE ajaran(
  ajaran  TEXT PRIMARY KEY UNIQUE NOT NULL
);

CREATE TABLE pelajaran (
  pelajaran TEXT PRIMARY KEY UNIQUE NOT NULL,
  kategori  TEXT REFERENCES kategori(kategori),
  kkm INTEGER,
  ajaran REFERENCES ajaran(ajaran),
  smester REFERENCES smester(smester)
);


CREATE TABLE smester(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  smester INTEGER NOT NULL,
  ajaran REFERENCES ajaran(ajaran)
);

CREATE TABLE nilai (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  nilai INTEGER,
  pelajaran REFERENCES pelajaran(pelajaran),
  ajaran REFERENCES ajaran (ajaran),
  smester INTEGER REFERENCES smester(smester),
  siswa REFERENCES siswa(nis)
);


CREATE TABLE keterangan (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  ijin TEXT,
  sakit TEXT,
  tk TEXT,
  catatan_guru TEXT,
  ajaran REFERENCES ajaran (ajaran),
  smester INTEGER REFERENCES smester(smester),
  siswa REFERENCES siswa(nis) UNIQUE
);


CREATE TABLE lapangan (
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  lokasi TEXT,
  nilai INTEGER,
  tanggal TEXT,
  tema TEXT,
  ajaran REFERENCES ajaran (ajaran),
  smester INTEGER REFERENCES smester(smester),
  siswa REFERENCES siswa(nis) UNIQUE
);



CREATE TABLE bp(
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  waktu TEXT,
  pristiwa TEXT,
  tindakan TEXT,
  ajaran REFERENCES ajaran (ajaran),
  smester INTEGER REFERENCES smester(smester),
  siswa REFERENCES siswa(nis) UNIQUE
);

CREATE TABLE tadarus(
  id TEXT PRIMARY KEY UNIQUE NOT NULL,
  surat TEXT,
  halaman INTEGER,
  nilai INTEGER,
  ajaran REFERENCES ajaran (ajaran),
  smester INTEGER REFERENCES smester(smester),
  siswa REFERENCES siswa(nis) UNIQUE
);

CREATE TABLE kategori(
  kategori TEXT PRIMARY KEY UNIQUE NOT NULL);




