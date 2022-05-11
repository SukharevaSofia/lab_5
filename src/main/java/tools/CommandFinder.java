package tools;


import exceptions.*;
import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

import static tools.ConsoleUI.bufferedReader;
import static tools.ConsoleUI.greeting;

public class CommandFinder{
    private final CollectionManager collectionManager;
    private final CommandManager commandManager;
    static boolean scriptMode = false;

    public CommandFinder(CollectionManager collectionManager, CommandManager commandManager){
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        greeting();
    }

    public void commandSearcher(){

        while(true){
            try{

                String[] userCommand = ConsoleUI.reader.nextLine().split(" ");
                String userCommandCheck = Arrays.stream(userCommand)
                        .collect(Collectors.joining(""));
                if (userCommandCheck.equals("")) continue;
                if(userCommand.length > 2) throw new CommandException();

                ConsoleUI.output(launchCommand(userCommand));

            }
            catch (CommandException e) {
                ConsoleUI.output("Команда не найдена");
            }
        }
    }


    private String launchCommand(String[] userCommand){

        switch(userCommand[0]) {

            case ("help"):
                if (userCommand.length == 1) {
                    return commandManager.help();
                } else return "Команда не найдена";

            case ("info"):
                if (userCommand.length == 1) {
                    return collectionManager.info();
                } else return "Команда не найдена";

            case ("show"):
                if (userCommand.length == 1) {
                    return collectionManager.show();
                } else return "Команда не найдена";

            case ("insert"):
                if (userCommand.length == 1) {
                    return collectionManager.insert();
                } else return "Команда не найдена";

            case ("update"):
                if (userCommand.length == 2) {
                    return collectionManager.updateById(userCommand[1]);
                } else return "Команда не найдена";

            case ("remove_key"):
                if (userCommand.length == 2) {
                    return collectionManager.removeById(userCommand[1]);
                } else return "Команда не найдена";

            case ("clear"):
                if (userCommand.length == 1) {
                    return collectionManager.clear();
                } else return "Команда не найдена";

            case ("save"):
                if (userCommand.length == 1) {
                    return collectionManager.save();
                } else return "Команда не найдена";

            case ("execute_script"):
                if (userCommand.length == 2) {
                    return executeScript(userCommand[1]);
                } else return "Команда не найдена";

            case ("exit"):
                if (userCommand.length == 1) {
                    ConsoleUI.output("Программа завершена");
                    System.exit(0);
                    return "";
                } else return "Команда не найдена";

            case ("remove_greater"):
                if (userCommand.length == 2) {
                    return collectionManager.removeGreater(userCommand[1]);
                } else return "Команда не найдена";

            case ("replace_if_lower"):
                if (userCommand.length == 2) {
                    return collectionManager.replaceIfLower(userCommand[1]);
                } else return "Команда не найдена";

            case ("remove_greater_key"):
                if (userCommand.length == 2) {
                    return collectionManager.removeGreaterKey(userCommand[1]);
                } else return "Команда не найдена";

            case ("filter_less_than_genre"):
                if (userCommand.length == 2) {
                    return collectionManager.filterLessThanGenre(userCommand[1]);
                } else return "Команда не найдена";

            case ("count_greater_than_description"):
                if (userCommand.length == 2) {
                    return collectionManager.countGreaterThanDescription(userCommand[1]);
                } else return "Команда не найдена";

            case ("print_field_descending_number_of_participants"):
                if (userCommand.length == 1) {
                    return collectionManager.printDescendingParticipants();
                } else return "Команда не найдена";

            default:
                return "Команда debug";
        }
    }


    private String executeScript(String fileName){

        scriptMode = true;
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            StringBuilder result = new StringBuilder();
            while (line != null) {
                try {

                    String[] userCommand = line.split(" ");

                    if (userCommand.length > 2) throw new CommandException();
                    if(userCommand[0].equals("execute_script") && userCommand[1].equals(fileName)){
                        throw new RecursiveException();
                    }

                    result.append(launchCommand(userCommand)).append("\n");
                    line = bufferedReader.readLine();

                } catch (CommandException e) {
                    result.append("Команда не найдена").append("\n");
                } catch (NullPointerException e) {
                    result.append("Ошибка ввода").append("\n");
                }
                catch (RecursiveException e){
                    return result.toString() + "Ошибка : файл рекурсивен";
                }
            }
            scriptMode = false;
            return result.toString();
        }
        catch (FileNotFoundException e){
            return "Файл не найден";
        } catch (IOException e) {
            return "Ошибка";
        }
    }

}

