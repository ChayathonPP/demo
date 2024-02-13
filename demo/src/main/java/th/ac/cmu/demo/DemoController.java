package th.ac.cmu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DemoController {
    @Autowired
    private PlayerService playerService;
    @PostMapping("/player")
    public Player createNewPlayer(@RequestBody String body){
        return this.playerService.createPlayer(body);
    }
    @GetMapping("/player/{name}")
    public ResponseEntity<Player> getPlayerInformation(@PathVariable String name) {
        Player player = playerService.getPlayerInformation(name);

        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/player/{name}")
    public ResponseEntity<Player> addClicks(@PathVariable String name) {
        Player player = playerService.addClicks(name);

        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/player/leaderboard")
    public ResponseEntity<List<Player>> getLeaderboard() {
        List<Player> leaderboard = playerService.getLeaderboard();

        if (!leaderboard.isEmpty()) {
            return ResponseEntity.ok(leaderboard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
