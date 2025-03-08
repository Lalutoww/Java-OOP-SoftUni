package behavioral.commad;

import behavioral.commad.commands.Command;
import behavioral.commad.commands.TurnOffLights;
import behavioral.commad.commands.TurnOnLights;

public class Main {
    public static void main(String[] args) {
        Lamp lamp = new Lamp(); // executor

        Controller remote = new Controller(); // controller

        Command c1 = new TurnOnLights(lamp);
        Command c2 = new TurnOffLights(lamp);

        remote.setCommand(c1);
        remote.pressButton(); // invoking command

        remote.setCommand(c2);
        remote.pressButton(); // invoking command
    }
}
