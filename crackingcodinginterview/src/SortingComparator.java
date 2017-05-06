import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class SortingComparator implements Comparator<Player> {

    @Override
    public int compare(Player one, Player two) {
        if(one.score != two.score) {
            return two.score - one.score;
        }

        return one.name.compareTo(two.name);
    }

}


