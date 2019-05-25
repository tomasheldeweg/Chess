package Heldeweg.Chess.persistence;

import Heldeweg.Chess.model.piece.Piece;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Long> {


}
