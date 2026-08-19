class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // row -> reserved seats
        for (int i = 0; i < reservedSeats.length; i++) {

            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            if (!map.containsKey(row)) {
                map.put(row, new ArrayList<>());
            }

            map.get(row).add(seat);
        }

        // Completely empty rows
        int ans = (n - map.size()) * 2;

        for (int row : map.keySet()) {

            List<Integer> seats = map.get(row);
            Collections.sort(seats);
            boolean left = true;
            boolean right = true;
            boolean mid = true;
            for (int c : seats) {
                if (c >= 2 && c <= 5)
                    left = false;
                if (c >= 4 && c <= 7)
                    mid = false;
                if (c >= 6 && c <= 9)
                    right = false;
            }
            int count = 0;
            if (left && right) {
                count = 2;
            } else if (left || right || mid) {
                count = 1;
            } else {
                count = 0;
            }

            ans += count;
        }

        return ans;
    }
}