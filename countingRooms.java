
import java.util.Scanner;

public class countingRooms {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		String[][]arr=new String[n][m];
		for(int i=0;i<n;i++) {
			
				String s=sc.next();
				String[]l=s.split("");
				for(int j=0;j<m;j++) {
				  arr[i][j]=l[j];
				}
		}
		
		boolean[][]b=new boolean[n][m];
		
		int ans=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j].equals(".")&&b[i][j]!=true) {
		             dfs(arr,n,m,b,i,j);				
				ans++;
				}
			}
		}

		System.out.println(ans);
	}
	
	public static void dfs(String[][]arr,int n,int m,boolean[][]b,int i,int j) {

		if(i>n-1||j>m-1||i<0||j<0||arr[i][j].equals("#")||b[i][j]==true) {
			return;
		}
	    
		b[i][j]=true;
		
		dfs(arr,n,m,b,i+1,j);
		dfs(arr,n,m,b,i,j+1);
		dfs(arr,n,m,b,i-1,j);
		dfs(arr,n,m,b,i,j-1);
		
	}

}
