package presentation.control;//package control;

import presentation.swing.BoardViewer;

public abstract class Cell {
    private int posX;
    private int posY;
    private boolean isStatic=false;

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX(){
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setStatic(){
        this.isStatic=true;
    }

    public boolean isStatic(){
        return isStatic;
    }

    public void printCell(BoardViewer viewer){
        /*switch (cellType){
            case('H'): {break;}
            case('B'): {viewer.setBrick(this.posX,this.posY);break;}
            case('W'): {viewer.setSolidPath(this.posX,this.posY);break;}
            case('1'): {viewer.setEnemy(this.posX,this.posY);break;}

        }*/
    }
}
