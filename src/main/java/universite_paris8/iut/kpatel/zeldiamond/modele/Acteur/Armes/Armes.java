package universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Armes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.kpatel.zeldiamond.modele.Acteur.Acteur;

public class Armes extends Acteur {
  private IntegerProperty x;
  private IntegerProperty y;
  private int degats;

  public Armes ( int x , int y , int degats){
      super(x , y , degats);
      this.x = new SimpleIntegerProperty(x);
      this.y = new SimpleIntegerProperty(y);
      this.degats = degats;
  }


}
