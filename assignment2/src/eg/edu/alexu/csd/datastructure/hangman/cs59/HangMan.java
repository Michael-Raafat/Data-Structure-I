
package eg.edu.alexu.csd.datastructure.hangman.cs59;
import java.util.Random;
import java.io.*;
import java.lang.*;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;


public class HangMan implements IHangman {

	String[] dictionary = new String [1000];
	int maximum;
	int j,m;
	char[] a = new char [1000];
	char[] n = new char [1000];
	static StringBuilder f = new StringBuilder("") ;
	static StringBuilder p = new StringBuilder("") ;
	public void setDictionary(String[] words) {
		int i ;
		j=words.length;
		for(i =0 ; i< words.length;i++)
		{	
			dictionary[i]=words[i];
		}
	}

	
	public String selectRandomSecretWord() {
		Random word = new Random ();
		if (j==0)
			  return null;
		int right = word.nextInt(j);
		 m=right;
		 for(int i =0 ;i<dictionary[right].length();i++)
		 {
			 if(dictionary[right].charAt(i)!=' ')
			 a[i]= '-';
		 } 
        	return dictionary[right];

	}
	public String guess(Character c) {
		if (j==0)
		{	 
			return "";
		}
		int k =0 , l=0 , e=0 ,w=0;
		char[] b = dictionary[m].toUpperCase().toCharArray();
		String r = String.copyValueOf(a, 0, dictionary[m].length());
		String n = f.toString().toUpperCase() ;
		String t = p.toString().toUpperCase();
		if (c== null)
		{
			return r;
		}
		for(int i = 0 ; i<b.length;i++)
		{
			if(Character.toUpperCase(c)==b[i] )
			{
				if(e==0)
				{
				   p=p.append(c);
				   e=1;
				}				
				a[i]=dictionary[m].charAt(i);
				k=1;
			}
		}
		r=String.copyValueOf(a, 0, dictionary[m].length());
		if(k==1)
		{
		    return r;
		}
		else
		{
			if(k==0)
			{
				t = p.toString().toUpperCase();
				for(int i=0;i<dictionary[m].length();i++)
				{
					for(int j = 0 ;j<t.length();j++ )
					{
						if(b[i]==t.charAt(j))
						{
							a[i]= dictionary[m].charAt(i);
						}
					}
				}
				r=String.copyValueOf(a, 0, dictionary[m].length());
				for(int j=0;j<n.length();j++)
				{	
					if(n.charAt(j)== Character.toUpperCase(c))
					{
						l=1;
					}
				}
				if(l==0)
					{
					   f=f.append(c);
					   maximum--;
					}
			}
		}
		if (maximum < 0)
		{
			return null ;
		}
		else 
		       return r ;
	
	}

	public void setMaxWrongGuesses(Integer max) {
		if(max== null)
		{
			maximum = 0  ;
		}
		else 
		{
		   maximum = max - 1  ;
		}
		
	}

}
