package tools;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.reflect.TypeToken;
import data.MusicBand;
import exceptions.*;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

/**
 * Сериализация и десеарилизация данных в JSON файл.
 */
public final class JsonManager {

    private static Gson gson = new Gson();

    public static final String extractFilePath(String cmdargs) throws FailedFilePathExtraction {
        String[] list = cmdargs.trim().split("");
        String filePath = "";
        boolean found = false;
        for (String s : list) {
            if (s.equals("-f"))
                found = true;
            if (found) {
                filePath = s;
                break;
            }
        }
        if (filePath == "") {
            throw new FailedFilePathExtraction();
        }
        return filePath;
    }
    // проверка на права доступа
    public static final File getfile(String filePathString) throws FileNotAccessible {
        File file = new File(filePathString);
        if (file.canRead() && file.canWrite()) {
            return file;
        } else
            throw new FileNotAccessible();
    }

    /**
     * Записывает коллекцию в переданный файл.
     *
     * @param collection Коллекция для записи.
     */
    public static String writeCollection(LinkedHashMap<Integer, MusicBand> collection, String env) {
        try (FileOutputStream file = new FileOutputStream(System.getenv(env));
                OutputStreamWriter collectionFileWriter = new OutputStreamWriter(file)) {
            collectionFileWriter.write(gson.toJson(collection));
            return "Записано!";
        } catch (IOException exception) {
            return "IOException. Файл не может быть открыт.";
        }catch (NullPointerException e){
            return "Файл по переменной окружения не найден";
        }
    }

    public static LinkedHashMap<Integer, MusicBand> readCollection(String readEnv) {
        try {
            var collection = new LinkedHashMap<Integer, MusicBand>();
            File file = new File(System.getenv(readEnv));
            try (Scanner collectionFileScanner = new Scanner(file)) {
                Type collectionType = new TypeToken<LinkedHashMap<Integer, MusicBand>>() {}.getType();
                collection = gson.fromJson(collectionFileScanner.nextLine().trim(), collectionType);
                ConsoleUI.message("Успешно загружено!");
            } catch (FileNotFoundException exception) {
                ConsoleUI.error("Файл не найден!");
            } catch (NoSuchElementException exception) {
                ConsoleUI.error("Файл пустой!");
            } catch (JsonParseException | NullPointerException exception) {
                ConsoleUI.error("Невалидный JSON!");
            } catch (IllegalStateException exception) {
                ConsoleUI.error("Непредвиденная ошибка :(");
                exception.printStackTrace();
                System.exit(0);
            }

            return collection;
        }
        catch (NullPointerException e){
            ConsoleUI.output("Переменная окружения с загрузочным файлом не найдена");
            return new LinkedHashMap<Integer, MusicBand>();
        }
    }

    @Override
    public String toString() {
        return "Класс JsonManager занимается чтением/записью в файл.";
    }
}
