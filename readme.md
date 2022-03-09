### Hent repoet.
```
git clone https://github.com/TimRJensen/zoom-example.git
```

### Kør.
```
./gradlew run
```

### Noter.
Jeg har brugt lidt avanceret FXML til at lave eksemplet. Grunden er, at jeg bruger composition over inheritance, 
dels fordi jeg syntes det er smartere, men også fordi at det er sådan React.js virker. Idéen er:

- Laver mange små selv isolerede components. En component har ansvar for sin egen View, Model og Controller.
- Lade app tilstand (state/model) "flyde" ned igennem appen/view, frem for op.

Da Java er lidt små fjollet, kan man ikke 100% implementere composition. Eksempelvis har jeg været nødsaget til at lave en controller til `Index.fxml`. 
Controllerens eneste funktion er reelt at lade `CustomCanvas` "flyde" ned til `SliderContainer` og registrere `Scroll` events.

`SliderContainer` er implementeret som et såkaldt custom control, eller det jeg kalde et component. Det vil sige at det gør brug af `fx:root` til at genererer en 
selv isoleret component. Denne kan vi så bruge i en anden FXML kontekst, i dette specifikke tilfælde i `Index.fxml`. Det er også denne metode der er brugt til at 
definere de mere avancerede controls som kommer indbygget med JavaFX, som f.eks. `Label`, `Button` eller `Slider`. 

Hvis du vil læse mere om FXML, så kan du kigge på denne 
[artikel](https://docs.oracle.com/javafx/2/fxml_get_started/why_use_fxml.htm#), særligt kapitel fem. Ellers er du også velkommen til bare at spørge.
