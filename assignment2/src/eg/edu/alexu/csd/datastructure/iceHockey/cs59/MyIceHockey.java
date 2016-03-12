package eg.edu.alexu.csd.datastructure.iceHockey.cs59;

import java.awt.Point;


import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class MyIceHockey implements IPlayersFinder {
	String[][] a = new String [100][100];
	Point[] it = new Point [100] ;
	int down = 0  , zew = 1 , up=0 , left = 0 , right = 0 ;
	int t = -1 , t2= -1 ;
	int f = 0 , p = -1 , m = -1  ;
	public void settingarray(String[] photo ){
		for(int i = 0 ; i < photo.length ; i++ )
		{
			for(int j = 0 ; j < photo[i].length() ; j++ )
			{
				a[i][j]=photo[i].substring(j, j);
			}
		}
		
		
	}

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		settingarray(photo);
		for(int i = 0 ; i < photo.length ; i++)
		{
			for(int j =0 ; j< photo[i].length() ; j++)
			{
				if (a[i][j]== String.valueOf(team))
				{
				Point hhh =	centre(i,j,a,threshold,photo[i].length());
					if (hhh == null)
					{}
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
		
		
		return real;
	}
	public Point centre(int i ,int j , String[][]s, int threshold , int length)
	{
		if( i+1<length && s[i+1][j]==s[i][j])
		{
			s[i+1][j]="-";
			zew++;
			if(i+1>p)
			{
				down++;
				p=i+1;
			}
			centre(i+1 , j , s , threshold , length  );
		}
		if(j+1<length && s[i][j+1]==s[i][j])
		{
			s[i][j+1]="-";
			zew++;
			if(j+1 > t2)
			{
				right++;
				t2=j-1 ;
			}
			centre(i , j+1 , s , threshold , length );
		}
		if(j-1>=0 && s[i][j-1]==s[i][j])
		{
			s[i][j-1]="-";
			zew++;
			if(j-1<t)
			{
				left++;
				t=j-1;
			}
			centre(i , j-1 , s , threshold , length );
		}
		if(i-1>=0 && s[i-1][j]==s[i][j])
		{
			s[i-1][j]="-";
			zew++;
			if(i-1>m)
			{
				up++;
				m=i-1;
			}
			centre(i-1 , j , s , threshold , length  );
			
		}
		if (4*zew >= threshold )
		{
			int y = up + down + 1 ;
			int x = left + right + 1;
			
			
			int centrex = x + j*2 ; 
			int centrey = y + i*2 ;
			 Point point = new java.awt.Point(centrex , centrey);
			
			return point ;
		}
		return null;
	}

}
