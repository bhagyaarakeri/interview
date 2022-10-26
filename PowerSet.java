package general.interview;

import java.util.ArrayList;
import java.util.List;

/*
* Power Set: Power set P(S) of a set S is the set of all subsets of S.
* For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.
* Assumption :
* 1 - S is character set (All Unique elements in an array)
* 2 - finding all unique subsets of a set S
* */

public class PowerSet {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        List<List<Character>> result = powerSet(arr);
        powerSet2(arr);
        System.out.println(result);
    }

    /*
    * Time Complexity: O(N*2^N)
    * Space Complexity: O(N*2^N)
    * */
    public static List<List<Character>> powerSet(char[] charArr) {
        List<List<Character>> result = new ArrayList<>();
        if(charArr.length > 0){
            int size = (int)Math.pow(2, charArr.length);
            for(int i = 0 ; i < size ; i++){
                List<Character> list = new ArrayList<>();
                for(int j = 0 ; j < charArr.length ; j++){
                    if( (i & (1 << j)) > 0){
                        list.add(charArr[j]);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    /*
     * Time Complexity: O(N*2^N)
     * Space Complexity: O(N) for String buffer - Can be printed directly without storing in any space
     * This is just to print in the same way as output given
     *
     * This method is to just print
     * */
    public static void powerSet2(char[] charArr) {
        List<List<Character>> result = new ArrayList<>();
        if(charArr.length > 0){
            System.out.print("{");
            int size = (int)Math.pow(2, charArr.length);
            for(int i = 0 ; i < size ; i++){
                System.out.print("{");
                StringBuilder builder = new StringBuilder();
                for(int j = 0 ; j < charArr.length ; j++){
                    if( (i & (1 << j)) > 0){
                        if(!builder.isEmpty())
                            builder.append(", ");
                        builder.append(charArr[j]);
                    }
                }
                System.out.print(builder);
                System.out.print("}");
                if(i != size-1) System.out.print(", ");
            }
            System.out.print("}");
            System.out.println();
        }
    }
}
