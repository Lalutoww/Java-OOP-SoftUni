package behavioral.commad.commands;

import behavioral.commad.Lamp;

public class TurnOnLights implements Command {
    private final Lamp lamp;

    public TurnOnLights(Lamp lights) {
        this.lamp = lights;
    }

    @Override
    public void execute() {
        this.lamp.TurnOn();
    }
}
