package day1;

import java.util.Scanner;
import java.util.Stack;

public class WeightedGraph {
	private int mat[][];
	private int verti, edge;
	private int INF = 999;
	
	public WeightedGraph(int vertix) {
		this.verti = vertix;
		mat = new int[verti][verti];
		for (int i = 0; i < verti; i++) {
			for (int j = 0; j < verti; j++) {
				mat[i][j] = INF;
			}
			
		}
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter the number of Edges");
		edge = sc.nextInt();
		System.out.println("Enter " + edge + "Edges Source--Destination--weight");
		for (int i = 0; i < edge; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			int wt = sc.nextInt();
			mat[src][des] = wt;
			mat[des][src] = wt;
		}		
	}
	
	public void display() {
		for (int i = 0; i < verti; i++) {
			System.out.print("V" + i );
			for (int j = 0; j < verti; j++) {
				if(mat[i][j] == INF)
					System.out.print("\t#");
				else
				System.out.print("\t" + mat[i][j]);
			}
			System.out.println();
		}	
	}
	
	void dfsTrav(int start) {
		System.out.print("DFS :: ");
		boolean[] marked = new boolean[verti];
		Stack<Integer> s = new Stack<>();
		s.push(start);
		marked[start] = true;
		while( !s.isEmpty()) {
			int trav = s.pop();
			System.out.print("\t " + trav +"," );
			for (int i = 0; i < verti; i++) {
				if(mat[trav][i] != INF && marked[i] == false) {
					s.push(i);
					marked[i] = true;
					
				}
				
			}	
		}
		System.out.println();
	}
	
	void bfsTrav(int start) {
		System.out.print("DFS :: ");
		boolean[] marked = new boolean[verti];
		Stack<Integer> s = new Stack<>();
		s.push(start);
		marked[start] = true;
		while( !s.isEmpty()) {
			int trav = s.pop();
			System.out.print("\t " + trav +"," );
			for (int i = 0; i < verti; i++) {
				if(mat[trav][i] != INF && marked[i] == false) {
					s.push(i);
					marked[i] = true;
					
				}
				
			}	
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WeightedGraph g = new WeightedGraph(6);
		g.accept(sc);
		g.display();
		g.dfsTrav(0);
		sc.close();
	}

}

/* 
7
0 1
0 2
0 3
1 2
1 4 
3 4 
3 5 
 */

/* 
7
0 1 2
0 2 4
0 3 6
1 2 8
1 4 10
3 4 12
3 5 14
 */





