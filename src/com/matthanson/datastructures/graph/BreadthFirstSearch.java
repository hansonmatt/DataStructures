package com.matthanson.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Matt on 9/9/16.
 */
public class BreadthFirstSearch {
    public int[] breadthFirstSearch(AdjacencyListGraph graph, AdjacencyListGraph.Vertex source) {
        AdjacencyListGraph.Vertex[] vertices = graph.vertices;

        int[] shortestPaths = new int[vertices.length];
        AdjacencyListGraph.GraphDiscovered[] vertexColors = new AdjacencyListGraph.GraphDiscovered[vertices.length];

        for (int n = 0; n < vertices.length; ++n) {
            shortestPaths[n] = Integer.MAX_VALUE;
            vertexColors[n] = AdjacencyListGraph.GraphDiscovered.UNDISCOVERED;
        }

        shortestPaths[source.value] = 0;
        vertexColors[source.value] = AdjacencyListGraph.GraphDiscovered.DISCOVERED;

        Queue<AdjacencyListGraph.Vertex> q = new LinkedList<>();
        q.add(vertices[source.value]);
        while (!q.isEmpty()) {
            AdjacencyListGraph.Vertex v = q.poll();
            AdjacencyListGraph.Vertex next = v.next;
            while (next != null) {
                if (vertexColors[next.value] == AdjacencyListGraph.GraphDiscovered.UNDISCOVERED) {
                    vertexColors[next.value] = AdjacencyListGraph.GraphDiscovered.DISCOVERED;
                    shortestPaths[next.value] = shortestPaths[v.value] + 1;
                    q.add(vertices[next.value]);

                }

                next = next.next;
            }

            vertexColors[v.value] = AdjacencyListGraph.GraphDiscovered.PROCESSED;
        }

        return shortestPaths;
    }
}
