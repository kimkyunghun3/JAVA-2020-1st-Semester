public class AddNumbers {
    public static void main(String[] args) {
        double Doublesum = 0;
        int Intsum = 0;
        double Doubletmp = 0;
        int Inttmp = 0;
        System.out.println("명령행 인자들을 출력합니다.");
        for(String elem : args)
            System.out.print(elem + ", ");      //명령형 인자들 모두 출력
        System.out.println();
        System.out.println();
        System.out.println("명령행 인자들의 정수와 실수 덧셈 연산을 수행합니다.");


        for (int i = 0; i < args.length; i++) {

            if (isInteger(args[i])) {       // 배열에서 Integer라면
                Inttmp = Integer.parseInt(args[i]);
                Intsum += Inttmp;       //Int 자료형 sum에 더한다

            } else if (isDouble(args[i]) == true) {     //배열에서 Double라면

                Doubletmp = Double.parseDouble(args[i]);
                Doublesum += Doubletmp;

            }else {
                System.out.println(args[i] + ": 정수나 실수가 아닙니다.");
            }

        }
        System.out.println("정수합 = " + Intsum);
        System.out.println("실수합 = " + Doublesum);
    }

    public static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);    // int 형으로 변환해보고
            return true;                      // 이상없으면 true를 리턴
        } catch (NumberFormatException e) {
            return false;                    // 이상 있으면 false를 리턴
        }
    }

    public static boolean isDouble(String num) {
        try {
            Double.parseDouble(num);    // double 형으로 변환하고
            return true;                // 이상 없으면 true 리턴
        } catch (NumberFormatException e) {
            return false;       // 이상 있으면 false 리턴
        }
    }

}