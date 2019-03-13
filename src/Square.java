import javax.swing.*;

public class Square {
    private JButton button = new JButton();
    private ImageIcon redPiece = new ImageIcon("red.png");
    private int buttonXpos = button.getLocation().x;
    private int buttonYpos = button.getLocation().y;

    public JButton getButton() {
        button.setIcon(redPiece);
        return button;
    }
    public int getYlocation(){
        System.out.println(buttonYpos);
        return buttonYpos;
    }
    public int getXlocation(){
        System.out.println(buttonXpos);
        return buttonXpos;
    }

}
