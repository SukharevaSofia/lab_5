package tools;

import data.*;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Класс, осуществляющий ввод пользователем параметров объекта MusicBand
 */


public class DataInput {

    public static String askName() {
        String name;
        while (true) {

            try {
                if (CommandFinder.scriptMode) {
                    name = ConsoleUI.bufferedReader.readLine();
                } else {
                    ConsoleUI.output("Введите имя группы: ");
                    name = ConsoleUI.reader.next();
                }
                if (name.equals("")) {
                    ConsoleUI.output("Строка пустая! Введите имя группы.");
                    continue;
                }
                break;
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return name;
    }

    public static float askX() {
        float x;
        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    x = Float.parseFloat(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите число х: ");
                    x = Float.parseFloat(ConsoleUI.reader.next());
                }
                break;
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Х должен быть числом! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return x;
    }

    public static Integer askY() {
        Integer y;
        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    y = Integer.parseInt(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите число y: ");
                    y = Integer.parseInt(ConsoleUI.reader.next());
                }
                break;
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Y должен быть числом! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return y;
    }

    public static Coordinates askCoordinates() {
        return new Coordinates(askX(), askY());
    }


    public static Integer askNumberOfParticipants() {
        Integer numberOfParticipants;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    numberOfParticipants = Integer.parseInt(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите количество участников группы (число должно быть больше нуля): ");
                    numberOfParticipants = Integer.parseInt(ConsoleUI.reader.next());
                }
                if (numberOfParticipants > 0)
                    break;
                else {
                    ConsoleUI.output("Количество участников должно быть числом больше нуля! Повторите ввод.");
                }
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Количество участников должно быть числом больше нуля! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return numberOfParticipants;
    }

    public static Integer askAlbumsCount() {
        Integer albumsCount;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    albumsCount = Integer.parseInt(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите количество альбомов (число должно быть больше нуля): ");
                    albumsCount = Integer.parseInt(ConsoleUI.reader.next());
                }
                if (albumsCount > 0)
                    break;
                else {
                    ConsoleUI.output("Количество участников должно быть числом больше нуля! Повторите ввод.");
                }
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Количество участников должно быть числом больше нуля! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return albumsCount;
    }

    public static String askDescription() {
        String description;
        int imsorry = 0;
        /*
        Проблема: при insert программа выводила на экран "введите описание" и
        сразу же после этого "строка пустая! повторите ввод".
        Фикс (костыль и мне стыдно, нужно сделать умнее но дедлайн...):
        в начале imsorry=0, программа просит ввести описание. Чтобы
        избежать сообщения о пустой строке, при imsorry==0 программа не
        выводит это сообщение. После чего imsorry+=1 и если поле правда пустое
        программа уже выведет сообщение об этом
         */
        while (true) {

            try {
                if (CommandFinder.scriptMode) {
                    description = ConsoleUI.bufferedReader.readLine();
                } else {
                    if (imsorry == 0){
                    ConsoleUI.output("Введите описание группы: ");
                    description = ConsoleUI.reader.nextLine();
                    }
                    else {description = ConsoleUI.reader.nextLine();}
                }
                if (description.equals("") ) {
                    if(imsorry == 0){ imsorry += 1; continue;}
                    ConsoleUI.output("Строка пустая! Введите описание группы.");
                    continue;
                }
                break;
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return description;
    }

    public static MusicGenre askMusicGenre() {
        String string;
        MusicGenre musicGenre;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    string = ConsoleUI.bufferedReader.readLine();
                } else {
                    ConsoleUI.output("Список доступных жанров: \n" + MusicGenre.toListString());
                    ConsoleUI.output("Выберите нужный жанр: ");
                    string = ConsoleUI.reader.next();
                }
                musicGenre = MusicGenre.valueOf(string.toUpperCase());
                break;
            } catch (NoSuchElementException | IllegalArgumentException | IllegalStateException e) {
                ConsoleUI.output("Что-то пошло не так! Выберите жанр музыки ещё раз.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return musicGenre;
    }


    public static String askBestAlbumName() {
        String bestAlbumName;
        while (true) {

            try {
                if (CommandFinder.scriptMode) {
                    bestAlbumName = ConsoleUI.bufferedReader.readLine();
                } else {
                    ConsoleUI.output("Введите название лучшего альбома: ");
                    bestAlbumName = ConsoleUI.reader.next();
                }
                if (bestAlbumName.equals("")) {
                    ConsoleUI.output("Строка пустая! Введите название лучшего альбома.");
                    continue;
                }
                break;
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }

        return bestAlbumName;
    }

    public static long askBestAlbumLength() {
        long bestAlbumLength;

        while (true) {
            try {
                if (CommandFinder.scriptMode) {
                    bestAlbumLength = Long.parseLong(ConsoleUI.bufferedReader.readLine());
                } else {
                    ConsoleUI.output("Введите количество песен лучшего альбома: ");
                    bestAlbumLength = Long.parseLong(ConsoleUI.reader.next());
                }
                if (bestAlbumLength > 0)
                    break;
                else {
                    ConsoleUI.output("Количество песен лучшего альбома должно быть числом больше нуля! Повторите ввод.");
                }
            } catch (final NumberFormatException e) {
                ConsoleUI.output("Количество песен лучшего альбома должно быть числом больше нуля! Повторите ввод.");
            } catch (IOException e) {
                ConsoleUI.output("");
            }
        }
        return bestAlbumLength;
    }

    public static BestAlbum askBestAlbum() {
        return new BestAlbum(askBestAlbumName(), askBestAlbumLength());
    }


        public static MusicBand askMusicBand () {
            return new MusicBand(askName(), askCoordinates(), askNumberOfParticipants(),
                    askAlbumsCount(), askDescription(), askMusicGenre(), askBestAlbum());
        }
}
