package Demo00;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args)
    {
        Scanner In = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        int N = In.nextInt();
        for(int i=0;i<N;i++)
        {
            list.add(In.next());
        }
        for (String str:list)
        {
            System.out.println(change(str));
        }
    }
    static String change(String str)
    {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        while (i<stringBuffer.length()-2)
        {
            while(i<stringBuffer.length()-2&&stringBuffer.charAt(i)==stringBuffer.charAt(i+1)&&stringBuffer.charAt(i+1)==stringBuffer.charAt(i+2))
            {
                stringBuffer.delete(i+1,i+2);
            }
            while (i<stringBuffer.length()-3&&stringBuffer.charAt(i)==stringBuffer.charAt(i+1)&&stringBuffer.charAt(i+2)==stringBuffer.charAt(i+3))
            {
                stringBuffer.delete(i+2,i+3);
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
