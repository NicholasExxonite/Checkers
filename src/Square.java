import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JComponent implements ActionListener{
    //instance variables
    private JButton square;
    private ImageIcon squareImg; //= new ImageIcon("red.png");
    private int squareXpos, tomoveXpos;
    private int squareYpos, tomoveYpos;
    private String piece;
    private int count;
    private Square array[];
    private String pieceType;


    //CONSTRUCTOR
    Square(String colour){
        this.pieceType = colour;
        square = new JButton();
        if (colour.equals("red.png") || colour.equals("white.png")){
            Piece newPiece = new Piece(colour);
            square = newPiece.addPiece();
        }
        else{
            this.squareImg = new ImageIcon(colour);
            square.setIcon(squareImg);
            square.setPreferredSize(new Dimension(100, 100 ));
        }
        /*this.square.addActionListener(actListener);
        this.square.addActionListener(actListenerTwo);*/
        count = 1;
        square.addActionListener(this::actionPerformed);
        array = new Square[2];

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
    public void changeColour(String x){
        squareImg = new ImageIcon(x);
        square.setIcon(squareImg);
    }
    public JButton getSquare() {
        return square;
    }


    //trying to figure out how to save 2 consecutive clicks
   /* ActionListener actListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(count % 2 != 0){
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
            count++;
        }
    };*/
    public void moveTo(){
    }
    //Location needs to be fixed, instead of giving pixel location it should
    //give the location inside the array. (initialization should happen in square class)
    //Y location on the board
    public int getYlocation(){
        System.out.println(squareYpos);
        squareYpos = square.getLocation().y;
        return squareYpos;
    }
    //X loaction on the board
    public int getXlocation(){
        System.out.println(squareXpos);
        squareXpos = square.getLocation().x;
        return squareXpos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(count % 2 != 0){
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
        count++;*/
        if(array[0] == null){
            array[0] = this;
            System.out.println("First sq :" + this.getXlocation() + this.getYlocation());
        }
        if(array[0] != null){
            array[1] = this;
            array[0] = null;
            System.out.println("Second sq :" + this.getYlocation() + this.getYlocation());
        }
    }
}
