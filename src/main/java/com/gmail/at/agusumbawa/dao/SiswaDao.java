package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.SiswaModel;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/9/2017.
 */
public interface SiswaDao {
    public void save(SiswaModel data);
    public void update(SiswaModel data);
    public void delete(SiswaModel data);
    public SiswaModel findById(String id);
    public List<SiswaModel> findAll();

    public List<SiswaModel> findAll(String id);


    public List report();

    public void deleteAll();
}
