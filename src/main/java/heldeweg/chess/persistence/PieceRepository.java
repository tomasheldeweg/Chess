package heldeweg.chess.persistence;

import heldeweg.chess.model.piece.Piece;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Long> {


}
