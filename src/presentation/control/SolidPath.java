package presentation.control;

import presentation.swing.BoardViewer;

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
    public void printCell(BoardViewer viewer){
        viewer.setSolidPath(super.getPosX()+1, super.getPosY()+1);
    }
}
