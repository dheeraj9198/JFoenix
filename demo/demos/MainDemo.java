package demos;

import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyphLoader;

import demos.gui.main.MainController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainDemo extends Application {

	@FXMLViewFlowContext private ViewFlowContext flowContext;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {

		new Thread(()->{
			try {
				SVGGlyphLoader.loadGlyphsFont(MainDemo.class.getResource("/resources/fonts/icomoon.svg"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}).start();

		Flow flow = new Flow(MainController.class);
		DefaultFlowContainer container = new DefaultFlowContainer();
		flowContext = new ViewFlowContext();
		flowContext.register("Stage", stage);
		flow.createHandler(flowContext).start(container);
		           JFXDecorator jfxDecorator =new JFXDecorator(stage, container.getView());
        jfxDecorator.setFullBtnVisible(false);
        jfxDecorator.getBorderPane().setStyle("-fx-background-color: #039be5");
        jfxDecorator.getBorderPane().setCenter(new Group(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("resources/ic_collapse.png")))));
		Scene scene = new Scene(jfxDecorator, 800, 800);
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());
		scene.getStylesheets().add(MainDemo.class.getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());
		//		stage.initStyle(StageStyle.UNDECORATED);
		//		stage.setFullScreen(true);
		stage.setMinWidth(700);
		stage.setMinHeight(700);
		stage.setScene(scene);
		stage.show();

	}

}