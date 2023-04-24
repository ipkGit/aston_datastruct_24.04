package org.example.graphs;

import java.util.List;

//не взвешанный и не ориентированный граф
public class UnweightedGraph<V> extends Graph<V, Edge> {

    public UnweightedGraph(List<V> vertices) {
        super(vertices);
    }

    public void addEdge(Edge edge) {
        edges.get(edge.to()).add(edge);
        edges.get(edge.from()).add(edge.reversed());
    }

    public void addEdge(int from, int to) {
        addEdge(new Edge(from, to));
    }

    public void addEdge(V first, V second) {
        addEdge(new Edge(indexOf(first), indexOf(second)));
    }
}
