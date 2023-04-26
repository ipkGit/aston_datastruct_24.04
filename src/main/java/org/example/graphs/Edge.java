package org.example.graphs;

public class Edge {
    private final int from;
    private final int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public Edge reversed() {
        return new Edge(to, from);
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
