package algorithm_ladder_IV;

// leetcode 666, 
// binary tree的另一种形式： 数组
// parent pos = child pos / 2
// left child pos = parent pos *2
// right child pos = parent pos * 2 + 1
public class PathSum_IV {
	class ResultType {
		int pathCnt;
		int sum;
		ResultType(int pC, int s) {
			pathCnt = pC;
			sum = s;
		}
	}
	
    public int pathSum(int[] nums) {
    		// build tree
    		int[] tree = new int[15]; // 2^5-1
    		boolean[] isNode = new boolean[15];
    		for (int i = 0; i < isNode.length; i++) {
    			isNode[i] = false;
    		}
    		
    		for (int num : nums) {
    			int pos = getPosition(num);
    			int val = getValue(num);
    			tree[pos-1] = val;
    			isNode[pos-1] = true;
    		}
    		
    		ResultType res = getSum(1, tree, isNode);
    		return res.sum;
    }
    
    private ResultType getSum(int pos, int[] tree, boolean[] isNode) {
    		// base case 1
    		if (!inTree(pos, isNode)) {
    			return new ResultType(0, 0);
    		}
    		
    		// hase case 2: if leaf
    		if (!inTree(pos*2, isNode) && !inTree(pos*2+1, isNode)) {
    			return new ResultType(1, tree[pos-1]);
    		}
    		
    		ResultType left = getSum(2*pos, tree, isNode);
    		ResultType right = getSum(2*pos+1, tree, isNode);
    		int newPthCnt = left.pathCnt + right.pathCnt;
    		int newSum = left.sum + right.sum + tree[pos-1] * newPthCnt;
    		
    		return new ResultType(newPthCnt, newSum);	
    }
    
    // position 1~15
    private int getPosition(int num) {
    		int hundred = num / 100;
    		int ten = (num- hundred*100) / 10;
    		return (int) (Math.pow(2, hundred-1) + ten-1);
    }
    
    private int getValue(int num) {
    		return num % 10;
    }
    
    private boolean inTree(int pos, boolean[] isNode) {
    		return pos <= 15 && pos >= 1 && isNode[pos-1];
    }
    
    public static void main(String[] args) {
    		int[] nums = new int[] {113, 221};
    		PathSum_IV ps = new PathSum_IV();
    		System.out.println(ps.pathSum(nums));
    }
}
