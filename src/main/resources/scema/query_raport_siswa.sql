-- header
  SELECT
  siswa.nama,
  siswa.nis,
  siswa.alamat,
   kelas.kelas,
   nilai.smester,
   ajaran.ajaran
  FROM
    pegawai JOIN kelas ON pegawai.nip = kelas.wali_kelas
    JOIN siswa ON kelas.kelas = siswa.kelas
    JOIN nilai ON siswa.nis = nilai.siswa
    JOIN pelajaran ON nilai.pelajaran = pelajaran.pelajaran
    JOIN ajaran ON nilai.ajaran = ajaran.ajaran
  WHERE
    ajaran.ajaran='2016/2017' AND
    pelajaran.kategori='akademis' AND
    nilai.smester=1;

-- akademis
SELECT
pelajaran.kategori,
pelajaran.kkm,
nilai.pelajaran,
nilai.nilai
FROM
pegawai JOIN kelas ON pegawai.nip = kelas.wali_kelas
    JOIN siswa ON kelas.kelas = siswa.kelas
    JOIN nilai ON siswa.nis = nilai.siswa
    JOIN pelajaran ON nilai.pelajaran = pelajaran.pelajaran
    JOIN ajaran ON nilai.ajaran = ajaran.ajaran
WHERE
ajaran.ajaran='2016/2017' AND
    pelajaran.kategori='akademis' AND
    nilai.smester=1 AND
siswa.nis='s001'
ORDER BY siswa.nis