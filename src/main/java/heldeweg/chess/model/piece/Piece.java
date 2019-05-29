package heldeweg.chess.model.piece;

import heldeweg.chess.model.game.Game;

import javax.persistence.*;
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

    private String team;

    @ManyToOne
    private Game game;

    public Piece() {
    }

    public Piece(String name, int xPos, int yPos, String team) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.team = team;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public long getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
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


}
