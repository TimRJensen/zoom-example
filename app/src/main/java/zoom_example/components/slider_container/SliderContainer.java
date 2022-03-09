package zoom_example.components.slider_container;

import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import zoom_example.components.custom_canvas.CustomCanvas;

public class SliderContainer extends HBox {
  private CustomCanvas canvas;

  private ChangeListener<Number> handleChange = (observer, prev, next) -> {
    var a = next.doubleValue();
    var b = prev.doubleValue();

    canvas.zoom(1 + (a - b), 1024 / 2, 768 / 2);
  };

  @FXML
  private Slider slider;

  public void setValue (double value) {
    this.slider.setValue(value);
  }

  public double getValue () {
    return this.slider.getValue();
  }

  @FXML
  private void handleZoomIncrease() {
    canvas.zoom(1.2, 1024 / 2, 768 / 2);
    this.slider.setValue(this.slider.getValue() + 0.2);
  }

  @FXML
  private void handleZoomDecrease() {
    canvas.zoom(0.8, 1024 / 2, 768 / 2);
    this.slider.setValue(this.slider.getValue() - 0.2);
  }

  public SliderContainer(@NamedArg("canvas") CustomCanvas canvas) {
    this.canvas = canvas;

    var loader = new FXMLLoader(this.getClass().getResource("SliderContainer.fxml"));

    loader.setRoot(this);
    loader.setController(this);

    try {
      loader.load();
    } catch (Exception error) {
      System.out.println(error.getMessage());
    }

    this.slider.setMin(0);
    this.slider.setMax(4);
    this.slider.setValue(2);
    this.slider.valueProperty().addListener(handleChange);

  }
}
