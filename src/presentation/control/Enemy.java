package presentation.control;//package control;

import presentation.dijkstra.Edge;
import presentation.dijkstra.Vertex;
import presentation.dijkstra.Graph;
import presentation.swing.BoardViewer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Enemy extends Player {

    private boolean wallPass=false;
    private int life;
    private double speed=0;
    private int intelligence=0;
    private int score;

    /****************************************************************************************/

    // Construtor

    /****************************************************************************************/

    public Enemy(int posX, int posY,int enemyType) {
        super(posX, posY);
        translateEnemyType(enemyType);
    }

    private void translateEnemyType(int enemyType){
        /*
        *        Nome        Pontos  Velocidade  Inteligência    PassaParedes
        *  1     Balloom     100     lento       baixa           não
        *  2     Oneal       200     médio       média           não
        *  3     Doll        400     médio       baixa           não
        *  4     Minvo       800     rápido      média           não
        *  5     Kondoria    1000    lentissimo  alta            sim
        *  6     Ovapi       2000    lento       média           sim
        *  7     Pass        4000    rápido      alta            Não
        *  8     Pontan      8000    rápido      alta            Sim
        * */

        translateLifePoints(enemyType);
        translateSpeed(enemyType);
        translateIntelligence(enemyType);
        translateWallPass(enemyType);
        translateScore(enemyType);

    }

    private void translateScore(int enemyType){
        switch(enemyType){
            case (1): score=100; break;
            case (2): score=200; break;
            case (3): score=400; break;
            case (4): score=800; break;
            case (5): score=1000; break;
            case (6): score=2000; break;
            case (7): score=4000; break;
            case (8): score=8000; break;
            default: break;
        }
    }

    private void translateWallPass(int enemyType){
        switch(enemyType){
            case (1): wallPass=false; break;
            case (2): wallPass=false; break;
            case (3): wallPass=false; break;
            case (4): wallPass=false; break;
            case (5): wallPass=true; break;
            case (6): wallPass=true; break;
            case (7): wallPass=false; break;
            case (8): wallPass=true; break;
            default: break;
        }
    }

    private void translateIntelligence(int enemyType){
        /*
        * Baixa = 1
        * Média = 2
        * Alta = 3
        * */
        switch(enemyType){
            case (1): intelligence=1; break;
            case (2): intelligence=2; break;
            case (3): intelligence=1; break;
            case (4): intelligence=2; break;
            case (5): intelligence=3; break;
            case (6): intelligence=2; break;
            case (7): intelligence=3; break;
            case (8): intelligence=3; break;
            default: break;
        }
    }

    private void translateSpeed(int enemyType){
        /*
        * Lentíssimo = 1/4
        * Lento = 1/2
        * Médio = 1
        * Rápido = 2
        * */
        switch(enemyType){
            case (1): speed=0.5; break;
            case (2): speed=1; break;
            case (3): speed=1; break;
            case (4): speed=2; break;
            case (5): speed=0.25; break;
            case (6): speed=0.5; break;
            case (7): speed=1; break;
            case (8): speed=1; break;
            default: break;
        }
    }

    private void translateLifePoints(int enemyType){
        switch(enemyType){
            case (1): life=100; break;
            case (2): life=200; break;
            case (3): life=400; break;
            case (4): life=800; break;
            case (5): life=1000; break;
            case (6): life=2000; break;
            case (7): life=4000; break;
            case (8): life=8000; break;
            default: break;
        }
    }

    /****************************************************************************************/

    // Outros

    /****************************************************************************************/

    public int getLife(){
        return life;
    }

    public int getScore(){
        return score;
    }

    public char nextDir(Cell[][] board, Player curr_player){
        char[] directions= {'U','D','L','R'};
        int  x,y;
        int e_x,e_y;
        e_x=super.getPosX();
        e_y=super.getPosY();

        //Encontra posição do jogador
        x=curr_player.getPosX();
        y=curr_player.getPosY();

        switch (intelligence){
            case(1):{
                Random r = new Random();
                int k=r.nextInt(4-0);
                return directions[k];
            }
            case(2):{
                //metodo pos relativa
                if(super.isMoved()==true){
                    return super.getDirection();
                }else{
                    char[] array=shortestPath(board, curr_player);
                    return isPlaceEnemy(board, array[0]);
                }
            }
            case (3):{
                //Encontrar o caminho mais curto??
                //Falta validação de inimigo
                char[] array=shortestPath(board, curr_player);
                return isPlaceEnemy(board, array[0]);
            }
            default: return 'U';
        }
    }


    public void printCell(BoardViewer viewer){
        viewer.setEnemy(super.getPosX()+1, super.getPosY()+1);
        setMoved(false);
    }

    private char[] shortestPath(Cell[][] board, Player player){
        List<Vertex> nodes=new ArrayList<Vertex>();
        List<Edge> edges=new ArrayList<Edge>();
        List<Cell> walls=new ArrayList<Cell>();


        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length;j++){

                Cell cell=board[i][j];
                if(cell.getClass().equals(Brick.class) || cell.getClass().equals(SolidPath.class)){
                    walls.add(cell);
                }else{
                    Iterator<Cell> it= walls.iterator();
                    //Cria o nó correspondente à célula
                    Vertex location= new Vertex("Node_"+ i + "_" + j,"Node_"+ i + "_" + j);
                    nodes.add(location);
                    if(i==0 || i<board.length || j==0 || j<board[i].length){
                        //tenta 2 ou 3 ligações

                    }else{
                        //tenta 4 ligações
                        cell= board[i-1][j];
                        if(!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                            //Edge_x.y_x.y
                            //Edge lane = new Edge("Edge_"+ i + "." + j + "_" +i+"."+j+1 ,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
                            //edges.add(lane);
                        }
                        cell=board[i+1][j];
                        if (!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                        }
                        cell=board[i][j-1];
                        if (!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                        }
                        cell=board[i][j+1];
                        if (!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                        }
                    }
                }
            }
        }


        Graph graph=new Graph(nodes,edges);
    }

    private char isPlaceEnemy(Cell[][] board, char direction){
        int e_x,e_y;
        e_x=super.getPosX();
        e_y=super.getPosY();

        switch (direction){
            case 'U':{
                Cell cell=board[e_x][e_y+1];
                if(cell.getClass().equals(SolidPath.class)){
                    return 'D';
                }else{
                    return direction;
                }
            }case 'D':{
                Cell cell=board[e_x][e_y-1];
                if(cell.getClass().equals(SolidPath.class)){
                    return 'U';
                }else{
                    return direction;
                }
            }
            case 'L':{
                Cell cell=board[e_x-1][e_y];
                if(cell.getClass().equals(SolidPath.class)){
                    return 'R';
                }else{
                    return direction;
                }
            }
            case 'R':{
                Cell cell=board[e_x+1][e_y];
                if(cell.getClass().equals(SolidPath.class)){
                    return 'L';
                }else{
                    return direction;
                }
            }
            default: return 'U';
        }
    }

//    private void addLane(String laneId, int sourceLocNo, int destLocNo,
//                         int duration) {
//        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
//        edges.add(lane);
//    }
//    @Override
//    public boolean isMovePossible(Cell cell, char orientation) {
//        //TODO Luís, só comentei isto porque estava em erro e queria dar-lhe mais um bocado
//        if(wallPass==true){
//            switch(orientation){
//                case 'U': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//                case 'D': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//                case 'R': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//                case 'L': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//            }
//        }else{
//            switch(orientation){
//                case 'U': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//                case 'D': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//                case 'R': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//                case 'L': if(/*board x y não for parede fronteira ou enemy ou bomba*/){
//                    return true;
//                }   break;
//            }
//        }
//    }

}
