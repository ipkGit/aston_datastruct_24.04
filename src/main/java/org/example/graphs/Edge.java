package org.example.graphs;

public record Edge(int from, int to) {

    public Edge reversed() {
        return new Edge(to, from);
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }
}
