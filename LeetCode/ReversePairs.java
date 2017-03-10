class ReversePairs {
    private class Res{
        public int[] nums;
        public int pairs;

        Res(int[] nums, int pairs){
            this.nums = nums;
            this.pairs = pairs;
        }
    }
    public Res merge(Res res1, Res res2) {
        int[] a = res1.nums;
        int[] b = res2.nums;
        int[] res = new int[a.length + b.length];
        int pairs = res1.pairs + res2.pairs;
        int i = 0, j = 0, count = 0;

        for(int x=0; x<a.length; x++){
            for(int y=0; y<b.length; y++){
                if(a[x] / 2.0 > b[y]){
                    pairs += 1;
                }
            }
        }

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[count] = a[i++];
            } else {
                res[count] = b[j++];
            }
            count++;
        }
        while (i < a.length) {
            res[count] = a[i++];
        }
        while (j < b.length) {
            res[count] = b[j++];
        }
        System.out.println("----------------");
        System.out.print(res1.pairs+" | ");showArray(res1.nums);
        System.out.print(res2.pairs+" | ");showArray(res2.nums);
        System.out.println(pairs);
        System.out.println("----------------");
        return new Res(res, pairs);
    }

    public Res mergeSort(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (start == end) {
            int[] res = new int[1];
            res[0] = nums[start];
            return new Res(res, 0);
        } else {
            return merge(mergeSort(nums, start, mid), mergeSort(nums, mid + 1, end));
        }
    }

    public int reversePairs(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Res res = mergeSort(nums, 0, nums.length - 1);
//        showArray(res.nums);
        return res.pairs;
    }

    public void showArray(int[] n){
        for(int i=0; i<n.length; i++){
            System.out.print(n[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReversePairs sol = new ReversePairs();

//        int[] input = {2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        int[] input = {1, 3, 2, 3, 1};

        System.out.println(sol.reversePairs(input));
    }
}