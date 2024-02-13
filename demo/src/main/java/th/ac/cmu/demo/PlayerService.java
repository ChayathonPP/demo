package th.ac.cmu.demo;

import java.util.List;

public interface PlayerService {
    Player createPlayer(String name);
    Player getPlayerInformation(String name);
    Player addClicks(String name);
    List<Player> getLeaderboard();

}
