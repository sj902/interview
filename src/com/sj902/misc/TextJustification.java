package com.sj902.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sol {
    public static void main(String[] args) {
        System.out.println(new TextJustification().fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
    }
}

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int currLen = 0;
        while (i < words.length) {
            currLen = 0;
            int start = i;
            while (i < words.length && currLen < maxWidth) {
                currLen += words[i].length();
                if (currLen > maxWidth)
                    break;
                currLen++;
                ++i;
            }
            int end = i - 1;
            if (end == words.length - 1) {
                String s = createLastStr(words, start, end, maxWidth);
                res.add(s);
            } else {
                String s = createStr(words, start, end, maxWidth);
                res.add(s);
            }
        }
        return res;
    }

    private String createLastStr(String[] words, int start, int end, int maxWidth) {
        int wordSize = getWordSize(words, start, end);
        int size = end - start + 1;
        int spaces = size - 1;
        int extraSpaces = maxWidth - wordSize - spaces;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (end != i) {
                sb.append(" ");
            }
        }
        for (int i = 0; i < extraSpaces; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String createStr(String[] words, int start, int end, int maxW) {
        int size = end - start + 1;
        if (size == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            for (int i = 0; i < maxW - words[start].length(); i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int spaces = size - 1;
        int wordSize = getWordSize(words, start, end);
        int spaceSize = maxW - wordSize;
        int avgSpaceSize = spaceSize / spaces;
        int extra = (spaceSize) - (avgSpaceSize * spaces);
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i == end) {
                sb.append(words[i]);
            } else {
                sb.append(words[i]);
                for (int j = 0; j < avgSpaceSize; j++) {
                    sb.append(" ");
                }
                if (extra > 0) {
                    sb.append(" ");
                    --extra;
                }
            }
        }
        return sb.toString();
    }

    private int getWordSize(String[] words, int start, int end) {
        int s = 0;
        for (int i = start; i <= end; i++) {
            s += words[i].length();
        }
        return s;
    }
}
