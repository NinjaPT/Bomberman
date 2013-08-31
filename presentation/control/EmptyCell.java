package presentation.control;

import presentation.swing.BoardViewer;
import presentation.swing.GameViewer;

/**
 * Created with IntelliJ IDEA.
 * User: Paulo Torres
 * Date: 13-07-2013
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
public class EmptyCell extends StaticCell {

    public EmptyCell(int posX, int posY) {
        super(posX, posY);
    }
//    public void printCell(BoardViewer viewer){
//        viewer.setEmpty(super.getPosX()+1, super.getPosY()+1);
//    }


    @Override
    public void printCell(GameViewer viewer) {
        viewer.setEmpty(super.getPosX()+1, super.getPosY()+1);
    }
}
