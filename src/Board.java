import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;

public class Board {
    private JFrame checkerBoard;

    public void prepareBoard(){
        checkerBoard = new JFrame("Checkers");
        checkerBoard.setSize(600, 600);
        checkerBoard.setVisible(true);
        checkerBoard.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void addButton(Square button){
        checkerBoard.add(button.getButton());
    }

}
