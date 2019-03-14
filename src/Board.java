import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;

public class Board {
    //instance variables
    private JFrame checkerBoard;
    //panel array to hold the positions of each square
    private JPanel backBoard[];
    private int rows = 8;
    private int cols = 8;
    //private int numSquares = 64;

    //METHODS
    //preparing the board
    public void prepareBoard(){
        checkerBoard = new JFrame("Checkers");
        checkerBoard.setLayout(new GridLayout(8, 8));
        checkerBoard.setSize(600, 600);
        checkerBoard.setVisible(true);
        checkerBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //array of arrays to hold the squares
        Square[][] squares = new Square[8][8];
        //array of panels, each holding a single square.
        backBoard = new JPanel[64];

        //initializing the squares into the board.
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                squares[i][j] = new Square();
                JPanel panel = new JPanel();
                if (j % 2 == 0 && i % 2 == 0){
                    squares[i][j].changeColour("empty.png");
                }
                else if(j % 2 == 0 && i % 2 !=0){
                    squares[i][j].changeColour("empty2.png");
                }
                else if (j%2 != 0 && i % 2 != 0){
                    squares[i][j].changeColour("empty.png");
                }
                else if (j%2 !=0 && i % 2 == 0){
                    squares[i][j].changeColour("empty2.png");
                }
                panel.add(squares[i][j].getSquare());
                backBoard[i+j] = panel;
                checkerBoard.add(panel);
                //checkerBoard.add(squares[i][j].getSquare());
            }
        }
    }
    //adding buttons
    public void addSquares(Square button){
        checkerBoard.add(button.getSquare());
    }


}
