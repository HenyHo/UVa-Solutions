package v114;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ExtendToPalindrome_UVa11475 {

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(sc.ready())
		{
			String s = sc.next();
			int k = s.length() - longestSuffixPalindrome(s.toCharArray());
			StringBuilder sb = new StringBuilder(s);
			while(k-- > 0)
				sb.append(s.charAt(k));
			out.println(sb);
		}
		out.flush();
		out.close();
	}
	
	static int longestSuffixPalindrome(char[] t)
	{
		int n = t.length * 2 + 1;
		char[] s = new char[n];
		for(int i = 0; i < t.length; ++i)
			s[t.length - i - 1] = s[t.length + 1 + i] = t[i];
		int[] pi = new int[n];
		for(int i = 1, j = 0; i < n; ++i)
		{
			while(j > 0 && s[i] != s[j])
				j = pi[j-1];
			if(s[i] == s[j])
				++j;
			pi[i] = j;
		}
		return pi[n-1];
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){    br = new BufferedReader(r);}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}