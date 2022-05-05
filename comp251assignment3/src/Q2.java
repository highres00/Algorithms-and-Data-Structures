import java.util.*;


public class Q2 {

    public static int rings(Hashtable<Integer, ArrayList<Integer>> graph, int[]location) {
        var r = new int[graph.size()];
        int i = 0;
        while (i < graph.size()) {
            var v = graph.get(i);
            int j = 0;
            while (true) {
                if (j >= v.size()) break;
                Integer node;
                node = v.get(j);
                r[node] ++;
                j++;
            }
            i++;
            System.out.println(graph);
        }

        int x = 0;
        int y = 0;
        int index=0;
        int[] p={1,2};

        int index2;
        index2 = 0;
        while (true) {
            if (index2 >= r.length) break;
            if (r[index2] != 0){
            }else{
                var a= location[index2];
                if (a != 1) y = y + 1;
                else x = x + 1;
                System.out.println(x);
            }
            index2 = index2 + 1;
            System.out.println(index2);
        }
        if (y <= x) index = 0;
        else index = 1;

        var removed = 0;
        var min = 0;

        if (removed >= graph.size()){
            return min;
        }
        do{
            var node = 0;
            var b = r.length;
            if (node >= b){
                if (removed != graph.size()){
                    index = (index + 1) % 2;
                    min++;
                    System.out.println(min);
                    System.out.println(graph);
                }
            }else{
                do{
                    if (r[node] != 0 || location[node] != p[index]){
                    }else{
                        ArrayList<Integer> temp = graph.get(node);
                        var j = 0;
                        while (true) {
                            if (j >= temp.size()) break;
                            Integer c = temp.get(j);
                            r[c]--;
                            j++;
                        }
                        r[node] = -1;
                        System.out.println(r);
                        removed++;
                        node = -1;
                    }
                    node++;
                } while (node < b);
                if (removed != graph.size()){
                    index = (index + 1) % 2;
                    System.out.println(min);
                    min++;
                }
            }
        } while (removed < graph.size());
        System.out.println("Messi better than ronaldo but Maguire is the GOAT");
        System.out.println(min);
        return min;
    }
//    private static int[] remove (Hashtable<Integer, ArrayList<Integer>> graph, Integer byeNode, int[] inDeg) {
//        ArrayList<Integer> outDeg = graph.get(byeNode);
//        for (int j = 0; j < outDeg.size(); j++){
//            Integer i = outDeg.get(j);
//            inDeg[i] = inDeg[i] - 1;
//        }
//        inDeg[byeNode] = -1;
//        return inDeg;
//
//    }


//    private static int[] calcInDegree (Hashtable<Integer, ArrayList<Integer>> graph)
//    {
//        int[] result = new int[graph.size()];
//        for(int i = 0; i < graph.size(); i ++)
//        {
//            ArrayList<Integer> val = graph.get(i);
//            for(Integer node : val)
//            {
//                result[node] = result[node] + 1;
//            }
//        }
//        return result;
//
//    }



    public static void main(String[] args) {

    }

}
