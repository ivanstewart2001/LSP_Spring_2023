package howard.edu.lsp.finals.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

    public void addSong(String genre, String songTitle) {
        if (!this.map.containsKey(genre)) {
            map.put(genre, new HashSet<String>());
        }
        map.get(genre).add(songTitle);
    }

    public Set<String> getSongs(String genre) {
        return map.getOrDefault(genre, new HashSet<String>());
    }

    public String getGenreOfSong(String songTitle) {
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
