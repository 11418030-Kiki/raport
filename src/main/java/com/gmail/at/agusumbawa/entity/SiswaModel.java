package com.gmail.at.agusumbawa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agus Suhardi on 2/7/2017.
 */
@Entity
@Table(name = "siswa")
public class SiswaModel implements Serializable {

    @Id
    private String nis;
    private String nama;
    private String gender;
    private String alamat;
    private String kelas;

    private String ajaran;
    private int smester;

    private int sakit;
    private int ijin;
    private int tk;

    private String tanggal;
    private String lokasi;
    private String tema;
    private int nilai_lapangan;

    private String wali_kelas;
    private String nip;

    private String catatan;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "siswa"
    )
    private List<BpModel> bp = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "siswa"
    )
    private List<TadarusModel> tadarus = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "siswa"
    )
    private List<NilaiModel> nilai = new ArrayList<>();

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getSakit() {
        return sakit;
    }

    public void setSakit(int sakit) {
        this.sakit = sakit;
    }

    public int getIjin() {
        return ijin;
    }

    public void setIjin(int ijin) {
        this.ijin = ijin;
    }

    public int getTk() {
        return tk;
    }

    public void setTk(int tk) {
        this.tk = tk;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getNilai_lapangan() {
        return nilai_lapangan;
    }

    public void setNilai_lapangan(int nilai_lapangan) {
        this.nilai_lapangan = nilai_lapangan;
    }

    public String getAjaran() {
        return ajaran;
    }

    public void setAjaran(String ajaran) {
        this.ajaran = ajaran;
    }

    public int getSmester() {
        return smester;
    }

    public void setSmester(int smester) {
        this.smester = smester;
    }

    public String getWali_kelas() {
        return wali_kelas;
    }

    public void setWali_kelas(String wali_kelas) {
        this.wali_kelas = wali_kelas;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public List<BpModel> getBp() {
        return bp;
    }

    public void setBp(List<BpModel> bp) {
        this.bp = bp;
    }

    public List<TadarusModel> getTadarus() {
        return tadarus;
    }

    public void setTadarus(List<TadarusModel> tadarus) {
        this.tadarus = tadarus;
    }

    public List<NilaiModel> getNilai() {
        return nilai;
    }

    public void setNilai(List<NilaiModel> nilai) {
        this.nilai = nilai;
    }
}
