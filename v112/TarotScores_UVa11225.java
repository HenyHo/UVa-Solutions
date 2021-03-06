package v112;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TarotScores_UVa11225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		TreeMap<String, Integer> map = new TreeMap<String,Integer>();
		map.put("king", 4);map.put("fool", 4);map.put("one", 4);map.put("jack", 1);
		map.put("twenty-one", 4);map.put("queen", 3);map.put("knight", 2);
		int[] x = new int[]{56,51,41,36};
		
		int TC = Integer.parseInt(br.readLine());
		for(int k = 1; k <= TC; k++)
		{
			int N = Integer.parseInt(br.readLine());
			int score  = N/2;
			int target = 0;
			while(N-->0)
			{
				String card = new StringTokenizer(br.readLine()).nextToken();
				if(map.containsKey(card))
				{
					score += map.get(card);
					if(card.equals("fool") || card.equals("twenty-one") || card.equals("one"))
						target++;
				}
			}
			out.printf("Hand #%d\n",k);
			if(score < x[target])
				out.printf("Game lost by %d point(s).\n",x[target]-score);
			else
				out.printf("Game won by %d point(s).\n",score-x[target]);
			if(k!=TC)
				out.println();
		}
		out.flush();
	}
}
