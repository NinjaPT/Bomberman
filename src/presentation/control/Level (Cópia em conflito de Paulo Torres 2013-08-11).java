package presentation.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level {
    private int level;
    private static List<String> levelInfo = new ArrayList<String>();
    private Cell[][] board;

    public Level(int level){
        this.level = level;
        loadLevel(level);
    }

    private boolean loadLevel(int level){
        //final String filename = "/home/fgalvao/Dropbox/POO_1213_V/T3/src/levels/Level_" + level;
        //final String filename = "C:\\Users\\fabio.a.galvao\\Dropbox\\POO_1213_V\\T3\\src\\levels\\Level_" + level;
        //final String filename = "C:\\Users\\Paulo Torres\\Dropbox\\POO_1213_V\\T3\\src\\levels\\level_" + level;
        final String filename = "/home/paulo/Dropbox/POO_1213_V/T3/src/levels/Level_" + level;
        try {
           getFileSize(filename);
            readFile(filename);
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }

    private void getFileSize(String aFileName) throws IOException,FileNotFoundException{
        File file = new File(aFileName);
        int i=0;
        int j =0;
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String lines = scanner.nextLine();
                    i++;
                    j=lines.length();

            }
        }catch (Exception e){
            throw new IOException();
        }
        board = new Cell[i][j];
    }

    private void readFile(String aFileName) throws IOException,FileNotFoundException{
        File file = new File(aFileName);
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split("\\s+");
                for (int i = 0; i<lines.length; i++) {
                    for (int j = 0; j<lines[i].length();j++){
                        char c = lines[i].charAt(j);
                        switch (c){
                            case('H'): {board[i][j] = new Player(i,j);break;}
                            case('N'): {board[i][j] = new EmptyCell(i,j);break;}
                            case('1'): {board[i][j] = new Enemy(i,j,c);break;}
                            case('2'): {board[i][j] = new Enemy(i,j,c);break;}
                            case('W'): {board[i][j] = new SolidPath(i,j);break;}
                            case('B'): {board[i][j] = new Brick(i,j);break;}
                            case('P'): {board[i][j] = new Bonus(i,j);break;}
                            case('X'): {board[i][j] = new Gate(i,j);break;}
                        }
                    }
                }
            }
        }
        catch (Exception e){
            throw new IOException();
        }
    }


    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }


    public List<String> getLevelInfo() {
        return this.levelInfo;
    }
}
