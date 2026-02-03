class Solution {

    // DFS to find path product from current -> target
    public double dfs(
            String curr,
            String target,
            double product,
            HashSet<String> visited,
            HashMap<String, HashMap<String, Double>> graph) {

        // base case
        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (String neighbor : graph.get(curr).keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(
                        neighbor,
                        target,
                        product * graph.get(curr).get(neighbor),
                        visited,
                        graph);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Build graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] result = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                result[i] = dfs(start, end, 1.0, visited, graph);
            }
        }

        return result;
    }
}
