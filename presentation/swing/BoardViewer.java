package presentation.swing;

import presentation.control.Cell;
import presentation.control.Level;

import javax.swing.*;
import java.awt.*;

public class BoardViewer extends JPanel
{

    private static final int ROWS = 13;
    private static final int COLUMNS = 31;

    /*
    private static final String BRICK_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Brick.png";
    private static final String SOLID_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Solid.png";
    private static final String EMPTY_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Empty.png";
    private static final String PLAYER_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_White.png";
    private static final String ENEMY1_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Ballom.png";
    private static final String BONUS_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Speed.png";
    private static final String GATE_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Mystery.png";
    private static final String BOMB_PATH = "/home/paulo/Dropbox/POO_1213_V/T3/images/Bomberman_Bomb.png";
     */
  /*
    private static final String BRICK_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Brick.png";
    private static final String SOLID_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Solid.png";
    private static final String EMPTY_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Empty.png";
    private static final String PLAYER_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_White.png";
    private static final String ENEMY1_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Balloom.png";
    private static final String BONUS_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Speed.png";
    private static final String GATE_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Mystery.png";
    private static final String BOMB_PATH = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Bomb.png";


    public static final String BRICK_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Brick.png";
    public static final String SOLID_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Solid.png";
    public static final String EMPTY_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Empty.png";
    public static final String PLAYER_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_White.png";
    public static final String ENEMY1_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Balloom.png";
    public static final String BONUS_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Speed.png";
    public static final String GATE_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Mystery.png";
    public static final String BOMB_PATH = "C:\\Users\\XPTA491\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Bomb.png";


    /*
    private static final String BRICK_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Brick.png";
    private static final String SOLID_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Solid.png";
    private static final String EMPTY_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Empty.png";
    private static final String PLAYER_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_White.png";
    private static final String ENEMY1_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Balloom.png";
    private static final String BONUS_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Speed.png";
    private static final String GATE_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Mystery.png";
    private static final String BOMB_PATH = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\images\\Bomberman_Bomb.png";
    */
    /*
    private static final String BRICK_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Brick.png";
    private static final String SOLID_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Solid.png";
    private static final String EMPTY_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Empty.png";
    private static final String PLAYER_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_White.png";
    private static final String ENEMY1_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Balloom.png";
    private static final String SPEED_BONUS_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Speed.png";
    private static final String FLAME_BONUS_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Flames.png";
    private static final String DETONATOR_BONUS_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Detonator.png";
    private static final String BOMB_BONUS_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Bombs.png";
    private static final String GATE_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Gate.png";
    private static final String BOMB_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Bom.jpg";
    private static final String FLAME_PATH = "/home/fgalvao/workspace/Bomberman/images/Bomberman_Flame.png";
    */

    private static final String BRICK_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Brick.png";
    private static final String SOLID_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Solid.png";
    private static final String EMPTY_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Empty.png";
    private static final String PLAYER_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_White.png";
    private static final String ENEMY1_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Balloom.png";
    private static final String SPEED_BONUS_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Speed.png";
    private static final String FLAME_BONUS_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Flames.png";
    private static final String DETONATOR_BONUS_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Detonator.png";
    private static final String BOMB_BONUS_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Bombs.png";
    private static final String GATE_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Gate.png";
    private static final String BOMB_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Bom.jpg";
    private static final String FLAME_PATH = "/Users/luissousa/Documents/prog/Bomberman/images/Bomberman_Flame.png";

    private ElementViewer[][] board = new ElementViewer[COLUMNS][ROWS];

    public BoardViewer()
    {
        setLayout(new GridLayout(ROWS, COLUMNS));
        initBoard();
        refreshLayout();
    }

    //Fill board with the initial state
    private void initBoard()
    {
        //Fill Edges
        for(int i = 0; i < COLUMNS; ++i)
        {
            board[i][0] = new ElementViewer(SOLID_PATH);
            board[i][ROWS-1] = new ElementViewer(SOLID_PATH);
        }
        for(int i = 1; i < ROWS-1; ++i)
        {
            board[0][i] = new ElementViewer(SOLID_PATH);
            board[COLUMNS-1][i] = new ElementViewer(SOLID_PATH);
        }
        for(int row = 0; row < ROWS; ++row)
        {
            for(int col = 0; col < COLUMNS; ++col)
            {
                if(row == 0 || col == 0 || row == ROWS-1 || col == COLUMNS-1)
                    board[col][row] = new ElementViewer(SOLID_PATH);
                else
                    board[col][row] = new ElementViewer(EMPTY_PATH);
            }
        }
    }

    public void refreshLayout()
    {
        removeAll();
        for(int row = 0; row < ROWS; ++row)
        {
            for(int col = 0; col < COLUMNS; ++col)
            {
                add(board[col][row]);
            }
        }
    }
    public void setFlame(int col, int row)
    {
        board[col][row] = new ElementViewer(FLAME_PATH);
    }
    public void setBrick(int col, int row)
    {
        board[col][row] = new ElementViewer(BRICK_PATH);
    }
    public void setPlayer(int col, int row)
    {
        board[col][row] = new ElementViewer(PLAYER_PATH);
    }
    public void setEmpty(int col, int row)
    {
        board[col][row] = new ElementViewer(EMPTY_PATH);
    }

    public void setSolidPath(int col, int row)
    {
        board[col][row] = new ElementViewer(SOLID_PATH);
    }
    public void setEnemy(int col, int row)
    {
        board[col][row] = new ElementViewer(ENEMY1_PATH);
    }
    public void setBonus(int col, int row, char bonusType){
        switch (bonusType){
            case('S'):{board[col][row] = new ElementViewer(SPEED_BONUS_PATH);}
            case('F'):{board[col][row] = new ElementViewer(FLAME_BONUS_PATH);}
            case('D'):{board[col][row] = new ElementViewer(DETONATOR_BONUS_PATH);}
            case('B'):{board[col][row] = new ElementViewer(BOMB_BONUS_PATH);}
        }
        //board[col][row] = new ElementViewer(BRICK_PATH);
    }

    public void setGate(int col, int row){
        board[col][row] = new ElementViewer(GATE_PATH);
    }

    public void setBomb(int col, int row){
        board[col][row] = new ElementViewer(BOMB_PATH);
    }

    public void writeLevel(Level level, GameViewer viewer){
        Cell[][] levelInfo = level.getBoard();
        for(int i = 0; i<levelInfo.length;i++){
            for(int j =0; j<levelInfo[i].length; j++){
                levelInfo[i][j].printCell(viewer);
            }
        }
    }
}

