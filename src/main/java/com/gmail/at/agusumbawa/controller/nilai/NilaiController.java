package com.gmail.at.agusumbawa.controller.nilai;

import com.gmail.at.agusumbawa.Main;
import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.NilaiDao;
import com.gmail.at.agusumbawa.entity.NilaiModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class NilaiController implements Initializable {
    public ComboBox comboKategori;
    public TextField txtNis;
    public TableView<NilaiModel> tblNilai;
    public TableColumn<NilaiModel, String> columnNama;
    public TableColumn<NilaiModel, String> columnPelajaran;
    public TableColumn<NilaiModel, Integer> columnNilai;


    NilaiDao dao = HibernateUtil.getNilaiDao();
    private Main application;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnNama.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NilaiModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<NilaiModel, String> param) {
                return new SimpleStringProperty(param.getValue().getSiswa().getNama());
            }
        });


        columnPelajaran.setCellValueFactory(new PropertyValueFactory<NilaiModel, String>("pelajaran"));
        columnNilai.setCellValueFactory(new PropertyValueFactory<NilaiModel, Integer>("nilai"));


        columnPelajaran.setCellFactory(TextFieldTableCell.<NilaiModel>forTableColumn());
        columnPelajaran.setOnEditCommit(event -> {

            NilaiModel h = dao.findById(event.getRowValue().getId());
            h.setNilai(Integer.parseInt(event.getNewValue()));
            dao.update(h);
            loadData(txtNis.getText(), comboKategori.getValue().toString());

        });


        tblNilai.setEditable(true);
    }

    public void loadData(String nis, String kategori) {
        comboKategori.getItems().clear();
        comboKategori.getItems().setAll(loadKategori());
        comboKategori.setValue(kategori);

        tblNilai.getItems().clear();
        tblNilai.getItems().addAll(dao.findByNis(nis, kategori));
        txtNis.setText(nis);
    }


    List<String> loadKategori() {
        List<String> data = new ArrayList<>();

        List<NilaiModel> l = dao.findKategori();
        for (int i = 0; i < l.size(); i++) {
            data.add(l.get(i).getKategori());
        }
        return data;
    }


    public void doBack(ActionEvent actionEvent) {
        this.application.showNilaiSiswa();
    }

    public void setApplication(Main application) {
        this.application = application;
    }

    public void onSelectKategori(ActionEvent actionEvent) {
        loadData(txtNis.getText(), comboKategori.getValue().toString());
    }
}
