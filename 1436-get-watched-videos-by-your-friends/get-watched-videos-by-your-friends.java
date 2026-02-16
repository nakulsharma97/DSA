class Solution {
    class Pair implements Comparable<Pair> {
        String video;
        int freq;

        Pair(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }

        public int compareTo(Pair that) {
            if (this.freq == that.freq) {

                return this.video.compareTo(that.video);
            }
            return this.freq - that.freq;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int curlevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curid = queue.poll();
                for (int friend : friends[curid]) {
                    if (!visited.contains(friend)) {
                        visited.add(friend);
                        queue.offer(friend);
                    }
                }
            }
            curlevel++;
            if (curlevel == level) {
                break;
            }
        }
        HashMap<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {
            int curid = queue.poll();
            for (String video : watchedVideos.get(curid)) {

                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        } 
        

        // all this is CUSTOM SORTING
        List<Pair> sortedvideo = new ArrayList<>();
        for (String video : freq.keySet()) {
            sortedvideo.add(new Pair(video, freq.get(video)));
        }
        Collections.sort(sortedvideo);
        List<String> res = new ArrayList<>();
        for (Pair pair : sortedvideo) {
            res.add(pair.video);
        }
        return res;
    }
}