import java.util.*;

class Solution {
    
    class DSU {
        int[] parent;
        
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        
        int id = 0;
        
        // Step 1: assign IDs
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                
                emailToName.put(email, name);
            }
        }
        
        // Step 2: Union-Find
        DSU dsu = new DSU(id);
        
        for (List<String> acc : accounts) {
            int firstId = emailToId.get(acc.get(1));
            
            for (int i = 2; i < acc.size(); i++) {
                dsu.union(firstId, emailToId.get(acc.get(i)));
            }
        }
        
        // Step 3: Group emails by root
        Map<Integer, List<String>> groups = new HashMap<>();
        
        for (String email : emailToId.keySet()) {
            int root = dsu.find(emailToId.get(email));
            
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }
        
        // Step 4: Build result
        List<List<String>> result = new ArrayList<>();
        
        for (List<String> emails : groups.values()) {
            Collections.sort(emails);
            
            String name = emailToName.get(emails.get(0));
            
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            
            result.add(account);
        }
        
        return result;
    }
}