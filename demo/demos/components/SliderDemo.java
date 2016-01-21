package demos.components;

import com.jfoenix.skins.JFXSliderSkin;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Skin;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXSlider.IndicatorPosition;

import java.text.DecimalFormat;

public class SliderDemo extends Application {

    public class MyJFXSlider extends JFXSlider {
        @Override
        protected Skin<?> createDefaultSkin() {
            JFXSliderSkin jfxSliderSkin = (JFXSliderSkin) super.createDefaultSkin();
            jfxSliderSkin.setDecimalFormat(new DecimalFormat("#.##"));
            jfxSliderSkin.setThumbColor(Color.valueOf("#FF0000"));
            jfxSliderSkin.setStrokeWidth(7);
            jfxSliderSkin.reinitialize();
            jfxSliderSkin.getThumb().onMouseClickedProperty().addListener(new ChangeListener<EventHandler<? super MouseEvent>>() {
                                                                              @Override
                                                                              public void changed(ObservableValue<? extends EventHandler<? super MouseEvent>> observableValue, EventHandler<? super MouseEvent> eventHandler, EventHandler<? super MouseEvent> t1) {
                                                                                  System.out.println("done");
                                                                              }
                                                                          }
            );
            return jfxSliderSkin;
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            JFXSlider hor_left = new MyJFXSlider();
            hor_left.setMinWidth(500);
            hor_left.setMax(1);
            hor_left.setMin(0);

            JFXSlider hor_right = new JFXSlider();
            hor_left.setMinWidth(500);
            hor_left.setIndicatorPosition(IndicatorPosition.RIGHT);

            JFXSlider ver_left = new JFXSlider();
            ver_left.setMinHeight(500);
            ver_left.setOrientation(Orientation.VERTICAL);

            JFXSlider ver_right = new JFXSlider();
            ver_right.setMinHeight(500);
            ver_right.setOrientation(Orientation.VERTICAL);
            ver_right.setIndicatorPosition(IndicatorPosition.RIGHT);

            HBox hbox = new HBox();
            hbox.setSpacing(450);
            hbox.getChildren().addAll(ver_right, ver_left);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(hor_right, hor_left, hbox);
            vbox.setSpacing(100);
            vbox.setPadding(new Insets(100, 50, 50, 150));

            Scene scene = new Scene(new Group());
            ((Group) scene.getRoot()).getChildren().add(vbox);
            scene.getStylesheets().add(SliderDemo.class.getResource("/resources/css/jfoenix-components.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setWidth(900);
            primaryStage.setHeight(900);
            primaryStage.show();
            primaryStage.setTitle("JFX Slider Demo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
