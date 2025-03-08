package behavioral.commad;

import behavioral.commad.commands.Command;

public class Controller {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        this.command.execute();
    }
}
