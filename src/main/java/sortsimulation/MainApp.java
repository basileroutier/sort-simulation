package sortsimulation;

import Controller.Controller;
import Model.LevelSort;
import Model.Model;
import Model.SeriesSort;
import Model.Sort;
import Model.SortingMethod;
import Model.ThreadSort;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.MainViewController;

public class MainApp
        extends Application {

    final static DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sort.fxml"));
        Parent root = loader.load();
        
        MainViewController mv = loader.getController();
        Model model = new Model(mv);
        Controller controller = new Controller(mv, model);
        mv.setController(controller);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
