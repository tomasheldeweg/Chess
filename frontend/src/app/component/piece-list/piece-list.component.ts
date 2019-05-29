import { Component, OnInit } from '@angular/core';
import { PieceService } from '../../services/piece.service';
import { Piece } from '../../model/piece';
import { connectableObservableDescriptor } from 'rxjs/internal/observable/ConnectableObservable';

@Component({
  selector: 'app-piece-list',
  templateUrl: './piece-list.component.html',
  styleUrls: ['./piece-list.component.css']
})
export class PieceListComponent implements OnInit {

  imgBasePath = "assets/pieces/"
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
      this.board[p.yPos][p.xPos] = this.imgBasePath + p.team + "_" + p.name + ".png"
    }
  }


  dragStart(event:Event){
    event.preventDefault();
    console.log("in drag start")
  }

  allowDrop(event:Event){
    event.preventDefault();
  }
  
  drag(event){
    event.dataTransfer.setData("text", event.target.id);
  }


  drop(event){
    event.preventDefault();
    var data = event.dataTransfer.getData("text");
    event.target.appendChild(document.getElementById(data));
  }

  dragEnd(event:Event){
    event.preventDefault();
  }
  
}


