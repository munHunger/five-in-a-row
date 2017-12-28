package se.munhunger.fir;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Point;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Marcus Münger
 */
public class GUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    private GridPane root = new GridPane();
    private Board b = new Board();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Noughts and crosses");

        root.setGridLinesVisible(true);
        for(int x = 0; x < 25; x++)
            for(int y = 0; y < 25; y++)
                root.add(getLabel(""), x, y);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Solver.solve(b);
                Platform.runLater(() -> {
                    for (Point p : b.o)
                        root.add(getLabel("O"), p.x, p.y);
                    for (Point p : b.x)
                        root.add(getLabel("X"), p.x, p.y);
                });
            }
        }, 0, 1000);
    }

    private Label getLabel(String text) {
        Label label = new Label(text);
        label.setMinHeight(20);
        label.setMinWidth(20);
        label.setTextAlignment(TextAlignment.CENTER);
        return label;
    }
}
