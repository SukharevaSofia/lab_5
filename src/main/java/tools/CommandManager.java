package tools;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import commands.*;

public class CommandManager {
    private InsertCommand addCommand;
    private ClearCommand clearCommand;
    private ExecuteScriptCommand executeScriptCommand;
    private HelpCommand helpCommand;
    private InfoCommand infoCommand;
    private RemoveKeyCommand removeKey;
    private SaveCommand saveCommand;
    private ShowCommand showCommand;
    private UpdateIdCommand updateIdCommand;
    private ExitCommand exitCommand;
    private RemoveLowerCommand removeLowerCommand;
    private ReplaceIfLowerCommand replaceIfLowerCommand;

    private final Integer HISTORY_SIZE = 6;
    private List<Command> commands;

    public CommandManager(InsertCommand addCommand, ClearCommand clearCommand,
                          ExecuteScriptCommand executeScriptCommand, HelpCommand helpCommand,
                          InfoCommand infoCommand, RemoveKeyCommand removeKey,
                          SaveCommand saveCommand, ShowCommand showCommand, UpdateIdCommand updateIdCommand, ExitCommand exitCommand,
                          RemoveLowerCommand removeLowerCommand, ReplaceIfLowerCommand replaceIfLowerCommand) {
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.removeKey = removeKey;
        this.saveCommand = saveCommand;
        this.showCommand = showCommand;
        this.updateIdCommand = updateIdCommand;
        this.exitCommand = exitCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.replaceIfLowerCommand = replaceIfLowerCommand;
        commands = List.of(addCommand, clearCommand, executeScriptCommand, helpCommand,
                infoCommand, removeKey, saveCommand, showCommand, updateIdCommand, exitCommand, removeLowerCommand, replaceIfLowerCommand);

    }


    public String help() {
        return commands.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining("\n"));
    }


    public String commandsString() {
        return commands.stream()
                .map(x -> x.getName())
                .collect(Collectors.joining("\n"));
    }

}
