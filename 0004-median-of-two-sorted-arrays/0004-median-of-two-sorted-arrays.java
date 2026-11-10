class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Ensure nums1 is the smaller array (so binary search runs on it)
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;        // partition in nums1
            int cut2 = (n1 + n2 + 1) / 2 - cut1; // partition in nums2

            int left1  = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2  = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Valid partition found
            if (left1 <= right2 && left2 <= right1) {

                // If total number of elements is odd
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // If total number is even
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }
            else if (left1 > right2) {
                // Move left
                high = cut1 - 1;
            }
            else {
                // Move right
                low = cut1 + 1;
            }
        }

        return 0.0;  // should never reach here
    }
}