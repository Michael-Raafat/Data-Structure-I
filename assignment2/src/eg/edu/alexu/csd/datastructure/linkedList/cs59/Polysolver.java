package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

import java.util.ArrayList;
public class Polysolver implements IPolynomialSolver {

	singleList A= new singleList();
	singleList B= new singleList();
	singleList C = new singleList();
	int a =0 , b=0 , c= 0;
	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub
		switch(poly)
		{
			case 'A':
			{
				a=1;
				boolean error=false;
				for(int i=0;i<terms.length &&!error;i++)
				{
					if(terms[i][1]<0)
						error=true;
					if( i !=terms.length-1 && terms[i][1]<terms[i+1][1])
						error=true;
					A.add(terms[i][0]);
					A.add(terms[i][1]);
				}
				if(error)
				{
					A.clear();
					throw new RuntimeException();
				}
				break;
			}
			case 'B':
			{
				b=1;
				boolean error=false;
				for(int i=0;i<terms.length &&!error;i++)
				{
					if(terms[i][1]<0)
						error=true;
					if( i !=terms.length-1&&terms[i][1]<terms[i+1][1] )
						error=true;
					B.add(terms[i][0]);
					B.add(terms[i][1]);
				}
				if(error)
				{
					B.clear();
					throw new RuntimeException();
				}
				break;
			}
			case 'C':
			{
				c=1;
				boolean error=false;
				for(int i=0;i<terms.length &&!error;i++)
				{
					if(terms[i][1]<0)
						error=true;
					if( i !=terms.length-1 && terms[i][1]<terms[i+1][1])
						error=true;
					C.add(terms[i][0]);
					C.add(terms[i][1]);
				}
				if(error)
				{
					C.clear();
					throw new RuntimeException();
				}
				break;
			}
			default:
			{
				throw new RuntimeException();
			}
		}
	}
	
	public String PrintL(singleList A)
	{
		if(this.A==A && a==0)
		{
		return null	;
		}
		else if(this.B==A && b==0)
		{
		return null	;
		}
		else if(this.C==A && c==0)
		{
		return null	;
		}
		else{
		String equation="";
		for(int i=0;i<A.size()-2;i+=2)
		{
			equation+=String.valueOf(A.get(i))+"x^" +String.valueOf(A.get(i+1))+"+";
		}
		if(A.isEmpty())
		{
			return equation;
		}
		else
		{
			if(A.get(A.size()-1).equals(0))
			{
				equation+=String.valueOf(A.get(A.size()-2));
			}
			else
			{
				equation+=String.valueOf(A.get(A.size()-2))+"x^" +String.valueOf(A.get(A.size()-1));
			}
			return equation;
		}
		}
	}
	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub
		switch(poly)
		{
			case 'A':
			{
				return PrintL(A);
			}
			case 'B':
			{
				return PrintL(B);
			}
			case 'C':
			{
				return PrintL(C);
			}
			default:
			{
				throw new RuntimeException();
			}
		}
	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		switch(poly)
		{
			case 'A':
			{
				A.clear();
				a=0;
			}
			case 'B':
			{
				B.clear();
				b=0;
			}
			case 'C':
			{
				C.clear();
				c=0;
			}
			default:
			{
				throw new RuntimeException("ERROR");
			}
		}
	}
    public float power (float x , int p)
    {
    	float r=1;
    	for(int i = 0 ; i<p ; i++)
    	{
    		r*=x;
    	}
    	return r ;
    }
    public float eva(singleList A , float gogo)
    {
    	int equation = 0 ;
		for(int i=0;i<A.size();i+=2)
		{
			equation+=Integer.valueOf(String.valueOf(A.get(i)))*power(gogo,Integer.valueOf(String.valueOf(A.get(i+1))));
		}
		if(A.isEmpty())
		{
			return 0;
		}
		else
		{
			return equation;
		}
    }
	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub
		     
		     if(poly == 'A')
		     {
		    	 if(a==0)
		    	 {
		    		 throw new RuntimeException("ERROR");
		    	 }
		    	 return eva(A,value);
		     }
		     else if(poly == 'B')
		     {
		    	 if(b==0)
		    	 {
		    		 throw new RuntimeException("ERROR");
		    	 }
		    	 return eva(B,value);
		     }
		     else
		     {
		    	 if(c==0)
		    	 {
		    		 throw new RuntimeException("ERROR");
		    	 }
		    	 return eva(C,value);
		     }
			}
	public singleList addto(singleList x, singleList y)
	{
		
		ArrayList <Integer>A = new ArrayList() ;
		
			int j =0 , i = 0 ;
            while(i<x.size() && j<y.size())
            {
            	int first = Integer.valueOf(String.valueOf(x.get(i+1)));
            	int firstc = Integer.valueOf(String.valueOf(x.get(i)));
            	int second= Integer.valueOf(String.valueOf(y.get(j+1)));
            	int secondc= Integer.valueOf(String.valueOf(y.get(j)));
            	if (first>second)
            	{
            		A.add(firstc);
            		A.add(first);
            		
            		i+=2;
            	}
            	else if (second>first)
            	{
            		A.add(secondc);
            		A.add(second);
            		j+=2;
            	}
            	else
            	{
            		if(secondc+firstc==0)
            		{
            			i+=2;
            			j+=2;
            		}
            		else
            		{A.add(secondc+firstc);
            		A.add(first);
            		i+=2;
            		j+=2;}
            	}
            	
            }
            if(j==y.size())
            {
            	for(int k = i ; k < x.size() ; k+=2 )
            	{
            		int first = Integer.valueOf(String.valueOf(x.get(k+1)));
                	int firstc = Integer.valueOf(String.valueOf(x.get(k)));
            		A.add(firstc);
            		A.add(first);
            		
            	}
            }
            if(i==x.size())
            {
            	for(int k = j ; k < y.size() ; k+=2 )
            	{
            		int second= Integer.valueOf(String.valueOf(y.get(k+1)));
                	int secondc= Integer.valueOf(String.valueOf(y.get(k)));
            		A.add(secondc);
            		A.add(second);
            	}
            }
            int [][]a=new int [A.size()/2][2];
            int l=0;
            for(int p = 0 ; p < A.size()/2 ; p++ )
            {
            	a[p][0]=A.get(l);
            	a[p][1]=A.get(l+1);
            	l+=2;
            }
            singleList print = new singleList(); 
            for(int u=0;u<a.length ;u++)
			{
		
				print.add(a[u][0]);
				print.add(a[u][1]);
			}
            return print ;
           
		}
		
		

	
	public int[][] addlist(singleList x, singleList y)
	{
		ArrayList <Integer>A = new ArrayList() ;
		
			int j =0 , i = 0 ;
            while(i<x.size() && j<y.size())
            {
            	int first = Integer.valueOf(String.valueOf(x.get(i+1)));
            	int firstc = Integer.valueOf(String.valueOf(x.get(i)));
            	int second= Integer.valueOf(String.valueOf(y.get(j+1)));
            	int secondc= Integer.valueOf(String.valueOf(y.get(j)));
            	if (first>second)
            	{
            		A.add(firstc);
            		A.add(first);
            		
            		i+=2;
            	}
            	else if (second>first)
            	{
            		A.add(secondc);
            		A.add(second);
            		j+=2;
            	}
            	else
            	{
            		if(secondc+firstc==0)
            		{
            			i+=2;
            			j+=2;
            		}
            		else
            		{	
            		A.add(secondc+firstc);
            		A.add(first);
            		i+=2;
            		j+=2;
            		}
            	}
            	
            }
            if(j==y.size())
            {
            	for(int k = i ; k < x.size() ; k+=2 )
            	{
            		int first = Integer.valueOf(String.valueOf(x.get(k+1)));
                	int firstc = Integer.valueOf(String.valueOf(x.get(k)));
            		A.add(firstc);
            		A.add(first);
            		
            	}
            }
            if(i==x.size())
            {
            	for(int k = j ; k < y.size() ; k+=2 )
            	{
            		int second= Integer.valueOf(String.valueOf(y.get(k+1)));
                	int secondc= Integer.valueOf(String.valueOf(y.get(k)));
            		A.add(secondc);
            		A.add(second);
            	}
            }
            int [][]a=new int [A.size()/2][2];
            int l=0;
            for(int p = 0 ; p < A.size()/2 ; p++ )
            {
            	a[p][0]=A.get(l);
            	a[p][1]=A.get(l+1);
            	l+=2;
            }
            return a;

		
		
	}
    
	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
	    
		if(poly1=='A' || poly2=='A' )
	    {
	    	if(poly1=='B' || poly2=='B')
	    	{
	    		if(a!=0 && b!=0)
	    		return addlist(A , B) ;
	    		else
	    			throw new RuntimeException();
	    	}
	    	else
	    	{
	    		if(a!=0 && c!=0)
		    		return addlist(A , C) ;
		    		else
		    			throw new RuntimeException();
	    	}
	    }
		else
		{
			if(c!=0 && b!=0)
	    		return addlist(B , C) ;
	    		else
	    			throw new RuntimeException();
		}
		
		
	}
     
	public int[][] subtlist(singleList x, singleList y)
	{
		ArrayList <Integer>A = new ArrayList() ;
		
			int j =0 , i = 0 ;
            while(i<x.size() && j<y.size())
            {
            	int first = Integer.valueOf(String.valueOf(x.get(i+1)));
            	int firstc = Integer.valueOf(String.valueOf(x.get(i)));
            	int second= Integer.valueOf(String.valueOf(y.get(j+1)));
            	int secondc= Integer.valueOf(String.valueOf(y.get(j)));
            	if (first>second)
            	{
            		A.add(firstc);
            		A.add(first);
            		
            		i+=2;
            	}
            	else if (second>first)
            	{
            		A.add(-secondc);
            		A.add(second);
            		j+=2;
            	}
            	else
            	{
            		if(firstc-secondc==0)
            			{i+=2;j+=2;}
            		else{
            		A.add(-secondc+firstc);
            		A.add(first);
            		i+=2;
            		j+=2;}
            	}
            	
            }
            if(j==y.size())
            {
            	for(int k = i ; k < x.size() ; k+=2 )
            	{
            		int first = Integer.valueOf(String.valueOf(x.get(k+1)));
                	int firstc = Integer.valueOf(String.valueOf(x.get(k)));
            		A.add(firstc);
            		A.add(first);
            		
            	}
            }
            if(i==x.size())
            {
            	for(int k = j ; k < y.size() ; k+=2 )
            	{
            		int second= Integer.valueOf(String.valueOf(y.get(k+1)));
                	int secondc= Integer.valueOf(String.valueOf(y.get(k)));
            		A.add(-secondc);
            		A.add(second);
            	}
            }
            int [][]a=new int [A.size()/2][2];
            int l=0;
            for(int p = 0 ; p < A.size()/2 ; p++ )
            {
            		a[p][0]=A.get(l);
            		a[p][1]=A.get(l+1);
            		
            	l+=2;
            }
            
            return a;

		
		
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		if(poly1=='A')
		{
			if(poly2=='B')
			{
				if(a!=0 && b!=0)
		    		return subtlist(A , B) ;
		    		else
		    			throw new RuntimeException();
			}
			else
			{
				if(a!=0 && c!=0)
		    		return subtlist(A , C) ;
		    		else
		    			throw new RuntimeException();
			}
		}
		else if(poly1=='B')
		{
			if(poly2=='A')
			{
				if(a!=0 && b!=0)
		    		return subtlist(B , A) ;
		    		else
		    			throw new RuntimeException();
			}
			else
			{
				if(b!=0 && c!=0)
		    		return subtlist(B , C) ;
		    		else
		    			throw new RuntimeException();
			}
		}
		else
		{
			if(poly2=='A')
			{
				if(a!=0 && c!=0)
		    		return subtlist(C , A) ;
		    		else
		    			throw new RuntimeException();
			}
			else
			{
				if(b!=0 && c!=0)
		    		return subtlist(C , B) ;
		    		else
		    			throw new RuntimeException();
			}
		}
	}
	public int[][] multiL(singleList X , singleList Y){
		singleList M=new singleList();
		singleList N=new singleList();
		for(int i=0;i<X.size();i+=2)
		{
			M.clear();
			for(int j=0;j<Y.size();j+=2)
			{
				int f=Integer.valueOf(String.valueOf(X.get(i+1)));
				int l=Integer.valueOf(String.valueOf(Y.get(j+1)));
				int fc=Integer.valueOf(String.valueOf(X.get(i)));
				int lc=Integer.valueOf(String.valueOf(Y.get(j)));
				int z=fc*lc;
				int c=f+l;
				M.add(z);
				M.add(c);
				
			}
			N=addto(N, M);
		}
		int [][]a=new int [N.size()/2][2];
        int l=0;
        for(int p = 0 ; p <N.size()/2 ; p++ )
        {
        	a[p][0]=Integer.valueOf(String.valueOf(N.get(l)));
        	a[p][1]=Integer.valueOf(String.valueOf(N.get(l+1)));
        	l+=2;
        }
        return a;
		
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		if(poly1=='A' || poly2=='A' )
	    {
	    	if(poly1=='B' || poly2=='B')
	    	{
	    		return multiL(A , B) ;
	    	}
	    	else
	    	{
	    		return multiL(A , C);
	    	}
	    }
		else
		{
			return multiL(B,C);
		}
	}

	
}
