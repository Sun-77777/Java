import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution1 {
    public static boolean isValid(String s) {
          if (s == null) {
              return true;
          }  
          if (s.length() == 1) {
              return false;
          }
          Map<Character,Character> map = new HashMap<>();
          map.put('(',')');
          map.put('[',']');
          map.put('{','}');

          Stack<Character> stack = new Stack<>();
          for (int i = 0; i < s.length(); i++) {
              char c = s.charAt(i);
              if (c == '(' || c == '[' || c == '{') {
                  stack.push(c);
                  continue;
              }
              if (stack.isEmpty()) {
                  return false;
              }
              if (c == map.get(stack.pop())) {
                  continue;
              }
              return false;
          }
          if (!stack.isEmpty()) {
              return false;
          }
          return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}