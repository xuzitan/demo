package Demo00;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * 查找字符串中最长子串的长度：
 *字符串中有重复的字符，要找到不重复并且最长的子串
 * 首先，得对字符串进行遍历，在遍历时对设左有界限，确保左右界限内的子串无重复字符。
 * 右界限right从只需往右进行遍历，为自变量，而左界限left为保障无重复条件得进行改变。
 * 设left为-1，确保left为子串左边的界限（具体，当右界限访问到字串中字符时，将左界限设到该字符处）
 * 返回值为最大，将最大与变化后的字串长度（right-left）进行比较。长的返回
 *
 *
 * 1.该方法利用ASCII码为256位大小整性数代替。将ASCII为索引进行存储‘字符串’中的字符的‘索引’。
 * 每个字符与相应索引进行一一映射，类似Hashmap的存储。当找到重复字符时，先将该字符索引赋值与左界限。
 * 再将该字符所对应的索引进行更新（确保其为字串中的索引）。
 */
public class Length_of_Longest_substring {
    public int lengthOfLongestSubstring(String s) {
        int[] str = new int[256];
        Arrays.fill(str,-1);
        int left=-1,result = 0;
        for (int i=0;i<s.length();i++)
        {
            left = Math.max(left,str[s.charAt(i)]);
            str[s.charAt(i)]=i;
            result=Math.max(result,i-left);
        }

        return result;
    }

    /**
     * @param s
     * 方法2.设置一个字符集合，
     *  当rihgt访问到不重复的字符，将其加到集合中
     *  若为重复字符，则先删除重复字符及其左边的字符，在进行添加新的字符。
     */
    public int lengthOfLongestSubstring1(String s)
    {
        int result=0,right=0,left=0;
        HashSet<Character> ch = new HashSet<Character>();
        while(right<s.length())
        {
            if (!ch.contains(s.charAt(right)))
            {
                ch.add(s.charAt(right++));
                result=Math.max(result,ch.size());
            }else
            {
                ch.remove(s.charAt(left++));
            }
        }
        return result;
    }
    public static void main(String args[])
    {
        Length_of_Longest_substring l = new Length_of_Longest_substring();
        System.out.println("result= "+l.lengthOfLongestSubstring1("asdasdss"));
    }

}
