package com.practice.string;

public class StringManipulation {
	
	public String wordReverse(String str){
		if(str==null || str.length()<2)
			return str;
		else{
			StringBuilder sb = new StringBuilder();
			String[] strArr = str.split(" ");
			for(int i =0;i<strArr.length;i++){
				char ch[] = strArr[i].toCharArray();
				int chArrLength = ch.length;
				for(int j =0 ;j<chArrLength/2;j++){
					char temp = ch[j];
					ch[j] = ch[chArrLength-1-j];
					ch[chArrLength-1-j] = temp;
				}
				sb.append(String.valueOf(ch)+" ");
			}
			return sb.toString();
		}
	}
	
	public void strPermutation(String str,int l,int r){
		if(l==r){
			System.out.println(str.toString());
			return;
		}
		for(int i =l;i<r;i++){
			char chStr[] = str.toCharArray();
			char ch = chStr[l];
			chStr[l] = chStr[i];
			chStr[i] = ch;
			str = String.valueOf(chStr);
			//swap(str,l,i);
			strPermutation(str,l+1,r);
			chStr = str.toCharArray();
			ch = chStr[l];
			chStr[l] = chStr[i];
			chStr[i] = ch;
			str = String.valueOf(chStr);
			//swap(str,l,i);
		}
	}
	
	public void dictonarySort(StringBuilder[] wordArr){
		for(int i =0;i<wordArr.length;i++){
			int position = i;
			for(int j = i;j<wordArr.length;j++){
				if(wordArr[j].toString().compareTo(wordArr[position].toString())<0){
					position = j;
				}
			}
			StringBuilder temp = new StringBuilder();
			temp = wordArr[i];
			wordArr[i] = wordArr[position];
			wordArr[position] = temp;
		}
	}
	
	public void stringVsBuilder(){
		StringBuilder str = new StringBuilder();
		str.append("str");
		StringBuilder str1 = str;//here reference will be copied
		StringBuilder str2 = str;//here reference will be copied
		str.append("str");
		System.out.println("1=="+str1 + "  2=="+str2);//Output strstr
		
		String strA = "str";
		String strB = strA;//here new object is created
		String strC = strA;//here new object is created
		strA = strA + "str";
		System.out.println("B=="+strB + "  C=="+strC + " A=="+strA);//Output str
	}
	
	public static void main(String[] args){
		StringManipulation sm = new StringManipulation();
		System.out.print(sm.wordReverse("I ami a boy."));
		sm.strPermutation("ABCD", 0, "ABCD".length());
		StringBuilder[] wordArr = new StringBuilder[7];
		wordArr[0] = new StringBuilder();
		wordArr[0].append("hello");
		wordArr[1] = new StringBuilder();
		wordArr[1].append("geek");
		wordArr[2] = new StringBuilder();
		wordArr[2].append("comp");
		wordArr[3] = new StringBuilder();
		wordArr[3].append("hello");
		wordArr[4] = new StringBuilder();
		wordArr[4].append("abbu");
		wordArr[5] = new StringBuilder();
		wordArr[5].append("abcu");
		wordArr[6] = new StringBuilder();
		wordArr[6].append("geeks");
		sm.dictonarySort(wordArr);
		for(StringBuilder sb:wordArr){
			System.out.print(sb+", ");
		}
	}
}
