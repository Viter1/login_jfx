package application;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Controlador_wizard {
	
	@FXML
	public AnchorPane login_principal;

	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private Label countLabel;

	@FXML
	private Button boton_izquierda;

	@FXML
	private Button boton_derecha;

	@FXML
	private Button boton_x;

	public void translateAnimation(double duration, Node node, double byX) {
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
		boton_izquierda.setOpacity(0);
	}

	int showSlide = 0;

	@FXML
	void nextAction() {

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
			boton_izquierda.setOpacity(1);
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");
			boton_izquierda.setOpacity(1);
			boton_derecha.setOpacity(0);
		} else {
			System.out.println("No hay mas pantallas");
		}

	}

	@FXML
	void backAction() {

		if (showSlide == 0) {
			System.out.println("No more slides");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
			boton_izquierda.setOpacity(0);
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
			boton_izquierda.setOpacity(1);
			boton_derecha.setOpacity(1);
//			boton_izquierda.setOpacity(0);
		}

	}

	@FXML
	private void cerrar_ventana() {
	
			try {
				// Load the fxml file and create a new stage for the popup.
//				FXMLLoader loader = new FXMLLoader();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista3.fxml"));
				AnchorPane page = (AnchorPane) loader.load();
				Stage homeStage = new Stage();
				homeStage.setTitle("Homepage");
				Scene scene = new Scene(page, 1350, 800);
				homeStage.setScene(scene);
//				homeStage.setMaximized(true);
				Stage thisStage = (Stage) login_principal.getScene().getWindow();
				thisStage.close();
				homeStage.show();
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
