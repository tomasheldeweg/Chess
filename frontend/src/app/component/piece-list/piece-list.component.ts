import { Component, OnInit } from '@angular/core';
import { PieceService } from '../../services/piece.service';
import { Piece } from '../../model/piece';

@Component({
  selector: 'app-piece-list',
  templateUrl: './piece-list.component.html',
  styleUrls: ['./piece-list.component.css']
})
export class PieceListComponent implements OnInit {

  imgBasePath = "/src/assets/"
  pieces:Piece[];
  board = Array(8).fill("white").map(() => Array(8).fill("e"));
  constructor(private pieceService:PieceService) { }

  ngOnInit() {
    this.getPieces();
  }

  getPieces(){
    this.pieceService.listAll().subscribe(data => {
      this.pieces = data
      this.fillBoard()
    })
  }

  fillBoard(){
    var imgPath:string;
    for(let p of this.pieces){
      imgPath
      this.board[p.yPos][p.xPos] = p.name
    }
  }
}
