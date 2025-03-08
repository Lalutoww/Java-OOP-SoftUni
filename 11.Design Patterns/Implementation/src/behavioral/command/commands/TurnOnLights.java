package behavioral.command.commands;

import behavioral.command.Lamp;

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
