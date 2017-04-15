package com.gmail.at.agusumbawa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Agus Suhardi on 2/18/2017.
 */
@Entity
@Table(name = "tadarus")
public class TadarusModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String surat;
    private int halaman;
    private int nilai;


    @ManyToOne
    @JoinColumn(name = "siswa", nullable = false)
    private SiswaModel siswa;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurat() {
        return surat;
    }

    public void setSurat(String surat) {
        this.surat = surat;
    }

    public int getHalaman() {
        return halaman;
    }

    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public SiswaModel getSiswa() {
        return siswa;
    }

    public void setSiswa(SiswaModel siswa) {
        this.siswa = siswa;
    }
}
