package zoom_example.views.index;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.TextAlignment;
import zoom_example.components.custom_canvas.CustomCanvas;
import zoom_example.components.slider_container.SliderContainer;

public class Index {

  @FXML
  private CustomCanvas canvas;

  @FXML
  private SliderContainer sliderContainer;

  @FXML
  private void handleScroll(ScrollEvent event) {
    this.sliderContainer.setValue(
        event.getDeltaY() < 1 ? this.sliderContainer.getValue() - 0.2 : this.sliderContainer.getValue() + 0.2);
  }

  ChangeListener<Number> handleInitialChange = (observer, prev, next) -> {
    var context = this.canvas.getGraphicsContext2D();

    context.setTextAlign(TextAlignment.CENTER);
    context.setTextBaseline(VPos.CENTER);
    context.fillText("Prøv at på teksten", Math.round(1024 / 2), Math.round(768 / 2));

    this.canvas.heightProperty().removeListener(this.handleInitialChange);
  };

  public void initialize() {
    this.canvas.heightProperty().addListener(handleInitialChange);
  }

}
