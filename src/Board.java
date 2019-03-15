import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;

public class Board {
    //instance variables
    private JFrame checkerBoard;
    private BasicOptionPaneUI.ButtonActionListener actionListener;
    //private MouseListener mouseListener;
    //Panels not needed for now. Were just a test.
    //panel array to hold the positions of each square
    //private JPanel backBoard[];
    private int rows = 8;
    private int cols = 8;
    //private int numSquares = 64;

    //METHODS

    //preparing the board
    Board(){
        checkerBoard = new JFrame("Checkers");
        checkerBoard.setLayout(new GridLayout(8, 8));
        checkerBoard.setSize(600, 600);
        checkerBoard.setVisible(true);
        checkerBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //array of arrays to hold the squares
        Square[][] squares = new Square[8][8];
        //array of panels, each holding a single square. THIS IS JUST A TEST.
        /*backBoard = new JPanel[64];*/
        int count = 24;

        //initializing the squares into the board.
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                squares[i][j] = new Square("empty.png");
                //JPanel panel = new JPanel();
                if (j % 2 == 0 && i % 2 == 0){
                    squares[i][j].changeColour("empty2.png");
                }
                else if(j % 2 == 0 && i % 2 !=0){
                    squares[i][j].changeColour("empty.png");
                }
                else if (j%2 != 0 && i % 2 != 0){
                    squares[i][j].changeColour("empty2.png");
                }
                else if (j%2 !=0 && i % 2 == 0){
                    squares[i][j].changeColour("empty.png");
                }
                /*panel.add(squares[i][j].getSquare());
                panel.setPreferredSize(new Dimension(100,100));
                backBoard[count] = panel;
                checkerBoard.add(panel);
                count++;*/
                //Seems to be working better with just the squares(JBUTTONS) instead of putting them in Panels, for now.
                checkerBoard.add(squares[i][j].getSquare());
                //squares[i][j].addActionListener
            }
        }
        // Change the colour of squares to red pieces(for the first player)
        for(int i = 0; i < 3; i++){
            {
                for(int j = 0; j < rows; j++){
                    if(((i == 0 || i == 2) && j % 2 != 0) || (i == 1 && j % 2 == 0)){
                        squares[i][j].changeColour("red.png");
                    }
                }
            }
        }
        for(int i = 5; i < 8; i++){
            {
                for(int j = 0; j < rows; j++){
                    if(((i == 5 || i == 7) && j % 2 == 0) || (i == 6 && j % 2 != 0)){
                        squares[i][j].changeColour("white.png");
                    }
                }
            }
        }
    }
    //Not needed now/ wrong.
    public void addSquares(Square button){
        checkerBoard.add(button.getSquare());
    }
}
