package com.gmail.at.agusumbawa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Agus Suhardi on 2/9/2017.
 */
@Entity
@Table(name = "nilai")
public class NilaiModel implements Serializable {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String pelajaran;
    private String kategori;
    private int nilai;
    private int kkm;
    @Transient
    private String ket;

    @ManyToOne
    @JoinColumn(name = "siswa", nullable = false)
    private SiswaModel siswa;


    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPelajaran() {
        return pelajaran;
    }

    public void setPelajaran(String pelajaran) {
        this.pelajaran = pelajaran;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getKkm() {
        return kkm;
    }

    public void setKkm(int kkm) {
        this.kkm = kkm;
    }

    public SiswaModel getSiswa() {
        return siswa;
    }

    public void setSiswa(SiswaModel siswa) {
        this.siswa = siswa;
    }
}
