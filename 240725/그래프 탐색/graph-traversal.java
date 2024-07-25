//첫 번째 줄에 N개의 정점과 M개의 간선이 주어짐. 
//그리고 뒤에 간선들이 주어지므로 이것으로 그래프를 구성해야함. 

import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int M;

    public static int maxi= 0;

    public static boolean[] visited;
    public static ArrayList<Integer>[] vertexMt;

    public static void visit(int vertex,int count){

        if(vertexMt[vertex].size() == 0){
            maxi = Math.max(maxi, count);
            return;
        }

        for(int i = 0; i< vertexMt[vertex].size(); i++){
            int currVer = vertexMt[vertex].get(i);
            if(visited[currVer]!= true){
                visited[currVer] = true;
                visit(currVer,count+1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        visited = new boolean[N+1];
        vertexMt = new ArrayList[N+1];
        for(int i = 1; i<=N; i++)
        vertexMt[i] = new ArrayList<Integer>();

        for(int i = 0; i< M; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            vertexMt[a].add(b);
            vertexMt[b].add(a);            
        }

        int rootVertex = 1;
        visited[rootVertex] = true;
        visit(rootVertex,0);

        System.out.print(maxi);

        
    }
}