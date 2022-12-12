/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import App.App;
import Model.Adotados;
import Model.Cliente;
import Model.ConnectSql;
import Model.Pets;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class AdotarController {


    @FXML
    private TextField idPetInp;

    @FXML
    private TextField nomeInp;

    @FXML
    private DatePicker dataNascInp;

    @FXML
    private TextField cpfInp;
    
    @FXML
    private TextField celularInp;

    @FXML
    private TextField cepInp;

    @FXML
    private TextField ocupacaoInp;
    
    @FXML
    private Label lblPetResultado;

    @FXML
    void btnVoltar(ActionEvent event) throws IOException {
        App.setRoot("Home");
    }
    
    @FXML
    void btnAdotar(ActionEvent event) {
        
        ConnectSql banco = new ConnectSql("localhost", "3306", "sofistCaoDB", "senha123", "sofistCaoDB");
        banco.conectarBanco();
        if (banco.isStatusConexao()) {
            Cliente cliente = new Cliente(banco.getConexao());
            try{
            
            cliente.setNome(nomeInp.getText());
            cliente.setDataNasc(dataNascInp.getValue());
            cliente.setCpf(cpfInp.getText());
            cliente.setCelular(celularInp.getText());
            cliente.setCep(cepInp.getText());
            cliente.setOcupacao(ocupacaoInp.getText());
            cliente.inserirCliente();
            
            
            }catch(SQLException e){
                System.out.println("SQL Exception: +e");
            }
            
           
            Pets pet = new Pets(banco.getConexao());
            try{
                Pets dados =  pet.pegarNomeRacaPet(Integer.parseInt(idPetInp.getText()));
                LocalDate hoje = LocalDate.now();
                
                String tipoPet = dados.getTipoDePet();
                String nomePet = dados.getNome();
                String racaPet = dados.getRaca();
                Adotados adotado = new Adotados(banco.getConexao());
                adotado.setNomeDoPet(nomePet);
                adotado.setRacaDoPet(racaPet);
                adotado.setTipoDoPet(tipoPet);
                adotado.setIdCliente(cliente.getIdCliente());
                adotado.setDataAdocao(hoje.toString());
                adotado.inserirPetAdotado();
                pet.deletarPet(Integer.parseInt(idPetInp.getText()));
                lblPetResultado.setText("Pet adotado com sucesso!");
            }
            catch(SQLException e){
                System.out.println("SQL Exception: "+e);
            }
        }else{
            System.out.println("Não conectado");
            System.out.println(banco.getMensagemErro());
        }
    }
    }

    

