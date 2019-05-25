package Heldeweg.Chess.service;

import Heldeweg.Chess.model.piece.Piece;
import Heldeweg.Chess.persistence.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PieceService {

    @Autowired
    private PieceRepository pieceRepository;

    public Optional<Piece> findById(long id){ return this.pieceRepository.findById(id); }

    public Piece save(Piece piece){
        return this.pieceRepository.save(piece);
    }

    public Iterable<Piece> findAll() {
        return this.pieceRepository.findAll();
    }
}
