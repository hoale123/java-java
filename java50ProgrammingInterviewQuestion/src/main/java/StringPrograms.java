public class StringPrograms {

    public static void main(String[] args) {

        String str = "123";
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        if (str == null)
            throw new IllegalArgumentException("Null is not valid input");

        StringBuilder out = new StringBuilder();

        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--)
            out.append(chars[i]);

        return out.toString();
    }
}
