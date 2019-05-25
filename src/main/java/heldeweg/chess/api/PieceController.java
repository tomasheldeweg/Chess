package heldeweg.chess.api;

import heldeweg.chess.model.piece.Piece;
import heldeweg.chess.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/pieces")
@CrossOrigin("*")
public class PieceController {

    @Autowired
    private PieceService pieceService;

    @PostMapping
    public Piece create(@RequestBody  Piece piece){
        return this.pieceService.save(piece);
    }

    @GetMapping("{id}")
    public Optional<Piece> findById(@PathVariable long id){
        return this.pieceService.findById(id);
    }

    @GetMapping
    public Iterable<Piece> listAll(){
        return this.pieceService.findAll();
    }

    @PutMapping("{id}")
    public Piece update(@RequestBody Piece input, @PathVariable long id){
        Optional<Piece> optionalTarget = this.pieceService.findById(id);
        if(optionalTarget.isPresent()){
            Piece piece = optionalTarget.get();
            piece.setxPos(input.getxPos());
            piece.setyPos(input.getyPos());
            return piece;
        }
        else return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        Optional<Piece> optionalTarget = this.pieceService.findById(id);
        if(optionalTarget.isPresent()) this.pieceService.deleteById(id);

    }
}
