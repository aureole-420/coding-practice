package algorithm_tree;

// 做前：完全没思路

// 做中：看了答案，超屌的DP！！！！
// G(n): # of unique BST sequence of length n
// F(i, n): # of unique BST, with i as root, sequence of length n --- i = 1, ..., n
// 1. init： G(0) = 1, G(1) = 1;
// 2. relation: G(n) = F(1, n) + ... F(n,n)
// 2. relation II: F(i, n) = G(i-1) * G(n-i), 以i为root，那leftsubtree (1, ..., i-1) rightsubtree (i+1, ..., n)

// O(n^3) complexity
public class LeetCode96_medium_UniqueBST {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1; G[1] = 1;
        
        for (int nn = 2; nn <= n; nn++) {
        		G[nn] = 0;
        		// G(nn) = F(1, nn) + ... F(nn,nn)
        		// G(nn) = sum_i F(i, nn) = sum_i G(i-1) * G(nn-i)
        		for (int i = 1; i <= nn; i++) {
        			G[nn] += G[i-1] * G[nn-i];
        		}
        }
        
        return G[n];
    }
}
