import java.util.Scanner;

public class CoinChanger {
    public static void main(String args[]){
        System.out.print("금액을 읿력하시오 >> ");
        int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
        Scanner scanner = new Scanner(System.in);
        int changer = scanner.nextInt();
        for(int i=0; i<unit.length;i++){
            if(changer / unit[i] >0){
                System.out.println(unit[i]+"원짜리 : " + changer / unit[i]);
                changer = changer - unit[i]*(changer/unit[i]);
            }
        }
        scanner.close();
    }
}
