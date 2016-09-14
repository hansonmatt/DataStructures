package com.matthanson.datastructures.graph;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/9/16.
 */
public class DepthFirstSearchTest {
    @Test
    public void testDFS() {
        AdjacencyListGraph graph = new AdjacencyListGraph(10);
        graph.addEdge(1, 4, 4, AdjacencyListGraph.GraphDirectedness.DIRECTED);
        graph.addEdge(1, 2, 2, AdjacencyListGraph.GraphDirectedness.DIRECTED);
        graph.addEdge(2, 5, 5, AdjacencyListGraph.GraphDirectedness.DIRECTED);
        graph.addEdge(3, 5, 5, AdjacencyListGraph.GraphDirectedness.DIRECTED);
        graph.addEdge(3, 6, 6, AdjacencyListGraph.GraphDirectedness.DIRECTED);
        graph.addEdge(4, 2, 2, AdjacencyListGraph.GraphDirectedness.DIRECTED);
        graph.addEdge(5, 4, 4, AdjacencyListGraph.GraphDirectedness.DIRECTED);
        graph.addEdge(6, 6, 6, AdjacencyListGraph.GraphDirectedness.DIRECTED);

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.dfs();

        Assert.assertEquals(1, dfs.entry[1]);
        Assert.assertEquals(8, dfs.exit[1]);
        Assert.assertEquals(0, dfs.predecessors[1]);
        Assert.assertEquals(AdjacencyListGraph.GraphDiscovered.PROCESSED, dfs.discovery[1]);

        Assert.assertEquals(2, dfs.entry[2]);
        Assert.assertEquals(7, dfs.exit[2]);
        Assert.assertEquals(1, dfs.predecessors[2]);
        Assert.assertEquals(AdjacencyListGraph.GraphDiscovered.PROCESSED, dfs.discovery[2]);

        Assert.assertEquals(9, dfs.entry[3]);
        Assert.assertEquals(12, dfs.exit[3]);
        Assert.assertEquals(0, dfs.predecessors[3]);
        Assert.assertEquals(AdjacencyListGraph.GraphDiscovered.PROCESSED, dfs.discovery[3]);

        Assert.assertEquals(4, dfs.entry[4]);
        Assert.assertEquals(5, dfs.exit[4]);
        Assert.assertEquals(5, dfs.predecessors[4]);
        Assert.assertEquals(AdjacencyListGraph.GraphDiscovered.PROCESSED, dfs.discovery[4]);

        Assert.assertEquals(3, dfs.entry[5]);
        Assert.assertEquals(6, dfs.exit[5]);
        Assert.assertEquals(2, dfs.predecessors[5]);
        Assert.assertEquals(AdjacencyListGraph.GraphDiscovered.PROCESSED, dfs.discovery[5]);

        Assert.assertEquals(10, dfs.entry[6]);
        Assert.assertEquals(11, dfs.exit[6]);
        Assert.assertEquals(3, dfs.predecessors[6]);
        Assert.assertEquals(AdjacencyListGraph.GraphDiscovered.PROCESSED, dfs.discovery[6]);
    }

}