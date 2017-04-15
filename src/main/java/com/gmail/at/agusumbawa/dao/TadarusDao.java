package com.gmail.at.agusumbawa.dao;

import com.gmail.at.agusumbawa.entity.BpModel;
import com.gmail.at.agusumbawa.entity.TadarusModel;

import java.util.List;

/**
 * Created by Agus Suhardi on 2/18/2017.
 */
public interface TadarusDao {
    public void save(TadarusModel data);
    public void update(TadarusModel data);
    public void delete(TadarusModel data);
    public TadarusModel findById(String id);
    public List<TadarusModel> findAll();

    public List<TadarusModel> findByNis(String s);

    public void deleteAll();
}
