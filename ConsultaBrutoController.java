/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package simulacro.pkg4;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
public class ConsultaBrutoController implements Initializable {

    @FXML
    private TextField campoconsulta;
    @FXML
    private TextArea areamostrar;
    CiudadModel cm=new CiudadModel();
    ArrayList<Ciudad> alma=new ArrayList();
    @FXML
    private Button botonHacer;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void realizarConsulta(ActionEvent event) {
         areamostrar.clear();
        try {

            String consultabaja = campoconsulta.getText().toLowerCase();
            if (consultabaja.startsWith("select")) {
                alma = cm.MostrarTodo(campoconsulta.getText());
                if (alma.isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText("Error");
                    a.setContentText("La consulta está mal o está vacia la tabla de datos");
                    a.showAndWait();
                    areamostrar.setText(DBUtil1.getDBUtil().error);

                } else {
                    for (Ciudad c : alma) {
                        areamostrar.setText(areamostrar.getText() + c.toString() + "\n");

                    }

                }

            } else if (consultabaja.startsWith("insert") || consultabaja.startsWith("delete") || consultabaja.startsWith("update")) {
                cm.ejecutar( campoconsulta.getText());

            } else {

                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Error");
                a.setContentText("La consulta está mal");
                a.showAndWait();
                areamostrar.setText(DBUtil1.getDBUtil().error);
            }

        } catch (Exception e) {

        }
        
    }  
    
}
