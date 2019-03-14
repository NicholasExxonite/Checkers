import javax.swing.*;
import java.awt.*;

public class Square {
    //instance variables
    private JLabel square;
    private ImageIcon squareImg; //= new ImageIcon("red.png");
    private int buttonXpos;
    private int buttonYpos;

    //CONSTRUCTOR
    Square(){
        square = new JLabel();
        squareImg = new ImageIcon("empty.png");
        square.setIcon(squareImg);
        square.setPreferredSize(new Dimension(60, 60 ));
    }

    //METHODS
    //get colour
    //colour change
    public void changeColour(String x){
        squareImg = new ImageIcon(x);
        square.setIcon(squareImg);
    }
    public JLabel getSquare() {
        return square;
    }
    //Location needs to be fixed, instead of giving pixel location it should
    //give the location inside the array. (initialization should happen in square class)
    //Y location on the board
    public int getYlocation(){
        System.out.println(buttonYpos);
        buttonYpos = square.getLocation().y;
        return buttonYpos;
    }
    //X loaction on the board
    public int getXlocation(){
        System.out.println(buttonXpos);
        buttonXpos = square.getLocation().x;
        return buttonXpos;
    }

}
