package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    Stage window;

    private Desktop desktop = Desktop.getDesktop();

    public static void main(String[] args) {
        launch(args);
        //String[] headerList = {"Carne","Nombre", "Correo"};

    }


    /**
     * Este método añade un Hbox a la interfaz, un espacio en la parte superior
     * @return hbox
     */
    public HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button openButton = new Button("Abrir Archivo");
        openButton.setPrefSize(100, 20);

        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        final FileChooser fileChooser = new FileChooser();

                        File file = fileChooser.showOpenDialog(window);
                        if (file != null) {
                            openFile(file);
                        }
                    }
                });

        hbox.getChildren().addAll(openButton);

        return hbox;
    }


    /**
     * Este método abre un archivo dentro de la computadora por medio del buscador de archivos.
     * @param file
     */
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    Main.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

    /**
     * Este método añade una cuadrícula a la interfaz, donde se coloca la información obtenida del archivo CSV.
     * @return grid
     */
    public GridPane addGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setStyle("-fx-background-color: #D2C4A1;");
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        // Category in column 2, row 1
        Text category = new Text("Carné");
        category.setFont(Font.font("Arial", 20));
        grid.add(category, 0, 0);

        Text category2 = new Text("Nombre");
        category2.setFont(Font.font("Arial", 20));
        grid.add(category2, 1, 0);

        Text category3 = new Text("Correo");
        category3.setFont(Font.font("Arial", 20));
        grid.add(category3, 2, 0);

        Text category4 = new Text("Teléfono");
        category4.setFont(Font.font("Arial", 20));
        grid.add(category4, 3, 0);

        Text category5 = new Text("Nickname");
        category5.setFont(Font.font("Arial", 20));
        grid.add(category5, 4, 0);

        Text category6 = new Text("Tipo Estudiante");
        category6.setFont(Font.font("Arial", 20));
        grid.add(category6, 5, 0);

        Text category7 = new Text("Nota Examenes");
        category7.setFont(Font.font("Arial", 20));
        grid.add(category7, 6, 0);

        Text category8 = new Text("Nota quices");
        category8.setFont(Font.font("Arial", 20));
        grid.add(category8, 7, 0);

        Text category9 = new Text("Nota tareas");
        category9.setFont(Font.font("Arial", 20));
        grid.add(category9, 8, 0);

        Text category10 = new Text("Nota P1");
        category10.setFont(Font.font("Arial", 20));
        grid.add(category10, 9, 0);

        Text category11 = new Text("Nota P2");
        category11.setFont(Font.font("Arial", 20));
        grid.add(category11, 10, 0);

        Text category12 = new Text("Nota P3");
        category12.setFont(Font.font("Arial",20));
        grid.add(category12, 11, 0);

        return grid;
    }

    /**
     * Este es el método de inicio, donde se le da función a los botones y se llama a otros métodos.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("CSV Reader");
        window.setWidth(1215);
        window.setHeight(600);
        window.setResizable(false);

        BorderPane border = new BorderPane();
        HBox hbox = addHBox();
        border.setTop(hbox);

        border.setCenter(addGridPane());


        Scene trial = new Scene(border,100,200);

        window.setScene(trial);
        window.show();

    }
}
