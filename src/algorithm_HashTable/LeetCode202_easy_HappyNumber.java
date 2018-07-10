package algorithm_HashTable;

// 做前:感觉好简单，尼玛写完helper函数后傻逼了， 难道不会无限循环？

// 做中：看了答案，前两个very presumptious 第三个好
// 这题关键是无论如何，不断的square sum，一定会有loop
// https://leetcode.com/problems/happy-number/discuss/56919/Explanation-of-why-those-posted-algorithms-are-mathematically-valid/153170

// 如果loop在1上，loopsize是1，不是1的话size更大。 --- 无论如何总会出现重复。不会无限增长地循环。

// sol1: 简单判断
// 迭代过程中出现1， return true
// 迭代过程中出现重复 -- 找到循环， return false 

// sol2: 类似 linked list cycle II
// 用快慢指针
public class LeetCode202_easy_HappyNumber {

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (true) {
        		slow = sumOfSquareDigits(slow);
        		fast = sumOfSquareDigits(fast);
        		fast = sumOfSquareDigits(fast);
        		
        		if (slow == fast) {
        			break;
        		}
        }
        
        return slow == 1;
    }
    
    private int sumOfSquareDigits(int num) {
    		int sum = 0;
    		while (num > 0) {
    			int digit = num % 10;
    			sum += digit * digit;
    			num = num / 10;
    		}
    		
    		return sum;
    }
}
