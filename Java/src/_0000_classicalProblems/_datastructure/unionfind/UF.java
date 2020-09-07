package _0000_classicalProblems._datastructure.unionfind;

public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
