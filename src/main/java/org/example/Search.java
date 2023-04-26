package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Search {

    /**
     * @param sortedArr - Should be sorted in ascending order
     * @param toFind    - What need getTo find
     * @return - index in sortedArr if exist and -1 if not exist
     */
    public static int binarySearch(int[] sortedArr, int toFind) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            int position = (left + right) / 2;
            int current = sortedArr[position];

            if (current == toFind)
                return position;
            else if (current < toFind)
                left = position + 1;
            else
                right = position - 1;
        }
        return -1;
    }


    /**
     * @param source
     * @param goal
     * @param successors
     * @return
     */
    public static <T> Optional<Node<T>> breadthFirstSearch(T source, Predicate<T> goal, Function<T, List<T>> successors) {
        Queue<Node<T>> toExplore = new LinkedList<>();
        Set<T> explored = new HashSet<>();

        toExplore.offer(new Node<>(source, null));
        explored.add(source);

        while (!toExplore.isEmpty()) {
            Node<T> currentNode = toExplore.poll();
            T currentState = currentNode.state;

            if (goal.test(currentState)) return Optional.of(currentNode);

            for (T child : successors.apply(currentState)) {
                if (explored.contains(child)) continue;

                explored.add(child);
                toExplore.offer(new Node<>(child, currentNode));
            }
        }
        return Optional.empty();
    }


    /**
     * @param source
     * @param goal
     * @param successors
     * @return
     */
    public static <T> Optional<Node<T>> depthFirstSearch(T source, Predicate<T> goal, Function<T, List<T>> successors) {
        Stack<Node<T>> frontier = new Stack<>(); //what will we need checking
        frontier.push(new Node<>(source, null));
        Set<T> explored = new HashSet<>(); //what we already checked
        explored.add(source);

        while (!frontier.isEmpty()) {
            Node<T> currentNode = frontier.pop();
            T currentState = currentNode.state;

            if (goal.test(currentState)) return Optional.of(currentNode);

            for (T child : successors.apply(currentState)) {
                if (explored.contains(child)) continue;

                explored.add(child);
                frontier.push(new Node<>(child, currentNode));
            }
        }
        return Optional.empty();
    }

    public static class Node<T> {
        final T state;
        Node<T> parent;

        Node(T state, Node<T> parent) {
            this.state = state;
            this.parent = parent;
        }

        public static <T> List<T> nodeToPath(Node<T> node) {
            List<T> path = new ArrayList<>();
            path.add(node.state);
            while (node.parent != null) {
                node = node.parent;
                path.add(0, node.state);
            }
            return path;
        }
    }
}


