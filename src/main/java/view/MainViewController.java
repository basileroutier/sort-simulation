package view;

import controller.Controller;
import model.ColumnParsingTable;
import model.LevelSort;
import model.SeriesSort;
import model.SortingMethod;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Model;

public class MainViewController implements Initializable, PropertyChangeListener {

    Controller controller;

    @FXML
    private Spinner threadSpinner = new Spinner();

    @FXML
    private ChoiceBox<SortingMethod> sortChoice = new ChoiceBox<>();

    @FXML
    private ChoiceBox<LevelSort> configurationChoice = new ChoiceBox<>();

    @FXML
    private TableColumn<ColumnParsingTable, String> nameCol;

    @FXML
    private TableColumn<ColumnParsingTable, Integer> sizeCol;

    @FXML
    private TableColumn<ColumnParsingTable, Integer> swapCol;

    @FXML
    private TableColumn<ColumnParsingTable, Float> durationCol;

    @FXML
    private TableView table = new TableView();

    @FXML
    private Label leftStatus;

    @FXML
    private Label rightStatus;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private LineChart<Integer, Long> chart;
    
    @FXML
    private MenuItem logsMenu;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        boolean sortChoiceEmpty = sortChoice.getSelectionModel().isEmpty();
        boolean configurationChoiceEmpy = sortChoice.getSelectionModel().isEmpty();
        if (!sortChoiceEmpty || !configurationChoiceEmpy) {
            XYChart.Series seriesOperation = new XYChart.Series();
            chart.getData().add(seriesOperation);

            controller.play((int) threadSpinner.getValue(), sortChoice.getValue(), configurationChoice.getValue());
        }

        //System.out.println("Ajout d'une colonne dans la table");
//        Student std = new Student(Integer.parseInt(num.getText()), firstname.getText(),lastname.getText());
//        table.getItems().add(std);
    }
    
    @FXML
    private void handleLogs(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/logSort.fxml"));
        Parent root = loader.load();
        
        LogViewSortController lsc = loader.getController();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public MainViewController() {

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        factory.setWrapAround(true);
        threadSpinner.setValueFactory(factory);
        threadSpinner.getValueFactory().setValue(1);

        sortChoice.setItems(FXCollections.observableArrayList(SortingMethod.values()));
        configurationChoice.setItems(FXCollections.observableArrayList(LevelSort.values()));

        nameCol.setCellValueFactory(new PropertyValueFactory<>("method"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        swapCol.setCellValueFactory(new PropertyValueFactory<>("operation"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
    }

    /**
     * For the Observateur to get all the property that observable send
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String eventChange = evt.getPropertyName();
        List<Object> infoTable;
        List<Object> infoThread;
        switch (eventChange) {
            case SeriesSort.PROPERTY_ACTION_SORTING_FINISH:
                infoTable = (List) evt.getNewValue();
                infoThread = (List) infoTable.get(4);
                ColumnParsingTable std = new ColumnParsingTable((SortingMethod) infoTable.get(0), (int) infoTable.get(1), (int) infoTable.get(2), (long) infoTable.get(3));
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        chart.getData().get(chart.getData().size() - 1).getData().add(new XYChart.Data((int) infoTable.get(1), (int) infoTable.get(2)));

                        leftStatus.setText("Threads actifs : " + infoThread.get(0));
                        rightStatus.setText("Dernière execution | Début : " + infoThread.get(1) + " - Fin : " + infoThread.get(2) + " - Durée : Duration : " + infoThread.get(3) + " ms");
                        
                        table.getItems().add(std);
                    }
                });
                break;
            default:
                System.out.println("bouhhh");
        }
    }
}
