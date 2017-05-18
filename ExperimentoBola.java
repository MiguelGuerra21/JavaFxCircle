import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
public class ExperimentoBola extends Application
{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage escenario)
    {
        Group contenedor = new Group();

        Circle circulo = new Circle();
        circulo.setFill(Color.RED);
        circulo.setRadius(60);
        circulo.setCenterX(250);
        circulo.setCenterY(250);

        contenedor.getChildren().add(circulo);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(.0200),event ->{
                    circulo.setTranslateX(circulo.getTranslateX() + 1);
                    circulo.setTranslateY(circulo.getTranslateY() + 1);
                }
            );
        Button botonParado = new Button("Parar");
        botonParado.setLayoutX(10);
        botonParado.setLayoutY(10);
        botonParado .setOnAction(event -> {
                if(timeline.getStatus().equals(Animation.Status.STOPPED)){
                    timeline.play();
                }
                else{
                    timeline.stop();
                }
            });
        contenedor.getChildren().add(botonParado);

        timeline.getKeyFrames().
        add(moveBall);
        timeline.play();

        Scene escena = new Scene(contenedor, 500 ,500);
        escenario.setScene(escena);
        escenario.setScene(escena);
        escenario.show();
    }

}