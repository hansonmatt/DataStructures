package com.matthanson.datastructures.graph;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/9/16.
 */
public class BreadthFirstSearchTest {
    @Test
    public void breadthFirstSearch() throws Exception {
        int weight = 100;

        AdjacencyListGraph graph = new AdjacencyListGraph(10);
        graph.addEdge(1, 2, 2, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(1, 5, 5, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(2, 3, 3, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(2, 4, 4, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(2, 5, 5, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(3, 4, 4, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);
        graph.addEdge(4, 5, 5, AdjacencyListGraph.GraphDirectedness.UNDIRECTED);

        BreadthFirstSearch bfs = new BreadthFirstSearch();

        int [] shortestPaths = bfs.breadthFirstSearch(graph, new AdjacencyListGraph.Vertex(1));
        Assert.assertEquals(10, shortestPaths.length);

        Assert.assertEquals(0, shortestPaths[1]);
        Assert.assertEquals(1, shortestPaths[2]);
        Assert.assertEquals(2, shortestPaths[3]);
        Assert.assertEquals(2, shortestPaths[4]);
        Assert.assertEquals(1, shortestPaths[5]);
    }

}