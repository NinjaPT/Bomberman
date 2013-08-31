package presentation.control;

import presentation.swing.BoardViewer;

/**
 * Created with IntelliJ IDEA.
 * User: Paulo Torres
 * Date: 13-07-2013
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class Brick extends StaticCell {

    public Brick(int posX, int posY) {
        super(posX, posY);
    }
    //encontra-se com +1 pois apenas temos o interior do board
    public void printCell(BoardViewer viewer){
        viewer.setBrick(super.getPosX()+1, super.getPosY()+1);
    }
}
