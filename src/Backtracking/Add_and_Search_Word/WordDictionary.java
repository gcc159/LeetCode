package Backtracking.Add_and_Search_Word;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
    /** Initialize your data structure here. */
    private TrieTree  trieTree;
    public WordDictionary() {
        trieTree=new TrieTree();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trieTree.insertWord(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trieTree.find(word,trieTree.root);
    }

    class TrieTree{
        final int MAX_SIZE=26;
        TrieTreeNode root;
        public class TrieTreeNode{
            Character ch;
            List<TrieTreeNode> childs;
            boolean isWord;
            public TrieTreeNode(){

                isWord=false;
                childs=new ArrayList<>();
            }
        }

        public TrieTree(){
            root=new TrieTreeNode();
        }
        public void insertWord(String s){
            if(s==null||s.length()==0)
                return;
            TrieTreeNode current=root;
            for(int i=0;i<s.length();i++){
                char currentChar=s.charAt(i);
                TrieTreeNode next=null;
                for(TrieTreeNode child:current.childs){
                    if(child.ch==currentChar) {
                        next = child;
                        break;
                    }

                }
                if(next==null){
                    next=new TrieTreeNode();
                    next.ch=currentChar;
                    current.childs.add(next);
                }

                current=next;
                //if(i==s.length()-1) current.isWord=true;

            }
            current.isWord=true;
        }


        public boolean find(String current,TrieTreeNode currentNode){
            char currentChar=current.charAt(0);
            if(current.length()==1){
                if(currentChar=='.'){
                    for(TrieTreeNode next:currentNode.childs)
                        if(next.isWord) return true;
                    return false;
                }else{
                    for(TrieTreeNode next:currentNode.childs)
                        if(next.ch==currentChar&&next.isWord) return true;
                    return false;
                }
            }else{
                boolean res= false;
                if(currentChar=='.'){
                    for(TrieTreeNode next:currentNode.childs)
                        res=res||find(current.substring(1),next);
                }else{
                    for(TrieTreeNode next:currentNode.childs){
                        if(next.ch==currentChar)
                            res=res||find(current.substring(1),next);
                    }
                }
                return res;
            }
        }
    }
}
