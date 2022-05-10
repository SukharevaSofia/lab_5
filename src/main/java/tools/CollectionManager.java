package tools;

import java.io.File;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import data.*;

/**
 * Класс, управляющий коллекцией
 */
public class CollectionManager {
    private static LinkedHashMap<Integer, MusicBand> data = new LinkedHashMap<Integer, MusicBand>();
    private LocalDate lastInitTime;
    private LocalDate lastSaveTime;
    private String readEnv;
    private String writeEnv;

    public CollectionManager(String readEnv, String writeEnv){
        this.readEnv = readEnv;
        this.writeEnv = writeEnv;
        init();
    }


    public final void init() {
        data = JsonManager.readCollection(readEnv);
    }

    public final String show() {
        if(data.size() > 0) {
            String output = data.entrySet().stream()
                    .map(entry -> entry.getValue().toString())
                    .collect(Collectors.joining("\n"));
            return output;
        }
        else return "Коллекция пуста";
    }

    public final String info(){

        try{
            if(lastSaveTime == null || lastInitTime == null) throw new NullPointerException();
            return "Время последней инициализации : " +  lastInitTime + "\n" +
                    "Время последнего сохранения : " + lastSaveTime + "\n" +
                    "Тип : " + data.getClass() + "\n" +
                    "Количество элементов : " + data.size() + "\n";
        }
        catch (NullPointerException e){

            try{
                if(lastSaveTime == null || lastInitTime == null) throw new NullPointerException();
                return "Время последней инициализации : " +  lastInitTime + "\n" +
                        "Время последнего сохранения коллекции не было сохранено\n" +
                        "Тип : " + data.getClass() + "\n" +
                        "Количество элементов : " + data.size() + "\n";
            }
            catch (NullPointerException e1){
                return
                        "Время последней инициализации : коллекция не найдена!\n" +
                                "Время последнего сохранения коллекции не было сохранено\n" +
                                "Тип : " + data.getClass() + "\n" +
                                "Количество элементов : " + data.size() + "\n"
                        ;

            }

        }
    }

    public final String insert() {
        var musicBand = DataInput.askMusicBand();
        data.put(musicBand.getId(), musicBand);
        lastInitTime = LocalDate.now();
        return "Успешный ввод!";
    }

    public final String removeById(String id) {
        try {
            int newId = Integer.parseInt(id);
            if (data.containsKey(newId)) {
                data.remove(newId);
                return "Удаление прошло успешно!";
            } else
                return "ID не найден!";
        } catch (NumberFormatException e) {
            return "ID должен быть числом!";
        }
    }

    public final String clear() {
        data.clear();
        return "Коллекция очищена";
    }

    public final String updateById(String id) {

        try {
            int newId = Integer.parseInt(id);
            if (data.containsKey(newId)) {
                data.remove(newId);
                data.put(newId, DataInput.askMusicBand());
                return "Успешно обновлено!";
            } else
                return "ID не найден!";

        } catch (NumberFormatException e) {
            return "ID должен быть числом!";
        }
    }

    public String save(){

        File file = new File("fileName");//добавить имя файла
        lastSaveTime = LocalDate.now();
        return JsonManager.writeCollection(data, writeEnv);

    }

    public String removeGreater(String element) {

        for (Map.Entry<Integer, MusicBand> map : data.entrySet()) {

            if (map.getValue().getName().compareTo(element) < 0) {
                data.remove(map.getKey());
            }
        }
        return "Элементы удалены";
    }

    public String replaceIfLower(String element){

        int cnt = 0;
        for (Map.Entry<Integer, MusicBand> map : data.entrySet()) {

            if (map.getValue().getName().compareTo(element) < 0) {
                map.getValue().setName(DataInput.askName());
                cnt++;
            }
        }

        if(cnt == 0){
            return "Значений меньше, чем " + element + " не найдено!";
        }
        else if(cnt == 1) {
            return "Значение успешно изменено!";
        }
        else return "Значения успешно изменены!";

    }

    public String removeGreaterKey(String key){

        try{
            int cnt = 0;
            int newKey = Integer.parseInt(key);
            for(int keys : data.keySet()){

                if(keys < newKey){
                    data.remove(keys);
                    cnt++;
                }
            }
            if(cnt == 0){
                return "Значений больше, чем " + key + " не найдено!";
            }
            else if(cnt == 1) {
                return "Значение успешно удалено!";
            }
            else return "Значения успешно удалены!";
        }
        catch (NumberFormatException e){
            return "Ключ должен являться числом!";
        }
    }

    public String filterLessThanGenre(String genre){

        LinkedList<MusicBand> musicBands = new LinkedList<MusicBand>();
        MusicGenre newGenre = MusicGenre.valueOf(genre.toUpperCase());
        try {
            for (Map.Entry<Integer, MusicBand> map : data.entrySet()) {

                if (map.getValue().getGenre().compareTo(newGenre) > 0) {
                    musicBands.add(map.getValue());
                }
            }
            return musicBands.stream().distinct().toString();
        }
        catch(NumberFormatException e){
            return "Аргумент должен быть названием жанра!";
        }
    }

    public String countGreaterThanDescription(String description){
        try{
            String newDescription = description;
            int cnt = 0;
            for (Map.Entry<Integer, MusicBand> map : data.entrySet()) {

                if (map.getValue().getDescription().compareTo(description) < 0) {
                    cnt++;
                }
            }
            return cnt + "";
        }
        catch (NumberFormatException e){
            return "Аргумент должен быть строкой!";
        }
    }

    public String printDescendingParticipants(){

        List<Integer> participantsOrder = new ArrayList<>();

        for (Map.Entry<Integer, MusicBand> map : data.entrySet()) {
                participantsOrder.add(map.getValue().getNumberOfParticipants());
        }
        participantsOrder.sort(Collections.reverseOrder());

        return participantsOrder.toString();
    }

    @Override
    public String toString() {
        return "CollectionManager []";
    }
}
