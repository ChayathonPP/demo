package th.ac.cmu.demo;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PlayerRepository implements PlayerService{
    private Map<String, Player> map = new HashMap<>();

    @Override
    public Player createPlayer(String name) {
        if(map.containsKey(name)){
            return map.get(name);
        }
        Player player = new Player(name);
        map.put(name,player);
        return player;
    }
    @Override
    public Player getPlayerInformation(String name) {
        return map.get(name);
    }

    @Override
    public Player addClicks(String name) {
        Player player = map.get(name);
        if (player != null) {
            player.clicked++;
            return player;
        } else {
            return null;
        }
    }
    @Override
    public List<Player> getLeaderboard() {
        return map.values().stream()
                .sorted(Comparator.comparing(Player::getClicked).reversed().thenComparing(Player::getName))
                .collect(Collectors.toList());
    }
}
