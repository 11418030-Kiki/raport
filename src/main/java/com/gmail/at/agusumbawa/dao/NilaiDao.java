package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.NilaiModel;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/9/2017.
 */
public interface NilaiDao {
    public void save(NilaiModel data);
    public void update(NilaiModel data);
    public void delete(NilaiModel data);
    public NilaiModel findById(String id);
    public List<NilaiModel> findAll();

    public NilaiModel findByKategory(String kategori);


    public List<NilaiModel> findByNis(String siswa, String kategori);

    public List<NilaiModel> findByNis(String siswa);


    public List<NilaiModel> findKategori();

    public void deleteAll();

}
