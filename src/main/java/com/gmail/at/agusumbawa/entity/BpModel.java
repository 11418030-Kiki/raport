package com.gmail.at.agusumbawa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Agus Suhardi on 2/16/2017.
 */
@Entity
@Table(name = "bp")
public class BpModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String waktu;
    private String pristiwa;
    private String tindakan;

    @ManyToOne
    @JoinColumn(name = "siswa", nullable = false)
    private SiswaModel siswa;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getPristiwa() {
        return pristiwa;
    }

    public void setPristiwa(String pristiwa) {
        this.pristiwa = pristiwa;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }

    public SiswaModel getSiswa() {
        return siswa;
    }

    public void setSiswa(SiswaModel siswa) {
        this.siswa = siswa;
    }
}
