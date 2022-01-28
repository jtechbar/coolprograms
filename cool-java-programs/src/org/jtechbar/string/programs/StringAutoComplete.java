package org.jtechbar.string.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 *	Program to implement String Auto-complete given a list of Strings as a library.  
 *
 *	e.g. library of strings -> {"a","an","and","andy","be"}
 *	user input is "an", then the program should suggest {"an","and","andy"} as possible matches.
 * 
 ***/
public class StringAutoComplete {
	
	class StringTrieNode{
		char data;
		boolean isword;
		Map<Character, StringTrieNode> childNodes;
		
		public StringTrieNode() {
			this.childNodes=new HashMap<>();
		}
		
		public StringTrieNode(char c) {
			this.data = c;
			this.childNodes=new HashMap<>();
		}
		
		public void insert(String word) {
			if(word == null || word.isEmpty())
				return;
			char c = word.charAt(0);
			StringTrieNode child = childNodes.get(c);
			if(child == null) {
				child = new StringTrieNode(c);
				childNodes.put(c, child);
			}
			
			if(word.length()>1) {
				child.insert(word.substring(1));
			}else {
				child.isword=true;
			}
			
			
		}
		
		
		
		
	}
	
	
	public void autocompleteHelper(StringTrieNode lastNode, List<String> wordsList, StringBuffer sb) {
		if(lastNode.isword) {
			wordsList.add(sb.toString());
		}
		
		if(lastNode.childNodes == null || lastNode.childNodes.isEmpty()) {
			return;
		}
		
		for(StringTrieNode child:lastNode.childNodes.values()) {
			autocompleteHelper(child, wordsList, sb.append(child.data));
			sb.setLength(sb.length()-1);
		}
		
	}
	
	public List<String> suggestStrings(String word){
		List<String> wordsList = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		StringTrieNode tempNode = root ;
		for(char c:word.toCharArray()) {
			tempNode = tempNode.childNodes.get(c);
			if(tempNode == null)
				return wordsList;
			
			sb.append(c);
		}
		autocompleteHelper(tempNode, wordsList, sb);
		
		
		return wordsList;
	}
	
	
	StringTrieNode root;
	
	public StringAutoComplete(String[] wordsArray) {
		root = new StringTrieNode();
		for(String word:wordsArray) {
			root.insert(word);
		}
	}

	public static void main(String[] args) {
		String[] wordsArray= {"a","an","and","andy","be"};
		List<String> words=Arrays.asList(wordsArray);
		//an --> an,and,andy
		StringAutoComplete autoComplete = new StringAutoComplete(wordsArray);
		System.out.println(autoComplete.suggestStrings("an"));
	}

}
