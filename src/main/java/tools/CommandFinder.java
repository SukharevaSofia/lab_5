package tools;

import exceptions.*;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static tools.ConsoleUI.bufferedReader;
import static tools.ConsoleUI.greeting;

public class CommandFinder {
  private final CollectionManager collectionManager;
  private final CommandManager commandManager;
  static boolean scriptMode = false;

  public CommandFinder(CollectionManager collectionManager, CommandManager commandManager) {
    this.collectionManager = collectionManager;
    this.commandManager = commandManager;
    greeting();
  }

  public void commandSearcher() {

    while (true) {
      try {

        String[] userCommand = ConsoleUI.reader.nextLine().split(" ");
        String userCommandCheck = Arrays.stream(userCommand)
            .collect(Collectors.joining(""));
        if (userCommandCheck.equals(""))
          continue;
        if (userCommand.length > 2)
          throw new CommandException();

        ConsoleUI.output(launchCommand(userCommand));

      } catch (CommandException e) {
        ConsoleUI.output("Команда не найдена");
      }
    }
  }

  private String launchCommand(String[] userCommand) {
    Map<String, Function<String, String>> commands =
      new HashMap<String, Function<String, String>>(
      );
    commands.put("help", commandManager::help);
    commands.put("info", collectionManager::info);
    commands.put("show", collectionManager::show);
    commands.put("insert", collectionManager::insert);
    commands.put("update", collectionManager::updateById);
    commands.put("remove_key", collectionManager::removeById);
    commands.put("clear", collectionManager::clear);
    commands.put("save", collectionManager::save);
    commands.put("execute_script", this::executeScript);
    commands.put("exit", (String s) -> {
      ConsoleUI.output("Программа завершена");
      System.exit(0);
      return "";
    });
    commands.put("remove_greater", collectionManager::removeGreater);
    commands.put("replace_if_lower", collectionManager::replaceIfLower);
    commands.put("remove_greater_key", collectionManager::removeGreaterKey);
    commands.put("filter_less_than_genre", collectionManager::filterLessThanGenre);
    commands.put("count_greater_than_description", collectionManager::countGreaterThanDescription);
    commands.put("print_field_descending_number_of_participants", collectionManager::printDescendingParticipants);
    
    return commands.
      getOrDefault(userCommand[0], (String s) -> "Command not found").
      apply(userCommand.length >= 2 ? userCommand[1] : "");
  }

  private String executeScript(String fileName) {

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

          if (userCommand.length > 2)
            throw new CommandException();
          if (userCommand[0].equals("execute_script") && userCommand[1].equals(fileName)) {
            throw new RecursiveException();
          }

          result.append(launchCommand(userCommand)).append("\n");
          line = bufferedReader.readLine();

        } catch (CommandException e) {
          result.append("Команда не найдена").append("\n");
        } catch (NullPointerException e) {
          result.append("Ошибка ввода").append("\n");
        } catch (RecursiveException e) {
          return result.toString() + "Ошибка : файл рекурсивен";
        }
      }
      scriptMode = false;
      return result.toString();
    } catch (FileNotFoundException e) {
      return "Файл не найден";
    } catch (IOException e) {
      return "Ошибка";
    }
  }

}
