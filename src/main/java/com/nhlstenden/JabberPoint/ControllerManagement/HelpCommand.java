package com.nhlstenden.JabberPoint.ControllerManagement;

public class HelpCommand implements Command {

  @Override
  public void execute() {
    Command aboutCommand = new AboutCommand();
    aboutCommand.execute();
  }
}
