import java.util.Scanner;

public class IncomeTaxCal {
    public static void main(String[] args) {
        System.out.println("소득금액을 천원단위로 입력하시오> ");
        double[] progressive_deduction = {0, 1080, 5220, 14900, 19400, 25400, 35400};
        double[] incometax = {0.06, 0.15, 0.24, 0.35, 0.38, 0.40, 0.42};
        Scanner scanner = new Scanner(System.in);
        double incomeaccount = scanner.nextInt();

        if (incomeaccount <= 12000) {
            double incometaxsum = incomeaccount * incometax[0] - progressive_deduction[0];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else if (incomeaccount < 12000 && incomeaccount >= 46000) {
            double incometaxsum = incomeaccount * incometax[1] - progressive_deduction[1];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else if (incomeaccount < 12000 && incomeaccount >= 46000) {
            double incometaxsum = incomeaccount * incometax[2] - progressive_deduction[2];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else if (incomeaccount < 46000 && incomeaccount >= 88000) {
            double incometaxsum = incomeaccount * incometax[3] - progressive_deduction[3];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else if (incomeaccount < 88000 && incomeaccount >= 150000) {
            double incometaxsum = incomeaccount * incometax[4]- progressive_deduction[4];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else if (incomeaccount < 150000 && incomeaccount >= 300000) {
            double incometaxsum = incomeaccount * incometax[5] - progressive_deduction[5];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else if (incomeaccount < 300000 && incomeaccount >= 500000) {
            double incometaxsum = incomeaccount * incometax[6] - progressive_deduction[6];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else if (incomeaccount < 500000) {
            double incometaxsum = incomeaccount * incometax[7] - progressive_deduction[7];
            System.out.println(incomeaccount + "천원의 소득세는 " + incometaxsum + " , 지방세는" + incometaxsum / 10);
        } else {
            System.out.println("이상해요");
        }
        scanner.close();
    }
}
