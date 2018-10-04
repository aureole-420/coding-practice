package bit_manipulation;

public class Fundamentals {



    // number a
    // 原码  |a| binary
    // 反码  ～|a|
    // 补码  ～\a\ + 1
    // 5 =>  0101
    // ~5 =>1111 .. 1010,  ~5+1 => 111....1011
    // -5 => 1111 ... 1011
    public static void main(String[] args) {

        int a = 10; // 00001010
        int b = 38; // 00100110

        System.out.println(a & b); // 00000010
        System.out.println(a | b); // 00101110 = 32+2+4+8 = 46
        System.out.println(a ^ b); // 00101100 = 32 +4+8 = 44  异或 别称 不进位加法
        System.out.println(~a); //1111....0101 = -11,   11 =1011, ~11 0100 , ~11+1 = 0101
        System.out.println(Integer.toBinaryString(~100 ));
        System.out.println(Integer.toBinaryString(-101));
        // ~n == -n - 1

        // 1 << 2   0001 => 0100  4
        // 正数 向左移动n位就是 multiply 2^n
        System.out.println(1 << 2);
        System.out.println(a << 1); // 00010100, 16+4
        System.out.println(a << 4); // 00010100, 10 * 16


        //向右移动 前面补0
        System.out.println(10 >> 1); // 0101
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(10 >> 1));
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10 >> 1) + " " + (-10 >> 1));
        System.out.println(Integer.toBinaryString(-10 >>> 1) + " " + (-10 >>> 1));

        System.out.println("test case 3");
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10 >>> 10) + " :: " + Integer.toBinaryString(-1100 << 30));


        System.out.println(Integer.toBinaryString((1 << 5) - 1) + " :: " + (1 << 2 - 1));

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1 << 25));
        System.out.println(Integer.toBinaryString((-1 << 25) >>> 27));
        int x  = 111;

        // n least significant bits
        System.out.println(x + "::" + Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(x & (int)((1L << 3) -1)));

        // the nth least signifcant BIT
        System.out.println(x + "::" + Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString((x >> 3)));
        System.out.println(Integer.toBinaryString((x >> 3) & 1));


    }
}
