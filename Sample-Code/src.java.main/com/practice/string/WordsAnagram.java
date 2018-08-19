/* given an array of words u have to tell all the anagrams of the word...
   example-- A[] = {"dog","hear","earh","god"};
        
   output--- dog-god
             hear-earh
             
   Approach 1:&Make Integer Array of 26
   			  &find all anagram for every word
  				set 1 in array for letters in word
  				check this array for every remaining word (if same then anagram otherwise not anagram)
  				set 0 in Integer Array
  			  &Repeat same for every word
  			  #complexity : O(n2)
  			  #space : none
  			  #Difficulty : not able to print all anagrams of words uniquely
  	Approach 2:&Make 2 array wordcopy[], index[]
  			   &copy original array to wordcopy
  			   &1 Sort chars of each word
  			   &2 Sort final wordcopy[]
			   #complexity : O(n2) + O(n*wordlength)
  			   #space : 2 * O(n)   //n is number of words
             */

package com.practice.string;

public class WordsAnagram {
	
	//Approach 2
	public void wordAnagram(String words[]){
		int[] index = new int[words.length];
		String[] wordsCopy = new String[words.length];
		for(int i=0;i<words.length;i++){
			wordsCopy[i] = wordSort(words[i]);
			index[i] = i;
		}
		
		for(int i=0;i<wordsCopy.length;i++){
			int position = i;
			for(int j=i;j<wordsCopy.length;j++){
				if(wordsCopy[j].compareTo(wordsCopy[i])<0)
					position = j;
			}
			String temp = wordsCopy[position];
			wordsCopy[position] = wordsCopy[i];
			wordsCopy[i] = temp; 
			int tempInt = index[position];
			index[position] = index[i];
			index[i] = tempInt;
		}
		
		for(int k=0;k<words.length;k++){
			System.out.print(words[index[k]]+", ");
		}
	}
	
	//assuming word contain only small letters
	public String wordSort(String word){
		int alphaAscii[] = new int[26];
		for(int i = 0;i<word.length();i++){
			alphaAscii[word.charAt(i)-97] = alphaAscii[word.charAt(i)-97] + 1; 
		}
		StringBuilder sortedWord = new StringBuilder();
		for(int i =0;i<26;i++){
			if(alphaAscii[i]>0){
				for(int j = 1;j<=alphaAscii[i];j++)
					sortedWord.append((char)(97+i));
			}
		}
		return sortedWord.toString();
	}
	
	public static void main(String[] args) {
		String wordArr[] = {"dog","hear","earh","god"};
		WordsAnagram obj = new WordsAnagram();
		obj.wordAnagram(wordArr);
	}

}
