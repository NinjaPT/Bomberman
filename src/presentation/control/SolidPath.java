package presentation.control;

import presentation.swing.BoardViewer;
import presentation.swing.GameViewer;

/**
 * Created with IntelliJ IDEA.
 * User: Paulo Torres
 * Date: 13-07-2013
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class SolidPath extends StaticCell {

    public SolidPath(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void printCell(GameViewer viewer) {
        viewer.setSolidPath(super.getPosX()+1, super.getPosY()+1);
    }
    /*
    public void printCell(BoardViewer viewer){
        viewer.setSolidPath(super.getPosX()+1, super.getPosY()+1);
    } */
}
