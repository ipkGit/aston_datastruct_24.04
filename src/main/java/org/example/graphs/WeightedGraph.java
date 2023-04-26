package org.example.graphs;

import java.util.*;

public class WeightedGraph<V> extends Graph<V, WeightedEdge> {

    public WeightedGraph(List<V> verticles) {
        super(verticles);
    }

    public void addEdge(WeightedEdge edge) {
        getEdgesOf(edge.getTo()).add(edge);
        getEdgesOf(edge.getFrom()).add(edge.reversed());
    }

    public void addEdge(int from, int to, double weight) {
        addEdge(new WeightedEdge(from, to, weight));
    }

    public void addEdge(V from, V to, double weight) {
        addEdge(new WeightedEdge(indexOf(from), indexOf(to), weight));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getVertexCount(); i++) {
            sb.append(getVertex(i));
            sb.append(" -> ");
            sb.append(Arrays.toString(getEdgesOf(i).stream()
                    .map(we -> "(" + getVertex(we.getFrom()) + ", " + we.getWeight() +
                            ")").toArray()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }


    public DijkstraResult dijkstra(V root) {
        int indexFirst = indexOf(root);

        double[] distances = new double[getVertexCount()];
        distances[indexFirst] = 0;
        boolean[] isVisited = new boolean[getVertexCount()];
        isVisited[indexFirst] = true;

        HashMap<Integer, WeightedEdge> pathMap = new HashMap<>();
        PriorityQueue<DijkstraNode> queue = new PriorityQueue<>();
        queue.offer(new DijkstraNode(indexFirst, 0));

        while (!queue.isEmpty()) {
            int vertex = queue.poll().vertex;
            double distVertex = distances[vertex];

            for (WeightedEdge edge : getEdgesOf(vertex)) {
                double distOld = distances[edge.getFrom()];
                double distNew = edge.getWeight() + distVertex;

                if (!isVisited[edge.getFrom()] || distOld > distNew) {
                    isVisited[edge.getFrom()] = true;
                    distances[edge.getFrom()] = distNew;
                    pathMap.put(edge.getFrom(), edge);
                    queue.offer(new DijkstraNode(edge.getFrom(), distNew));
                }
            }
        }
        return new DijkstraResult(distances, pathMap);
    }

    public static List<WeightedEdge> pathMapToPath(int start, int end,
                                                   Map<Integer, WeightedEdge> pathMap) {
        if (pathMap.size() == 0) {
            return List.of();
        }
        LinkedList<WeightedEdge> path = new LinkedList<>();
        WeightedEdge edge = pathMap.get(end);
        path.add(edge);
        while (edge.getTo() != start) {
            edge = pathMap.get(edge.getTo());
            path.add(edge);
        }
        Collections.reverse(path);
        return path;
    }

    public void printWeightedPath(List<WeightedEdge> wp) {
        for (WeightedEdge edge : wp) {
            System.out.println(getVertex(edge.getTo()) + " "
                    + edge.getWeight() + "km > " + getVertex(edge.getFrom()));
        }
    }

    public Map<V, Double> distanceArrayToDistanceMap(double[] distances) {
        HashMap<V, Double> distanceMap = new HashMap<>();
        for (int i = 0; i < distances.length; i++) {
            distanceMap.put(getVertex(i), distances[i]);
        }
        return distanceMap;
    }

    public static class DijkstraResult {
        public final double[] distances;
        public final Map<Integer, WeightedEdge> pathMap;

        public DijkstraResult(double[] distances, Map<Integer, WeightedEdge> pathMap) {
            this.distances = distances;
            this.pathMap = pathMap;
        }
    }

    public static class DijkstraNode implements Comparable<DijkstraNode> {

        public final int vertex;
        public final double distance;

        public DijkstraNode(int vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(DijkstraNode o) {
            Double mine = distance;
            Double theirs = o.distance;
            return mine.compareTo(theirs);
        }
    }
}
