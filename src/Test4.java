import java.util.Arrays;
class Tool {
    public String str;

    public Tool() {
    }

    ;

    //判断字符串是否全为数字
    public Boolean isNumber(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < '0' || array[i] > '9') {
                return false;
            }
        }
        return true;
    }

    //判断是否全是大写字母
    public Boolean isCapital(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 65 || array[i] > 90) {
                return false;
            }
        }
        return true;
    }

    //是否全是小写英文字母
    public Boolean isLowercase(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 97 || array[i] > 122) {
                return false;
            }
        }
        return true;
    }

    //如果字符串全是字母，将其中所有小写字母转换为大写字母
    public void transformCapital(String str) {
        char[] array = str.toCharArray();
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > '0' && array[i] < '9') {
                flag = false;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= 97 && array[i] <= 122) {
                    array[i] = (char) (array[i] - 32);
                }
            }
            System.out.println(array);
        }
    }

    //如果字符串全是数字组成，则按照数字大小升序排序并装入整型数组中,最后按升序打印出该数组
    public void sortNumber(String str) {
        int[] array2 = new int[7];
        char[] array = str.toCharArray();
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > '9' || array[i] < '0') {
                flag = false;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i] - 48;
            }
            Arrays.sort(array2);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array2[i]);
            }
            System.out.println();
        }
    }

    //如果字符串全是字母组成，则按照字母排序装入字符数组中，并按字母顺序打印出该该数组
    public void sortWord(String str) {
        char[] array = str.toCharArray();
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > '0' && array[i] < '9') {
                flag = false;
                break;
            }
        }
        if (flag) {
            Arrays.sort(array);
            System.out.println(array);
        }
    }
}
public class Test4 {
    public static void main(String[] args) {
        String str = "acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi";
        String[] strings = str.split(",");
        Tool tool = new Tool();

        System.out.println("判断是否全为数字--------");
        for(int i = 0; i < strings.length; i++){
            System.out.println(tool.isNumber(strings[i]));
        }

        System.out.println("判断是否全为大写英文字母------");
        for(int i = 0; i < strings.length; i++) {
            System.out.println(tool.isCapital(strings[i]));
        }

        System.out.println("判断是否全为小写英文字母-------");
        for(int i = 0; i < strings.length; i++) {
            System.out.println(tool.isLowercase(strings[i]));
        }

        System.out.println("将小写的英文字母转换成大写------------");
        for(int i = 0; i < strings.length; i++) {
            tool.transformCapital(strings[i]);
        }

        System.out.println("将全为数字的按照升序装入整型数组中------------");
        for(int i = 0; i < strings.length; i++) {
            tool.sortNumber(strings[i]);
        }

        System.out.println("将全为字母的按照其顺序打印----------");
        for(int i = 0; i < strings.length; i++) {
            tool.sortWord(strings[i]);
        }
    }
}
