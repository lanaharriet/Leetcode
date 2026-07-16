// Last updated: 7/16/2026, 4:09:07 PM
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int rounded=((purchaseAmount+5)/10)*10;
        return 100-rounded;
        
    }
}