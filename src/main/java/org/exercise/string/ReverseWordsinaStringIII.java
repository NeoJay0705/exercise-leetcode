package org.exercise.string;

// 557

public class ReverseWordsinaStringIII {
    public static void main(String[] args) {
        ReverseWordsinaStringIII rwsiii = new ReverseWordsinaStringIII();    
        String[] inputs = new String[] {
                                         "",
                                         "i",
                                         "i am a student.",     
                                       };
        for ( String input : inputs ) {
            System.out.println(rwsiii.reverseWords3(input) + "+");
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int offset = 0;
        for ( int i = 0; i < s.length(); ++i ) {
            if ( s.charAt(i) == ' ' ) {
                sb.append(' ');
                offset = sb.length();
            }
            else {
                sb.insert(offset, s.charAt(i));
            }
        }

        return sb.toString();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        for ( int fast = 0; fast < s.length(); fast++ ) {
            if ( s.charAt(fast) == ' ' ) {
                reverse(sb, s.substring(sb.length(), fast));
            }
        }

        reverse(sb, s.substring(sb.length(), s.length()));
        
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    private void reverse(StringBuilder sb, String s) {
        StringBuilder word = new StringBuilder(s);
        sb.append(word.reverse().toString());
        sb.append(' ');
    }

    public String reverseWords3(String s) {
        char[] chars = s.toCharArray();
        int slow = 0;
        for ( int fast = 0; fast < s.length(); ++fast ) {
            if ( chars[fast] == ' ' ) {
                reverseChars(chars, slow, fast - 1);
                slow = fast + 1;
            }
        }
        reverseChars(chars, slow, s.length() - 1);

        return new String(chars);
    }

    public void reverseChars(char[] chars, int slow, int fast) {
        while ( slow < fast ) {
            char tmp = chars[fast];
            chars[fast] = chars[slow];
            chars[slow] = tmp;
            slow++;
            fast--;
        }
    }
}
