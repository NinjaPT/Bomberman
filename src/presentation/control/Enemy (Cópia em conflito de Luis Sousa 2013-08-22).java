package presentation.control;//package control;

import presentation.swing.BoardViewer;

public class Enemy extends NonStaticCell{

    private int posX;
    private int posY;
    private char enemyType;
    private boolean wallPass = false;
    private int speed;

    public Enemy(int posX, int posY,char enemyType) {
        super(posX, posY, 'R');
        this.enemyType=enemyType;
    }

    @Override
    public int getPosX() {
        return posX;
    }
    @Override
    public void setPosX(int posX) {
        this.posX = posX;
    }
    @Override
    public int getPosY() {
        return posY;
    }
    @Override
    public void setPosY(int posY) {
        this.posY = posY;
    }

    public char getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(char enemyType) {
        this.enemyType = enemyType;
    }

    public void printCell(BoardViewer viewer){
        viewer.setEnemy(super.getPosX()+1, super.getPosY()+1);
        setMoved(false);
    }

    @Override
    public boolean isMovePossible(Cell cell) {
        boolean result = false;
        if (cell.getClass().equals(Brick.class) && wallPass == true ){
            result = true;
        }else if (cell.getClass().equals(Bonus.class)){
            Bonus bonus = (Bonus) cell;
            if (bonus.getWall()==false)
                result = true;
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
    /*
    TODO Algoritmo de jogo do inimigo

     */
}
