package fr.istic.vv;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
            int curlyBraces = 0, squareBrackets = 0, parentheses = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                switch (c) {
                    case '{':
                        curlyBraces++;
                        break;
                    case '}':
                        curlyBraces--;
                        if (curlyBraces < 0) {
                            return false;
                        }
                        break;
                    case '[':
                        squareBrackets++;
                        break;
                    case ']':
                        squareBrackets--;
                        if (squareBrackets < 0) {
                            return false;
                        }
                        break;
                    case '(':
                        parentheses++;
                        break;
                    case ')':
                        parentheses--;
                        if (parentheses < 0) {
                            return false;
                        }
                        break;
                }
            }

            return curlyBraces == 0 && squareBrackets == 0 && parentheses == 0;
        }

}
