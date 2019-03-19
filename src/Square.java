import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JButton implements /*ActionListener,*/ MouseListener {
    //instance variables
    private JButton square, piece;
    private ImageIcon squareImg; //= new ImageIcon("red.png");
    private int squareRow, selectedRow;
    private int squareCol, selectedCol;
    private int selectedX, selectedY, curX, curY;
    private Square[][] board = new Square[8][8];
    private String pieceType;
    private Square tomoveSquare;
    private boolean isPiece;
    private static int[] test = new int[2];
    //ako nqma izbrano -1 i -1, ako ima izbrano shte e 1 i 1
    //proverqvash dali kordinatite sa razlichni ot -1 i -1, znachi ima selectnato i proverqvame dali e piece.
    // ako nqma nishto selectnato i e piece selectvam piece
    //ako nqma selectnato i ne e piece, nishto ne pravim
    // ako imam selectatno neshto i ne e piece, premestvam piece na novite kordinati i triem piece

    //CONSTRUCTOR
    Square(String colour, int r, int c) {
        this.pieceType = colour;
        squareRow = r;
        squareCol = c;
        //squareXpos = this.getLocation().x;
        //squareYpos = this.getLocation().y;
        //piece = new JButton();
        square = new JButton();
        board[r][c] = this;
        square.setBounds(20, 20, 164, 164);
        square.addMouseListener(this);
        //square.addActionListener(this);
        if (colour.equals("red.png") || colour.equals("white.png")) {
            this.isPiece = true;
            this.pieceType = colour;
            this.squareImg = new ImageIcon(pieceType);
            this.square.setIcon(squareImg);

        }
        else {
            //square = new JButton();
            /*test[0] = -1;
            test[1] = -1;*/
            this.isPiece = false;
            this.pieceType = colour;
            this.squareImg = new ImageIcon(pieceType);
            this.square.setIcon(squareImg);

        }

    }

    //METHODS
    /*public Square pieceColour(String colour){
        this.pieceType = colour;
        if(pieceType.equals("red.png")|| pieceType.equals("white.png")){
            Piece newPiece = new Piece(pieceType);
            square = newPiece.addPiece(pieceType);
        }
        return this;
    }*/
    //colour change
    public void changeColour(String x) {
        squareImg = new ImageIcon(x);
        square.setIcon(squareImg);
    }
    public JButton getSquare() {
        /*if(isPiece == true){
            return piece;
        }
        else return square;*/
        return square;
    }

    public ImageIcon getIcon() {
        return this.getIcon();
    }
    public Square[][] getBoard(){
        return board;
    }
    public void movement(Square sq){
        this.square = sq;
    }

    public int getSquareRow(){
        return squareRow;
    }
    public int getSelectedCol(){
        return squareCol;
    }
    void updateBoard(Square[][] s){
        s = board;
    }
    void toMove(int x, int y){
        if(isPiece){
            selectedX = x;
            selectedY = y;
            selectedRow = this.squareRow;
            selectedCol = this.squareCol;
            System.out.println("Make your move.");
            return;
        }
        if(test[0] < 0) {
            System.out.println("Click the piece you want to move.");
            return;
        }
        if(test[0] > 0){
            curX = this.getLocation().x;
            curY = this.getLocation().y;
            int currentRow = squareRow;
            int currentCol = squareCol;
            square.setLocation(curX, curY);
            //makeMove(toX, toY, selectedX, selectedY/*squareRow, squareCol, selectedRow, selectedCol*/);
        }
    }

    void makeMove(/*Square sq*/int fromRow, int fromCol, int toRow, int toCol){
       // board[toRow][toCol] = board[fromRow][fromCol];
        /*int tempX = selectX;
        int tempY = selectY;
        //this.square.setLocation(sq.getLocation());
        square.setLocation(selectX, selectY);
        sq.setLocation(sqX, sqY);
        */
        board[fromRow][fromCol] = board[toCol][toRow];
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        e.getSource();
        if(isPiece){
            System.out.println("You clicked a Piece.");
            test[0] = 1;
            test[1] = 1;
            selectedX = e.getX();
            selectedY = e.getY();
            selectedRow = this.squareRow;
            selectedCol = this.squareCol;
        }
        if (!isPiece){
            System.out.println("You clicked an empty square");
            test[0] = -1;
            test[1] = -1;
        }
        toMove(selectedX, selectedY);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
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

}
