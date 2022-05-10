package commands;

/**
 * Команда execute_script file_name : считать и исполнить скрипт из указанного файла.
 * В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */
public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand() {
        super("execute_script file_name"," считать и исполнить скрипт из указанного файла.");
    }
}
