package org.example.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @param <V> - graph vertex type
 * @param <E> - graph edge type
 */
public abstract class Graph<V, E extends Edge> {

    private final ArrayList<V> vertices = new ArrayList<>();
    private final ArrayList<ArrayList<E>> edges = new ArrayList<>();

    public Graph() {
    }

    public Graph(List<V> vertices) {
        this.vertices.addAll(vertices);

        for (V vertex : vertices) {
            edges.add(new ArrayList<>());
        }
    }

    public int addVertex(V vertex) {
        vertices.add(vertex);
        edges.add(new ArrayList<>());
        return getVertexCount() - 1;
    }

    public V getVertex(int index) {
        return vertices.get(index);
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int indexOf(V vertex) {
        return vertices.indexOf(vertex);
    }

    public int getEdgesCount() {
        return edges.stream()
                .mapToInt(ArrayList::size)
                .sum();
    }

    public List<V> getNeighborsOf(int index) {
        return edges.get(index).stream()
                .map(e -> getVertex(e.getFrom()))
                .collect(Collectors.toList());
    }

    public List<V> getNeighborsOf(V vertex) {
        return getNeighborsOf(indexOf(vertex));
    }

    public List<E> getEdgesOf(int index) {
        return edges.get(index);
    }

    public List<E> getEdgesOf(V vertex) {
        return getEdgesOf(indexOf(vertex));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getVertexCount(); i++) {
            sb.append(getVertex(i))
                    .append(" -> ")
                    .append(Arrays.toString(getNeighborsOf(i).toArray()))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
