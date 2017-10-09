package SnowMan;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.Random;

import static SnowMan.SnowmanClient.*;

public class Snowman extends Application {
    static double t = 650;
    static Circle[] circle;
    static Scene scene;

    public static void main(String... args) {

        launch(args);
    }

    public static Circle[] Globe(int parts) {
        Circle[] circleG = new Circle[parts];
        double radius = circle[circle.length - 1].getRadius();
        Color color = Color.color(Math.random(), Math.random(), Math.random());
        circleG[0] = new Circle(t / 2,
                circle[circle.length - 1].getCenterY() + (radius / 3),
                3 + Math.random() * (radius / 4),
                Paint.valueOf(color.toString()));
        circleG[1] = new Circle((t / 2) - (radius / 3),
                circle[circle.length - 1].getCenterY() - (radius / 3),
                2 + Math.random() * (radius / 6),
                Paint.valueOf(color.toString()));
        circleG[2] = new Circle((t / 2) + (radius / 2),
                circle[circle.length - 1].getCenterY() - (radius / 3),
                2 + Math.random() * (radius / 6),
                Paint.valueOf(color.toString()));
        return circleG;
    }

    public static Circle[] circle(int count) {
        circle = new Circle[count];
        for (int i = 0; i < circle.length; i++) {
            double radius = min + Math.random() * max;
            Random random = new Random ( );
            Color color = new Color ( random.nextDouble ( ) ,
                    random.nextDouble ( ) ,
                    random.nextDouble ( ) ,
                    1.0 );
            if (i == 0) {
                circle[i] = new Circle(t / 2, t - radius, radius,
                        Paint.valueOf(color.toString()));
            } else {
                circle[i] = new Circle(t / 2,
                        circle[i - 1].getCenterY() - circle[i - 1].getRadius()
                                - radius, radius, Paint.valueOf(color.toString()));
            }
        }
        return circle;
    }
    private static Paint gradientPaint ( int step , int steps ) {
        Color color = new Color ( 1.0 * step / steps , 1.0 * step / steps , 1.0 * step / steps , 1 );
        return Paint.valueOf ( color.toString ( ) );
    }
    static void paintGradient ( Circle[] circle ) {
        circle[ 0 ].setFill ( Paint.valueOf ( "#000000FF" ) );
        for ( int i = circle.length - 4 ; i > 0 ; i-- ) {
            circle[ i ].setFill ( gradientPaint ( i , circle.length - 2 ) );
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snowman");
        Pane pane = new Pane();
        pane.getChildren().addAll(circle(count));
        pane.getChildren().addAll(Globe(3));
        Button button = new Button("show");
        scene = new Scene(pane, t, t);
        button.setTranslateX(10);
        button.setTranslateY(10);
        button.setOnMouseClicked(event -> {
            pane.getChildren().clear();
            pane.getChildren().addAll(circle(count));
            pane.getChildren().addAll(Globe(3));
            pane.getChildren().addAll(button);

        });
        pane.getChildren().addAll(button);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
