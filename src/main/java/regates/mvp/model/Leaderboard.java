package regates.mvp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Leaderboard {

    private List<Score> scores = new ArrayList<>();
    private static Leaderboard instance;

    public static Leaderboard getInstance() {
        if (instance == null)
            instance = new Leaderboard();
        return instance;
    }

    //"/regates/mvp/scoresData.txt"
    public void readScore(String path) {
        String[] buffer;
        Scanner scanner = null;
        try {
            String s = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(path)).getPath();
            File f = new File(s);
            scanner = new Scanner(f);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                buffer = line.split(";");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                scores.add(new Score(buffer[0], Float.parseFloat(buffer[1]), formatter.parse(buffer[2])));
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }

    public void sortByDate() {
        Collections.sort(scores, Score.ComparatorDate);
    }

    public void sortByScore() {
        Collections.sort(scores, Score.ComparatorScore);
    }

    public void sortByName() {
        Collections.sort(scores, Score.ComparatorPlayer);
    }
}
