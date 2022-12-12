/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import App.App;
import Model.ConnectSql;
import Model.Pets;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class VisualizarController {

    @FXML
    private TableView<Pets> tableViewPets;

    @FXML
    private TableColumn<Pets, String> nomeColum;

    @FXML
    private TableColumn<Pets, String> tipoColum;

    @FXML
    private TableColumn<Pets, Integer> idadeColum;

    @FXML
    private TableColumn<Pets, String> racaColum;

    @FXML
    private TableColumn<Pets, Integer> idColum;

    private ObservableList<Pets> observablelistPets;

    private void visualizar() {
        ConnectSql banco = new ConnectSql("localhost", "3306", "sofistCaoDB", "senha123", "sofistCaoDB");
        banco.conectarBanco();
        if (banco.isStatusConexao()) {
            Pets pet = new Pets(banco.getConexao());
            try {
                ResultSet dados = pet.listarPets();
                ObservableList<Pets> lista = FXCollections.observableArrayList();

                while (dados.next()) {
                    Pets p = new Pets(dados.getInt("idPet"), dados.getString("tipoDePet"), dados.getString("nome"), dados.getInt("idade"), dados.getString("raca"), banco.getConexao());
                    lista.add(p);
                }

                idColum.setCellValueFactory(new PropertyValueFactory("idPet"));
                nomeColum.setCellValueFactory(new PropertyValueFactory("nome"));
                tipoColum.setCellValueFactory(new PropertyValueFactory("tipoDePet"));
                idadeColum.setCellValueFactory(new PropertyValueFactory("idade"));
                racaColum.setCellValueFactory(new PropertyValueFactory("raca"));
                tableViewPets.setItems(lista);

            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e);
            }
        } else {
            System.out.println("Não conectado");
            System.out.println(banco.getMensagemErro());
        }
    }

    @FXML
    void initialize() throws SQLException {
        visualizar();
    }
    
    @FXML
    void btnDeletar(ActionEvent event) throws SQLException{
        Pets p = tableViewPets.getSelectionModel().getSelectedItem();
        p.deletarPet(p.getIdPet());
        visualizar();
    }
    
    @FXML
    void btnVoltar(ActionEvent event) throws IOException {
        App.setRoot("Home");
    }

}
