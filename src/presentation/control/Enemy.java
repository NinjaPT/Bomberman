package presentation.control;//package control;

import presentation.dijkstra.DijkstraAlgorithm;
import presentation.dijkstra.Edge;
import presentation.dijkstra.Graph;
import presentation.dijkstra.Vertex;
import presentation.swing.BoardViewer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Enemy extends Player {


//      x=29
//      y=11
//    0	    1	2	3	4	5	6	7	8	9	10
//    11	12	13	14	15	16	17	18	19	20	21
//    22	23	24	25	26	27	28	29	30	31	32
//    33	34	35	36	37	38	39	40	41	42	43
//    44	45	46	47	48	49	50	51	52	53	54
//    55	56	57	58	59	60	61	62	63	64	65
//    66	67	68	69	70	71	72	73	74	75	76
//    77	78	79	80	81	82	83	84	85	86	87
//    88	89	90	91	92	93	94	95	96	97	98
//    99	100	101	102	103	104	105	106	107	108	109
//    110	111	112	113	114	115	116	117	118	119	120
//    121	122	123	124	125	126	127	128	129	130	131
//    132	133	134	135	136	137	138	139	140	141	142
//    143	144	145	146	147	148	149	150	151	152	153
//    154	155	156	157	158	159	160	161	162	163	164
//    165	166	167	168	169	170	171	172	173	174	175
//    176	177	178	179	180	181	182	183	184	185	186
//    187	188	189	190	191	192	193	194	195	196	197
//    198	199	200	201	202	203	204	205	206	207	208
//    209	210	211	212	213	214	215	216	217	218	219
//    220	221	222	223	224	225	226	227	228	229	230
//    231	232	233	234	235	236	237	238	239	240	241
//    242	243	244	245	246	247	248	249	250	251	252
//    253	254	255	256	257	258	259	260	261	262	263
//    264	265	266	267	268	269	270	271	272	273	274
//    275	276	277	278	279	280	281	282	283	284	285
//    286	287	288	289	290	291	292	293	294	295	296
//    297	298	299	300	301	302	303	304	305	306	307
//    308	309	310	311	312	313	314	315	316	317	318

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
                    return shortestPath(board, curr_player);
                }
            }
            case (3):{
                //Encontrar o caminho mais curto??
                //Falta validação de inimigo

                return shortestPath(board, curr_player);
            }
            default: return 'U';
        }
    }


    public void printCell(BoardViewer viewer){
        viewer.setEnemy(super.getPosX()+1, super.getPosY()+1);
        setMoved(false);
    }

    private char shortestPath(Cell[][] board, Player player){
        List<Vertex> nodes=new ArrayList<Vertex>();
        List<Edge> edges=new ArrayList<Edge>();
        List<Cell> walls=new ArrayList<Cell>();
        int e_x, e_y;
        e_x=super.getPosX()+1;
        e_y=super.getPosY()+1;


        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length;j++){
                Vertex location= new Vertex("Node_"+ i + "_" + j,"Node_"+ i + "_" + j,i+1,j+1);
                nodes.add(location);
            }
        }
        for(Vertex node:nodes){
            int i=node.x;
            int j=node.y;
            Cell cell=board[i][j];
            if(!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                //se não for um tipo de wall cria edges
                //tenta 4 ligações
                try{
                    cell= board[i-1][j];
                    if(!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                        //Edge_x.y_x.y
                        Edge lane = new Edge("Edge_"+ i + "." + j + "_" +(i-1)+"."+j ,nodes.get(i*j), nodes.get((i-1)*j), 1);
                        edges.add(lane);
                    }
                } catch (Exception e){
                    //Do nothing
                }
                try {
                    cell=board[i+1][j];
                    if (!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                        Edge lane = new Edge("Edge_"+ i + "." + j + "_" +(i+1)+"."+j ,nodes.get(i*j), nodes.get((i+1)*j), 1);
                        edges.add(lane);
                    }
                } catch (Exception e){
                    //Do nothing
                }
                try {
                    cell=board[i][j-1];
                    if (!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                        Edge lane = new Edge("Edge_"+ i + "." + j + "_" +i+"."+(j-1) ,nodes.get(i*j), nodes.get(i*(j-1)), 1);
                        edges.add(lane);
                    }
                } catch (Exception e){
                    //Do nothing
                }
                try {
                    cell=board[i][j+1];
                    if (!cell.getClass().equals(Brick.class) && !cell.getClass().equals(SolidPath.class)){
                        Edge lane = new Edge("Edge_"+ i + "." + j + "_" +i+"."+(j+1) ,nodes.get(i*j), nodes.get(i*(j+1)), 1);
                        edges.add(lane);
                    }
                } catch (Exception e){
                    //Do nothing
                }
            }

        }
        Graph graph=new Graph(nodes,edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(e_x*e_y));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));
        int x=path.getFirst().x;
        int y=path.getFirst().y;
        if((e_x-x)==0){
            if ((e_y - y)<0){
                return 'L';
            }else return 'R';
        }else if ((e_x - x)<0){
            return 'U';
        }else return 'D';
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
