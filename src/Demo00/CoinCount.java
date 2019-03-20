package Demo00;

import java.util.Scanner;

public class CoinCount {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = 1024-N;
        int Count = 0;
        if(N>1024||N<-1)
        {
            return;
        }

        while(M>=1)
        {
            if (M>=64)
            {
                M=M-64;
                Count++;
            } else if(M>=16)
            {
                M=M-16;
                Count++;
            }else if (M>=4)
            {
                M=M-4;
                Count++;
            }else
            {
                M=M-1;
                Count++;
            }
        }
        System.out.println(Count);
    }
}
