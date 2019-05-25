package Heldeweg.Chess.api;

import Heldeweg.Chess.model.piece.Piece;
import Heldeweg.Chess.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/pieces")
@CrossOrigin("*")
public class PieceController {

    @Autowired
    private PieceService pieceService;

    @PostMapping
    public Piece create(Piece piece){
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
            return Piece;
        }
    }
}
