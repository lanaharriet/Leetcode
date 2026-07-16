// Last updated: 7/16/2026, 4:11:46 PM
class Solution {
    public int addDigits(int num) {
        while(num>9){
          int sum=0;
           while(num>0){
            sum=sum+(num%10);
            num=num/10;  
            }
        num=sum;  
        }
        return num;
    }
}