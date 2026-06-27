class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res= new ArrayList<>();
        int n=p.length();
        int m=s.length();
        if(n>m){
            return res;
        }
        int[] freq=new int[26]; // freq of char in p
        int[] win=new int[26]; // freq of char in s 
        
        for(int i=0;i<n;i++)    {  

            freq[p.charAt(i)-'a']++; //p char freq
            win[s.charAt(i)-'a']++; //s char freq and original win 
        }

        if(Arrays.equals(freq,win)) { 
            res.add(0);
        }

        int left=0;
        for(int j=n; j<m; j++) {  
            win[s.charAt(j)-'a']++;
            win[s.charAt(left)-'a']--;
            left++;

            if(Arrays.equals(freq,win)) {
                res.add(left);
            }
        }
        return res;
    }
}