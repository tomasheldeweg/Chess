package heldeweg.chess.api;

import heldeweg.chess.model.game.Game;
import heldeweg.chess.model.piece.Piece;
import heldeweg.chess.service.GameService;
import heldeweg.chess.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/games")
@CrossOrigin("*")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PieceService pieceService;

    @GetMapping
    public Iterable<Game> listAll(){
        return this.gameService.listAll();
    }

    @PostMapping("/new-Game")
    public Game save(){

        Game game = new Game();
        this.gameService.save(game);

        Set<Piece> pieceSet = game.newGame();
        for(Piece piece : pieceSet){
            game.addPiece(piece);
            this.pieceService.save(piece);
        }

        return this.gameService.save(game);
    }


}
