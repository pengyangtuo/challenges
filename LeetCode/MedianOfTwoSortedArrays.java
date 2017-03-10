class MedianOfTwoSortedArrays {

    int getMedianIdxJ(int m, int n, int i) {
        return (m + n)/2 - i;
    }

    int getMedianIdxI(int[] nums1, int[] nums2, int start, int end) {
        int i = (start + end) / 2;
        int j = (nums1.length + nums2.length) / 2 - i;
        if()
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }

        int medianIdxI = getMedianIdxI(nums1, nums2, 0, m);
        int medianIdxJ = getMedianIdxJ(m, n, medianIdxI);

        return (Math.max(nums1[medianIdxI-1], nums2[medianIdxJ-1])
                + Math.min(nums1[medianIdxI], nums2[medianIdxJ])) / 2;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();

        int[] a = {1, 2, 3, 4};
        int[] b = {4, 4, 4};

        System.out.println(sol.findMedianSortedArrays(a, b));
    }
}