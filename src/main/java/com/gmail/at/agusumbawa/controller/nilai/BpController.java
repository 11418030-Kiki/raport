package com.gmail.at.agusumbawa.controller.nilai;

import com.gmail.at.agusumbawa.Main;
import com.gmail.at.agusumbawa.config.HibernateUtil;
import com.gmail.at.agusumbawa.dao.BpDao;
import com.gmail.at.agusumbawa.entity.BpModel;
import com.gmail.at.agusumbawa.entity.SiswaModel;
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
public class BpController implements Initializable {

    public TableView<BpModel> tblBp;
    public TableColumn<BpModel, String> columnNama;
    public TableColumn<BpModel, String> columnPeristiwa;
    public TextField txtWaktu;
    public TextField txtPeristiwa;
    public TextField txtTindak;
    public TextField txtNis;

    BpDao dao = HibernateUtil.getBpDao();
    private Main application;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnNama.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BpModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BpModel, String> param) {
                return new SimpleStringProperty(param.getValue().getSiswa().getNama());
            }
        });

        columnPeristiwa.setCellValueFactory(new PropertyValueFactory<BpModel, String>("pristiwa"));

        tblBp.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends BpModel> values, BpModel oldValue, BpModel newValue) -> {
                    setField(newValue);
                });



    }

    public void setField(BpModel data) {
        txtNis.setText(data.getSiswa().getNis());
        txtPeristiwa.setText(data.getPristiwa());
        txtTindak.setText(data.getTindakan());
        txtWaktu.setText(data.getWaktu());
    }

    public void loadData(String nis) {
        tblBp.getItems().clear();
        tblBp.getItems().addAll(dao.findByNis(nis));
        txtNis.setText(nis);
    }



    public void doBack(ActionEvent actionEvent) {
        this.application.showNilaiSiswa();
    }

    public void doSave(ActionEvent actionEvent) {
        BpModel data = new BpModel();
        SiswaModel s = new SiswaModel();
        s.setNis(txtNis.getText());

        data.setSiswa(s);
        data.setPristiwa(txtPeristiwa.getText());
        data.setTindakan(txtTindak.getText());
        data.setWaktu(txtWaktu.getText());

        dao.save(data);
        loadData(txtNis.getText());
        txtWaktu.setText(null);
        txtTindak.setText(null);
        txtPeristiwa.setText(null);
    }

    public void setApplication(Main application) {
        this.application = application;
    }
}
