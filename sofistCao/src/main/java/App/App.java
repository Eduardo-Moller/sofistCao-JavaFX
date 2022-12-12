package App;

import Model.ConnectSql;
import Model.Pets;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


 /*public class App {
    public static void main(String[] args) {
        ConnectSql banco = new ConnectSql("localhost", "3306", "sofistCaoDB", "senha123", "sofistCaoDB");
        banco.conectarBanco();
        if (banco.isStatusConexao()) {
            Pets pet = new Pets(banco.getConexao());
            try{
                pet.setTipo("Cachorro");
                pet.setNome("Alvin");
                pet.setIdade(12);
                pet.setRaca("Dachshund");
                pet.setUltimoDono("Não tem");
                pet.setDescricao("Ele mesmo");
                pet.deletarPet(1);
            }
            catch(SQLException e){
                System.out.println("Não foi possível inserir o pet "+e);
            }
        }else{
            System.out.println("Não conectado");
            System.out.println(banco.getMensagemErro());
        }
    }
}*/

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Home"), 680, 470);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    

}