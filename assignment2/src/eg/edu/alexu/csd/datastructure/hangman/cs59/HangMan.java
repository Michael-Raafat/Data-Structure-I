
package eg.edu.alexu.csd.datastructure.hangman.cs59;
import java.util.Random;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;


public class HangMan implements IHangman {

	String[] dictionary = new String [1000];
	int maximum;
	int j,m;
	char[] a = new char [1000];

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
		int k =0 ;
		char[] b = dictionary[m].toUpperCase().toCharArray();
		String r = String.copyValueOf(a, 0, dictionary[m].length());
		if (c== null)
		{
			return r;
		}
		//if(dictionary[m].equals(null))
			//return null;
		for(int i = 0 ; i<b.length;i++)
		{
			if(Character.toUpperCase(c)==b[i] )
			{
				
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
			maximum--;
		}
		if (maximum < 0)
		{
			return null ;
		}
		else 
		       return r ;
	
	}

	public void setMaxWrongGuesses(Integer max) {
		if(max== null || max==1)
		{
			maximum = 0  ;
		}
		else 
		{
		   maximum = max - 1 ;
		}
		
	}

}
