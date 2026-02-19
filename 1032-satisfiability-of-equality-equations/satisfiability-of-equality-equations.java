class Solution {
    public boolean equationsPossible(String[] equations) {
        char parent[] = new char[26];
        int rank[] = new int[26];
        for(int i =0 ; i<26 ; i++){
            parent[i]=(char)('a'+i);
            rank[i]=0;
        }
        for(String str : equations){
            if(str.charAt(1)=='='){
                union(str.charAt(0) , str.charAt(3), parent , rank);
            }
        }
        for(String str : equations){
            if(str.charAt(1)=='!'){
                char pa = find(str.charAt(0), parent);
                char pb = find(str.charAt(3), parent);
                if(pa==pb){
                    return false;
                }
            }
        }
        return true;
    }
    public static char find(char a , char parent[]){
        if(a==parent[a-'a']){
            return a;
        }
        return parent[a-'a']= find(parent[a-'a'] , parent);
    }
    public static void union(char a , char b , char parent[] , int rank[]){
        char pa  = find(a , parent);
        char pb = find(b , parent);
        
        if(rank[pa-'a']> rank[pa-'a']){
            parent[pb-'a']=pa;
        }else if(rank[pa-'a']< rank[pa-'a']){
             parent[pa-'a']=pb;
        }else{
            parent[pa-'a']=pb;
            rank[pb-'a']++;
        }
    }
}