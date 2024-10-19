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

// Find Common Characters
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> l=new ArrayList<>();
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] a=new int[26];
        for(int i=0;i<words[0].length();i++){
            a[words[0].charAt(i)-'a']++;
        }
        for(int i=1;i<words.length;i++){
            String s=words[i];
            int[] b=new int[26];
            for(int j=0;j<s.length();j++){
               b[s.charAt(j)-'a']++;
            }
            for(int j=0;j<26;j++){
                a[j]=Math.min(a[j],b[j]);
            }
        }
        for(int i=0;i<26;i++){
            while(a[i]>0){
                l.add(((char)(i+'a'))+"");
                a[i]--;
            }
        }
        return l;
    }
}

// Lemonade Change
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] a=new int[3];
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) a[0]++;
            else if(bills[i]==10){
                a[1]++;
                if(a[0] > 0) a[0]--;
                else return false;
            }
            else if(bills[i]==20) {
                a[2]++;
                if(a[0] > 0 && a[1] > 0){
                    a[0]--;
                    a[1]--;
                }
                else if(a[0] >= 3){
                    a[0]-=3;
                }
                else return false;
            }
        }
        return true;
    }
}

// Minimum Common Value
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ans=-1;
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]) {ans=nums1[i];break;}
            if(nums1[i]<nums2[j]) i++;
            else j++;
        }
        return ans;
    }
}

// 3Sum

