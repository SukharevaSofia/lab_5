package commands;

/**
 * Команда print_field_descending_number_of_participants : вывести значения поля numberOfParticipants
 * всех элементов в порядке убывания
 */
public class PrintParticipantsCommand extends Command{
    public PrintParticipantsCommand() {
        super(" print_field_descending_number_of_participants"," вывести значения поля numberOfParticipants" +
                " всех элементов в порядке убывания");
    }
}
