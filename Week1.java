// Assign Cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int c=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0;c<g.length && i<s.length;++i){
            if (g[c]<=s[i]){
                c++;
            }
        }
        return c;
    }
}

// Buy 2 Chocolates
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return prices[0]+prices[1] > money ? money : money-(prices[0]+prices[1]);
    }
}

// Count Elements with Maximum Frequency
class Solution {
    public int maxFrequencyElements(int[] nums) {
       HashMap<Integer,Integer> d=new HashMap<>();
       for(int v: nums){
           d.put(v,d.getOrDefault(v,0)+1);
       }
       int m=0;
       for(Map.Entry<Integer,Integer> v:d.entrySet()){
           if(m<v.getValue()) m=v.getValue();
       }
       int c=0;
       for(Map.Entry<Integer,Integer> v:d.entrySet()){
           if(m==v.getValue()) c+=m;
       }
       return c;
    }
}
// Divide Array into Arrays with Max Difference
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans=new int[nums.length/3][3];
        for(int i=0;i<nums.length;i+=3){
            if(nums[i+1]-nums[i] > k || nums[i+2]-nums[i+1] > k || nums[i+2]-nums[i] > k) return new int[][]{};
            ans[i/3]=new int[]{nums[i],nums[i+1],nums[i+2]};
        }
        return ans;
    }
}
