package CodeWars;

import java.util.Stack;

public class CodeWarsStrings {

    /**
     * Encode string, if one letter found > 1 ")", else "("
     * @param str any string
     * @return encoded string
     */
    public static String encode(String str){
        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] letters = str.toCharArray();
        for(int i = 0; i < letters.length; i++){
            char tmp = letters[i];
            if(str.chars().mapToObj(item ->(char)item).filter(x -> x.equals(tmp)).count() > 1)
                sb.append(")");
            else
                sb.append("(");
        }
        return sb.toString();
    }

    /**
     * Find length of the shortest word in string
     * @param string any string
     * @return length of the shortest word
     */
    public static int shortestWord (String string){
        String[] str = string.split(" ");
        int min = str[0].length();
        for(int i = 1; i < str.length; i++){
            if(min > str[i].length())
                min = str[i].length();
        }
        return min;
    }

    /**
     * Checks if braces are in right positions
     * @param str any string with braces
     * @return true if valid, false if isn't valid
     */
    public static boolean isValidBraces(String str){
        Stack stack = new Stack();
        char[] braces = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            if(braces[i] == '(' || braces[i] == '{' || braces[i] == '[') {
                stack.push(braces[i]);
            } else if(stack.empty())
                return false;
            else if(braces[i] == ')'){
                if(stack.peek().equals('('))
                    stack.pop();
                else
                    return false;
            } else if(braces[i] == '}'){
                if(stack.peek().equals('{'))
                    stack.pop();
                else
                    return false;
            } else if(braces[i] == ']'){
                if(stack.peek().equals('['))
                    stack.pop();
                else
                    return false;
            }
        }
        if(!stack.empty())
            return false;
        return true;
    }

    /**
     * Checks if string is isogram
     * @param str any string
     * @return true if isogram, false if it isn't
     */
    public static boolean isIsogram(String str){
        String s = str.toLowerCase();
        if(str == null)
            return true;
        System.out.println(str);
        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j < str.length(); j++){
                System.out.println(i + " " + j);
                System.out.println(s.charAt(i) + " " + s.charAt(j));
                if(s.charAt(i) == s.charAt(j))
                    return false;
            }
        }
        return true;
    }

    /**
     * Converts string to camel case
     * @param str any string
     * @return string in camel case
     */
    public static String toCamelCase(String str){
        StringBuilder sb = new StringBuilder();
        String[] s = str.split("-|_");
        sb.append(s[0]);
        for(int i = 1; i < s.length; i++) {
            s[i] = s[i].substring(0, 1).toUpperCase() + s[i].substring(1);
            sb.append(s[i]);
        }
        return sb.toString();
    }

    /**
     * Counts 'a', 'e', 'i', 'o', 'u' in string
     * @param str any string
     * @return number of this letters in string
     */
    public static int getCount(String str) {
        return (int) str.chars()
                .mapToObj(item -> (char) item)
                .filter(x -> x.equals('a') || x.equals('e') || x.equals('i') || x.equals('o') || x.equals('u'))
                .count();
    }

    public static void main(String[] args) {
        String str = "Success";
        System.out.println(encode(str));
        //System.out.println(shortestWord(str));
        //System.out.println(getCount(str));
        //System.out.println(isValidBraces(str));
        //String str = "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
        //System.out.println(isIsogram(str));
        //System.out.println(toCamelCase(str));
    }
}
