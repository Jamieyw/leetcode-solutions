/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Approach 2: Chucked Transfer Encoding

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded_strings = new StringBuilder();

        for (String s : strs) {
            encoded_strings.append(s.length()).append('#').append(s);
        }

        return encoded_strings.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded_strings = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            // eg. s = "3#abc", i = 0, j = 1, 3 -> s.substring(0, 1) = "3"
            int curr_length = Integer.valueOf(s.substring(i, j));
            // Update i
            i = j + 1 + curr_length;
            // Add the decoded string to the list
            decoded_strings.add(s.substring(j + 1, i));
        }

        return decoded_strings;
    }

    // // Approach 1: Escaping the delimiter and escape character

    // // Encodes a list of strings to a single string.
    // public String encode(List<String> strs) {

    //     StringBuilder encoded_strings = new StringBuilder();

    //     // escaping character: /
    //     // delimiter: #
    //     for (String s : strs) {
    //         // escape the escape character '/' in each string because we are using it as an escape character
    //         // edge case: ["V","Grz/"] -> "V#Grz/#"
    //         // escape the delimiter '#' in each string
    //         // add delimiter '#' to the end
    //         encoded_strings.append(s.replace("/", "//").replace("#", "/#")).append('#');
    //     }

    //     return encoded_strings.toString();
    // }

    // // Decodes a single string to a list of strings.
    // public List<String> decode(String s) {
        
    //     List<String> decoded_strings = new ArrayList<>();
    //     StringBuilder curr_string = new StringBuilder();

    //     int i = 0;
    //     while (i < s.length()) {
    //         // If we encounter a delimiter '#'
    //         if (s.charAt(i) == '#') {
    //             decoded_strings.add(curr_string.toString());
    //             curr_string = new StringBuilder();
    //             i++;
    //         } 
    //         // If we encounter an escape character '/' followed by '#'
    //         else if(i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '#') {
    //             curr_string.append(s.charAt(i + 1));
    //             i += 2;
    //         }
    //         // If we encounter an escape character '/' followed by '/'
    //         else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
    //             curr_string.append('/');
    //             i += 2;
    //         }
    //         else {
    //             curr_string.append(s.charAt(i));
    //             i++;
    //         }
    //     }
    //     return decoded_strings;
    // }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
// @lc code=end

