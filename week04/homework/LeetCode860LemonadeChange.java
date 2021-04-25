/**
 * @author songshiyu 柠檬水找零问题
 * @date 2021/4/24 10:22
 **/
public class LeetCode860LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0 || bills[0] > 5) {
            return false;
        }
        int count5 = 0, count10 = 0;
        for (int i = 1; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;
            } else if (bills[i] == 10) {
                if (count5 < 1) {
                    return false;
                }
                count10++;
                count5--;
            } else {
                if ((count5 >= 1 && count10 >= 1)) {
                    count10--;
                    count5--;
                } else if (count5 >= 3) {
                    count5 -= 3;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
