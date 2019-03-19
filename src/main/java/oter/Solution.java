package oter;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[ ]args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("an");
        System.out.println(dictionary.search("ata"));
    }
}

class WordDictionary {

    private Dictionary root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Dictionary();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chs = word.toCharArray();
        Dictionary rootTemp = root;
        for(int i = 0; i < chs.length; i++) {
            if(rootTemp.dict[chs[i] - 'a'] == null) {
                Dictionary newDict = new Dictionary();
                rootTemp.dict[chs[i] - 'a'] = newDict;
                rootTemp = newDict;
            } else {
                rootTemp = rootTemp.dict[chs[i] - 'a'];
            }
        }
        rootTemp.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        return doSearch(chs, root);
    }

    private boolean doSearch(char[] chs, Dictionary root) {
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == '.') {
                for(int j = 0; j < root.dict.length; j++) {
                    if(root.dict[j] != null) {
                        boolean isExists = doSearch(Arrays.copyOfRange(chs, i + 1, chs.length), root.dict[j]);
                        if(isExists) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if(root.dict[chs[i] - 'a'] == null) {
                    return false;
                } else {
                    root = root.dict[chs[i] - 'a'];
                }
            }
        }
        return root.isWord;
    }

    class Dictionary {
        public Dictionary[] dict = new Dictionary[26];
        public boolean isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */