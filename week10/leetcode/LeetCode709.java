/**
 * @description: 709. 转换成小写字母
 * @create: 2021/5/31 09:23:14
 **/
public class LeetCode709 {

    public String toLowerCase(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                charArray[i] -= 32;
            }
        }
        return new String(charArray);
    }
}
