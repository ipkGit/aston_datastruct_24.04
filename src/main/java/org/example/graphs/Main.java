package org.example.graphs;

import org.example.Search;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //представим граф как связи между городами
        UnweightedGraph<String> cityGraph = new UnweightedGraph<>(
                List.of("Екатеринбург", "Москва", "Санкт-Петербург", "Минск", "Киев", "Ростов-на-Дону", "Казань",
                        "Гомель", "Витебск", "Полоцк", "Алматы")
        );

        cityGraph.addEdge("Екатеринбург", "Москва");
        cityGraph.addEdge("Екатеринбург", "Казань");
        cityGraph.addEdge("Екатеринбург", "Алматы");
        cityGraph.addEdge("Москва", "Санкт-Петербург");
        cityGraph.addEdge("Москва", "Минск");
        cityGraph.addEdge("Москва", "Киев");
        cityGraph.addEdge("Москва", "Ростов-на-Дону");
        cityGraph.addEdge("Москва", "Гомель");
        cityGraph.addEdge("Москва", "Казань");
        cityGraph.addEdge("Санкт-Петербург", "Витебск");
        cityGraph.addEdge("Санкт-Петербург", "Минск");
        cityGraph.addEdge("Минск", "Гомель");
        cityGraph.addEdge("Минск", "Витебск");
        cityGraph.addEdge("Минск", "Полоцк");
        cityGraph.addEdge("Минск", "Киев");
        cityGraph.addEdge("Киев", "Ростов-на-Дону");
        cityGraph.addEdge("Киев", "Гомель");
        cityGraph.addEdge("Ростов-на-Дону", "Казань");
        cityGraph.addEdge("Казань", "Алматы");

        System.out.println(cityGraph);

        showPath("Екатеринбург", "Витебск", cityGraph);
    }

    private static void showPath(String from, String to, UnweightedGraph<String> cityGraph) {

        Optional<Search.Node<String>> bfsResult = Search
                .breadthFirstSearch(from, v -> v.equals(to),
                        cityGraph::getNeighborsOf);

        Optional<Search.Node<String>> dfsResult = Search
                .depthFirstSearch(from, v -> v.equals(to),
                        cityGraph::getNeighborsOf);

        if (bfsResult.isPresent()) {
            List<String> path = Search.Node.nodeToPath(bfsResult.get());
            System.out.printf("Your path(BFS) from %s to %s looks like this:\n%s\n", from, to, path);
        } else {
            System.out.printf("No way, you can't go to %s from %s\n", to, from);
        }

        if (dfsResult.isPresent()) {
            List<String> path = Search.Node.nodeToPath(dfsResult.get());
            System.out.printf("Your path(DFS) from %s to %s looks like this:\n%s\n", from, to, path);
        } else {
            System.out.printf("No way, you can't go to %s from %s\n", to, from);
        }
    }
}