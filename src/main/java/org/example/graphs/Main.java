package org.example.graphs;

import java.util.List;

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
    }
}