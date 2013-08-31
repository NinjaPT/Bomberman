package presentation.control;//package control;

import presentation.Viewer;
import presentation.swing.BoardViewer;
import presentation.swing.GameViewer;

import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends StaticCell{
    private int flame;
    private int time = 3; //3 segundos
    private boolean detonator = false;

    public Bomb(int posX, int posY, int flame) {
        super(posX, posY);
        this.flame = flame;
    }

    public boolean isDetonator() {
        return detonator;
    }

    public void setDetonator(boolean detonator) {
        this.detonator = detonator;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void printCell(GameViewer viewer) {
        viewer.setBomb(super.getPosX()+1, super.getPosY()+1);
    }

    public int getFlame() {
        return flame;
    }

}
