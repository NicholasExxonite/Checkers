import javax.swing.*;

public class Piece extends JComponent {
    private JButton piece;
    private ImageIcon image;


    Piece(String img){
        piece = new JButton();
        this.image = new ImageIcon(img);
        piece.setIcon(image);
    }

    public JButton addPiece(){
        /*this.image = new ImageIcon(colour);
        piece.setIcon(image);*/
        return piece;
    }

}
