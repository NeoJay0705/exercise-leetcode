package org.exercise.string;

import java.util.LinkedList;
import java.util.List;

// 186

public class ReverseWordsinaString {
    public static void main(String[] args) {
        ReverseWordsinaString rws = new ReverseWordsinaString();
        String[] inputs = new String[] {
                                         "",
                                         " a c",
                                         "abc",
                                         " abc  def",
                                         " abc  def ",
                                         "abc  def  ",
                                       };
        for ( String s : inputs) {
            System.out.println(rws.reverseWords2(s) + "+");
        }
    }

    public String reverseWords(String s) {
        List<String> words = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < s.length(); ++i ) {
            if ( s.charAt(i) != ' ' ) {
                sb.append(s.charAt(i));
            }
            else if ( sb.length() > 0 ) {
                words.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        if ( sb.length() > 0 ) {
            words.add(sb.toString());
            sb.delete(0, sb.length());
        }

        for ( int i = words.size() - 1; i > -1; --i ) {
            sb.append(words.get(i));
            sb.append(' ');
        }

        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int offset = 0;
        for ( int i = 0; i < s.length(); ++i ) {
            if ( s.charAt(i) != ' ' ) {
                sb.insert(offset, s.charAt(i));
                offset++;
            }
            else if ( offset > 0 ) {
                sb.insert(offset, ' ');
                offset = 0;
            }
        }

        if ( offset > 0 ) {
            sb.insert(offset, ' ');
        }

        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }
}
