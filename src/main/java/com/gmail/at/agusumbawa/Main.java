package com.gmail.at.agusumbawa;

import com.gmail.at.agusumbawa.controller.cetak.CetakController;
import com.gmail.at.agusumbawa.controller.cetak.CetakSemuaController;
import com.gmail.at.agusumbawa.controller.HomeController;
import com.gmail.at.agusumbawa.controller.master.SiswaController;
import com.gmail.at.agusumbawa.controller.nilai.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Agus Suhardi on 2/7/2017.
 */
public class Main extends Application {


    private Stage primariStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primariStage = primaryStage;
        showHome();
//        showCetak();
//        showNilai("151052043");


    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }


    public Initializable getController(String fxml) {


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);

            //screen auto resolusi
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            primariStage.setX(bounds.getMinX());
            primariStage.setY(bounds.getMinY());
            primariStage.setWidth(bounds.getWidth());
            primariStage.setHeight(bounds.getHeight());


            primariStage.setScene(scene);
            primariStage.show();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showHome() {
        HomeController controller = (HomeController) getController("/view/Home.fxml");
        controller.setApplication(this);
    }

    public void showSiswa() {
        SiswaController controller = (SiswaController) getController("/view/master/Siswa.fxml");
        controller.setApplication(this);
    }


    public void showNilaiSiswa() {
        NilaiSiswaController controller = (NilaiSiswaController) getController("/view/nilai/NilaiSiswa.fxml");
        controller.setApplication(this);
    }


    public void cetakSemua() {
        CetakSemuaController controller = (CetakSemuaController) getController("/view/cetak/CetakSemua.fxml");
        controller.setApplication(this);
    }


    public void showBP(String nis) {
        BpController controller = (BpController) getController("/view/nilai/BP.fxml");
        controller.setApplication(this);
        controller.loadData(nis);
    }

    public void showTadarus(String nis) {
        TadarusController controller = (TadarusController) getController("/view/nilai/Tadarus.fxml");
        controller.setApplication(this);
        controller.loadData(nis);
    }

    public void showNilai(String nis) {
        NilaiController controller = (NilaiController) getController("/view/nilai/Nilai.fxml");
        controller.setApplication(this);
        controller.loadData(nis, "akademis");
    }

    public void showCetak() {
        CetakController controller = (CetakController) getController("/view/cetak/Cetak.fxml");
        controller.setApplication(this);
    }
}
