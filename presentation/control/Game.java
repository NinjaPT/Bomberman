package presentation.control;

public class Game {
    private Level level;
    private Player currentPlayer;

    public Game(){
        level= new Level(1);
    }

    public Cell[][] getCells(){
        return level.getBoard();
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /****************************************************************************************/

    //  JOGADA

    /****************************************************************************************/
    public void setPlay(){

        //TODO for each enemy for each set play calculate move accordingly to int level

        Cell[][] board = level.getBoard();

        /*
        *
        * Cálculo da Jogada
        *
        * */

        for(int i= 0 ; i<board.length;i++){
            //se é um objecto não estático, validar se é possível mover
            for(int j = 0; j<board[i].length;j++){
                /*
                 *
                 * Cálculo do movimento de jogador
                 *
                 * */
                if (board[i][j].getClass().equals(Player.class) ) {
                    // || board[i][j].getClass().equals(Enemy.class)
                    //mover o player
                    Player cell = (Player) board[i][j];
                    if (!cell.isMoved()) {
                        Cell newCell;
                        char direction = cell.getDirection();
                        if (direction == 'R') {
                            try {
                                newCell = board[i][j+1];
                                if (cell.isMovePossible(newCell)) {
                                    board[i][j+1] = cell;
                                    board[i][j] = new EmptyCell(j,i);
                                    cell.setNewPosition(j+1,i);
                                }
                            }catch (Exception e){

                            }
                        } else if (direction == 'L') {
                            try {
                                newCell = board[i][j-1];
                                if (cell.isMovePossible(newCell)) {
                                    board[i][j-1] = cell;
                                    board[i][j] = new EmptyCell(j,i);
                                    cell.setNewPosition(j-1,i);
                                }
                            }catch (Exception e){

                            }
                        } else if (direction == 'U') {
                            try {
                                newCell = board[i-1][j];
                                if (cell.isMovePossible(newCell)) {
                                    board[i-1][j] = cell;
                                    board[i][j] = new EmptyCell(j,i);
                                    cell.setNewPosition(j,i-1);
                                }
                            }catch (Exception e){

                            }
                        } else if (direction == 'D') {
                            try {
                                newCell = board[i+1][j];
                                if (cell.isMovePossible(newCell)) {
                                    board[i+1][j] = cell;
                                    board[i][j] = new EmptyCell(j,i);
                                    cell.setNewPosition(j,i+1);
                                }
                            }catch (Exception e){

                            }
                        }
                        cell.setMoved(true);
                    }
                    currentPlayer = cell;
                }else if (board[i][j].getClass().equals(Bomb.class) ){
                    /*
                     *
                     * Bomba
                     *
                     * */
                    //se for bomba, ver o tempo que ela ainda tem, caso não seja detonator
                    Bomb bomb = (Bomb) board[i][j];
                    if (!bomb.isDetonator() && bomb.getTime()!=0){
                        //se ainda tem tempo, então decrementar
                        bomb.setTime(bomb.getTime()-1);
                    }else if (!bomb.isDetonator() && bomb.getTime()==0){
                        //se chegámos ao final, então esta bomba rebenta
                        deployExplosion(bomb, board);
                    }
                }else if (board[i][j].getClass().equals(Flame.class)){
                    /*
                     *
                     * Chama
                     *
                     * */
                    //se for a flame da bomba, temos de ver onde bateu esta flame
                    Flame flame = (Flame) board[i][j];
                    if (!flame.isDisplay())
                        board[i][j] = putOutFlames(flame);
                }else if(board[i][j].getClass().equals(Enemy.class)){
                    Cell newCell, cell;
                    Enemy enemy=(Enemy) board[i][j];
                    char direction= enemy.nextDir(board,currentPlayer);

                    switch (direction){
                        case('R'): {
                            try {
                                newCell = board[i][j+1];
                                if (enemy.isMovePossible(newCell)) {
                                    board[i][j+1] = enemy;
                                    board[i][j] = new EmptyCell(j,i);
                                    enemy.setNewPosition(j+1,i);
                                }
                            }catch (Exception e){

                            }
                        }case('L'): {
                            try {
                                newCell = board[i][j-1];
                                if (enemy.isMovePossible(newCell)) {
                                    board[i][j-1] = enemy;
                                    board[i][j] = new EmptyCell(j,i);
                                    enemy.setNewPosition(j-1,i);
                                }
                            }catch (Exception e){

                            }
                        }case('U'): {
                            try {
                                newCell = board[i-1][j];
                                if (enemy.isMovePossible(newCell)) {
                                    board[i-1][j] = enemy;
                                    board[i][j] = new EmptyCell(j,i);
                                    enemy.setNewPosition(j,i-1);
                                }
                            }catch (Exception e){

                            }
                        }case('D'): {
                            try {
                                newCell = board[i+1][j];
                                if (enemy.isMovePossible(newCell)) {
                                    board[i+1][j] = enemy;
                                    board[i][j] = new EmptyCell(j,i);
                                    enemy.setNewPosition(j,i+1);
                                }
                            }catch (Exception e){

                            }
                        }
                        default: break;
                    }
                    enemy.setMoved(true);

                }
            }
        }

    }

    private void deployExplosion(Bomb bomb, Cell[][] board){
        /*
        Quando o timer da bomba despoleta, deverá pintar-se
        o ecrã com as flames
        */
        //ir buscar o tamanho da explosão
        int flame = 0;
        //estas variáveis servem para quando se bater em algo, a chama não avança mais para esse lado
        boolean left=false, right=false, up=false, down=false;
        //decrementar o tamanho da explosão até esta ser zero
        while (flame != bomb.getFlame()){
            flame++;
            if (!left)
                try {
                    if (board[bomb.getPosY()][bomb.getPosX() - flame].getClass() != EmptyCell.class)
                        left=true;
                    if (board[bomb.getPosY()][bomb.getPosX() - flame].getClass() != SolidPath.class)
                        board[bomb.getPosY()][bomb.getPosX()-flame] = new Flame(bomb.getPosX()-flame,bomb.getPosY(), board[bomb.getPosY()][bomb.getPosX()-flame]);
                } catch (Exception e){
                    //Do nothing
                }
            if (!right)
                try{
                    if (board[bomb.getPosY()][bomb.getPosX() + flame].getClass() != EmptyCell.class)
                        right=true;
                    if (board[bomb.getPosY()][bomb.getPosX() + flame].getClass() != SolidPath.class)
                        board[bomb.getPosY()][bomb.getPosX()+flame] = new Flame(bomb.getPosX()+flame,bomb.getPosY(), board[bomb.getPosY()][bomb.getPosX()+flame]);
                } catch (Exception e){
                    //Do nothing
                }
            if (!up)
                try{
                    if (board[bomb.getPosY()-flame][bomb.getPosX()].getClass() != EmptyCell.class)
                        up=true;
                    if (board[bomb.getPosY()-flame][bomb.getPosX()].getClass() != SolidPath.class)
                        board[bomb.getPosY()-flame][bomb.getPosX()] = new Flame(bomb.getPosX(),bomb.getPosY()-flame, board[bomb.getPosY()-flame][bomb.getPosX()]);
                } catch (Exception e){
                    //Do nothing
                }
            if (!down)
                try{
                    if (board[bomb.getPosY()+flame][bomb.getPosX()].getClass() != EmptyCell.class)
                        down=true;
                    if (board[bomb.getPosY()+flame][bomb.getPosX()].getClass() != SolidPath.class)
                        board[bomb.getPosY()+flame][bomb.getPosX()] = new Flame(bomb.getPosX(),bomb.getPosY()+flame, board[bomb.getPosY()+flame][bomb.getPosX()]);
                } catch (Exception e){
                    //Do nothing
                }

        }
        //no sitio onde está a bomba passa a flame também
        board[bomb.getPosY()][bomb.getPosX()] = new Flame(bomb.getPosX(),bomb.getPosY(), new EmptyCell(bomb.getPosX(),bomb.getPosY()));
        //após a explosão o player pode colocar outra bomba
        int nBombs=currentPlayer.getBombs();
        currentPlayer.setBombs(++nBombs);
    }

    public void setBomb(){
        Cell[][] board = level.getBoard();
        currentPlayer.setBombs(currentPlayer.getBombs()-1);
        /*
        vamos mexer o player uma posição para trás, e na posição onde ele estava colocamos a bomba
        */
        if (currentPlayer.getDirection() == 'R'){
            board[currentPlayer.getPosY()][currentPlayer.getPosX()] = new Bomb(currentPlayer.getPosX(), currentPlayer.getPosY(), currentPlayer.getFlameSize());
            currentPlayer.setNewPosition(currentPlayer.getPosX()-1,currentPlayer.getPosY());
            board[currentPlayer.getPosY()][currentPlayer.getPosX()-1] = currentPlayer;
        }else if (currentPlayer.getDirection() == 'L'){
            board[currentPlayer.getPosY()][currentPlayer.getPosX()] = new Bomb(currentPlayer.getPosX(), currentPlayer.getPosY(), currentPlayer.getFlameSize());
            currentPlayer.setNewPosition(currentPlayer.getPosX() + 1, currentPlayer.getPosY());
            board[currentPlayer.getPosY()][currentPlayer.getPosX()+1] = currentPlayer;
        }else if (currentPlayer.getDirection() == 'U'){
            board[currentPlayer.getPosY()][currentPlayer.getPosX()] = new Bomb(currentPlayer.getPosX(), currentPlayer.getPosY(), currentPlayer.getFlameSize());
            currentPlayer.setNewPosition(currentPlayer.getPosX(),currentPlayer.getPosY()+1);
            board[currentPlayer.getPosY()+1][currentPlayer.getPosX()] = currentPlayer;
        }else if (currentPlayer.getDirection() == 'D'){
            board[currentPlayer.getPosY()][currentPlayer.getPosX()] = new Bomb(currentPlayer.getPosX(), currentPlayer.getPosY(), currentPlayer.getFlameSize());
            currentPlayer.setNewPosition(currentPlayer.getPosX(),currentPlayer.getPosY()-1);
            board[currentPlayer.getPosY()-1][currentPlayer.getPosX()] = currentPlayer;
        }

    }

    public Cell putOutFlames(Flame flame){
        /*
        *
        * Após ocorrer a explosão, vamos então apagar as chamas e ver os estragos
        *
        * */
        //se apenas queimámos uma célula vazia, então volta a ser uma célula vazia
        if (flame.getCellBackUp().getClass().equals(EmptyCell.class))
            return flame.getCellBackUp();
            //se rebentámos um tijolo, então passa a célula vazia
        else if (flame.getCellBackUp().getClass().equals(Brick.class))
            return new EmptyCell(flame.getPosX(),flame.getPosY());
            //se matámos um enemy, então ganhamos pontos e aquela posição passa a vazio
        else if (flame.getCellBackUp().getClass().equals(Enemy.class)){
            Enemy enemy = (Enemy) flame.getCellBackUp();
            currentPlayer.setScore(enemy.getScore());
            return new EmptyCell(flame.getPosX(),flame.getPosY());
        }
        //se acertámos num bónus, então temos de fazer display ao bónus em si
        else if (flame.getCellBackUp().getClass().equals(Bonus.class)){
            Bonus bonus = (Bonus) flame.getCellBackUp();
            bonus.setWall(false);
            return bonus;
        }
        //se acertámos no Gate, então este tem de estar dísponivel no ecrã
        else if (flame.getCellBackUp().getClass().equals(Bonus.class)){
            Gate gate = (Gate) flame.getCellBackUp();
            gate.setWall(false);
            return gate;
        }
        //se acertámos no Player, então morre
        else if (flame.getCellBackUp().getClass().equals(Player.class)){
            currentPlayer = (Player) flame.getCellBackUp();
            if (currentPlayer.death()){
                level= new Level(1);
                Cell[][] board = getCells();
                board[0][0] = currentPlayer;
                return currentPlayer;
            }
            return new EmptyCell(flame.getPosX(),flame.getPosY());
        }

        return new EmptyCell(flame.getPosX(),flame.getPosY());

    }
    public void movementPlay(/* orientation , actual position */){
        //método principal que valida a jogada
    }

    public boolean ruleCheck(/* orientation , actual position */){
        if(isEnemy()==false && isWall()==false/* && todas as outras regras*/) return true;
        return false;
    }


    public boolean isWall(/* orientation , actual position */){
        //if(cell[x][y].getType()==WALL){
        // return true;
        // }else{
        // return false;
        // }
        return true;
    }
    public boolean isEnemy(/* orientation , actual position */){
        //if(cell[x][y].getType()==ENEMY){
        // return true;
        // }else{
        // return false;
        // }
        return true;
    }

}
