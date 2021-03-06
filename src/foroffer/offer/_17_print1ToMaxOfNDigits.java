package foroffer.offer;

/**
 * offer 17. 打印从1到最大的n位数
 * 思路很直接：可以把一个函数拆分为三个函数各自做自己的事
 * 1. main；2. increment给数组加一并返回是否达到边界；3. 打印数组数字
 */
public class _17_print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits(int n){
        if (n <= 0) return;
        char[] number = new char[n];

        while (!increment(number)){
            printNumber(number);
        }
    }

    public boolean increment(char[] number){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) nSum++;
            if (nSum >= 10){
                if (i == 0){
                    isOverflow = true;
                } else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char)('0' + nSum);
                }
            } else{
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    public void printNumber(char[] number){
        boolean isBeginning0 = true;
        for (char c : number) {
            if (isBeginning0 && c != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}
