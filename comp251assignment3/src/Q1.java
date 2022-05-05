import java.util.*;


public class Q1 {
    //private static boolean found = false;

    public static int find_exit(String[][][] jail) {
        int[] startPos = {0, 0, 0};
        boolean foundS = false;
        boolean[][][] visited = new boolean[jail.length][jail[0].length][jail[0][0].length];

        for(int level = 0; level < jail.length; level ++)
        {
            for(int row = 0; row < jail[0].length; row ++)
            {
                for (int col = 0; col < jail[0][0].length; col ++)
                {
                    if (jail[level][row][col].equals("S"))
                    {
                        startPos = new int[] {level, row, col};
                        foundS = true;
                        break;
                    }

                }
                if(foundS == true)
                {
                    break;
                }

            }
            if(foundS == true)
            {
                break;
            }

        }

        //hashmap storing number of moves
        Hashtable <int [], Integer> hm = new Hashtable<int [], Integer>();
        int[] result = new int[1];

        hm.put(startPos, 0);

        //add to q
        Queue<int []> q = new LinkedList<int []>();
        q.add(startPos);

        int count = 0;
        boolean[] found = {false};
        while(!q.isEmpty())
        {

            if(found[0] /* ||   count == 400000*/)
            {
                return result[0];

            }
            else {
                int[] element = q.remove();

                {
                    addToQ(element, jail, q, hm, found, result);
                }
                count ++;
            }

        }
        return -1;

    }


    public static void main(String[] args) {


    }

    private static void addToQ (int [] cord,  String [][][] jail, Queue<int []> q, Hashtable<int [], Integer> hm, boolean[] found, int[] result)
    {
        if(found[0])
        {
            return;
        }

        jail[cord[0]][cord[1]][cord [2]] = "v";


        int lastLevel = jail.length - 1;
        int lastRow = jail[0].length - 1;
        int lastCol = jail[0][0].length - 1;

        int[] neighbour;



        //up
        int distance = hm.get(cord);
        if (cord[0] != 0 && /*visited[cord[0] - 1][cord[1] ][cord[2]]== false*/(jail[cord[0] - 1][cord[1] ][cord[2]].equals(".") || jail[cord[0] - 1][cord[1] ][cord[2]].equals("E")  ))
        {
            neighbour =new int[] {cord[0] - 1, cord[1], cord[2] };
            q.add(neighbour);
            hm.put(neighbour, distance + 1);
            if(jail[cord[0] - 1][cord[1] ][cord[2]].equals("E"))
            {
                found[0]= true;
                result[0] = distance + 1;
                return;
            }

        }

        //down
        if (cord[0] != lastLevel && /*visited[cord[0] + 1][cord[1]][cord[2]]== false*/(jail[cord[0] + 1][cord[1]][cord[2]].equals(".") || jail[cord[0] + 1][cord[1]][cord[2]].equals("E") ))
        {
            neighbour =new int[] {cord[0] + 1, cord[1], cord[2] };
            q.add(neighbour);
            hm.put(neighbour, distance + 1);
            if(jail[cord[0] + 1][cord[1]][cord[2]].equals("E"))
            {
                found[0]= true;
                result[0] = distance + 1;
                return;
            }

        }

        //right
        if (cord[2] != lastCol && /*visited[cord[0]][cord[1]][cord[2] + 1]== false */(jail[cord[0]][cord[1]][cord[2] + 1].equals(".") || jail[cord[0]][cord[1]][cord[2] + 1].equals("E") ))
        {
            neighbour =new int[]{cord[0], cord[1], cord[2] + 1};
            q.add(neighbour);
            hm.put(neighbour, distance + 1);
            if(jail[cord[0]][cord[1]][cord[2] + 1].equals("E"))
            {
                found[0]= true;
                result[0] = distance + 1;
                return;
            }


        }


        //front
        if (cord[1] != 0 && /*visited[cord[0]][cord[1] - 1][cord[2]]== false*/(jail[cord[0]][cord[1] - 1][cord[2]].equals(".") || jail[cord[0]][cord[1] - 1][cord[2]].equals("E") ) )
        {
            neighbour =new int[]{cord[0], cord[1] - 1, cord[2] };
            q.add(neighbour);
            hm.put(neighbour, distance + 1);
            if(jail[cord[0]][cord[1] - 1][cord[2]].equals("E"))
            {
                found[0]= true;
                result[0] = distance + 1;
                return;
            }

        }

        //left
        if (cord[2] != 0 && /*visited[cord[0] ][cord[1]][cord[2] - 1]== false*/(jail[cord[0] ][cord[1]][cord[2] - 1].equals(".") || jail[cord[0] ][cord[1]][cord[2] - 1].equals("E") ))
        {
            neighbour =new int[]{cord[0], cord[1] , cord[2] - 1};
            q.add(neighbour);
            hm.put(neighbour, distance + 1);

            if(jail[cord[0] ][cord[1]][cord[2] - 1].equals("E"))
            {
                found[0]= true;
                result[0] = distance + 1;
                return;
            }

        }

        //back

        if (cord[1] != lastRow && /*visited[cord[0]][cord[1] + 1][cord[2] ]== false*/ (jail[cord[0]][cord[1] + 1][cord[2] ].equals(".") ||  jail[cord[0]][cord[1] + 1][cord[2] ].equals("E")) )
        {
            neighbour =new int[] {cord[0], cord[1] + 1 , cord[2] };
            q.add(neighbour);
            hm.put(neighbour, distance + 1);
            if(jail[cord[0]][cord[1] + 1][cord[2] ].equals("E"))
            {
                found[0]= true;
                result[0] = distance + 1;
                return;
            }


        }









    }

}