package Star;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import static Star.StarClient.*;

public class Star extends Application {
    public static Circle circle = new Circle(x,y,r);

    public static void main(String...args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        Pane root = new Pane();

        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawStarShape(gc);

        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 600, 600, Color.WHITESMOKE);

        stage.setTitle("Star");
        stage.setScene(scene);
        stage.show();
    }

    private void drawStarShape(GraphicsContext gc) {
        double x = circle.getCenterX();
        double y = circle.getCenterY();
        double r = circle.getRadius();

        double xpoints[] = {x - r * 0.23, x, x + r * 0.23, x + r * 0.95, x + r * 0.36,
                x + r * 0.59, x, x - r * 0.59, x - r * 0.36, x - r * 0.95};
        double ypoints[] = {y - r * 0.31, y - r, y - r * 0.31, y - r * 0.31, y + r * 0.09,
                y + r * 0.75, y + r * 0.34, y + r * 0.75, y + r * 0.09, y - r * 0.31};
        gc.strokePolygon(xpoints, ypoints, xpoints.length);
    }
}
