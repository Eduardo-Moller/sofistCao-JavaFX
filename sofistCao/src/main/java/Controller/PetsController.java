package Controller;

import App.App;
import Model.ConnectSql;
import Model.Pets;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PetsController {

    @FXML
    private TextField nomeInput;

    @FXML
    private TextField tipoInput;

    @FXML
    private TextField idedeInput;

    @FXML
    private TextField racaInput;

    @FXML
    private TextField ultimodonoInput;

    @FXML
    private TextArea descricaoInput;
    
    @FXML
    private Label lblSucesso;
    
    @FXML
    private Button cadastrarBtn;
    
    @FXML
    private Button btnVoltar;

    @FXML
    void btnCadastrarAction(ActionEvent event){
        /*String nome = nomeInput.getText();
        String tipo = tipoInput.getText();
        int idade = idedeInput.get();
        String raca = racaInput.getText();
        String UltimoDono = ultimodonoInput.getText();
        String descricao = descricaoInput.getText();*/
        
        ConnectSql banco = new ConnectSql("localhost", "3306", "sofistCaoDB", "senha123", "sofistCaoDB");
        banco.conectarBanco();
        if (banco.isStatusConexao()) {
            Pets pet = new Pets(banco.getConexao());
            try{
                pet.setNome(nomeInput.getText());
                pet.setTipoDePet(tipoInput.getText());
                pet.setIdade(Integer.parseInt(idedeInput.getText()));
                pet.setRaca(racaInput.getText());
                pet.setUltimoDono(ultimodonoInput.getText());
                pet.setDescricao(descricaoInput.getText());
                pet.inserirPet();
                lblSucesso.setText("Cadastrado com sucesso!");
                
            }
            catch(SQLException e){
                System.out.println("SQL Exception: "+e);
            }
        }else{
            System.out.println("Não conectado");
            System.out.println(banco.getMensagemErro());
        }
    }
    
    @FXML
    void btnVoltarAction(ActionEvent event) throws IOException {
        App.setRoot("Home");
    }
}