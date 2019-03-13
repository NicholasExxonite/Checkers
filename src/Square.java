import javax.swing.*;
import java.awt.*;

public class Square {
    //instance variables
    private JButton square;
    private ImageIcon squareImg; //= new ImageIcon("red.png");
    private int buttonXpos;
    private int buttonYpos;

    //CONSTRUCTOR
    Square(String x){
        square = new JButton();
        squareImg = new ImageIcon(x);
        square.setIcon(squareImg);
    }

    //METHODS

    public JButton getButton() {
        return square;
    }
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
