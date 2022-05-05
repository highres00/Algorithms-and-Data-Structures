

public class A2_Q2 {

//    public static int weight(int[] plates) {
//        int N;
//        N = plates.length;
//        boolean[] a;
//        a = new boolean[2000];
//
//        pLoop(plates, N, a);
//        int l;
//        l = 2001;
//        {
//            int i=1000;
//            l = loop2(a, l, i);
//        }
//        int s;
//        s = -1;
//        int i;
//        i = 1000;
//        s = loop3(a, s, i);
//
//        //            System.out.println(nextLargest);
//        if(l-1000>=1000-s) return l;
//        else return s;
//
//    }
//
//    private static void pLoop(int[] plates, int N, boolean[] a){
//        int i;
//        i = 0;
//        while (true) {
//            if (i >= N) break;
//            int x= plates[i];
//            int j= a.length-1;
//            loop1(a, x, j);
//            a[x]=true;
//
//            i++;
//        }
//    }
//
//    private static int loop3(boolean[] a, int s, int i){
//        while (i >=0) {
//            if (a[i] != true){
//                i--;
//            }else{
//                s = i;
//                break;
//            }
//        }
//        return s;
//    }
//
//    private static int loop2(boolean[] a, int l, int i){
//        while (i < a.length) {
//            if (a[i] != true){
//                i++;
//            }else{
//                l = i;
//                break;
//            }
//        }
//        return l;
//    }
//
//    private static void loop1(boolean[] a, int x, int j){
//        while (j >=0) {
//            if (a[j] != true || j + x >= a.length){
//            }else{
//                a[j + x]=true;
//            }
//            j--;
//        }
//    }

    public static int weight(int[] plates) {
        int N=plates.length;
        boolean[] w= new boolean[1200];

        for (int i=0;i<N;i++){
            int x=plates[i];
            for (int j=w.length-1;j>=0;j--){
                if(w[j]==true && j+x< w.length){
                    w[j+x]=true;
                }

            }
            w[x]=true;

        }
        int nextLargest =0;
        for(int i=1000;i<w.length;i++){
            if(w[i]==true){
                nextLargest=i;
                break;
            }
        }
        int nextSmallest=-1;
        for(int i=1000; i>0;i--){
            if (w[i]==true){
                nextSmallest=i;
                break;
            }
        }

        if(nextLargest-1000>=1000-nextSmallest){
//            System.out.println(nextLargest);
            return nextLargest;
        } else return nextSmallest;
//            System.out.println(nextSmallest);
//        }
//
//        return 0;
    }
    public static void main(String[] args){



        int[] w={900,500,498,4};//should return 1001,returns 998
        System.out.println(weight(w));
    }

}
