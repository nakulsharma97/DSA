class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return positions[a] - positions[b];

            }
        });
        List<Integer> res = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
       for(int i : indexes){
            if (directions.charAt(i) == 'R') {
                st.push(i);
            } else {
                if (st.isEmpty()) {
                    st.push(i);
                }
                boolean survive = false;
                while (!st.isEmpty()) {
                    int node = st.peek();
                    if (directions.charAt(node) == 'L') {
                        survive = true;
                        break;

                    }

                    if (healths[node] > healths[i]) {
                        healths[node] -= 1;
                        healths[i] = 0;
                        survive = false;
                        break;
                    } else if (healths[node] == healths[i]) {
                        survive = false;
                        healths[node] = 0;
                        healths[i] = 0;
                        st.pop();
                        break;
                    } else if (healths[node] < healths[i]) {
                        survive = true;
                        healths[i] -= 1;
                        healths[node] = 0;
                        st.pop();

                    }

                }
                if(survive){
                    st.push(i) ;
                }
            }
        }
        for( int i = 0 ;i <n;i++)
    {
        if (healths[i] > 0) {
            res.add(healths[i]);
        }
    }
    return res;
}}