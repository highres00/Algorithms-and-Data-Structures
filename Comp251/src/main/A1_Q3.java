package main;

import java.util.*;

public class A1_Q3 {

    private static String[] posts;
    private static Map<String, String[]> p3;
    private static Map<String, Integer> f2;
    private static HashMap<String, Integer> h1;
    private static String[] Vog;
    private static Map<String, Integer> hashMap;
    private static ArrayList<String> array;
    private static Map<String, Integer> f;
    private static Map<String, String[]> p;
    private static LinkedList<Map.Entry<String, Integer>> ss;

    public static ArrayList<String> Discussion_Board(String[] posts){
        A1_Q3.posts = posts;


        ArrayList<String> array1 = new ArrayList<String>();
        ArrayList<String> array2 = new ArrayList<String>();

        HashMap<String, String[]> p = new HashMap<>();
        firstIteration(posts, p);
        HashMap<String, Integer> f = new HashMap<>();
        HashMap<String, Integer> mainMap = new HashMap<>();
        hashFunction(mainMap, p, f);
        helper4(array1, p, mainMap);
        HashMap<Integer, String> og=new HashMap<Integer, String>();

        Map<String, Integer> end = helper3(array1, f);
        Map<String, Integer> assist = helper3(array2, f);
        Map<String, Integer> counter = helper3(array1, mainMap);
        Map<String, Integer> store = helper3(array2, mainMap);
        LinkedList<Map.Entry<String, Integer>> ss = new LinkedList<Map.Entry<String, Integer>>(end.entrySet());

        cmp(ss);
        LinkedHashMap<String, Integer> sM = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Integer> sM1 = new LinkedHashMap<String, Integer>();
        LinkedHashMap<String, Integer> sM2 = new LinkedHashMap<String, Integer>();
        ArrayList<String> finalAnswer = finalAnswer(ss, sM);
        return finalAnswer;
    }

    private static void helper4(ArrayList<String> array, Map<String, String[]> p, HashMap<String, Integer> mainMap){
        A1_Q3.array = array;
        A1_Q3.p = p;
        hashMap = mainMap;
        Iterator<Map.Entry<String, Integer>> i4;
        i4 = mainMap.entrySet().iterator();
        if (!i4.hasNext()){
            return;
        }
        do{
            Map.Entry<String, Integer> entry = i4.next();
            if (entry.getValue() != p.size()){
            }else{
                boolean add;
                add = array.add(entry.getKey());
            }
        } while (i4.hasNext());
    }

    private static Map<String, Integer> helper3(ArrayList<String> array, Map<String, Integer> f){
        A1_Q3.array = array;
        A1_Q3.f = f;
        int i = 0;
        HashMap<String, Integer> e1 = new HashMap<>();
        while (array.size() > i) {
            e1.put(array.get(i), f.get(array.get(i)));
            i++;
        }
        HashMap<String, Integer> e11;
        e11 = e1;
        return e11;
    }

    private static ArrayList<String> finalAnswer(LinkedList<Map.Entry<String, Integer>> ss, LinkedHashMap<String, Integer> sM){
        A1_Q3.ss = ss;
        hashMap = sM;
        int j = 0;
        if (j < ss.size()){
            do{
                Map.Entry<String, Integer> e2;
                e2 = ss.get(j);
                Integer put;
                put = sM.put(e2.getKey(), e2.getValue());
                j = j + 1;
            } while (j < ss.size());
        }

        return idk(sM);
    }

    private static ArrayList<String> idk(LinkedHashMap<String, Integer> sM){
        HashSet<Integer> v2;
        v2 = new HashSet<Integer>(sM.values());
        ArrayList<String> ch;
        ch = new ArrayList<String>();
        return getAnswer(ch, sM, v2);
    }

    private static void cmp(LinkedList<Map.Entry<String, Integer>> ss){
        ss.sort(new Comparator<Map.Entry<String, Integer>>(){
            private Map.Entry<String, Integer> o1;
            private Map.Entry<String, Integer> o2;

            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                this.o1 = o1;
                this.o2 = o2;
                int i;
                i = o1.getValue().compareTo(o2.getValue());
                return i;

            }
        });
    }

    private static void torMa(LinkedList<Map.Entry<String, Integer>> ss){
        ss.sort(new Comparator<Map.Entry<String, Integer>>(){
            private Map.Entry<String, Integer> o1;
            private Map.Entry<String, Integer> o2;

            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                this.o1 = o1;
                this.o2 = o2;
                int i = o1.getValue().compareTo(o2.getValue());
                return i;

            }
        });
    }

    private static ArrayList<String> getAnswer(ArrayList<String> c, Map<String, Integer> sM2, Set<Integer> v2){
        if (!(sM2.size() != v2.size())){
            Iterator<Map.Entry<String, Integer>> iterator = sM2.entrySet().iterator();
            if (!iterator.hasNext()){
            }else{
                do{
                    Map.Entry<String, Integer> entry;
                    entry = iterator.next();

                    boolean add = c.add(entry.getKey());
                } while (iterator.hasNext());
            }
            Collections.reverse(c);
        }else{
            TreeMap<String, Integer> sm = new TreeMap<>(sM2);


            Iterator<Map.Entry<String, Integer>> i3;
            i3 = sm.entrySet().iterator();
            while (i3.hasNext()) {
                Map.Entry<String, Integer> entry = i3.next();

                boolean add = c.add(entry.getKey());
            }

        }


        return c;
    }

    private static void hashFunction(Map<String, Integer> hashMap, Map<String, String[]> people, Map<String, Integer> frequency){
        int s;
        Iterator<Map.Entry<String, String[]>> i2 = people.entrySet().iterator();
        while (i2.hasNext()) {
            Map.Entry<String, String[]> s11;
            s11 = i2.next();
            HashMap<String, Integer> h1 = new HashMap<>();
            String[] value;
            value = s11.getValue();
            helper1(frequency, h1, value);

            helper2(hashMap, h1);

        }
    }

    private static void helper2(Map<String, Integer> hashMap, HashMap<String, Integer> h1){
        A1_Q3.hashMap = hashMap;
        A1_Q3.h1 = h1;
        int s;
        Iterator<Map.Entry<String, Integer>> i1;
        i1 = h1.entrySet().iterator();
        while (i1.hasNext()) {
            Map.Entry<String, Integer> entry = i1.next();

            if (hashMap.get(entry.getKey()) != null){
                s = hashMap.get(entry.getKey());
            }else s = 0;
            Integer put = hashMap.put(entry.getKey(),
                    entry.getValue() + s);
        }
    }

    private static void helper1(Map<String, Integer> f2, HashMap<String, Integer> h1, String[] v){
        A1_Q3.f2 = f2;
        A1_Q3.h1 = h1;
        A1_Q3.Vog = v;
        int i = 0;
        while (i < v.length) {
            String w = v[i];

            Integer og1;
            og1 = h1.get(w);
            Integer f;
            f = f2.get(w);

                      if (og1 != null){
                          if (f != null){
                          }else f2.put(w, 1);
                      }else{
                          h1.put(w, 1);
                          if (f != null){
                          }else f2.put(w, 1);
                      }
            if (f == null){
            }else f2.put(w, f2.get(w) + 1);
            i++;
        }
    }

    private static void firstIteration(String[] posts, Map<String, String[]> people){
        A1_Q3.posts = posts;
        A1_Q3.p3 = people;
        int i = 0;
        if (i < posts.length){
            do{
                String[] words;
                words = posts[i].split(" ");

                if (people.get(words[0]) != null){
                    int v = people.get(words[0]).length;
                    int w = words.length;
                    String[] x;
                    x = new String[v+ w];
                    System.arraycopy(people.get(words[0]), 0, x, 0, v);
                    System.arraycopy(words, 0, x, v, w);
                    for (String s : people.put(words[0], x)){

                    }

                }else people.put(words[0], words);
                i++;
            } while (!(i >= posts.length));
        }
    }
}


//        int s = 0;
//
//        HashMap<String, String[]> p = new HashMap<>();
//
//        firstIteration(posts, p);
//
//        HashMap<String, Integer> mainH = new HashMap<>();
//        HashMap<String, Integer> f;
//        f = new HashMap<>();
//        Iterator<Entry<String, String[]>> og = getOg(p);
//
//        secondIteration(mainH, f, og);
//
//        ArrayList<String> s4 = new ArrayList<>();
//
//        hashFunction(p, mainH, s4);
//
//        LinkedList<Entry<String, Integer>> list = mainHelper(f, s4);
//        LinkedHashMap<String, Integer> sM = getH(list);
//        HashSet<Integer> ss = new HashSet<Integer>(sM.values());
//        ArrayList<String> count;
//        count = new ArrayList<String>();
//        return findAnswer(sM, ss, count);
//    }
//
//    private static Iterator<Entry<String, String[]>> getOg(HashMap<String, String[]> p){
//        Iterator<Entry<String, String[]>> og = p.entrySet().iterator();
//        return og;
//    }
//
//    private static ArrayList<String> findAnswer(LinkedHashMap<String, Integer> sM, HashSet<Integer> ss, ArrayList<String> count){
//        if (sM.size() == ss.size()){
//            Iterator<Entry<String, Integer>> bigF = sM.entrySet().iterator();
//            while (bigF.hasNext()) {
//                Entry<String, Integer> entry = bigF.next();
//                count.add(entry.getKey());
//            }
//            Collections.reverse(count);
//            return count;
//        }
//        TreeMap<String, Integer> sm = new TreeMap<>(sM);
//        Iterator<Entry<String, Integer>> i2 = sm.entrySet().iterator();
//        while (i2.hasNext()) {
//            Entry<String, Integer> e = i2.next();
//            count.add(e.getKey());
//        }
//        return count;
//    }
//
//    private static LinkedList<Entry<String, Integer>> mainHelper(HashMap<String, Integer> f, ArrayList<String> s4){
//        ArrayList<String> torMaz;
//        torMaz = s4;
//        HashMap<Integer, String> m;
//        m = new HashMap<Integer, String>();
//        HashMap<String, Integer> end;
//        end = new HashMap<>();
//        int c = 0;
//        while (true) {
//            if (c >= torMaz.size()) break;
//            end.put(torMaz.get(c), f.get(torMaz.get(c)));
//            c++;
//        }
//        LinkedList<Entry<String, Integer>> list = cmpre(end);
//        return list;
//    }
//
//    private static LinkedList<Entry<String, Integer>> cmpre(HashMap<String, Integer> end){
//        LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(end.entrySet());
//        Collections.sort(list, new Comparator<Entry<String, Integer>>(){
//            public int cmp(Entry<String, Integer> o1, Entry<String, Integer> o2){
//                return 0;
//            }
//
//            private Entry<String, Integer> o1;
//            private Entry<String, Integer> o2;
//
//            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
//                this.o1 = o1;
//                this.o2 = o2;
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//        return list;
//    }
//
//    private static LinkedHashMap<String, Integer> getH(LinkedList<Entry<String, Integer>> list){
//        LinkedHashMap<String, Integer> sM;
//        sM = new LinkedHashMap<String, Integer>();
//        int q = 0;
//        int listSize = list.size();
//        while (q < listSize) {
//            Entry<String, Integer> entry = list.get(q);
//            sM.put(entry.getKey(), entry.getValue());
//            q++;
//        }
//        return sM;
//    }
//
//    private static void hashFunction(HashMap<String, String[]> p, HashMap<String, Integer> mainH, ArrayList<String> strings){
//        Iterator<Entry<String, Integer>> iterator = mainH.entrySet().iterator();
//        if (iterator.hasNext()){
//            do{
//                Entry<String, Integer> xyz = iterator.next();
//                if (xyz.getValue() != p.size()){
//                    continue;
//                }
//                String key;
//                key = xyz.getKey();
//                boolean add = strings.add(key);
//            } while (iterator.hasNext());
//        }
//    }

//    private static void secondIteration(HashMap<String, Integer> mainH, HashMap<String, Integer> f, Iterator<Entry<String, String[]>> og){
//        int s;
//        while (og.hasNext()) {
//            Entry<String, String[]> gg;
//            gg = og.next();
//            HashMap<String, Integer> h = new HashMap<>();
//            String[] v;
//            v = gg.getValue();
//            int j;
//            j = 0;
//            while (j < v.length) {
//                String word = v[j];
//                helper(f, h, word);
//                j++;
//            }
//
//            Iterator<Entry<String, Integer>> ggwp;
//            ggwp = h.entrySet().iterator();
//
//            while (ggwp.hasNext()) {
//                Entry<String, Integer> entry = ggwp.next();
//                if (mainH.get(entry.getKey()) == null){
//                    s = 0;
//                }else s = mainH.get(entry.getKey());
//                mainH.put(entry.getKey(),
//                        (int) entry.getValue() + s);
//            }
//        }
//    }
//
//    protected static void firstIteration(String[] posts, HashMap<String, String[]> p){
//        int i = 0;
//        if (i < posts.length){
//            do{
//                String[] words;
//                words = posts[i].split("\\s");
//                if (null != p.get(words[0])){
//                    int v;
//                    v = words.length;
//                    int w;
//                    w = p.get(words[0x0]).length;
//                    String[] cm;
//                    cm = new String[v + w];
//                    System.arraycopy(p.get(words[0]), 0b0, cm, 0x0, w);
//
//                    System.arraycopy(words, 0x0, cm, w, v);
//
//                    String[] put = p.put(words[0x0], cm);
//                }else{
//                    String[] put = p.put(words[0], words);
//                }
//                i++;
//            } while (!(posts.length <= i));
//        }
//    }
//
//    private static void helper(HashMap<String, Integer> f, HashMap<String, Integer> h, String word){
//        if (h.get(word) == null){
//            h.put(word, 1);
//            if (f.get(word) != null) f.put(word, f.get(word) + 1);
//            else if (f.get(word) == null){
//                f.put(word, 1);
//                if (f.get(word) == null){
//                }else f.put(word, f.get(word) + 1);
//            }
//            if (f.get(word) != null){
//            }else f.put(word, 1);
//        }else if (f.get(word) != null){
//        }else f.put(word, 1);
//        if (f.get(word) == null) return;
//        f.put(word, f.get(word) + 1);
//    }
//}


//    public static int nunuKha(String[] posts) {
////          ArrayList<String> x=new ArrayList<String>();
//        //x=
//        HashMap<String, Integer> torMa = new HashMap<String, Integer>();
//
//        ArrayList<ArrayList<String>> inside = new ArrayList<>();
////        int c=Math.max();
//        for (int i = 0; i <inside.size(); i++) {
////            inside.add()
//            posts[i].split("\\s");
//            ArrayList<String> words = new ArrayList<>();
//
//            for (int j = 0; j <= posts.length; j++) {
//                words.add(posts[j]);
//            }
//            inside.add(words);
//
//        }
//        int i = 0;
//        int j = inside.get(0).size();
//        for (int x = 0; x <= inside.size(); x++) {
//            if (inside.get(x).size() < j) {
//                j = inside.get(x).size();
//                i = x;
//            }
//        }
//        int count = 0;
//        for (int y = 0; y < inside.get(i).size(); y++) {
//            String w = inside.get(i).get(y);
//            Boolean t = true;
//
//            for (int z = 0; z < inside.size(); z++) {
//                for (int p = 0; p < inside.get(z).size(); p++) {
//                    if (inside.get(z).get(p) == w) {
//                        count++;
//                    }
//                }
//            }
//
//        }
//
//
////        for(int i=0;i<posts.length;i++){
////            String[] x= posts[i].split("\\s");
////            HashMap<String, Integer> temp= new HashMap<String, Integer>();
////            int key=0;
////            for(int j=0;j<x.length;j++){
////              temp.put(x[j],key);
////              key++;
////            }
////        }
//
//
////          for(int a=0;a<posts.length;a++){
////              if (torMa.containsKey(posts[a])) {
////                  torMa.put(posts[a], torMa.get(posts[a]) + 1);
////              } else {
////                  torMa.put(posts[a], 1);
////              }
////          }
////        Set<Map.Entry<String, Integer> > chush = torMa.entrySet();
////        String key = "";
////        int value = 0;
////
////        for (Map.Entry<String, Integer> me : chush) {
////
////            if (me.getValue() > value) {
////                value = me.getValue();
////                key = me.getKey();
////            }
////        }
////        return key;
////    }
//        return count;
//    }
//    public static void main (String[]args)
//    {
//        String arr[] = {"nunu kha", "nunu 1", "nunu 2", "nunu 3", "dhon"};
////            String sol = nunuKha(arr);
//
//        // Print word having highest frequency
////            System.out.println(sol);
//        System.out.println(nunuKha(arr));
//
//    }
