package commands;

/**
 * Команда replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого
 */
public class RemoveLowerCommand extends Command{
    public RemoveLowerCommand() {
        super("remove_lower"," заменить значение по ключу, если новое значение меньше старого");
    }
}
