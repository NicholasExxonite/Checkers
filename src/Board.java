import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame  {
    //number of rows and cols
    private int rows = 8, cols = 8;
    //an array of arrays to hold each square with it's correct position.
    private Square[][] checkerBoard = new Square[8][8];
    //variables that store the information needed for a movement.
    // selRow and selCol are the rows and cols of the piece that is to be moved.
    // toRow and toCol are the rows and cols of the empty square that the piece is to be moved to.
    private int toRow, toCol, selRow, selCol;
    //A boolean variable that stores information whether a piece is selected or not.
    private boolean selected;

//Constructor for the Board window. Title is chosen in the main class.
    public Board(String title) {
        super(title);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));
        //Feeling in the checkerBoard array with squares and pieces.
        setUpBoard();
        //Add the checkerBoard
        addCheckerboard();
        this.setVisible(true);
        //repainting the window after all the changes.
        this.repaint();


    }
    //Called in the constructor. This method fills up an array of arrays(checkerBoard) with squares/pieces.
    private void setUpBoard() {
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                //put white pieces in their correct positions.
                if (((c == 5 || c == 7) && r % 2 == 0) || (c == 6 && r % 2 != 0)) {
                    Square square = new Square(c, r, "WHITE");
                    checkerBoard[c][r] = square;
                    //Action listeners that checks if a white piece is clicked.
                    //if it's clicked then set selected=true, indicating that a piece was selected
                    // selRow and selCol are set to the current row and col of the square that was clicked.
                    square.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            selected = true;
                            selRow = square.getRow();
                            selCol = square.getCol();
                            //simple console prints that help with orientation and debugging.
                            System.out.println("Piece!");
                            if(selected){
                                System.out.println("Chose where to move");
                            }
                        }
                    });
                    //Fill up checkerBoard with empty squares. White and black empty squares' position is determined
                    // in the Square constructor.
                } else {
                    Square square = new Square(c, r, "NONE");
                    checkerBoard[c][r] = square;
                    //Actionlistener for the empty squares. If no piece has been selected, aka selected=false
                    //do nothing, if a piece has been selected, aka selected=true, then
                    //save the row and col of the empty square that was clicked to the instance variables toRow, toCol
                    //and call the toMove method from Square class, using as a parameter the previously clicked and saved piece.
                    //Finally set selected to false, so we can then do other moves.
                    square.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("empty square");
                            if(!selected){
                                System.out.println("Chose a piece to move");
                            }
                            else {
                                toRow = square.getRow();
                                toCol = square.getCol();

                                square.toMove(checkerBoard[selCol][selRow]);
                                System.out.println("Piece moved");
                                selected = false;
                            }
                        }
                    });
                }
            }
        }
    }
    // a method that adds the checkerBoard to the Board window.
    private void addCheckerboard(){
        for(int r =0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                add(checkerBoard[r][c]);
            }
        }
    }

}