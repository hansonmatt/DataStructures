package com.matthanson.datastructures.graph;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/7/16.
 */
public class AdjacencyListGraphTest {

    @Test
    public void testUndirectedGraphAddEdge() {
        int x = 1;
        int y = 2;
        int weight = 100;

        AdjacencyListGraph graph = new AdjacencyListGraph(100);
        graph.addEdge(x, y, weight, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        Assert.assertEquals(2, graph.nVertices);

        Assert.assertEquals(y, graph.vertices[x].next.value);
        Assert.assertEquals(weight, graph.vertices[x].next.weight);

        Assert.assertEquals(x, graph.vertices[y].next.value);
        Assert.assertEquals(weight, graph.vertices[y].next.weight);
    }

    @Test
    public void testUndirectedGraphInitialization() {
        int weight = 100;

        AdjacencyListGraph graph = new AdjacencyListGraph(10);
        graph.addEdge(1, 2, 2, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(1, 5, 5, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(2, 3, 3, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(2, 4, 4, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(2, 5, 5, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(3, 4, 4, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(4, 5, 5, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);

        Assert.assertEquals(5, graph.nVertices);
    }
}