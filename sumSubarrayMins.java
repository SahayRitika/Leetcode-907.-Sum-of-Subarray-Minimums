class Solution {
    public int sumSubarrayMins(int[] arr) {
         int res = 0;
        Stack<Integer> st = new Stack<>();
        long mod = (long) 1e9 + 7;

        for (int right = 0; right <=arr.length; right++) {
            int curr = right == arr.length ? Integer.MIN_VALUE : arr[right];
            while(!st.isEmpty() && curr < arr[st.peek()]){
                int main = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                long add = ((main - pse) * (right - main) * (long)arr[main]) % mod;
                res += add;
                res %= mod;
            }
            st.push(right);
        }
        return res;
    }
}
