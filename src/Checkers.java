import javax.swing.*;

public class Checkers {
    public static void main(String Args[]){
        Board board = new Board();
        Square but = new Square();

        board.prepareBoard();
        board.addButton(but);
        but.getYlocation();
        but.getXlocation();
    }
}
