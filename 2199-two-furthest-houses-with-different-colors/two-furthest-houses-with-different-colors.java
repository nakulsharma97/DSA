class Solution {
    public int maxDistance(int[] colors) {
    int n = colors.length;
    int maxx = 0;

    for (int i = 0; i < n; i++) {
        if (colors[i] != colors[0]) {
            maxx = Math.max(maxx, i);
        }
        if (colors[i] != colors[n - 1]) {
            maxx = Math.max(maxx, n - 1 - i);
        }
    }
    return maxx;
}
}