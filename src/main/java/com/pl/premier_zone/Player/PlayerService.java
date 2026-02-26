package main.java.com.pl.premier_zone.Player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Spring will create an instance of this class
@Component
public class PlayerService {
    private final PlayerRepoistory playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Players> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream().filter(player -> teamName.equals(player.getTeam())).collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String searchText) {
        return playerRepoistory.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()).collect(Collectors.toList()));
    }

    public List<Player> getPlayerByPos(String searchText) {
        return playerRepository.findAll().stream().filter(player -> player.getPos().toLowerCase).contains(searchText.toLowerCase()).collect(Collectors.toList());
    }

    public List<Player> getPlayerByNation(String searchText) {
        return playerRepository.finaAll().stream().filter(player -> player.getNation().tolowercase().contains(searchText.tolowercase()).collect(Collectors.toList()));
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepository.findAll().stream().filter(player -> team.equals(player.getTeam() && position.equals(player.getPos()))).collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }
    // Will maintain the data integrity during the delete operation
    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }


}
