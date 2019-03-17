import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;

public class Board extends JPanel implements ActionListener{
    //instance variables
    private JFrame board;
    private BasicOptionPaneUI.ButtonActionListener actionListener;
    private int squareXpos, tomoveXpos;
    private int squareYpos, tomoveYpos;
    //private MouseListener mouseListener;
    //Panels not needed for now. Were just a test.
    //panel array to hold the positions of each square
    private JPanel checkerBoard;
    private int rows = 8;
    private int cols = 8;
    private Square[][] squares;
    private Square tomoveSquare;
    //private int numSquares = 64;

    //METHODS

    //preparing the board
    Board(){
        board = new JFrame("Checkers");
        board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board.setSize(500, 500);
        checkerBoard = new JPanel();
        checkerBoard.setLayout(new GridLayout(8, 8));
        //array of arrays to hold the squares
        /*Piece piece = new Piece("empty.png");*/
        squares = new Square[8][8];
        //array of panels, each holding a single square. THIS IS JUST A TEST.
        /*backBoard = new JPanel[64];*/

        //initializing the squares into the board.
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                squares[i][j] = new Square("empty.png");

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
                if(((i == 0 || i == 2) && j % 2 != 0) || (i == 1 && j % 2 == 0)){
                    /*squares[i][j].changeColour("red.png");*/
                    squares[i][j] = new Square("red.png");
                }
                if(((i == 5 || i == 7) && j % 2 == 0) || (i == 6 && j % 2 != 0)){
                    /*squares[i][j].changeColour("white.png");*/
                    squares[i][j] = new Square("white.png");

                }

                squares[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        System.out.println("Button!");
                    }
                });
                checkerBoard.add(squares[i][j].getSquare());
                checkerBoard.repaint();

            }
        }

        checkerBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Yoooo");
            }
        });
        checkerBoard.setVisible(true);
        board.add(checkerBoard);
        board.setVisible(true);

    }
    //Not needed now/ wrong.
    public void addSquares(Square button){
        checkerBoard.add(button.getSquare());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("yoo");
    }
    public void move(){

    }
    /*@Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("I was clicked");
        for (int i =0; i < rows; i++) {
            for (int j = 0; i < cols; i++){
                if (squares[i][j].getIcon().toString().equals("red.png") || squares[i][j].getIcon().toString().equals("white.png")) {
                    squareXpos = squares[i][j].getLocation().x;
                    squareYpos = squares[i][j].getLocation().y;
                    System.out.println("I was clicked!: " + squares[i][j].getLocation().x + " " + squares[i][j].getLocation().y);
                } else {
                    tomoveSquare = squares[i][j];
                    tomoveXpos = squares[i][j].getLocation().x;
                    tomoveYpos = squares[i][j].getLocation().y;
                    System.out.println("not a piece");
                }
            }
        }
    }*/
}
