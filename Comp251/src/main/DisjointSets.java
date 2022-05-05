package main;


/****************************
 *
 * COMP251 template file
 *
 * Assignment 1, Question 2
 *
 *****************************/


public class DisjointSets {

    private int[] par;
    private int[] rank;

    /* contructor: creates a partition of n elements. */
    /* Each element is in a separate disjoint set */
    DisjointSets(int n) {
        if (n>0) {
            par = new int[n];
            rank = new int[n];
            for (int i=0; i<this.par.length; i++) {
                par[i] = i;
            }
        }
    }

    public String toString(){
        int pari,countsets=0;
        String output = "";
        String[] setstrings = new String[this.par.length];
        /* build string for each set */
        {
            int i=0;
            if (i < this.par.length){
                do{
                    pari = find(i);
                    if (setstrings[pari] == null){
                        setstrings[pari] = String.valueOf(i);
                        countsets += 1;
                    }else{
                        setstrings[pari] += "," + i;
                    }
                    i++;
                } while (i < this.par.length);
            }
        }
        /* print strings */
        output = countsets + " set(s):\n";
        for (int i=0; i<this.par.length; i++) {
            if (setstrings[i] != null) {
                output += i + " : " + setstrings[i] + "\n";
            }
        }
        return output;
    }

    /* find resentative of element i */
    public int find(int i) {

        /* Fill this method (The statement return 0 is here only to compile) */
//        return 0;
        //Base case, we have found the root of tree which is the representative of itself
//        if (par[i] == i) return i;
//        par[i] = find(par[i]); //parent of i is directly set to the root (path compression)
//        return par[i]; //return parent of i
        if(par[i]==i) return i;
         return find(par[i]);

    }

    /* merge sets containing elements i and j */
    public int union(int i, int j) {

        /* Fill this method (The statement return 0 is here only to compile) */
//        return 0;
//
//        if (find(i) == find(j)) {
//            return 0;
//        } //check if representative of i and j are not equal (not in same set already)
//        if (rank[find(i)] < rank[find(j)]) { //if the rank of representative of i is less than rank of representative of j
//            par[find(i)] = find(j);
//        }
//        if (rank[find(i)] > rank[find(j)]) {
//            par[find(j)] = find(i);
//        }
//        par[find(i)] = find(j);
//        rank[find(j)]++;
//        return 0;

        if(find(j) == find(i)){
            return find(i);
        }

        if (rank[find(j)] < rank[find(i)]){
            par[find(j)]=find(i);
            par[find(i)]= find(j);
            if (rank[find(i)] >= rank[find(j)]){
                rank[find(j)] = rank[find(j)] + 1;
            }
        }
        par[find(i)] = find(j);
        if (rank[find(j)] > rank[find(i)]) return par[find(i)];
        rank[find(j)] = rank[find(j)] + 1;

        return par[find(i)];
    }

    public static void main(String[] args) {

        DisjointSets myset = new DisjointSets(6);
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 3");
        myset.union(2,3);
        System.out.println(myset);
        System.out.println("-> Union 2 and 1");
        myset.union(2,1);
        System.out.println(myset);
        System.out.println("-> Union 4 and 5");
        myset.union(4,5);
        System.out.println(myset);
        System.out.println("-> Union 3 and 1");
        myset.union(3,1);
        System.out.println(myset);
        System.out.println("-> Union 2 and 4");
        myset.union(2,4);
        System.out.println(myset);

    }

}
