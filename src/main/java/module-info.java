module universite_paris8.iut.kpatel.zeldiamond {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens universite_paris8.iut.kpatel.zeldiamond to javafx.fxml;
    exports universite_paris8.iut.kpatel.zeldiamond.modele;
    exports universite_paris8.iut.kpatel.zeldiamond.controller;
    opens universite_paris8.iut.kpatel.zeldiamond.controller to javafx.fxml;
    exports universite_paris8.iut.kpatel.zeldiamond;
    exports universite_paris8.iut.kpatel.zeldiamond.modele.Acteur;
}