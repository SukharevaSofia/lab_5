package commands;

/**
 * Команда filter_less_than_genre genre : вывести элементы, значение поля genre которых меньше заданного
 */
public class FilterGenreCommand extends Command {
    public FilterGenreCommand() {
        super("filter_less_than_genre genre", " вывести элементы, значение поля genre которых меньше заданного");
    }
}
