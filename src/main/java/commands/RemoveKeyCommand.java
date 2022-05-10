package commands;

/**
 * Команда remove_key null : удалить элемент из коллекции по его ключу
 */
public class RemoveKeyCommand extends Command {
    public RemoveKeyCommand() {
        super("remove_key id", " удалить элемент из коллекции по его ключу");
    }
}
