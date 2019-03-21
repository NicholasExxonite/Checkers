import javax.swing.*;
import java.util.HashSet;

public class Square extends JButton {
    //instance variable for the image to be used.
    private ImageIcon image;
    //rows and cols of each square;
    private int row, col;
    //a board array of arrays so we can have the same location of each square as in the Board class.
    private Square[][] board = new Square[8][8];

    private int selectedRow, selectedCol;

    //different types of squares
   /* private static final String
                    NONE = "empty.png",
                     NONE2 = "empty2.png", WHITE = "white.png", RED = "red.png";
*/
    //the type of the square.
    private String type; //Can be NONE, RED, WHITE, etc.
    //a boolean check to see if the square is empty or a piece.
    private boolean isPiece;

    //constructor for the Square object
    public Square(int c, int r, String t){
        //save the information for each square from the Board to the instance variables in Square class
        // so we can manipulate them easily
        row = r;
        col = c;
        type = t;
        //legal[c][r] =
        //this board is identical to the checkerBoard from Board class
        board[r][c] = this;
        //Creating the empty squares, if the parameter t(type) from Board was "NONE" then it's an empty square
        //put them on the correct position depending on the row and col.
        if(type.equals("empty.png"))
        {
            this.isPiece = false;
            if(row % 2 == 0 && col % 2 == 0 || row % 2 != 0 && col % 2 != 0){
                image = new ImageIcon("empty2.png");
                this.setIcon(image);
                type = "empty2.png";
            }
            if(row % 2 != 0 && col % 2 == 0 || row % 2 == 0 && col % 2 != 0){
                image = new ImageIcon("empty.png");
                this.setIcon(image);

            }
        }
        //if the t(type) inputed from Board is "WHITE", then create white pieces.
        if(type.equals("white.png")){
            image = new ImageIcon(type);
            this.setIcon(image);
            this.isPiece = true;
        }
        if(type.equals("red.png")){
            image = new ImageIcon(type);
            this.setIcon(image);
            this.isPiece = true;
        }

    }

    //Method, called in Board to make a move.
    public void toMove(Square sq){
        if(this.type.equals("empty2.png")){
            System.out.println("You can't move on black squares!");
            return;
        }
        /*int tempCol = this.getCol();
        int tempRow = this.getRow();
        this.setCol(sq.getCol());
        this.setRow(sq.getRow());
        sq.setCol(tempCol);
        sq.setRow(tempRow);*/
        int x = sq.getLocation().x;
        int y = sq.getLocation().y;
        sq.setLocation(this.getLocation());
        this.setLocation(x, y);
        System.out.println("Piece moved.");
        //repaint the board after the movement.
        repaint();

    }

    public boolean isPiece() {
        return isPiece;
    }

    public String getType() {

        return type;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int r){
        this.row = r;
    }
    public void setCol(int c){
        this.col = c;
    }
    public int getCol() {
        return col;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public int getSelectedCol() {
        return selectedCol;
    }

    public void setSelectedCol(int col) {
        selectedCol = col;
    }

    public void setSelectedRow(int row) {
        selectedRow = row;
    }
}
