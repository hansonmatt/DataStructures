package com.matthanson.datastructures.graph;

/**
 * Created by Matt on 9/8/16.
 */
public class DepthFirstSearch {
    public AdjacencyListGraph graph;
    public int[] entry;
    public int[] exit;
    public int[] predecessors;
    public AdjacencyListGraph.GraphDiscovered[] discovery;

    public DepthFirstSearch(AdjacencyListGraph theGraph) {
        this.graph = theGraph;

        int graphLength = this.graph.vertices.length;

        this.entry = new int[graphLength];
        this.exit = new int[graphLength];
        this.predecessors = new int[graphLength];
        this.discovery = new AdjacencyListGraph.GraphDiscovered[graphLength];

        for (int n = 0; n < graphLength; ++n) {
            discovery[n] = AdjacencyListGraph.GraphDiscovered.UNDISCOVERED;
        }

    }

    private int t;

    public void dfs() {

        t = 0;

        for (int n = 0; n < this.graph.vertices.length; ++n) {
            if (this.graph.vertices[n] != null) {
                AdjacencyListGraph.Vertex v = this.graph.vertices[n];

                if (discovery[v.value] == AdjacencyListGraph.GraphDiscovered.UNDISCOVERED) {
                    visit(v);
                }

            }

        }
    }

    private void visit(AdjacencyListGraph.Vertex v) {
        t++;

        int index = v.value;
        discovery[index] = AdjacencyListGraph.GraphDiscovered.DISCOVERED;
        entry[index] = t;
        AdjacencyListGraph.Vertex next = v.next;
        while (next != null) {
            if (discovery[next.value] == AdjacencyListGraph.GraphDiscovered.UNDISCOVERED) {

                predecessors[next.value] = index;
                visit(graph.vertices[next.value]);
            }

            next = next.next;
        }

        exit[index] = ++t;
        discovery[index] = AdjacencyListGraph.GraphDiscovered.PROCESSED;
    }
}
