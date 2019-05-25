package heldeweg.chess.model.game;

import heldeweg.chess.model.piece.Piece;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "game")
    private Set<Piece> pieces = new HashSet<>();

    public void addPiece(Piece piece){
        this.pieces.add(piece);
        piece.setGame(this);
    }

    public Set<Piece> getPieces() {
        return this.pieces;
    }

    public long getId() {
        return id;
    }

    public Set<Piece> newGame(){
        Set<Piece> pieceSet = new HashSet<>();

        //BLACK PIECES
        for(int pawns = 0; pawns < 8; pawns++) pieceSet.add(new Piece("p", pawns, 1, 1));        //pawns
        pieceSet.add(new Piece("r", 0,0, 1)); pieceSet.add(new Piece("r", 7,0, 1));        //rooks
        pieceSet.add(new Piece("k", 1,0 ,1)); pieceSet.add(new Piece("k", 6,0, 1));        //knights
        pieceSet.add(new Piece("b", 2, 0, 1)); pieceSet.add(new Piece("b", 5, 0, 1));        //bishops
        pieceSet.add(new Piece("Q", 3, 0, 1)); pieceSet.add(new Piece("K", 4, 0, 1));        //Queen and King

        //WHITE PIECES
        for(int pawns = 0; pawns < 8; pawns++) pieceSet.add(new Piece("p", pawns, 6, 0));        //pawns
        pieceSet.add(new Piece("r", 0,7, 1)); pieceSet.add(new Piece("r", 7,7, 1));        //rooks
        pieceSet.add(new Piece("k", 1,7 ,1)); pieceSet.add(new Piece("k", 6,7, 1));        //knights
        pieceSet.add(new Piece("b", 2, 7, 1)); pieceSet.add(new Piece("b", 5, 7, 1));        //bishops
        pieceSet.add(new Piece("Q", 3, 7, 1)); pieceSet.add(new Piece("K", 4, 7, 1));        //Queen and King

        return pieceSet;

    }
}
