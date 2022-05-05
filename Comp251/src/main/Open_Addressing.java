package main;

import java.util.Random;

public class Open_Addressing {
    public int m; // number of SLOTS AVAILABLE
    public int A; // the default random number
    int w;
    int r;
    public int[] Table;

    protected Open_Addressing(int w, int seed, int A) {

        this.w = w;
        this.r = (int) (w-1)/2 +1;
        this.m = power2(r);
        if (A==-1){
            this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
        }
        else{
            this.A = A;
        }
        this.Table = new int[m];
        for (int i =0; i<m; i++) {
            Table[i] = -1;
        }

    }

    /** Calculate 2^w*/
    public static int power2(int w) {
        return (int) Math.pow(2, w);
    }
    public static int generateRandom(int min, int max, int seed) {
        Random generator = new Random();
        if(seed>=0){
            generator.setSeed(seed);
        }
        int i = generator.nextInt(max-min-1);
        return i+min+1;
    }
    /**Implements the hash function g(k)*/
    public int probe(int key, int i) {
        //TODO: implement this function and change the return statement.
        return ((((int)((A*key)%power2(w)))>>(w-r))+i)%power2(r);//implement function provided in the pdf
//        return -1;

    }

    /**Inserts key k into hash table. Returns the number of collisions encountered*/
    public int insertKey(int key) {
        //TODO : implement this and change the return statement.


        int y = 0;

        int i = 0;
        while(!(i >= m) && !(Table[probe(key, i)] < 0)){
            i = i + 1;
            y = y + 1;
        }

        if (probe(key, i) >= m || Table[probe(key, i)] > 0) return y;
        Table[probe(key, i)] = key;
        return y;

    }

    /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
    public int insertKeyArray (int[] keyArray){
        int collision = 0;
        for (int key: keyArray) {
            collision += insertKey(key);
        }
        return collision;
    }

    /**Inserts key k into hash table. Returns the number of collisions encountered*/
    public int removeKey(int key){
        //TODO: implement this and change the return statement

//        return -1;
        int i=0;
        int collisioncount =0;
        int hashvalue = probe(key, i);
        while (Table[hashvalue] !=key && Table[hashvalue] != -1 && i<m) {
            i++;
            hashvalue = probe(key,i);
            collisioncount ++;
        }
        if (hashvalue <= m && Table[hashvalue] == key) {
            Table[hashvalue] = Integer.MIN_VALUE;
        }else if (Table[hashvalue]== -1) {
            collisioncount++;

        }
        return collisioncount;

//        int i=0;
//        int y=0;
//        if (Table[probe(key, i)] == key || Table[probe(key, i)] == -1 || i >= m) {
//            if(probe(key,i)<=m && Table[probe(key,i)]==key) {
//                Table[probe(key, i)] = Integer.MIN_VALUE;
//                if (Table[probe(key,i)]==-1) y++;
//                if (Table[probe(key,i)]==-1) y++;
//            }
//            if (Table[probe(key, i)] == -1) {
//                y++;
//            }
//        } else {
//            do {
//                i = i + 1;
//                y = y + 1;
//            } while ((i < m) && (key != Table[probe(key, i)]) && !(Table[probe(key, i)] == -1));
//            if (probe(key, i) > m) {
//            } else if (Table[probe(key, i)] != key) {
//            } else {
//                Table[probe(key, i)] = Integer.MIN_VALUE;
//                for (int j = 0; j < 2; j++) {
//                    if (Table[probe(key, i)] == -1) y++;
//                }
//            }
//            if (Table[probe(key, i)] == -1) {
//                y = y + 1;
//            }
//        }
//        return y;
    }
}



