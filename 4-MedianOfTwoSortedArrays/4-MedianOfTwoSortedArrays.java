// Last updated: 7/16/2026, 4:13:47 PM
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];

        for(int i=0; i<nums1.length; i++){
            arr[i] = nums1[i];
        }

        for(int i=0; i<nums2.length; i++){
            arr[i+nums1.length] = nums2[i];
        }

        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }

        if(arr.length%2==0){
            return (double) (arr[arr.length/2-1] + arr[arr.length/2])/2;
        } else {
            return arr[arr.length/2];
        }
    }
}