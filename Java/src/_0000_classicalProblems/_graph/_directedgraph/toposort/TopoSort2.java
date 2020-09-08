package _0000_classicalProblems._graph._directedgraph.toposort;

import _0000_classicalProblems._graph._directedgraph.cycledetection.DirectedCycleDetection;
import _0000_classicalProblems._graph._directedgraph.dfs.GraphDFS;
import _0000_classicalProblems._graph.graphrepresentation.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSort2 {
    // 有向无权图（也不能存在环）
    private Graph G;
    private ArrayList<Integer> res;
    private boolean hasCycle = false;

    public TopoSort2(Graph G) {

        if (!G.isDirected())
            throw new IllegalArgumentException("DirectedCycleDetection only works in directed graph.");

        this.G = G;
        res = new ArrayList<>();

        hasCycle = (new DirectedCycleDetection(G)).hasCycle();
        if (hasCycle) return;

        GraphDFS dfs = new GraphDFS(G);
        for (int v : dfs.post())
            res.add(v);

        Collections.reverse(res);
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public ArrayList<Integer> result() {
        return res;
    }

    public static void main(String[] args) {
        String graphPath = "./src/_0000_classicalProblems/_graph/_directedgraph/toposort";

        Graph ug = new Graph(graphPath + "/ug.txt", true);
        TopoSort2 topoSort = new TopoSort2(ug);
        System.out.println(topoSort.result());
    }
}
