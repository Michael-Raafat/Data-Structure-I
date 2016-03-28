package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

import java.util.ArrayList;
public class Polysolver implements IPolynomialSolver {

	singleList A= new singleList();
	singleList B= new singleList();
	singleList C = new singleList();
	singleList R = new singleList();
	int a =0 , b=0 , c= 0;
	public void setR(singleList R,int[][]terms)
	{
		R.clear();
		boolean error=false;
		for(int i=0;i<terms.length &&!error;i++)
		{
			if(terms[i][1]<0)
				error=true;
			if( i !=terms.length-1 && terms[i][1]<terms[i+1][1])
				error=true;
			R.add(terms[i][0]);
			R.add(terms[i][1]);
		}
		StringBuilder x = new StringBuilder();
		x.append(" "+terms[3][0]);
		x.append(" "+terms[3][1]);
		x.append(" "+terms[4][0]);
		x.append(" "+terms[4][1]);
		x.append(" "+terms[5][0]);
		x.append(" "+terms[5][1]);
		throw new RuntimeException(x.toString());
	}
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
					a=0;
					throw new RuntimeException("A cleared yo!");
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
					b=0;
					throw new RuntimeException("B cleared yo!");
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
					c=0;
					throw new RuntimeException("C cleared too");
				}
				break;
			}
			default:
			{
				throw new RuntimeException("Invalid poly set try");
			}
		}
	}
	
	public String PrintL(singleList A)
	{
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
	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub
		switch(poly)
		{
			case 'A':
			{
				if(A.isEmpty())
					return null;
				return PrintL(A);
			}
			case 'B':
			{
				if(B.isEmpty())
					return null;
				return PrintL(B);
			}
			case 'C':
			{
				if(C.isEmpty())
					return null;
				return PrintL(C);
			}
			case 'R':
			{
				if(R.isEmpty())
					return null;
				return PrintL(R);
			}
			default:
			{
				throw new RuntimeException("invalid printer call");
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
			case 'R':
			{
				R.clear();
			}
			default:
			{
				break;
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
			throw new RuntimeException();
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
		    		 throw new RuntimeException();
		    	 }
		    	 return eva(A,value);
		     }
		     else if(poly == 'B')
		     {
		    	 if(b==0)
		    	 {
		    		 throw new RuntimeException();
		    	 }
		    	 return eva(B,value);
		     }
		     else if (poly == 'C')
		     {
		    	 if(c==0)
		    	 {
		    		 throw new RuntimeException();
		    	 }
		    	 return eva(C,value);
		     }
		     else if (poly == 'R')
		     {
		    	 if(R.isEmpty())
		    	 {
		    		 throw new RuntimeException();
		    	 }
		    	 return eva(R,value);
		     }
		     else
		     {
		    	 throw new RuntimeException();
		     }
			}
	public singleList addto(singleList x, singleList y)
	{
		
		ArrayList <Integer>A = new ArrayList<Integer>() ;
		
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
            else if(i==x.size())
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
		ArrayList <Integer>A = new ArrayList<Integer>() ;
		
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
            else if(i==x.size())
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
            singleList temp = new singleList();
            for(int p = 0 ; p < A.size()/2 ; p++ )
            {
            	a[p][0]=A.get(l);
            	a[p][1]=A.get(l+1);
            	temp.add(a[p][0]);
            	temp.add(a[p][1]);
            	l+=2;
            }
            R.clear();
            setR(R, a);
            return a;
	}
    
	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
	    if((poly1!='A'&&poly1!='B'&&poly1!='C')||(poly2!='A'&&poly2!='B'&&poly2!='C'))
	    	throw new RuntimeException();
		if(poly1=='A' || poly2=='A' )
	    {
	    	if(poly1=='B' || poly2=='B')
	    	{
	    		if(!A.isEmpty() && !B.isEmpty())
	    			return addlist(A , B) ;
	    		else
	    			throw new RuntimeException();
	    	}
	    	else if (poly1=='A' && poly2=='A')
	    	{
	    		if(!A.isEmpty() )
		    		return addlist(A , A) ;
		    	else
		    		throw new RuntimeException();
	    	}
	    	else 
	    	{
	    		if(!A.isEmpty() && !C.isEmpty())
	    			return addlist(A , C) ;
		    	else
		    		throw new RuntimeException();
	    	}
	    }
		else if (poly1=='B' || poly2=='B')
		{
			if (poly1=='B' && poly2=='B')
	    	{
	    		if(!B.isEmpty())
		    		return addlist(B , B) ;
		    	else
		    		throw new RuntimeException();
	    	}
			
			if(!C.isEmpty() && !B.isEmpty())
	    		return addlist(B , C) ;
	    	else
	    		throw new RuntimeException();
		}
		else if (poly1=='C' && poly2=='C')
    	{
    		if(!C.isEmpty())
	    		return addlist(C , C) ;
	    	else
	    		throw new RuntimeException();
    	}
		else 
		{
			throw new RuntimeException();
		}
		
	}
     
	public int[][] subtlist(singleList x, singleList y)
	{
		ArrayList <Integer>A = new ArrayList<Integer>() ;
		
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
            singleList temp = new singleList();
            for(int p = 0 ; p < A.size()/2 ; p++ )
            {
           		a[p][0]=A.get(l);
           		a[p][1]=A.get(l+1);
           		temp.add(a[p][0]);
            	temp.add(a[p][1]);
            	l+=2;
            }
            R.clear();
            setR(R, a);
            return a;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int [][]tal5ees = new int [1][2];
		tal5ees[0][1]=0; tal5ees[0][0]=0;
		if(poly1=='A')
		{
			if(poly2=='A')
			{
				if(a!=0 )
		    		return tal5ees ;
		    	else
		    		throw new RuntimeException();
			}
			if(poly2=='B')
			{
				if(a!=0 && b!=0)
		    		return subtlist(A , B) ;
		    	else
		    		throw new RuntimeException();
			}
			else if (poly2=='C')
			{
				if(a!=0 && c!=0)
		    		return subtlist(A , C) ;
		   		else
		   			throw new RuntimeException();
			}
			else
			{
				throw new RuntimeException();
			}
		}
		else if(poly1=='B')
		{
			if(poly2=='B')
			{
				if(b!=0 )
		    		return tal5ees ;
		    	else
		    		throw new RuntimeException();
			}
			if(poly2=='A')
			{
				if(a!=0 && b!=0)
		    		return subtlist(B , A) ;
		    		else
		    			throw new RuntimeException();
			}
			else if (poly2=='C')
			{
				if(b!=0 && c!=0)
		    		return subtlist(B , C) ;
		    		else
		    			throw new RuntimeException();
			}
			else
			{
				throw new RuntimeException();
			}
		}
		else if (poly1=='C')
		{
			if(poly2=='C')
			{
				if(c!=0 )
		    		return tal5ees ;
		    		else
		    			throw new RuntimeException();
			}
			if(poly2=='A')
			{
				if(a!=0 && c!=0)
		    		return subtlist(C , A) ;
		    		else
		    			throw new RuntimeException();
			}
			else if (poly2=='B')
			{
				if(b!=0 && c!=0)
		    		return subtlist(C , B) ;
		    		else
		    			throw new RuntimeException();
			}
			else
			{
				throw new RuntimeException();
			}
		}
		else
		{
			throw new RuntimeException();
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
        R.clear();
        setR(R, a);
        return a;
		
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		if(poly1=='A' || poly2=='A' )
	    {
	    	if(poly1=='B' || poly2=='B')
	    	{
	    		if(a!=0 && b!=0)
	    		return multiL(A , B) ;
	    		else
	    			throw new RuntimeException();
	    	}
	    	else if (poly1=='A' && poly2=='A')
	    	{
	    		if(a!=0 )
		    		return multiL(A , A) ;
		    	else
		    		throw new RuntimeException();
	    	}
	    	else 
	    	{
	    		if(a!=0 && c!=0)
		    		return multiL(A , C) ;
		    		else
		    			throw new RuntimeException();
	    	}
	    }
		else if (poly1=='B' || poly2=='B')
		{
			if (poly1=='B' && poly2=='B')
	    	{
	    		if(b!=0)
		    		return multiL(B , B) ;
		    		else
		    			throw new RuntimeException();
	    	}
			
			if(c!=0 && b!=0)
	    		return multiL(B , C) ;
	    		else
	    			throw new RuntimeException();
		}
		else if (poly1=='C' && poly2=='C')
    	{
    		if(c!=0)
	    		return multiL(C , C) ;
	    		else
	    			throw new RuntimeException();
    	}
		else 
		{
			throw new RuntimeException();
		}
		
	}
	public void accumulate(singleList A)
	{
		int i;
		i=0;
		int x;
		R=addto(R,A);
		
	}
}
