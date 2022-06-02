/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.SimulationDto;
import model.repository.SimulationRepository;
import model.repository.exception.RepositoryException;

/**
 * Controller class for FXML file
 */
public class LogViewSortController implements Initializable {

    private SimulationRepository simulationRepository;

    @FXML
    private TableColumn<ColumnLogParsingTable, String> timeStamp;

    @FXML
    private TableColumn<ColumnLogParsingTable, String> sortType;

    @FXML
    private TableColumn<ColumnLogParsingTable, Integer> maxSize;

    @FXML
    private TableView tableLog = new TableView();

    public LogViewSortController() {
        simulationRepository = SimulationRepository.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeStamp.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));
        sortType.setCellValueFactory(new PropertyValueFactory<>("sortType"));
        maxSize.setCellValueFactory(new PropertyValueFactory<>("maxSize"));

        List<SimulationDto> listSimuDto = null;
        try {
            listSimuDto = simulationRepository.getAll();
        } catch (RepositoryException ex) {
            Logger.getLogger(LogViewSortController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<ColumnLogParsingTable> listColLog = new ArrayList<>();
        for (SimulationDto simu : listSimuDto) {
            listColLog.add(new ColumnLogParsingTable(simu.getTimestamp(), simu.getSortType(), simu.getMaxSize()));
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tableLog.getItems().addAll(listColLog);
            }
        });

    }

}
