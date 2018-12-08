package Design.Implement_Trie;

public class Trie {
    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current=root;
        for(int i=0;i<word.length();i++){
            char currentChar=word.charAt(i);
            if(current.childs[currentChar-'a']==null){
                current.childs[currentChar-'a']=new Node();
                current.childs[currentChar-'a'].word
                        =currentChar;

            }
            current=current.childs[currentChar-'a'];

        }
        current.isWord=true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current=root;
        boolean res=true;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(current.childs[index]==null) return false;
            current=current.childs[index];
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current=root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(current.childs[index]==null) return false;
            current=current.childs[index];
        }
        if(current.isWord) return true;
        else{
            for(int i=0;i<26;i++)
                if(current.childs[i]!=null) return true;
        }
        return false;
    }

    private Node root;

    class Node{
        boolean isWord=false;
        Node[] childs;
        Character word;

        private Node() {
            childs=new Node[26];
        }

    }




}
