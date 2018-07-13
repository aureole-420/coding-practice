package algorithm_HashTable;
import java.util.*;


// 做前：首先我知道：只要是分数，无限位的必定有循环节 （没有循环节就成irrational number了）

// 做中： 想的很复杂，ing没有想透彻；环的处理没想清楚

// 做后： 答案so nb！！！
// 1. 正负号
// 2. 整数部分和分数部分 分开处理
// 3. hashmap存数字和string中的index
// 4. 再次遇到循环节的第一个数字时回溯到第一次该数字出现的index并insert "(". e.g 72.123 456 456, 在第二4出现时
//https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution
public class LeetCode166_medium_FractionToRecurringDecimal {
	

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
        		return "0";
        }
        
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-":"");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // integeral part
        res.append(num / den);
        num = num % den;
        if (num == 0) {
        		return res.toString(); // no fraction part
        }
        
        // fraction part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) { // find end
        		num *= 10;
        		res.append(num / den);
        		num = num % den;
        		if (map.containsKey(num)) { // found the cycle
        			int index = map.get(num);
        			res.insert(index, "(");
        			res.append(")");
        			break;
        		} else {
        			map.put(num, res.length());
        		}
        }
        
        return res.toString();
    }
    

}
