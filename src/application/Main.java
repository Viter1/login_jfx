package application;
	


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
/**
 * 
 * @author V1tter
 * @version 1.0
 * @see Controlador_login
 * @see Controlador_transicion
 * @see Controlador_homepage
 * @see Controlador_wizard
 * 
 * En este proyecto tenemos 5 ramas 
 * 
 * 	1.-Login
 * 	en esta rama hemos colocado un login donde en un inicio tenemos un SlpashScreen y despues un login con campos de texto 
 * 	usuario y contraseña 
 * 
 *  2.-Home_page
 *  donde una vez logueados nos aparecera un menu burguer donde si hacemos click nos apareceran varias opciones desplazadas desde
 *  la izquierda y haciendo click de nuevo fuera del menu este se esconde 
 *  
 *  3.-Transiciones
 *  en esta rama tenemos nuestro login pero esta vez con transiciones en el fondo donde van apareciendo imagenes con un efecto
 *  de fadeTransition una foto desaparece poco a poco mientras aparece la siguiente
 *  
 *  4.-Wizard
 *  lo que sucede en esta rama hemos colocado entre el login y el hompage animaciones en forma de intro donde explica 
 *  de lo que se trata nuestra aplicación y con dos botones izquierda derecha si le damos hacia la derecha nos muestra
 *  mas imagenes de nuestra aplicacion con un efecto de tranlateAnimation
 *  
 *
 */

public class Main extends Application {
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista2.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root , 630 , 600);
			scene.setFill(Color.TRANSPARENT);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
