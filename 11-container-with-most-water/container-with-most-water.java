class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int p = n - 1;
        int maxx = 0;
        int i = 0;

        while (i < p) {

            int h = Math.min(height[i], height[p]);
            int width = p - i;
            int area = h * width;
            maxx = Math.max(maxx, area);

            if (height[i] < height[p]) {
                i++;
            } else {
                p--;
            }
        }

        return maxx;
    }
}