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
	
	public static void main(String[] args){
		StringManipulation sm = new StringManipulation();
		System.out.print(sm.wordReverse("I ami a boy."));
	}
}
