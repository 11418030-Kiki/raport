package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.BpModel;
import com.gmail.at.agusumbawa.entity.SiswaModel;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/18/2017.
 */
public interface BpDao {
    public void save(BpModel data);
    public void update(BpModel data);
    public void delete(BpModel data);
    public BpModel findById(String id);
    public List<BpModel> findAll();


    public List<BpModel> findByNis(String s);

    public void deleteAll();


}
