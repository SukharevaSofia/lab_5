package commands;

/**
 * Команда replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого
 */
public class ReplaceIfLowerCommand extends Command {
    public ReplaceIfLowerCommand() {
        super("replace_if_lower", " заменить значение по ключу, если новое значение меньше старого");
    }
}
