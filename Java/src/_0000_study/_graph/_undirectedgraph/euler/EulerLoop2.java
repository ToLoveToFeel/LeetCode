package _0000_study._graph._undirectedgraph.euler;

import _0000_study._graph._undirectedgraph.bfs.bfsapplication.CC;
import _0000_study._graph.graphrepresentation.Graph;
import _0000_study._graph.util.FilePrefix;

import java.util.ArrayList;
import java.util.Stack;

public class EulerLoop2 {

    private Graph G;

    public EulerLoop2(Graph G){
        this.G = G;
    }

    private boolean hasEulerLoop(){

        CC cc = new CC(G);
        if(cc.count() > 1) return false;

        for(int v = 0; v < G.V(); v ++)
            if(G.degree(v) % 2 == 1) return false;
        return true;
    }

    // 寻找欧拉回路
    public ArrayList<Integer> result(){

        ArrayList<Integer> res = new ArrayList<>();
        if(!hasEulerLoop()) return res;

        Graph g = (Graph)G.clone();

        Stack<Integer> stack = new Stack<>();
        int curv = 0;
        stack.push(curv);
        while(!stack.isEmpty()){
            if(g.degree(curv) != 0){
                stack.push(curv);
                int w = g.adj(curv).iterator().next();
                g.removeEdge(curv, w);
                curv = w;
            }
            else{
                res.add(curv);
                curv = stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args){
        String graphPath = FilePrefix.pathPrefix + "_undirectedgraph/euler";
        Graph g = new Graph(graphPath + "/g.txt");
        EulerLoop2 el = new EulerLoop2(g);
        System.out.println(el.result());

        Graph g2 = new Graph(graphPath + "/g2.txt");
        EulerLoop2 el2 = new EulerLoop2(g2);
        System.out.println(el2.result());
    }
}
