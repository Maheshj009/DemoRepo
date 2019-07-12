import java.util.Arrays;

public class Program {
	
	

	public static void main(String[] args) {
		
		if(true)
		return;
		int ar[]= {2,3,5,6,8,5};
		Arrays.sort(ar);
		for(int i=0;i<ar.length;i++)
		{
		int n=ar[i];
		int counter=0;
		
		for(int j=0;j<ar.length;j++) {
			if(n==ar[j])
				counter++;
		}
		if(counter>1)
		{
			System.out.println("dn"+ar[i]);
			break;
		}
		}
		
		
		if(true)
			return;
		String fnr="aabbccfdddd";
		char ch[]=fnr.toCharArray();
		for (char c : ch) {
			if(fnr.indexOf(c)==fnr.lastIndexOf(c))
			{
				System.out.println(c);
				break;
			}
		}
		
		
		if(true)
			return;
		String word="aaaabbbcccdddddi";
		char v[]=word.toCharArray();
		int vcount=0;
		
		for (char c : v) {
			
			switch(c)
			{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				vcount++;
				break;
				default:
			}
			
		}
		System.out.println(vcount);
		

		if(true)
			return;
		int n=12121 ,rev=0;
		int c=n;
		while(n!=0)
		{
			int r=n%10;
			n=n/10;
			rev=rev*10+r;
		}
		System.out.println(rev);
		
		if(c!=rev)
			System.out.println("not p");
		
		else
		System.out.println(rev + "-is p");
		
		if(true)
			return;
		int na[] = {10,5,7,15,4,3};
	int l =na.length;
		for(int i=0;i<l;i++)
		{
			for(int j=i+1;j<l;j++)
			{
				if(na[i]<na[j])
				{
					int temp=na[i];
					na[i]=na[j];
					na[j]=temp;
					
				}
			}
		}
		for(int i=0;i<na.length;i++)
		System.out.println(na[i]);
		
		
		if(true)
			return;
		int a=-100,b=200;
		a=a+b;
		b=a-b;
		a=a-b;
		
		System.out.println(a + " "+b);
		
		

	
		if(true)
			return;
		String s="levelll";
		char[] sa=s.toCharArray();
		String rs = new String();
		for(int i=s.length()-1;i>=0;i--)
		{
			
			rs=rs+sa[i];
		}
		
		System.out.println(rs);
		if(rs.equals(s)==true)
		{
			System.out.println("palindrom");
			
		}
		else
		{
			System.out.println("==");
		}
		if(true)
			return;
		
		StringBuffer temp=new StringBuffer(s);
		String s1=temp.reverse().toString();
		
		if(s.equals(s1)==true)
		{
			System.out.println(s+"--string is palindrom ");
		}
		else
		{
			System.out.println("not palindrom");
		}
	}
}
