package _0000_study._graph._undirectedgraph.euler;

import _0000_study._graph._undirectedgraph.bfs.bfsapplication.CC;
import _0000_study._graph.graphrepresentation.Graph;

public class EulerLoop {

    private Graph G;

    public EulerLoop(Graph G){
        this.G = G;
    }

    private boolean hasEulerLoop(){

        CC cc = new CC(G);
        if(cc.count() > 1) return false;

        for(int v = 0; v < G.V(); v ++)
            if(G.degree(v) % 2 == 1) return false;
        return true;
    }
}
