public class Five {

    public static int multiply(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return multiplyByAdd(max, min);
    }

    public static int multiplyByAdd(int max, int min) {
        int mask = 1;
        int carryOver = (min & mask) == 0 ? 0 : max;

        int nextMultiplier = min >> 1;
        if(nextMultiplier == 0) {
            return carryOver;
        } else {
            int prevRes = (multiplyByAdd(max, nextMultiplier) << 1);
            return prevRes + carryOver;
        }
    }

    public static void main(String[] args){
        int a = 100;
        int b = 20;
        System.out.println("result: " + multiply(a, b));
    }
}