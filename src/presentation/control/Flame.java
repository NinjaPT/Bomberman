package presentation.control;

import presentation.swing.BoardViewer;

/**
 * Created with IntelliJ IDEA.
 * User: fgalvao
 * Date: 22-08-2013
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class Flame extends StaticCell {
    private Cell cellBackUp;
    public Flame(int posX, int posY, Cell cellBackUp) {
        super(posX, posY);
        this.cellBackUp = cellBackUp;
    }

    public Cell getCellBackUp() {
        return cellBackUp;
    }

    //encontra-se com +1 pois apenas temos o interior do board
    public void printCell(BoardViewer viewer){
        viewer.setFlame(super.getPosX()+1, super.getPosY()+1);
    }
}
