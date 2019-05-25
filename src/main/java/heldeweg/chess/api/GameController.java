package heldeweg.chess.api;

import heldeweg.chess.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/games")
@CrossOrigin("*")
public class GameController {

    @Autowired
    private GameService gameService;

}
