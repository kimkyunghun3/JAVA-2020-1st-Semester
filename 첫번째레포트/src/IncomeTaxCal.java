import java.util.Scanner;

public class IncomeTaxCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("소득금액을 천원단위로 입력하시오> ");
        int incomeaccount = scanner.nextInt();

        if (incomeaccount <= 12000) {
            double incometaxsum = incomeaccount * 0.06 - 0;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 12000 && incomeaccount < 46000) {
            double incometaxsum = (incomeaccount * 0.15) - 1080;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 46000 & incomeaccount < 88000) {
            double incometaxsum = (incomeaccount * 0.24) - 5220;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 88000 && incomeaccount < 150000) {
            double incometaxsum = (incomeaccount * 0.35) - 14900;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 150000 && incomeaccount < 300000) {
            double incometaxsum = (incomeaccount * 0.38) - 19400;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 300000 && incomeaccount < 500000) {
            double incometaxsum = (incomeaccount * 0.40) - 25400;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        } else if (incomeaccount > 500000) {
            double incometaxsum = (incomeaccount * 0.42) - 35400;
            System.out.println(incomeaccount + "천원의 소득세는 " + (int) incometaxsum +
                    "천원이고, 지방세는"+ (int)incometaxsum/10+"천원 입니다.");
        }
        scanner.close();
    }
}
