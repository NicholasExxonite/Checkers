import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Piece extends JComponent implements ActionListener {
    private JButton piece;
    private ImageIcon image;
    private int pieceX;
    private int pieceY;


    Piece(String img){
        piece = new JButton();
        this.image = new ImageIcon(img);
        piece.setIcon(image);
        //piece.addActionListener(this::actionPerformed);
    }

    public JButton addPiece(){
        /*this.image = new ImageIcon(colour);
        piece.setIcon(image);*/
        return piece;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("I was clicked!: " + piece.getLocation().x + " " + piece.getLocation().y);
        pieceX = this.getLocation().x;
        pieceY = this.getLocation().y;
    }
    public int getPieceX(){
        return pieceX;
    }
    public int getPieceY(){
        return pieceY;
    }
}
