package org.example;

import org.example.graphs.UnweightedGraph;
import org.example.graphs.WeightedEdge;
import org.example.graphs.WeightedGraph;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        представим граф как связи между городами
//        UnweightedGraph<String> cityGraph = new UnweightedGraph<>(
//                List.of("Екатеринбург", "Москва", "Санкт-Петербург", "Минск", "Киев", "Ростов-на-Дону", "Казань",
//                        "Гомель", "Витебск", "Полоцк", "Алматы")
//        );
//
//        cityGraph.addEdge("Екатеринбург", "Москва");
//        cityGraph.addEdge("Екатеринбург", "Казань");
//        cityGraph.addEdge("Екатеринбург", "Алматы");
//        cityGraph.addEdge("Москва", "Санкт-Петербург");
//        cityGraph.addEdge("Москва", "Минск");
//        cityGraph.addEdge("Москва", "Киев");
//        cityGraph.addEdge("Москва", "Ростов-на-Дону");
//        cityGraph.addEdge("Москва", "Гомель");
//        cityGraph.addEdge("Москва", "Казань");
//        cityGraph.addEdge("Санкт-Петербург", "Витебск");
//        cityGraph.addEdge("Санкт-Петербург", "Минск");
//        cityGraph.addEdge("Минск", "Гомель");
//        cityGraph.addEdge("Минск", "Витебск");
//        cityGraph.addEdge("Минск", "Полоцк");
//        cityGraph.addEdge("Минск", "Киев");
//        cityGraph.addEdge("Киев", "Ростов-на-Дону");
//        cityGraph.addEdge("Киев", "Гомель");
//        cityGraph.addEdge("Ростов-на-Дону", "Казань");
//        cityGraph.addEdge("Казань", "Алматы");
//
//        System.out.println(cityGraph);
//
//        showPath("Екатеринбург", "Витебск", cityGraph);

//=================================================

        WeightedGraph<String> cityGraph2 = new WeightedGraph<>(
                List.of("Екатеринбург", "Москва", "Санкт-Петербург", "Минск", "Киев", "Ростов-на-Дону", "Казань",
                        "Гомель", "Витебск", "Полоцк", "Алматы"));

        cityGraph2.addEdge("Екатеринбург", "Москва", 5000);
        cityGraph2.addEdge("Екатеринбург", "Казань", 720);
        cityGraph2.addEdge("Екатеринбург", "Алматы", 1900);
        cityGraph2.addEdge("Москва", "Санкт-Петербург", 703);
        cityGraph2.addEdge("Москва", "Минск", 719);
        cityGraph2.addEdge("Москва", "Киев", 862);
        cityGraph2.addEdge("Москва", "Ростов-на-Дону", 1077);
        cityGraph2.addEdge("Москва", "Гомель", 660);
        cityGraph2.addEdge("Москва", "Казань", 5000);
        cityGraph2.addEdge("Санкт-Петербург", "Витебск", 628);
        cityGraph2.addEdge("Санкт-Петербург", "Минск", 790);
        cityGraph2.addEdge("Минск", "Гомель", 310);
        cityGraph2.addEdge("Минск", "Витебск", 291);
        cityGraph2.addEdge("Минск", "Полоцк", 225);
        cityGraph2.addEdge("Минск", "Киев", 570);
        cityGraph2.addEdge("Киев", "Ростов-на-Дону", 953);
        cityGraph2.addEdge("Киев", "Гомель", 260);
        cityGraph2.addEdge("Ростов-на-Дону", "Казань", 1451);
        cityGraph2.addEdge("Казань", "Алматы", 3181);

        System.out.println(cityGraph2);


        showShortestPath("Екатеринбург", "Минск", cityGraph2);
    }

    private static void showShortestPath(String from, String to, WeightedGraph<String> cityGraph2) {
        WeightedGraph.DijkstraResult result = cityGraph2.dijkstra(from);

        Map<String, Double> nameDistance = cityGraph2
                .distanceArrayToDistanceMap(result.distances);

        System.out.printf("Дистанции из %s\n", from);
        nameDistance
                .forEach((name, distance) -> System.out.println(name + " : " + distance));

        System.out.printf("\nМаршрут из %s в %s\n", from, to);
        List<WeightedEdge> path = WeightedGraph.pathMapToPath(
                cityGraph2.indexOf(from),
                cityGraph2.indexOf(to),
                result.pathMap);

        cityGraph2.printWeightedPath(path);
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
            System.out.printf("Your path(BFS) getFrom %s getTo %s looks like this:\n%s\n", from, to, path);
        } else {
            System.out.printf("No way, you can't go getTo %s getFrom %s\n", to, from);
        }

        if (dfsResult.isPresent()) {
            List<String> path = Search.Node.nodeToPath(dfsResult.get());
            System.out.printf("Your path(DFS) getFrom %s getTo %s looks like this:\n%s\n", from, to, path);
        } else {
            System.out.printf("No way, you can't go getTo %s getFrom %s\n", to, from);
        }


    }
}