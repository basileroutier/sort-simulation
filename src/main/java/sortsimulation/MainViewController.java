package sortsimulation;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController implements Initializable{

    @FXML
    private TextField num;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;
    
    @FXML
    private TableView table;
    
    
    
    

//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("Ajout d'une colonne dans la table");
//        Student std = new Student(Integer.parseInt(num.getText()), firstname.getText(),lastname.getText());
//        table.getItems().add(std);
//    }

    public MainViewController() {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
//        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
//        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
    }
}
