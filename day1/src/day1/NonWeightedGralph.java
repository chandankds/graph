package day1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

public class NonWeightedGralph {
	private int mat[][];
	private int verti, edge;
	
	public NonWeightedGralph(int vertix) {
		this.verti = vertix;
		mat = new int[verti][verti];
	}
	
	public void accept(Scanner sc) {
		System.out.println("Enter the number of Edges");
		edge = sc.nextInt();
		System.out.println("Enter " + edge + "Edges Source--Destination");
		for (int i = 0; i < edge; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			mat[src][des] = 1;
			mat[des][src] = 1;
		}		
	}
	
	public void display() {
		for (int i = 0; i < verti; i++) {
			System.out.print("V" + i );
			for (int j = 0; j < verti; j++)
				System.out.print("\t" + mat[i][j]);
			System.out.println();
		}	
	}
	
	public void dfsTrav(int start) {
		System.out.print("DFS :: ");
		boolean[] marked = new boolean[verti];
		Stack<Integer> s = new Stack<>();
		s.push(start);
		marked[start] = true;
		while( !s.isEmpty()) {
			int trav = s.pop();
			System.out.print("\t" + trav +"," );
			for (int i = 0; i < verti; i++) {
				if(mat[trav][i] == 1 && marked[i] == false) {
					s.push(i);
					marked[i] = true;
					
				}
				
			}	
		}
		System.out.println();
	}
	
	void bfsTrav(int start) {
		System.out.print("BFS :: ");
		boolean[] marked = new boolean[verti];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		marked[start] = true;
		while( !q.isEmpty()) {
			int trav = q.poll();
			System.out.print("\t" + trav +"," );
			for (int i = 0; i < verti; i++) {
				if(mat[trav][i] != 1 && marked[i] == false) {
					q.offer(i);
					marked[i] = true;
					
				}
				
			}	
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NonWeightedGralph g = new NonWeightedGralph(6);
		g.accept(sc);
		g.display();
		g.dfsTrav(0);
		g.bfsTrav(0);
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





