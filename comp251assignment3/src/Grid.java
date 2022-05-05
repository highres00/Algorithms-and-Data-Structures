// Java Code implementation for above problem
import java.util.LinkedList;
import java.util.Queue;


// QItem for current location and distance
// from source location
class QItem
{

    int level;
    int row;
    int col;
    int dist;
    public QItem(int level, int row , int col, int dist)
    {
        this.level = level;
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class Grid
{

    private static int find_exit(String[][][] jail)
    {

        QItem source = new QItem(0, 0, 0, 0);

        // To keep track of visited QItems. Marking
        // blocked cells as visited.
        firstLoop:
        for (int i = 0; i < jail.length; i++)
        {
            for (int j = 0; j < jail[i].length; j++)
            {
                for(int k = 0 ; k < jail[i][j].length ; k++)
                    // Finding source
                    if (jail[i][j][k] == "S")
                    {
                        source.level = i;
                        source.row = j;
                        source.col = k;
                        break firstLoop;
                    }
            }
        }

        // applying BFS on matrix cells starting from source
        Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(source.level, source.row, source.col,0));

        boolean[][][] visited = new boolean[jail.length][jail[0].length][jail[0][0].length];
        visited[source.level][source.row][source.col] = true;

        while (queue.isEmpty() == false)
        {
            QItem p = queue.remove();

            // Destination found;
            if (jail[p.level][p.row][p.col] == "E")
                return p.dist;

            // moving North
            if (isValid(p.level, p.row - 1, p.col, jail, visited))
            {
                queue.add(new QItem(p.level, p.row - 1, p.col, p.dist + 1));
                visited[p.level][p.row - 1][p.col] = true;
            }

            // moving South
            if (isValid(p.level, p.row + 1, p.col, jail, visited))
            {
                queue.add(new QItem(p.level, p.row + 1, p.col, p.dist + 1));
                visited[p.level][p.row + 1][p.col] = true;
            }

            // moving West
            if (isValid(p.level, p.row, p.col - 1, jail, visited))
            {
                queue.add(new QItem(p.level, p.row, p.col - 1, p.dist + 1));
                visited[p.level][p.row][p.col - 1] = true;
            }

            // moving East
            if (isValid(p.level, p.row, p.col + 1, jail,visited))
            {
                queue.add(new QItem(p.level, p.row, p.col + 1,p.dist + 1));
                visited[p.level][p.row][p.col + 1] = true;
            }

            // moving Up
            if (isValid(p.level - 1, p.row, p.col, jail,visited))
            {
                queue.add(new QItem(p.level -1, p.row, p.col ,p.dist + 1));
                visited[p.level-1][p.row][p.col] = true;
            }

            // moving Down
            if (isValid(p.level + 1, p.row, p.col, jail,visited))
            {
                queue.add(new QItem(p.level + 1, p.row, p.col ,p.dist + 1));
                visited[p.level + 1][p.row][p.col] = true;
            }
        }
        return -1;
    }

    // checking where it's valid or not
    private static boolean isValid(int level, int row, int col, String[][][] jail, boolean[][][] visited)
    {
        if(level < 0 || level >= jail.length)
        {
            return false;
        }
        if(row < 0 || row >= jail[0].length)
        {
            return false;
        }
        if(col < 0 || col >= jail[0][0].length)
        {
            return false;
        }
        if(jail[level][row][col] == "#" || visited[level][row][col] == true)
        {
            return false;
        }

        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        String jail[][][] = {{{"S", ".", ".", ".", "."}, {".", "#", "#", "#", "."}, {".", "#", "#", ".", "."}, {"#", "#", "#", ".", "#"}} ,

                {{"#","#","#","#","#"}, {"#","#","#","#","#"}, {"#","#",".","#","#"}, {"#","#",".",".","."}} ,

                {{"#","#","#","#","#"}, {"#","#","#","#","#"}, {"#",".","#","#","#"}, {".",".",".","#","E"}} };

        System.out.println(find_exit(jail));
    }
}