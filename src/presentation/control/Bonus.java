package presentation.control;//package control;

import presentation.swing.BoardViewer;

/**
 * Created with IntelliJ IDEA.
 * User: fgalvao
 * Date: 04-07-2013
 * Time: 0:49
 * To change this template use File | Settings | File Templates.
 */
public class Bonus extends StaticCell {
    char bonusType;
    private boolean wall=true;

    public Bonus(int posX, int posY, char bonusType) {
        super(posX, posY);
        wall = true;
        this.bonusType = bonusType;
    }

    public void Bonus(char type){
        bonusType = type;
    }

    private void increaseFlame(Player player){
        player.addFlame();
    }

    private void increaseBomb(Player player){
        int nBombs = player.getBombs();
        player.setBombs(++nBombs);
    }



    private void increaseSpeed(Player player){
        int speed = player.getSpeed();
        player.setSpeed(++speed);
    }

    private void setDetonator(Player player){
        player.setDetonator(true);
    }

    private void setWallPass(Player player){
        player.setWallPass(true);
    }

    private void setFlamePass(Player player){
        player.setFlamePass(true);
    }

    public void printCell(BoardViewer viewer){
        if (wall)
            viewer.setBrick(super.getPosX()+1, super.getPosY()+1);
        else
            viewer.setBonus(super.getPosX()+1, super.getPosY()+1, bonusType);
    }

    public void setWall(boolean wall){
        this.wall = wall;
    }

    public boolean getWall(){
        return wall;
    }

    public void deployBonus(Player player){
        switch (bonusType){
            case('F'): { increaseFlame(player); }
            case('S'): { increaseSpeed(player); }
            //case('W'): { setWallPass(player); }
            case('D'): { setDetonator(player); }
            case('B'): { increaseBomb(player); }
            //case('P'): { setFlamePass(player); }
        }
    }
}
