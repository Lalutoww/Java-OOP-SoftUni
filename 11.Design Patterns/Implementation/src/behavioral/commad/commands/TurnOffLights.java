package behavioral.commad.commands;

import behavioral.commad.Lamp;

public class TurnOffLights implements Command {
    private Lamp lamp;

    public TurnOffLights(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        this.lamp.TurnOff();
    }
}
