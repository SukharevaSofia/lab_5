/**
 * Основной класс, осуществляет работу приложения
 * @author Сухарева Софья P3112
 */

import commands.*;
import tools.*;

public class Main {
    public static void main(String[] args) {


        String readEnv = "READENV";
        String writeEnv = "WRITENV";
        CollectionManager collectionManager = new CollectionManager(readEnv, writeEnv);
        CommandManager commandManager = new CommandManager(
                new InsertCommand(),
                new ClearCommand(),
                new ExecuteScriptCommand(),
                new HelpCommand(),
                new InfoCommand(),
                new RemoveKeyCommand(),
                new SaveCommand(),
                new ShowCommand(),
                new UpdateIdCommand(),
                new FilterGenreCommand(),
                new RemoveGreaterCommand(),
                new ReplaceIfLowerCommand(),
                new CountDescriptionCommand(),
                new FilterGenreCommand(),
                new PrintParticipantsCommand()
        );
        CommandFinder commandFinder = new CommandFinder(collectionManager, commandManager);
        commandFinder.commandSearcher();
    }
}
