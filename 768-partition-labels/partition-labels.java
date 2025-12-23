class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();
        int n = s.length();
        int k[] = new int[26];
        for (int i = 0; i < n; i++) {
            k[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, k[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}