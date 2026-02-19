class Solution {
    public boolean equationsPossible(String[] equations) {

        char parent[] = new char[26];
        int rank[] = new int[26];

        for(int i = 0; i < 26; i++){
            parent[i] = (char)('a' + i);
            rank[i] = 0;
        }

        // Step 1: Process all ==
        for(String str : equations){
            if(str.charAt(1) == '='){
                union(str.charAt(0), str.charAt(3), parent, rank);
            }
        }

        // Step 2: Process all !=
        for(String str : equations){
            if(str.charAt(1) == '!'){
                char pa = find(str.charAt(0), parent);
                char pb = find(str.charAt(3), parent);
                if(pa == pb){
                    return false;   // contradiction found
                }
            }
        }

        return true;
    }

    public static char find(char a, char parent[]){
        int idx = a - 'a';
        if(parent[idx] == a){
            return a;
        }
        parent[idx] = find(parent[idx], parent);
        return parent[idx];
    }

    public static void union(char a, char b, char parent[], int rank[]){
        char pa = find(a, parent);
        char pb = find(b, parent);

        if(pa == pb) return;

        int ia = pa - 'a';
        int ib = pb - 'a';

        if(rank[ia] > rank[ib]){
            parent[ib] = pa;
        }
        else if(rank[ia] < rank[ib]){
            parent[ia] = pb;
        }
        else{
            parent[ia] = pb;
            rank[ib]++;
        }
    }
}
