package tools;

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
    private FilterGenreCommand exitCommand;
    private RemoveGreaterCommand removeLowerCommand;
    private ReplaceIfLowerCommand replaceIfLowerCommand;
    private CountDescriptionCommand countDescriptionCommand;
    private FilterGenreCommand filterGenreCommand;
    private PrintParticipantsCommand printParticipantsCommand;

    private final Integer HISTORY_SIZE = 6;
    private List<Command> commands;

    public CommandManager(InsertCommand addCommand, ClearCommand clearCommand,
                          ExecuteScriptCommand executeScriptCommand, HelpCommand helpCommand,
                          InfoCommand infoCommand, RemoveKeyCommand removeKey,
                          SaveCommand saveCommand, ShowCommand showCommand, UpdateIdCommand updateIdCommand,
                          FilterGenreCommand exitCommand,RemoveGreaterCommand removeLowerCommand,
                          ReplaceIfLowerCommand replaceIfLowerCommand, CountDescriptionCommand countDescriptionCommand,
                          FilterGenreCommand filterGenreCommand, PrintParticipantsCommand printParticipantsCommand) {
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
        this.countDescriptionCommand = countDescriptionCommand;
        this.filterGenreCommand = filterGenreCommand;
        this.printParticipantsCommand = printParticipantsCommand;
        commands = List.of(addCommand, clearCommand, executeScriptCommand, helpCommand,
                infoCommand, removeKey, saveCommand, showCommand, updateIdCommand, exitCommand, removeLowerCommand,
                replaceIfLowerCommand, countDescriptionCommand, filterGenreCommand, printParticipantsCommand);

    }


    public String help(String input) {
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
