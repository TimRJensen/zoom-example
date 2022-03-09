package zoom_example.components.custom_canvas;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Affine;

public class CustomCanvas extends Canvas {
  private Affine transform = new Affine();

  private void repaint() {
    var context = this.getGraphicsContext2D();

    context.clearRect(0, 0, this.getWidth(), this.getHeight());
    context.setTransform(this.transform);
    context.setTextAlign(TextAlignment.CENTER);
    context.setTextBaseline(VPos.CENTER);
    context.fillText("Prøv at zoome på teksten", Math.round(1024 / 2), Math.round(768 / 2));
  }

  public void zoom(double factor, double x, double y) {
    this.transform.prependTranslation(-x, -y);
    this.transform.prependScale(factor, factor);
    this.transform.prependTranslation(x, y);

    this.repaint();
  }
}
