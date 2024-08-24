package com.sj902.dp;

public class KeysKeyboard {
    public static void main(String[] args) {
        System.out.println(new Solution1().minSteps(5));
    }
}

 class Solution1 {
    int target;

    public int minSteps(int n) {
        target = n;
        return aux(1, 0);
    }

    private int aux(int screen, int clipboard) {
        if(screen == target) return 0;
        if(screen>target) return target+1;
        boolean canCopy = screen!=clipboard;
        boolean canPaste = clipboard>0;
        int copy = canCopy? 1+(aux(screen, screen)) : target+1;
        int paste = canPaste? 1+(aux(screen+clipboard, clipboard)) : target+1;
        return Math.min(copy, paste);
    }

}
