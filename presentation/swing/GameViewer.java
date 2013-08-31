package presentation.swing;

import presentation.Viewer;
import presentation.control.Cell;
import presentation.control.Game;
import presentation.control.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameViewer extends JFrame implements Viewer
{
    private BoardViewer board = new BoardViewer();
    private Game game ;

    public GameViewer()
    {
        super("POO Bomberman");
        //default content pane has a BorderLayout layout Manager
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(board);
        game = new Game();

        buildBehavior();
        run();
        printGame();

    }

    public void play(){
         game.setPlay();
    }

    public void printGame(){
         Cell[][] cells = game.getCells();
         for (int i =0; i<cells.length; ++i){
             for (int j = 0 ;j<cells[i].length;++j){
                 cells[i][j].printCell(this);  //board);
             }
         }
    }

    private void buildBehavior()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String text = null;
                Player currentPlayer = game.getCurrentPlayer();
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    text = "UP";
                    currentPlayer.setDirection('U');
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    text = "DOWN";
                    currentPlayer.setDirection('D');
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    text = "RIGHT";
                    currentPlayer.setDirection('R');
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    text = "LEFT";
                    currentPlayer.setDirection('L');
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    text = "SPACE";
                    if (currentPlayer.getBombs()!=0){
                        game.setBomb();
                    }
                }
                if (text != null)
                    //JOptionPane.showMessageDialog(GameViewer.this, "You've pressed " + text);
                    System.out.println("You've pressed " + text);
            }
        });
    }

    public void run()
    {
        pack();
        setVisible(true);
    }

    @Override
    public void refreshLayout() {
        board.refreshLayout();
        pack();
    }

    @Override
    public void setBrick(int col, int row) {
        board.setBrick(col, row);
    }

    @Override
    public void setPlayer(int col, int row) {
        board.setPlayer(col, row);
    }

    @Override
    public void setEnemy(int col, int row) {
        board.setEnemy(col, row);
    }

    @Override
    public void setSolidPath(int col, int row) {
        board.setSolidPath(col, row);
    }

    @Override
    public void setEmpty(int col, int row) {
        board.setEmpty(col, row);
    }

    public void setBomb(int col, int row){
        board.setBomb(col,row);
    }

    public void setGate(int col, int row){
        board.setGate(col, row);
    }

    public void setBonus(int col, int row, char bonusType){
        board.setBonus(col, row, bonusType);
    }

    public void setFlame(int col, int row){
        board.setFlame(col, row);
    }


}
