package data;
//TODO: ADD METHODS

import java.util.LinkedList;
import java.util.List;

/**
 * Класс MusicGenre
 */
public enum MusicGenre {
    PROGRESSIVE_ROCK,
    HIP_HOP,
    PSYCHEDELIC_CLOUD_RAP,
    SOUL,
    POST_PUNK;

    public static List<String> toListString() {
        var list = new LinkedList<String>();
        list.add("PROGRESSIVE_ROCK");
        list.add("HIP_HOP");
        list.add("PSYCHEDELIC_CLOUD_RAP");
        list.add("SOUL");
        list.add("POST_PUNK");

        return list;
    }
}