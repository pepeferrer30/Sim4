

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConfController implements Initializable {

    @FXML
    private TextField campoUbicacion;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoServidor;
    @FXML
    private TextField campoPuerto;
    @FXML
    private TextField campoBdd;
    @FXML
    private TextField campoUsuario;
    @FXML
    private TextField CampoContraseña;
    @FXML
    private Button botonActualizar;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         campoUsuario.setText(DBUtil1.getDBUtil().nombreUsuario);
      CampoContraseña.setText(DBUtil1.getDBUtil().password);
      campoPuerto.setText(DBUtil1.getDBUtil().puerto);
      campoServidor.setText(DBUtil1.getDBUtil().host);
      campoBdd.setText(DBUtil1.getDBUtil().bdd);
    }    

    @FXML
    private void actualizar(ActionEvent event) {
        DBUtil1.getDBUtil().password=CampoContraseña.getText();
        DBUtil1.getDBUtil().nombreUsuario=campoUsuario.getText();
        DBUtil1.getDBUtil().host=campoServidor.getText();
        DBUtil1.getDBUtil().puerto=campoPuerto.getText();
        DBUtil1.getDBUtil().bdd=campoBdd.getText();
    }
}
