package heldeweg.chess.model.piece;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int xPos;
    private int yPos;

    private int team;


    public Piece() {
    }

    public Piece(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public long getId() {
        return id;
    }


    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Set<Piece> newGame(){
        Set<Piece> pieceSet = new HashSet<>();
        //pawns
        for(int pawns = 0; pawns < 8; pawns++) pieceSet.add(new Piece("p", pawns, 1));
        //rooks

        pieceSet.add(new Piece("r", 0,0)); pieceSet.add(new Piece("r", 7,0));

        //knights
        pieceSet.add(new Piece("k", 1,0)); pieceSet.add(new Piece("k", 6,0));

        //bishops
        pieceSet.add(new Piece("b", 2, 0)); pieceSet.add(new Piece("b", 5, 0));

        //Queen and King
        pieceSet.add(new Piece("Q", 3, 0)); pieceSet.add(new Piece("K", 4, 0));

        return pieceSet;

    }
}
