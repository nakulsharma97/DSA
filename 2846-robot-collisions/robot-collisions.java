class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer indexes[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i; // 1 ,2 ,3 ,4 
        }
        // 2 ,4 = negative (no swap) 
        // 4 , 2 = swap , positive
        Arrays.sort(indexes, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                // increasing order 
                // neg or 0 , no swapping ;
                // positive , swap ;
                return positions[a] - positions[b];
            }
        });
        List<Integer> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int index : indexes) {
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else {
                if(stack.isEmpty()){
                    stack.push(index) ;
                }
                boolean isSurvived = true;
                while (!stack.isEmpty()) {
                    int node = stack.peek();
                    if (directions.charAt(node) == 'L') {
                        isSurvived = true;
                        break;

                    } else if (healths[node] > healths[index]) {
                        isSurvived = false;
                        healths[node] -= 1 ;
                        healths[index] = 0;
                        break ;
                    }
                    else if (healths[node] < healths[index]) {
                        isSurvived = true;
                        healths[node] = 0 ;
                        stack.pop() ;
                        healths[index] -= 1;
                      
                    }
                    else {
                        isSurvived = false ;
                        healths[node] = 0 ;
                        healths[index] = 0 ;
                        stack.pop() ;
                        break ;

                    }
                }
                if (isSurvived) {
                    stack.push(index); // left ddirection 
                }
            }
        }
        for(int i = 0 ;i < n ;i++){
            if(healths[i] > 0){
                res.add(healths[i]) ;
            }
        }
return res ;
    }
}