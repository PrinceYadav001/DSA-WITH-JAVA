import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> bankSet = new HashSet<>();
        for (String s : bank) bankSet.add(s);

        // agar endGene hi bank me nahi hai -> impossible
        if (!bankSet.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(startGene);
        vis.add(startGene);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String cur = q.poll();

                if (cur.equals(endGene)) return steps;

                char[] arr = cur.toCharArray();

                for (int i = 0; i < 8; i++) {
                    char old = arr[i];

                    for (char g : genes) {
                        if (g == old) continue;

                        arr[i] = g;
                        String next = new String(arr);

                        if (bankSet.contains(next) && !vis.contains(next)) {
                            vis.add(next);
                            q.add(next);
                        }
                    }
                    arr[i] = old; // backtrack
                }
            }
            steps++;
        }

        return -1;
    }
}
