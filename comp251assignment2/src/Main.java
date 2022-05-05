import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int N=in.nextInt();
        int[] nums= new int[N];
        for (int i =0;i<N;i++){
            nums[i]=in.nextInt();
        }

        boolean[] w= new boolean[2000];
        for (int i=0;i<N;i++){
            int x=nums[i];
            for (int j=w.length-1;j>=0;j--){
                if(w[j]==true && j+x< w.length){
                    w[j+x]=true;
                }
            }
            w[x]=true;
        }
        int nextLargest =2001;
        for(int i=1000;i<w.length;i++){
            if(w[i]==true){
                nextLargest=i;
                break;
            }
        }
        int nextSmallest=-1;
        for(int i=1000; i>=0;i--){
            if (w[i]==true){
                nextSmallest=i;
                break;
            }
        }

        if(nextLargest-1000>=1000-nextSmallest){
//            System.out.println(nextLargest);
//            return nextLargest;
        } else{
//        return nextSmallest;
            System.out.println(nextSmallest);}
//        }
//
//        return 0;
        }
    }

