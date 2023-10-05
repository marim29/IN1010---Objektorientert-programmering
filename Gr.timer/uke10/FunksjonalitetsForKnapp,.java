import javafx.event.EventHandler;
import javafx.event.Event;

class FunksjonalitetForKnapp1<T extends Event> implements EventHandler<T> {
  @Override
  public void handle(T event) {
    System.out.println("Knappaction med vanlig klasse");
  }
}
