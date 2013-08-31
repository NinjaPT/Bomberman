package presentation.control;

public abstract class StaticCell extends Cell {

    public StaticCell(int posX, int posY) {
        super(posX, posY);
        isStatic();
    }

}
