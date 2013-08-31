package presentation;

public interface Viewer
{
    void refreshLayout();
    void setBrick(int col, int row);
    void setPlayer(int col, int row);
    void setEnemy(int col, int row);
    void setSolidPath(int col, int row);
    void setEmpty(int col, int row);
    void setBomb(int col, int row);
    void setGate(int col, int row);
    void setBonus(int col, int row, char bonusType);
    void printGame();
    void play();
}
