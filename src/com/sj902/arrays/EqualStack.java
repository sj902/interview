package com.sj902.arrays;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EqualStack {
    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int[] h1Suffix = new int[(h1.size())];
        int[] h2Suffix = new int[(h2.size())];
        int[] h3Suffix = new int[(h3.size())];

        h1Suffix[h1.size() - 1] = h1.get(h1.size() - 1);

        for (int i = h1.size() - 2; i >= 0; i--) {
            h1Suffix[i] = h1Suffix[i + 1] + h1.get(i);
        }

        h2Suffix[h2.size() - 1] = h2.get(h2.size() - 1);
        for (int i = h2.size() - 2; i >= 0; i--) {
            h2Suffix[i] = h2Suffix[i + 1] + h2.get(i);
        }
        h3Suffix[h3.size() - 1] = h3.get(h3.size() - 1);
        for (int i = h3.size() - 2; i >= 0; i--) {
            h3Suffix[i] = h3Suffix[i + 1] + h3.get(i);
        }

        int h1I = 0;
        int h2I = 0;
        int h3I = 0;

        while (h1I < h1.size() && h2I < h2.size() && h3I < h3.size() && h1Suffix[h1I] != h2Suffix[h2I] && h1Suffix[h3I] != h2Suffix[h2I]) {
            int h1s = h1Suffix[h1I];
            int h2s = h2Suffix[h2I];
            int h3s = h3Suffix[h3I];
            if (h1s > h2s && h1s > h3s) {
                h1I++;
            } else if (h2s > h1s && h2s > h3s) {
                h2I++;
            } else {
                h3I++;
            }
        }
        if (h1I == h1.size() || h2I == h3.size() || h3I == h2.size()) {
            return 0;
        }
        return h1Suffix[h1I];
    }

}

