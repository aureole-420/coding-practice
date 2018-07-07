package algorithm_HashTable;
import java.util.*;
// 这题并没有什么思路，但是出现频率非常高！！！

// 做中： 看了官方答案：
//https://leetcode.com/problems/encode-and-decode-tinyurl/solution/
// 套路都是一样的： longurl -> key -> shorturl; put(key, longurl); parse shorturl to key; map.get(key)  -> get long url
// 1. simple counter: HashMap count -> url 
// 2.
// 3. 系统自带的hashcode -- 会有hash collision （这时候会fail） -- 可以检测如果有冲突的话就随机生成一个数作为hashcode。

// 上面几种基本都有limited by the range of int.

// 5. fixed-length encoding.
// 构造6位key的随机产生器，随机产生6个62个字符中的某一个； 生成key后判断key有没有重复，重复的话换一个key。
// （10+26*2)^6个url
public class LeetCode535_medium_EncodeAndDecodeTinyURL {
	
	// <hashcode, longUrl>
	HashMap<Integer, String> map = new HashMap<>();
	public String encode(String longUrl) {
		int key = longUrl.hashCode();
		map.put(key, longUrl);
		return "http://tinyurl.com/"+key;
	}
	
	public String decode(String shortUrl) {
		int key = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
		return map.get(key);
	}
}
