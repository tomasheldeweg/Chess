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
        for(int pawns = 0; pawns < 8; pawns++) pieceSet.add(new Piece("pawn", pawns, 1, "b"));        //pawns
        pieceSet.add(new Piece("rook", 0,0, "b")); pieceSet.add(new Piece("rook", 7,0, "b"));        //rooks
        pieceSet.add(new Piece("knight", 1,0 ,"b")); pieceSet.add(new Piece("knight", 6,0, "b"));        //knights
        pieceSet.add(new Piece("bishop", 2, 0, "b")); pieceSet.add(new Piece("bishop", 5, 0, "b"));        //bishops
        pieceSet.add(new Piece("queen", 3, 0, "b")); pieceSet.add(new Piece("king", 4, 0, "b"));        //Queen and King

        //WHITE PIECES
        for(int pawns = 0; pawns < 8; pawns++) pieceSet.add(new Piece("pawn", pawns, 6, "w"));        //pawns
        pieceSet.add(new Piece("rook", 0,7, "w")); pieceSet.add(new Piece("rook", 7,7, "w"));        //rooks
        pieceSet.add(new Piece("knight", 1,7 ,"w")); pieceSet.add(new Piece("knight", 6,7, "w"));        //knights
        pieceSet.add(new Piece("bishop", 2, 7, "w")); pieceSet.add(new Piece("bishop", 5, 7, "w"));        //bishops
        pieceSet.add(new Piece("queen", 3, 7, "w")); pieceSet.add(new Piece("king", 4, 7, "w"));        //Queen and King

        return pieceSet;

    }
}
