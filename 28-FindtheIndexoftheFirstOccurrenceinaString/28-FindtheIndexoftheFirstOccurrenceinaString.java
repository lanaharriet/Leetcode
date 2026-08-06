// Last updated: 8/6/2026, 9:15:59 AM
1class Solution {
2    public List<List<Integer>> generate(int numRows) {
3        if (numRows == 0) return new ArrayList<>();
4        if (numRows == 1) {
5            List<List<Integer>> result = new ArrayList<>();
6            result.add(Arrays.asList(1));
7            return result;
8        }
9        
10        List<List<Integer>> prevRows = generate(numRows - 1);
11        List<Integer> newRow = new ArrayList<>();
12        
13        for (int i = 0; i < numRows; i++) {
14            newRow.add(1);
15        }
16        
17        for (int i = 1; i < numRows - 1; i++) {
18            newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
19        }
20        
21        prevRows.add(newRow);
22        return prevRows;
23    }
24}