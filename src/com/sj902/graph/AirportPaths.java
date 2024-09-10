package com.sj902.graph;

import java.util.*;

public class AirportPaths {
    public static List<String> findPaths(List<String> connections) {
        Map<String, String> graph = new HashMap<>();
        Set<String> starts = new HashSet<>();
        Set<String> ends = new HashSet<>();

        // Populate the graph and identify start/end points
        for (String connection : connections) {
            String[] parts = connection.split(" -> ");
            String start = parts[0];
            String end = parts[1];
            graph.put(start, end);
            starts.add(start);
            ends.add(end);
        }

        // Find start points (nodes with no incoming edges)
        starts.removeAll(ends);

        // Build paths
        List<String> paths = new ArrayList<>();
        for (String start : starts) {
            StringBuilder path = new StringBuilder(start);
            String current = start;
            while (graph.containsKey(current)) {
                current = graph.get(current);
                path.append(" -> ").append(current);
            }
            paths.add(path.toString());
        }

        return paths;
    }

    public static void main(String[] args) {
        List<String> connections = Arrays.asList(
                "C -> D",
                "A -> B",
                "E -> F",
                "B -> C",
                "F -> G"
        );

        List<String> result = findPaths(connections);
        for (String path : result) {
            System.out.println(path);
        }
    }
}