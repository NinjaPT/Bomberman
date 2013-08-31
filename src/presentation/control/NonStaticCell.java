package presentation.control;

public abstract class NonStaticCell extends Cell {
    private char direction;
    private boolean moved=false;
    public NonStaticCell(int posX, int posY, char direction) {
        super(posX, posY);
        this.direction = direction;
    }


    public void setNewPosition(int posX,int posY){
        this.setPosX(posX);
        this.setPosY(posY);
    }
    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public boolean isMovePossible(Cell cell){
        return false;
    }
}
