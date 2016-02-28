package eg.edu.alexu.csd.datastructure.hangman.cs59;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

import java.util.Random;
public class HangMan implements IHangman {

	String[] dictionary = new String [1000];
	int max;
	int j,m;
	char[] a = new char [1000];
	@Override
	public void setDictionary(String[] words) {
		int i ;
		for(i =0 ; i< words.length;i++)
		{
			dictionary[i]=words[i];
		}
		j=i;
	}

	@Override
	public String selectRandomSecretWord() {
		Random word = new Random ();
		int right = word.nextInt(j);
		m=right;
        if (j==0)
		  return null;
        else 
        {
        	setting();
        	return dictionary[right];
        }
	}
	public void setting()
	{
		for(int i = 0 ; i<dictionary[m].length();i++)
		{
			if(dictionary[m].charAt(i)!= ' ')
			a[i]='-';
		}
	}
	
	

	@Override
	public String guess(Character c) {
		int k =0 ;
		for(int i = 0 ; i<dictionary[m].length();i++)
		{
			if(c== dictionary[m].charAt(i))
			{
				a[i]= c ;
				k=1;
			}
		}
		String r ;
		r= String.copyValueOf(a);
		if (c== null)
		{
			return r;
		}
		if(k==1)
		{
			if (dictionary[m]==r)
			{
				return String.format("%s You Won",r );
			}
		    return r;
		}
		else
		{
			max--;
			if (max==0)
			{
				return null ;
			}
			else 
		       return r ;
		}
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if(max== null)
		{
			this.max = 0 ;
		}
		else 
		{
			this.max = max ;
		}
		
	}

}
