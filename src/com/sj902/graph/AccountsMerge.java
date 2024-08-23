package com.sj902.graph;

import java.util.*;

class UF1 {
    int n;
    int[] parent;
    int[] size;

    public UF1(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
        int pI = find(i);
        int pJ = find(j);
        if (pJ == pI) return;
        if (size[pI] > size[pJ]) {
            size[pI] += size[pJ];
            parent[pJ] = pI;
        } else {
            size[pJ] += size[pI];
            parent[pI] = pJ;
        }
    }
}


public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF1 uf = new UF1(accounts.size());
        HashMap<String, Integer> parents = new HashMap<>();


        for (int j = 0; j < accounts.size(); j++) {
            List<String> l = accounts.get(j);
            for (int i = 1; i < l.size(); i++) {
                if (parents.containsKey(l.get(i))) {
                    uf.union(parents.get(l.get(i)), j);
                } else {
                    parents.put(l.get(i), j);
                }
            }
        }

        HashMap<Integer, HashSet<String>> invParents = new HashMap<>();

        for (String mail : parents.keySet()) {
            int p = uf.find(parents.get(mail));
            HashSet<String> mailSet = invParents.getOrDefault(p, new HashSet<>());
            mailSet.add(mail);
            invParents.put(p, mailSet);
        }

        List<List<String>> res = new ArrayList<>();
        for (int parent : invParents.keySet()) {
            ArrayList<String> l = new ArrayList<>();
            l.add(accounts.get(parent).get(0));
            ArrayList<String> l2 = new ArrayList<>(invParents.get(parent));
            Collections.sort(l2);
            l.addAll(l2);
            res.add(l);
        }
        return res;
    }
}
