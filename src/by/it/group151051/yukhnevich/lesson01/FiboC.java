package by.it.group151051.yukhnevich.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d, %d)=%d \n\t time=%d \n\n", n, m, fibo.fasterC(n, m), fibo.time());
        n = 1;
        m = 2;
        System.out.printf("fasterC(%d, %d)=%d \n\t time=%d \n\n", n, m, fibo.fasterC(n, m), fibo.time());
        n = 999999999;
        m = 321;
        System.out.printf("fasterC(%d, %d)=%d \n\t time=%d \n\n", n, m, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //Решение сложно найти интуитивно
        //возможно потребуется дополнительный поиск информации
        //см. период Пизано
        long[] arrFibo = new long [6 * m + 1];
        arrFibo[0] = 0;
        arrFibo[1] = 1;
        long res = arrFibo[0] + arrFibo[1];
        int i = 1;
        while (((arrFibo[i] != 0) || (res % m != 0)) && (i < (6 * m + 1)))
        {
            i++;
            arrFibo[i] = arrFibo[i-1] + arrFibo[i-2];
            arrFibo[i] %= m;
            res += arrFibo[i];
        }
        if ((res%m != 0) && (arrFibo[i] != 0))
        {
            return arrFibo[i];
        }
        int ex = (int)(n % i);
        return arrFibo[ex];
    }


}

