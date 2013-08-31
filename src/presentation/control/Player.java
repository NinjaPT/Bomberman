package presentation.control;//package control;

import presentation.Viewer;
import presentation.swing.BoardViewer;
import presentation.swing.GameViewer;

/**
 * Created with IntelliJ IDEA.
 * User: fgalvao
 * Date: 30-06-2013
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class Player extends NonStaticCell {
    private int speed;
    private int lives;
    private int nBombs;
    private boolean wallPass = false;
    private boolean flamePass = false;
    private boolean detonator = false;
    private int flameSize = 1;
    private int score;


    public Player(int posX, int posY) {
        super(posX, posY, 'R');
        lives = 2;
        speed = 1;
        nBombs = 2;
        score = 0;
    }

    public boolean isFlamePass() {
        return flamePass;
    }

    public void setFlamePass(boolean flamePass) {
        this.flamePass = flamePass;
    }

    public int getFlameSize() {
        return flameSize;
    }

    public void setFlameSize(int flame) {
        this.flameSize = flame;
    }

    public void addFlame(){
        int f = getFlameSize();
        setFlameSize(++f);
    }

    public int getBombs() {
        return nBombs;
    }

    public void setBombs(int nBombs) {
        this.nBombs= nBombs;
    }

    public boolean isDetonator() {
        return detonator;
    }

    public void setDetonator(boolean detonator) {
        this.detonator = detonator;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isWallPass() {
        return wallPass;
    }

    public void setWallPass(boolean wallPass) {
        this.wallPass = wallPass;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public boolean death(){
        this.lives--;
        if (getLives()<0)
            return false;
        return true;
    }

    public void setNewPosition(int posX, int posY) {
        setPosX(posX);
        setPosY(posY);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public void printCell(GameViewer viewer) {
        viewer.setPlayer(super.getPosX()+1, super.getPosY()+1);
        setMoved(false);
    }

    /*
    public void printCell(BoardViewer viewer){
        viewer.setPlayer(super.getPosX()+1, super.getPosY()+1);
        setMoved(false);
    } */



    @Override
    public boolean isMovePossible(Cell cell) {
        boolean result = false;
        if (cell.getClass().equals(Brick.class) && wallPass == true ){
            result = true;
        }else if (cell.getClass().equals(Bonus.class)){
            Bonus bonus = (Bonus) cell;
            if (bonus.getWall()==false){
                result = true;
                //neste caso temos de fazer deploy do bónus no nosso player
                bonus.deployBonus(this);
            }
        }else if (cell.getClass().equals(Gate.class)){
            Gate gate = (Gate) cell;
            if (gate.isWall()==false)
                result = true;
        }else if (cell.getClass().equals(EmptyCell.class))
            result = true;
        else if (cell.getClass().equals(Enemy.class))
            result = true;

        return result;
    }
}
