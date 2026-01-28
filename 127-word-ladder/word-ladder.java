class Solution {

    List<String> getn(String word, HashSet<String> hash) {
        List<String> l = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i))
                    continue;

                String newword = word.substring(0, i) + ch + word.substring(i + 1);

                if (hash.contains(newword)) {
                    l.add(newword);
                }
            }
        }
        return l;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> hash = new HashSet<>(wordList);
        if (!hash.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        hash.remove(beginWord); // remove directly

        int level = 0;

        while (!q.isEmpty()) {
            int curlevel = q.size();

            for (int i = 0; i < curlevel; i++) {
                String node = q.poll();

                if (node.equals(endWord))
                    return level + 1;

                List<String> neigh = getn(node, hash);

                for (String word : neigh) {
                    q.offer(word);
                    hash.remove(word); // mark visited
                }
            }
            level++;
        }

        return 0; // important
    }
}
