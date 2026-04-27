package fr.univ_amu.iut.exercice4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Exercice 4 - Mise en page d'un formulaire.
 *
 * <p>Objectif : reproduire la maquette d'un mini-formulaire en combinant plusieurs conteneurs
 * JavaFX. L'exercice force à réfléchir à la décomposition d'une IHM en zones.
 *
 * <h3>Maquette à reproduire</h3>
 *
 * <pre>
 * ┌───────────────────────────────┐
 * │ [Fichier] [Aide]              │  ← MenuBar
 * ├───────────────────────────────┤
 * │ Nom :     [__________]        │  ┐
 * │ Email :   [__________]        │  │ GridPane (2 × 2)
 * │                               │  ┘
 * │ [  Valider  ]  [ Annuler ]    │  ← HBox
 * └───────────────────────────────┘
 * </pre>
 *
 * Concepts : {@link javafx.scene.layout.BorderPane}, {@link javafx.scene.layout.GridPane}, {@link
 * javafx.scene.layout.HBox}, {@link javafx.scene.control.MenuBar}.
 */
public class MiseEnPage extends Application {

  @Override
  public void start(Stage primaryStage) {
    // TODO exercice 4 : construire la maquette ci-dessus.
    //
    // Stratégie conseillée :
    //
    // 1. Un BorderPane comme racine (setTop, setCenter, setBottom).
    // 2. Top : un MenuBar avec deux Menu "Fichier" et "Aide".
    // 3. Center : un GridPane avec 2 lignes / 2 colonnes :
    // (0,0) Label "Nom :" | (1,0) TextField
    // (0,1) Label "Email :" | (1,1) TextField
    // 4. Bottom : un HBox contenant deux boutons "Valider" et "Annuler",
    // avec un peu d'espacement et un padding.
    //
    // Donne un id CSS utile sur les composants si tu veux les retrouver
    // facilement (les tests utilisent lookup sur les classes ".text-field"
    // et ".button", pas besoin d'id particulier).
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setWidth(800);
    primaryStage.setHeight(400);

    final Menu menu1 = new Menu("Fichier");
    final Menu menu2 = new Menu("Aide");
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(menu1, menu2);
    root.setTop(menuBar);

    GridPane gridPane = new GridPane();
    root.setCenter(gridPane);
    Label label1 = new Label("Nom :");
    GridPane.setConstraints(label1, 0, 0);
    Label label2 = new Label("Email :");
    GridPane.setConstraints(label2, 0, 1);

    TextField textfield1 = new TextField();
    TextField textfield2 = new TextField();
    GridPane.setConstraints(textfield1, 1, 0);
    GridPane.setConstraints(textfield2, 1, 1);
    gridPane.getChildren().addAll(label1, label2, textfield1, textfield2);

    HBox Box = new HBox(5);
    root.setBottom(Box);
    Button button1 = new Button("Valider");
    Button button2 = new Button("Annuler");
    Box.getChildren().addAll(button1, button2);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
