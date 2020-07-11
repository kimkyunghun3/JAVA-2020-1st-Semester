//package Question5;
//
//public class MyStringEx {
//    public static void main(String[] args) {
//        char [] chs = new char[] {'A', 'B', ' ', 'C', 'D'};
//        MyString str1 = new MyString(chs);
//        chs[0] = 'Z';
//
//        System.out.print("str1 문자열 : ");
//        MyString.println(str1);  // AB CD
//        System.out.print("str1 문자열의 길이 : ");
//        System.out.println(str1.length());  // 5
//
//        MyString str2 = new MyString(new char[] {'A', 'B', ' ', 'C', 'D', 'E'});
//        System.out.print("str2 문자열 : ");
//        MyString.println(str2);  // AB CDE
//        if (str1.equals(str2))
//            System.out.println("str1 과 str2 문자열은 같습니다");
//        else
//            System.out.println("str1 과 str2 문자열은 다릅니다");
//
//        MyString str3 = new MyString(new char[] {' ','\t','A', 'b', ' ', 'C', 'd',' '});
//        MyString str4 = str3.trim().toUpperCase();
//
//        System.out.print("str4 문자열 : ");
//        MyString.println(str4);  // AB CD
//        if (str1.equals(str4))
//            System.out.println("str1 과 str4 문자열은 같습니다");
//        else
//            System.out.println("str1 과 str4 문자열은 다릅니다");
//
//        MyString sub = new MyString(new char[] {'B', ' ', 'C'});
//        System.out.print("sub 문자열 : ");
//        MyString.println(sub);  // B C
//
//        if (str1.contains(sub))
//            System.out.println("str1은 sub 문자열을 포함합니다 ");
//        else
//            System.out.println("str1은 sub 문자열을 포함하지 않습니다.");
//
//
//    public boolean Mystring(Object anObject){
//            if (this == anObject) {
//                return true;
//            }
//            if (anObject instanceof String) {
//                String anotherString = (String) anObject;
//                int n = value.length;
//                if (n == anotherString.value.length) {
//                    char v1[] = value;
//                    char v2[] = anotherString.value;
//                    int i = 0;
//                    while (n-- != 0) {
//                        if (v1[i] != v2[i])
//                            return false;
//                        i++;
//                    }
//                    return true;
//                }
//            }
//            return false;
//        }
//}
//
