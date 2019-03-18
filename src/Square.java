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
    private int squareXpos, tomoveXpos;
    private int squareYpos, tomoveYpos;
    private int rowPlacement, colPlacement;
    private Square[][] board = new Square[8][8];
    private int count;
    private Square array[];
    private String pieceType;
    private Square tomoveSquare;
    private boolean isPiece;


    //CONSTRUCTOR
    Square(String colour, int r, int c) {
        this.pieceType = colour;
        rowPlacement = r;
        colPlacement = c;
        //squareXpos = this.getLocation().x;
        //squareYpos = this.getLocation().y;
        piece = new JButton();
        square = new JButton();
        //square.addActionListener(this);
        if (colour.equals("red.png") || colour.equals("white.png")) {
            /*Piece newPiece = new Piece(colour);*/
            /*square = newPiece.addPiece();*/
            //piece = new JButton();
            this.isPiece = true;
            this.pieceType = colour;
            this.squareImg = new ImageIcon(pieceType);
            piece.setIcon(squareImg);
            piece.setPreferredSize(new Dimension(100, 100));
            board[this.rowPlacement][this.colPlacement] = this;
            /*square.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Piece!");
                    if(isPiece == true){
                        squareXpos = square.getLocation().x;
                        squareYpos = square.getLocation().y;
                    }
                    System.out.println(squareXpos + " " + squareYpos);
                }
            });*/
        }
        else {
            //square = new JButton();
            this.isPiece = false;
            this.pieceType = colour;
            this.squareImg = new ImageIcon(pieceType);
            square.setIcon(squareImg);
            square.setPreferredSize(new Dimension(100, 100));
            board[this.rowPlacement][this.colPlacement] = this;
            /*square.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent m) {
                    System.out.println("Not a piece!");
                    if(isPiece == false){
                        tomoveXpos = square.getLocation().x;
                        tomoveYpos = square.getLocation().y;
                    }
                    *//*
                    System.out.println(tomoveXpos + " " + tomoveYpos);
                    square.setLocation(squareXpos, squareYpos);*//*
                }
            });*/
        }
        /*this.square.addActionListener(actListener);
        this.square.addActionListener(actListenerTwo);*/
        //square.addActionListener(this::actionPerformed);
        //this.toMove(tomoveSquare);
        /*square.addActionListener(this::actionPerformed);
        piece.addActionListener(this::actionPerformed);*/
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
        if(isPiece == true){
            return piece;
        }
        else return square;
    }
    public int getRowPlacement(){
        return rowPlacement;
    }
    public int getColPlacement(){
        return colPlacement;
    }
    public ImageIcon getIcon() {
        return this.getIcon();
    }

    //Location needs to be fixed, instead of giving pixel location it should
    //give the location inside the array. (initialization should happen in square class)
    //Y location on the board
    public int getYlocation() {
        System.out.println(squareYpos);
        squareYpos = square.getLocation().y;
        return squareYpos;
    }

    //X loaction on the board
    public int getXlocation() {
        System.out.println(squareXpos);
        squareXpos = square.getLocation().x;
        return squareXpos;
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == piece){
            System.out.println("PIECE");
            squareXpos = piece.getLocation().x;
            squareYpos = piece.getLocation().y;
            System.out.println("Position of piece: " + squareXpos + " " + squareYpos);
            //Component c =
        }
        else if(src == square){
            System.out.println("SQUARE");
            tomoveYpos = square.getLocation().y;
            tomoveXpos = square.getLocation().x;
            System.out.println("Position of empty square: " + tomoveXpos + " " + tomoveYpos);
        }
    }*/
    public void toMove(Square tomoveSquare){

    }
    public int getTomoveXpos(){
        return tomoveXpos;
    }
    public int getTomoveYpos(){
        return tomoveYpos;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }
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
    /*@Override
    public void actionPerformed(ActionEvent e) {
        *//*if(count % 2 != 0){
            squareXpos = square.getLocation().x;
            squareYpos = square.getLocation().y;
            System.out.println("Square 1 location: " + squareXpos + " "+ squareYpos);
        }
        if(count % 2 == 0){
            System.out.println("2222");
        }
        if(count > 10){
            count = 1;
        }
        count++;*//*


         *//*if(array[0] == null){
            array[0] = this;
            System.out.println("First sq :" + this.getXlocation() + this.getYlocation());
        }
        if(array[0] != null){
            array[1] = this;
            array[0] = null;
            System.out.println("Second sq :" + this.getYlocation() + this.getYlocation());
        }*//*
    }*/
}
