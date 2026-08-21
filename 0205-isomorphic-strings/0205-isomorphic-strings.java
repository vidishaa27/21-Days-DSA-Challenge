class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(sTot.containsKey(c1)) {
                if(sTot.get(c1) != c2)
                    return false;
            } else sTot.put(c1, c2);

            if(tTos.containsKey(c2)) {
                if(tTos.get(c2) != c1)
                    return false;
            } else tTos.put(c2, c1);
        }
        return true;
    }
}