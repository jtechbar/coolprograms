package org.jtechbar.string.programs;

public class StringPermutation {

	public static void main(String[] args) {
		String str="ABC";
		StringPermutation permutation=new StringPermutation();
		permutation.permute(str,0,str.length()-1);

	}
	
	public void permute(String str, int l, int h) {
		if(l==h)
			System.out.println(str);
		
		for(int i=l;i<=h;i++) {
			str=swap(str, l, i);
			permute(str,l+1,h);
			str=swap(str,l,i);
		}
	}
	
	public String swap(String str, int i,int j) {
		
		char temp;
		char[] charArray=str.toCharArray();
		temp=charArray[i];
		charArray[i]=charArray[j];
		charArray[j]=temp;
		
		return String.valueOf(charArray);
	}

}
