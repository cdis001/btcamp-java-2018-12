package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalControllerAdvice {

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    DatePropertyEditor propEditorDate = new DatePropertyEditor();
    CarPropertyEditor propEditorCar = new CarPropertyEditor();
    EnginePropertyEditor propEditorEng = new EnginePropertyEditor();

    binder.registerCustomEditor(java.util.Date.class, propEditorDate);
    binder.registerCustomEditor(Car.class, propEditorCar);
    binder.registerCustomEditor(Engine.class, propEditorEng);
  }

  class EnginePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      Engine engine = new Engine();
      String[] texts = text.split(",");
      engine.setModel(texts[0]);
      engine.setCc(Integer.parseInt(texts[1]));
      engine.setValve(Integer.parseInt(texts[2]));
      setValue(engine);
    }

  }

  class CarPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      Car car = new Car();
      String[] texts = text.split(",");
      car.setModel(texts[0]);
      car.setCapacity(Integer.parseInt(texts[1]));
      car.setAuto(Boolean.parseBoolean(texts[2]));
      car.setCrateDate(java.sql.Date.valueOf(texts[3]));
      setValue(car);
    }

  }

  class DatePropertyEditor extends PropertyEditorSupport {
    SimpleDateFormat format;

    public DatePropertyEditor() {
      format = new SimpleDateFormat("yyyy-MM-dd");
    }

    public DatePropertyEditor(SimpleDateFormat format) throws Exception {
      this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

      System.out.println("DatePropertyEditor.setAsText()");

      try {
        Date date = format.parse(text);
        setValue(date);
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }

    @Override
    public Object getValue() {
      System.out.println("DatePropertyEditor.getValue()");
      return super.getValue();
    }
  }
}
