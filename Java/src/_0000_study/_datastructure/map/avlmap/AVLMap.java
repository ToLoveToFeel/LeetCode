package _0000_study._datastructure.map.avlmap;

import _0000_study._datastructure.avltree.AVLTree;
import _0000_study._datastructure.map.Map;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avl;

    public AVLMap() {
        avl = new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avl.set(key, newValue);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }
}
