package cn.zsza.string;

/**
 * Created by zs on 2017/7/27.
 * 14:46
 * 写一个方法,用"%20"替换掉所有的空格
 */
public class ReplaceBlankOfStr {
    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(replaceBlank(str));
    }

    private static String replaceBlank(String input) {
        if (input == null || input == "")
            return null;
        StringBuffer outputStr = new StringBuffer();
        for (int i=0; i < input.length(); i++){
            if (input.charAt(i) == ' '){
                outputStr.append("%");
                outputStr.append("2");
                outputStr.append("0");
            }else {
                outputStr.append(String.valueOf(input.charAt(i)));
            }
        }
        return new String(outputStr);
    }
}
