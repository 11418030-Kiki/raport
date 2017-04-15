package com.gmail.at.agusumbawa.controller.nilai;

import com.gmail.at.agusumbawa.Main;
import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.SiswaDao;
import com.gmail.at.agusumbawa.dao.TadarusDao;
import com.gmail.at.agusumbawa.entity.SiswaModel;
import com.gmail.at.agusumbawa.entity.TadarusModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Agus Suhardi on 3/5/2017.
 */
public class TadarusController implements Initializable {
    public TableView<TadarusModel> tblTadarus;
    public TableColumn<TadarusModel, String> columnNama;
    public TableColumn<TadarusModel, String> columnSurat;
    public TableColumn<TadarusModel, Integer> columnHalaman;
    public TableColumn<TadarusModel, Integer> columnNilai;
    public TextField txtSurat;
    public TextField txtHalamn;
    public TextField txtNilai;
    public TextField txtNis;

    TadarusDao dao = HibernateUtil.getTadarusDao();
    SiswaDao daoSiswa = HibernateUtil.getSiswaDao();
    private Main application;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        columnNama.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TadarusModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TadarusModel, String> param) {
                return new SimpleStringProperty(param.getValue().getSiswa().getNama());
            }
        });

        columnSurat.setCellValueFactory(new PropertyValueFactory<TadarusModel, String>("surat"));
        columnHalaman.setCellValueFactory(new PropertyValueFactory<TadarusModel, Integer>("halaman"));
        columnNilai.setCellValueFactory(new PropertyValueFactory<TadarusModel, Integer>("nilai"));

        tblTadarus.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends TadarusModel> values, TadarusModel oldValue, TadarusModel newValue) -> {
                    setField(newValue);
                });

    }

    public void setField(TadarusModel data) {
        txtNis.setText(data.getSiswa().getNis());
        txtSurat.setText(data.getSurat());
        txtHalamn.setText(String.valueOf(data.getHalaman()));
        txtNilai.setText(String.valueOf(data.getNilai()));
    }

    public void loadData(String nis) {
        tblTadarus.getItems().clear();
        tblTadarus.getItems().addAll(dao.findByNis(nis));
        txtNis.setText(nis);
    }

    public void doBack(ActionEvent actionEvent) {
        this.application.showNilaiSiswa();
    }

    public void doSave(ActionEvent actionEvent) {
        SiswaModel s = daoSiswa.findById(txtNis.getText());
        TadarusModel data = new TadarusModel();

        data.setSiswa(s);
        data.setSurat(txtSurat.getText());
        data.setHalaman(Integer.parseInt(txtHalamn.getText()));
        data.setNilai(Integer.parseInt(txtNilai.getText()));
        dao.save(data);

        txtSurat.setText(null);
        txtNilai.setText(null);
        txtHalamn.setText(null);
        loadData(txtNis.getText());
    }

    public void setApplication(Main application) {
        this.application = application;
    }
}
