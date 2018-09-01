package facebook;

public class LeetCode273_hard_IntegerToEnglishWords {

    public String numberToWords(int num) {
        if (num == 0) {
            return "zero";
        }
        int billionPart = num / ((int) (Math.pow(10, 9)));
        int millionPart = ( num % ((int) (Math.pow(10, 9))) )/ ((int) (Math.pow(10, 6)));
        int thousandPart = (num  % ((int) (Math.pow(10, 6))) ) / ((int) (Math.pow(10, 3)));
        int belowThousand = num %  ((int) (Math.pow(10, 3)));

        StringBuilder sb = new StringBuilder();
        if (billionPart > 0) sb.append(convert(billionPart) + "Billion ");
        if (millionPart > 0) sb.append(convert(millionPart) + "Million ");
        if (thousandPart > 0) sb.append(convert(thousandPart) + "Thousand ");
        sb.append(convert(belowThousand));
        return sb.toString().trim();
    }

    // below 1000
    private String convert(int num) {
        StringBuilder sb = new StringBuilder();
        int hundreds = num / 100;
        if (hundreds != 0) {
            sb.append(unitToString(hundreds) + "Hundred ");
        }
        num = num % 100;
        if (num < 10) {
            sb.append(unitToString(num));
        } else if (num < 20) {
            String temp = "";
            switch (num) {
                case 10 : temp = "Ten "; break;
                case 11 : temp = "Eleven "; break;
                case 12 : temp = "Twelve "; break;
                case 13 : temp = "Thirteen "; break;
                case 14 : temp = "Fourteen "; break;
                case 15 : temp = "Fifteen "; break;
                case 16 : temp = "Sixteen "; break;
                case 17 : temp = "Seventeen "; break;
                case 18 : temp = "Eighteen "; break;
                case 19 : temp = "Nineteen "; break;
                default : temp = "error tens digit 1::"+num; break;
            }
            sb.append(temp);
        } else { // 20 - 99
            int tens = num / 10;
            String temp = "";
            switch (tens) {
                case 2: temp = "Twenty "; break;
                case 3: temp = "Thirty "; break;
                case 4: temp = "Forty "; break;
                case 5: temp = "Fifty "; break;
                case 6: temp = "Sixty "; break;
                case 7: temp = "Seventy "; break;
                case 8: temp = "Eighty "; break;
                case 9: temp = "Ninety "; break;
                default : temp = "error tens digit over 2:: " + num; break;
            }
            sb.append(temp);

            num = num % 10; // unit digit
            sb.append(unitToString(num));
        }

        return sb.toString();
    }

    // 1-9
    private String unitToString(int num) {
        switch (num) {
            case 0 : return "";
            case 1 : return "One ";
            case 2 : return "Two ";
            case 3 : return "Three ";
            case 4 : return "Four ";
            case 5 : return "Five ";
            case 6 : return "Six ";
            case 7 : return "Seven ";
            case 8 : return "Eight ";
            case 9 : return "Nine ";
            default: return "error converting unit::"+num;
        }
    }

    public static void main(String[] args) {
        LeetCode273_hard_IntegerToEnglishWords ite = new LeetCode273_hard_IntegerToEnglishWords();
        System.out.println(ite.numberToWords(123));
        System.out.println(ite.numberToWords(12345));
        System.out.println(ite.numberToWords(1234567));
        System.out.println(ite.numberToWords(123456789));
        System.out.println(ite.numberToWords(1234567891));
    }
}
