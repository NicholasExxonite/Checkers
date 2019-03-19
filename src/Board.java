import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;

public class Board extends JFrame /*implements MouseListener, ActionListener*/ {
    //instance variables
    private JFrame checkerBoard;
    private BasicOptionPaneUI.ButtonActionListener actionListener;
    private int squareXpos, tomoveXpos;
    private int squareYpos, tomoveYpos;
    //private MouseListener mouseListener;
    //Panels not needed for now. Were just a test.
    //panel array to hold the positions of each square
    //private JPanel checkerBoard;
    private int rows = 8;
    private int cols = 8;
    private Square square;
    private Square[][] squares;
    //private int numSquares = 64;
    //Kak da nakaram borda razbere che e kliknat buton. Borda da e statichen, kato cukna na buton da vikne metod koito da kazva koi buton e kliknal

    //METHODS

    //preparing the board
    Board(){
        checkerBoard = new JFrame();
        checkerBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        checkerBoard.setSize(500, 500);
        checkerBoard.setVisible(true);
        checkerBoard.setResizable(false);
        /*checkerBoard.addMouseListener(this);*/
        //checkerBoard = new JPanel();
        checkerBoard.setLayout(new GridLayout(8, 8));
        //array of arrays to hold the squares
        /*Piece piece = new Piece("empty.png");*/
        squares = new Square[8][8];
        //initializing the squares into the board.

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                //squares[i][j] = new Square("empty.png", i, j, checkerBoard);
                //squares[i][j].addMouseListener(this);

                if (j % 2 == 0 && i % 2 == 0){
                    //squares[i][j].changeColour("empty2.png");
                    squares[i][j] = new Square("empty2.png", i, j);
                }
                else if(j % 2 == 0 && i % 2 !=0){
                    squares[i][j] = new Square("empty.png", i, j);
                    /*squares[i][j].changeColour("empty.png");*/
                }
                else if (j%2 != 0 && i % 2 != 0){
                    /*squares[i][j].changeColour("empty2.png");*/
                    squares[i][j] = new Square("empty2.png", i, j);
                }
                else if (j%2 !=0 && i % 2 == 0){
                    /*squares[i][j].changeColour("empty.png");*/
                    squares[i][j] = new Square("empty.png", i, j);
                }
                if(((i == 0 || i == 2) && j % 2 != 0) || (i == 1 && j % 2 == 0)){
                    //squares[i][j].changeColour("red.png");
                    squares[i][j] = new Square("red.png",i ,j);
                    //squares[i][j].addMouseListener(this);
                }
                if(((i == 5 || i == 7) && j % 2 == 0) || (i == 6 && j % 2 != 0)){
                    //squares[i][j].changeColour("white.png");
                    squares[i][j] = new Square("white.png",i, j);
                    //squares[i][j].addMouseListener(this);
                }
                /*squares[i][j].addMouseListener(this);
                squares[i][j].addActionListener(this::actionPerformed);*/
               // squares[i][j].updateBoard(squares);
                checkerBoard.add(squares[i][j].getSquare());
                squares[i][j].updateBoard(squares);
            }
        }
        checkerBoard.setVisible(true);
        checkerBoard.repaint();
    }
    //Not needed now/ wrong.
    public void addSquares(Square button) {
        checkerBoard.add(button.getSquare());
    }
    void update(){
        for(int i = 0; i < rows; i++){
            for(int j =0; j< cols; i++){

            }
        }
    }

   /* @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Button pressed!");
        Component c = checkerBoard.getComponentAt(e.getX(), e.getY());
        Object o = e.getSource();
        System.out.println("yoo");
        if(c instanceof JButton){
            System.out.println("yo");
            Point parentLoc = c.getLocation();
            int x = parentLoc.x;
            int y = parentLoc.y;
            System.out.println(x + y);
        }
        if(c instanceof Square){
            System.out.println("yoo");
            Component p = ((JPanel) c).findComponentAt(e.getX(), e.getY());
            Point parentLocation = c.getParent().getLocation();
            Component n = p.getComponentAt(parentLocation);
            int x = e.getX();
            int y = e.getY();
            System.out.println(x + y );
        }
    }*/
/*

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
*/

    public void actionPerformed(ActionEvent e) {
        System.out.println("Woah");
    }
}
