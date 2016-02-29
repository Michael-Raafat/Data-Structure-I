
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
        
        	setting();
        	return dictionary[right];

	}
	public void setting()
	{
		for(int i = 0 ; i<dictionary[m].length();i++)
		{
			if(dictionary[m].charAt(i)!= ' ')
			a[i]='-';
		}
	}
	
	

	public String guess(Character c) {
		if (j==0)
			  return "";
		int k =0 ;
		char[] b = dictionary[m].toUpperCase().toCharArray();
		String secret = String.valueOf(a);
		secret.toLowerCase();
		String h = dictionary[m];
		char[]p= h.toLowerCase().toCharArray();
		
		if (c== null || c.equals(null))
		{
			return secret;
		}
		for(int i = 0 ; i<b.length;i++)
		{
			if(c== p[i] || c==b[i] )
			{
				
				a[i]= dictionary[m].charAt(i)  ;
				k=1;
			}
		}
		String r ;
		r= String.valueOf(a);
		if(k==1)
		{
		    return r;
		}
		else
		{
			maximum--;
			if (maximum<0)
			{
				return null ;
			}
			else 
		       return r ;
		}
	}

	public void setMaxWrongGuesses(Integer max) {
		if(max== null)
		{
			maximum = 0 ;
		}
		else 
		{
		   maximum = max ;
		}
		
	}

}
