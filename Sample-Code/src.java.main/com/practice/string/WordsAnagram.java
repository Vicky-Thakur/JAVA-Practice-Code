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
		StringBuilder[] wordsCopy = new StringBuilder[words.length];
		for(int i=0;i<words.length;i++){
			wordsCopy[i] = new StringBuilder(words[i]);
			index[i] = i;
		}
		
	}
	
	public static void main(String[] args) {
		String wordArr[] = {"dog","hear","earh","god"};
		
	}

}
