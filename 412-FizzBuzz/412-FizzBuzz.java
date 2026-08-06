// Last updated: 8/6/2026, 10:01:19 AM
1class Solution {
2    public List<String> fizzBuzz(int n) {
3        List<String> response = new ArrayList<>();
4        for(int i = 1 ; i <= n ; i ++){
5            if(i % 3 == 0 && i % 5 == 0){
6                response.add("FizzBuzz");
7            }else if(i % 3 == 0){
8                response.add("Fizz");
9            }else if(i % 5 == 0){
10                response.add("Buzz");
11            }else{
12                response.add(String.valueOf(i));
13            }
14        }
15        return response;
16    }
17}