package foroffer.offer;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class _10_3JumpFloor {
    public int JumpFloor(int target) {
        int a=1,b=2,sum=0;
        if (target<=3) return target;
        while(target>=3){
            sum = a+b;
            a=b;
            b=sum;
            target--;
        }
        return sum;
    }
}
