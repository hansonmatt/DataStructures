package com.matthanson.datastructures.graph;

/**
 * Created by Matt on 9/7/16.
 */
public class AdjacencyListGraph {
    public enum GraphDirectedness {
        DIRECTED,
        UNDIRECTED
    }

    public enum GraphDiscovered {
        UNDISCOVERED,
        DISCOVERED,
        PROCESSED
    }

    public AdjacencyListGraph(int theSize) {
        this.vertices = new Vertex[theSize];
        for (int n = 0; n < theSize; ++n) {
            this.vertices[n] = null;
        }
    }

    public static class Vertex {
        int value = 0;
        long weight = 0;
        Vertex next = null;

        public Vertex(int theValue, long theWeight) {
            this.value = theValue;
            this.weight = theWeight;
        }

        public Vertex(int theValue) {
            this.value = theValue;
        }

        public boolean equals(Vertex toCompare) {
            if (toCompare == null) return false;

            return this.value == toCompare.value && this.weight == toCompare.weight;
        }
    }

    public Vertex[] vertices;

    public int nVertices = 0;

    public void addEdge(int x, int y, long weight, GraphDirectedness directed) {
        if (vertices[x] == null) {
            vertices[x] = new Vertex(x);
            nVertices++;
        }

        Vertex vY = new Vertex(y, weight);
        vY.next = vertices[x].next;
        vertices[x].next = vY;

        if (directed == GraphDirectedness.UNDIRECTED) {
            addEdge(y, x, weight, GraphDirectedness.DIRECTED);
        }
    }
}
