import java.util.*;

class Fancy {

    static final long MOD = 1000000007;

    ArrayList<Long> list;
    long mul = 1;
    long add = 0;

    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {

        long x = (val - add + MOD) % MOD;
        x = (x * modInverse(mul)) % MOD;

        list.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {

        if(idx >= list.size()) return -1;

        long val = list.get(idx);

        return (int)((val * mul + add) % MOD);
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {

        long res = 1;

        while(b > 0) {

            if((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;

            b >>= 1;
        }

        return res;
    }
}