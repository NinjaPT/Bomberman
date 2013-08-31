package presentation.control;

import presentation.swing.BoardViewer;
import presentation.swing.GameViewer;

/**
 * Created with IntelliJ IDEA.
 * User: Paulo Torres
 * Date: 13-07-2013
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public class Gate extends StaticCell {
    private boolean wall=true;
    public Gate(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void printCell(GameViewer viewer) {
        if (wall)
            viewer.setBrick(super.getPosX()+1, super.getPosY()+1);
        else
            viewer.setGate(super.getPosX()+1, super.getPosY()+1);
    }

    /*
    public void printCell(BoardViewer viewer){
        if (wall)
            viewer.setBrick(super.getPosX()+1, super.getPosY()+1);
        else
            viewer.setGate(super.getPosX()+1, super.getPosY()+1);
    } */

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }
}
