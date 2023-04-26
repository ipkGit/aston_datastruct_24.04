package org.example.graphs;

public class WeightedEdge extends Edge implements Comparable<WeightedEdge> {

    private final double weight;

    public WeightedEdge(int from, int to, double weight) {
        super(from, to);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public WeightedEdge reversed() {
        return new WeightedEdge(getTo(), getFrom(), weight);
    }

    @Override
    public int compareTo(WeightedEdge o) {
        Double mine = weight;
        Double theirs = o.getWeight();
        return mine.compareTo(theirs);
    }

    @Override
    public String toString() {
        return getFrom() + " " + getWeight() + " -> " + getTo();
    }
}
