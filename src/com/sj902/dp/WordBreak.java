package com.sj902.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    boolean[][] res;
    boolean[][] visited;

    public boolean wordBreak(String s, List<String> wordDict) {
        visited = new boolean[s.length()+1][s.length()+1];
        res = new boolean[s.length()+1][s.length()+1];
        return aux(s, new HashSet<>(wordDict),0, s.length()-1);
    }
    public boolean aux(String s, Set<String> wordDict, int start, int end) {
        if(s.length()==0) return true;
        if(visited[start][end]) return res[start][end];


        if(wordDict.contains(s.substring(start, end+1))) {
            visited[start][end] = true;
            return res[start][end] = true;
        }

        for (int i = start; i < end; i++) {
            boolean a = aux(s,wordDict,start, i);
            boolean b = aux(s,wordDict,i+1,end);
            if( a && b){
                visited[start][end] = true;
                return res[start][end] =true;
            }
        }
        visited[start][end] = true;
        return res[start][end] =false;
    }
}
