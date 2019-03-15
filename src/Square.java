import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JComponent{
    //instance variables
    private JButton square;
    private ImageIcon squareImg; //= new ImageIcon("red.png");
    private int squareXpos, tomoveXpos;
    private int squareYpos, tomoveYpos;
    private String piece;


    //CONSTRUCTOR
    Square(String colour){
        this.piece = colour;
        square = new JButton();
        this.squareImg = new ImageIcon(colour);
        square.setIcon(squareImg);
        square.setPreferredSize(new Dimension(100, 100 ));
        /*this.squareImg = new ImageIcon(colour);
        square.setIcon(squareImg)*/;
        /*this.squareXpos = square.getLocation().x;
        this.squareYpos = square.getLocation().y;*/
        this.square.addActionListener(actListener);
    }

    //METHODS
    public void pieceColour(){
        if(piece == "red.png"){

        }
    }
    //colour change
    public void changeColour(String x){
        squareImg = new ImageIcon(x);
        square.setIcon(squareImg);
    }
    public JButton getSquare() { return square;}
    //trying to figure out how to save 2 consecutive clicks
    ActionListener actListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            squareXpos = square.getLocation().x;
            squareYpos = square.getLocation().y;
            System.out.println(squareXpos + " "+ squareYpos);
            ActionListener actListenerTwo = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent t) {
                    tomoveXpos = square.getLocation().x;
                    tomoveYpos = square.getLocation().y;
                    System.out.println(tomoveXpos + " " + tomoveYpos);
                }
            };
        }
    };
    public void moveTo(Square squareToMove){
        int temp =0;
        int temp2 = 0;
        temp = squareXpos;
        temp2 = squareYpos;
        squareXpos = tomoveXpos;
        squareYpos = tomoveYpos;
        tomoveXpos = temp;
        tomoveYpos = temp2;
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

}
