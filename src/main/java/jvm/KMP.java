package jvm;

public class KMP {
    public static void main(String[] args) {
        String s = "ABCABB";
        int[] nexts = getNext(s);
        for(int i = 0; i < nexts.length; i++) {
            System.out.print(nexts[i]);
        }
    }

    public static int match(String t, String p) {
        int[] nexts = getNext(p);
        char[] tChs = t.toCharArray();
        char[] pChs = p.toCharArray();
        int k = 0;
        int i = 0;
        for(; i < tChs.length && k < pChs.length; ) {
            if(tChs[i] == pChs[k]) {
                ++k;
                ++i;
            } else {
                k = nexts[k];
            }
        }
        if(k == p.length()) {
            return i - k;
        }
        return -1;
    }

    public static int[] getNext(String pattern) {
        int len = pattern.length();
        int[] nexts = new int[len];
        char[] p = pattern.toCharArray();

        nexts[0] = -1;
        int k = -1;
        for(int i = 0; i < len - 1;) {
            if(k == -1 || p[i] == p[k]) {
                nexts[++i] = ++k;
            } else {
                k = nexts[k];
            }
        }

        return nexts;
    }
}
