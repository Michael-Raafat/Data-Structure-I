package eg.edu.alexu.csd.datastructure.iceHockey.cs59;

import java.awt.Point;


import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class MyIceHockey implements IPlayersFinder {
	char[][] a = new char [100][100];
	Point[] it = new Point [100] ;
	int down = 0  , zew = 1 , up=0 , left = 0 , right = 0 ;
	int t = -1 , t2= -1 ;
	int  p = -1 , ioo = 0 , ioo1=0 , foo=0 , joo=0 , joo1=0 , joo2=0 ;
	int f = 0 ;
	public void settingarray(String[] photo ){
		for(int i = 0 ; i < photo.length ; i++ )
		{
			for(int j = 0 ; j < photo[i].length() ; j++ )
			{
				a[i][j]= photo[i].charAt(j);
			}
		}
		
		
	}
    public void arraysort (Point [] real  ){
    	Point temp = new java.awt.Point(1000,1000); 
    	int k = 0 ;
    	if(real.length>= 0 && real[0]!=null)
    	{
    		for(int i =0 ; i<real.length-1 ; i++)
    	{
    		for(int j=i+1 ; j< real.length ;j++)
    		{
    			  
    			if(real[i].x > real[j].x)
    			{
    			
    					temp=real[j];
    					real[j]=real[i];
    					real[i]=temp;
    			}
    			else if (real[i].x == real[j].x)
    			{
    				if ( real[i].y > real[j].y)
    				{
    					temp=real[j];
    					real[j]=real[i];
    					real[i]=temp;
    				}
    				
    			}
    				
    		}
    	}
    	}
    	
    	
    }
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		settingarray(photo);
		for(int i = 0 ; i < photo.length ; i++)
		{
			for(int j =0 ; j< photo[i].length() ; j++)
			{
				foo=i;
				ioo=i;
				ioo1=i;
				if (a[i][j]== String.valueOf(team).toCharArray()[0])
				{
					
					joo= j;
					joo1=j;
					joo2=j;
				Point hhh =	centre(i,j,a,threshold,photo[i].length(),team);
		     	   if (hhh == null);
		    	   else 
		     	   {			
						it[f]=hhh ;
						f++;
		      	   }
				}
			}
		}
		Point [] real = new Point [f] ;
		for(int i = 0 ; i<f ; i++)
		{
					real[i]=it[i] ;
		}
		arraysort(real);
		f=0;
		return real;
	}
	public Point centre(int i ,int j , char[][]s, int threshold , int length ,int  team)
	{
		s[i][j]='-';
		if( i+1<s.length && s[i+1][j]==String.valueOf(team).toCharArray()[0])
		{
			if(i+1<s.length)
			s[i+1][j]='-';
			zew++;
			if(i+1>ioo1)
			{
				down++;
				ioo1=i+1;
			}
			if(i+1<s.length)
			centre(i+1 , j , a , threshold , length , team  );
		}
		if(j+1<length && s[i][j+1]==String.valueOf(team).toCharArray()[0])
		{
			if(j+1<s.length)
			s[i][j+1]='-';
			zew++;
			if(j+1 > joo1)
			{
				right++;
				joo1=j+1 ;
			}
			centre(i , j+1 , a , threshold , length , team );
		}
		if(j-1>=0 && s[i][j-1]==String.valueOf(team).toCharArray()[0])
		{
			if(j-1>=0)
			s[i][j-1]='-';
			zew++;
			if(j-1<joo2)
			{
				left++;
				joo2=j-1;
			}
			if(j-1>=0)
			centre(i , j-1 , a , threshold , length , team );
		}
		if(i-1>=0 && s[i-1][j]==String.valueOf(team).toCharArray()[0])
		{
			if(i>=0)
			s[i-1][j]='-';
			zew++;
			if(i-1<ioo)
			{
				up++;
				ioo=i-1;
			}
			if(i-1>=0)
			centre(i-1 , j , a , threshold , length , team  );
			
		}
		if(foo==i && joo==j)
		{if ((4*zew) >= threshold )
		{
			int y = up + down +1 ;
			int x = left + right + 1;
			if(j>joo2 && joo2!=0)
			{
			 j = joo2 ;	
			}
			if ( i > ioo && ioo!=0)
			{
				i= ioo ;
			}
            up = 0 ;
            down = 0; 
            left = 0 ;
            right = 0 ;
			zew = 1;
			joo1=0;
			joo2=0;
			ioo1=0;
			ioo=0;
			t=-1;
			t2=-1;
			p=-1;
			
			int centrex = x + j*2 ; 
			int centrey = y + i*2 ;
			 Point point = new java.awt.Point(centrex , centrey);
			
			return point ;
		}
		else
		{
			up = 0 ;
            down = 0; 
            left = 0 ;
            right = 0 ;
			zew = 1;
			joo1=0;
			joo2=0;
			ioo1=0;
			ioo=0;
			t2=-1;
			t=-1;
			p=-1;
			Point point = null ; 
		  return point ;
		}
		}
		else 
			return null ;
	}

}
