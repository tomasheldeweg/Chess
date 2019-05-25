package heldeweg.chess.persistence;

import heldeweg.chess.model.game.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
