package Controller;

import App.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button cadastrarBtn;

    @FXML
    private Button VisulizarBtn;

    @FXML
    private Button adotarBtn;
    
    
    @FXML
    void BtnCadastrarRedirecionar(ActionEvent event) throws IOException {
        App.setRoot("Cadastrar");
    }
    
    @FXML
    void BtnAdotarRedirecionar(ActionEvent event) throws IOException {
        App.setRoot("Adotar");
    }
    
    @FXML
    void BtnVisualizarRedirecionar(ActionEvent event) throws IOException {
        App.setRoot("Visualizar");
    }
    
}
