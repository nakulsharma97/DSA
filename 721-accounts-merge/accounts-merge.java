class Solution {
    public void dfs(String firstm, HashSet<String> visited, HashMap<String, List<String>> map, List<String> subs) {
        visited.add(firstm);
        subs.add(firstm);
        if (!map.containsKey(firstm)) {
            return;
        }
        for (String neigh : map.get(firstm)) {
            if (!visited.contains(neigh)) {
                dfs(neigh, visited, map, subs);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //  List<List<String>> ll = new ArrayList<>() ; 

        // adj mmap

        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> account : accounts) {
            String firstm = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String currm = account.get(i);
                if (!map.containsKey(firstm)) {
                    map.put(firstm, new ArrayList<>());
                }
                map.get(firstm).add(currm);
                if (!map.containsKey(currm)) {
                    map.put(currm, new ArrayList<>());
                }
                map.get(currm).add(firstm);
            }
        }
        List<List<String>> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for (List<String> account : accounts) {
            String firstm = account.get(1);
            if (!visited.contains(firstm)) {
                List<String> subs = new ArrayList<>();

                dfs(firstm, visited, map, subs);
                Collections.sort(subs);
                subs.add(0, account.get(0));
                res.add(subs);
            }

        }

        return res;
    }

}