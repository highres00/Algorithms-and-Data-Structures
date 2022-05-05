import java.math.BigInteger;
import java.util.HashMap;


public class A2_Q4{


    public static String mod_fibonacci(int N, BigInteger K){
        while (true) {
            String x = "X";
            String y = "Y";

            if (N == 1) return x;
            if (N == 2) return y;

            if (N > 2 || N < 1){
                int result;
                result = K.compareTo(fib(N - 2));
                if (!(-1 != result)){
                    N -= 2;
                    continue;
                }
                if (!(0 != result)){
                    N -= 2;
                    continue;
                }
                K = subtract(N, K);
            }else{
                K = subtract(N, K);
            }
            N--;

        }
    }

    private static BigInteger subtract(int N, BigInteger K){
        K = K.subtract(fib(N - 2));
        return K;
    }

    private static HashMap<Integer, BigInteger> hm = new HashMap<>();

    private static BigInteger fib(int n){
        if (n == 1 || n == 2) return BigInteger.ONE;

        if (!hm.containsKey(n)){
            return add(n);
        }
        return hm.get(n);

    }

    private static BigInteger add(int n){
        BigInteger a;
        a = fib(n - 2).add(fib(n - 1));
        hm.put(n, a);
        return a;
    }

    public static void main(String[] args){
        System.out.println(mod_fibonacci(4,BigInteger.valueOf(2)));
    }
}