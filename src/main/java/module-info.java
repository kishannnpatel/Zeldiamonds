module universite_paris8.iut.kpatel.zeldiamond {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens universite_paris8.iut.kpatel.zeldiamond to javafx.fxml;
    exports universite_paris8.iut.kpatel.zeldiamond;
}