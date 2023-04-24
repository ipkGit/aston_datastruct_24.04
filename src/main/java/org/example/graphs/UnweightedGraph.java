package org.example.graphs;

import java.util.List;

//не взвешанный и не ориентированный граф
public class UnweightedGraph<V> extends Graph<V, Edge> {

    public UnweightedGraph(List<V> vertices) {
        super(vertices);
    }

    public void addEdge(Edge edge) {
        getEdgesOf(edge.to()).add(edge);
        getEdgesOf(edge.from()).add(edge.reversed());
    }

    public void addEdge(int indexFrom, int indexTo) {
        addEdge(new Edge(indexFrom, indexTo));
    }

    public void addEdge(V from, V to) {
        addEdge(new Edge(indexOf(from), indexOf(to)));
    }
}
