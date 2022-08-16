package com.renua_sw.crm_v2.renua_sw_crm_v2.commander;

import com.ironhack.renua_sw_crm_v2.userinput.UserInput;

public class Commander<T> {
    private final Command<T>[] commands;
    private boolean autorun = false;

    public void setAutorun(boolean autorun) {
        this.autorun = autorun;
    }

    public Commander(Command<T>[] commands) {
        this.commands = commands;
    }
    public Commander(Command<T>[] commands, boolean autorun) {
        this.commands = commands;
        setAutorun(autorun);
    }

    public CommandResult<T> askForCommand() {
        CommandResult<T> commandResult = null;

        do {
            String inp = UserInput.readText();
            for (var command : commands) {
                commandResult = command.tryProcessCommand(inp);
                if(commandResult != null) break;
            }
            if(commandResult == null) {
                System.out.println("[!] The command does not exist");
            }
        } while (commandResult == null);

        if(autorun) commandResult.run();
        return commandResult;
    }
}
