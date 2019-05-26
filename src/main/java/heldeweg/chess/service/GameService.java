package heldeweg.chess.service;

import heldeweg.chess.model.game.Game;
import heldeweg.chess.persistence.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    public Game save(Game game) {
        return this.gameRepository.save(game);
    }

    public Iterable<Game> listAll() {
        return this.gameRepository.findAll();
    }
}
