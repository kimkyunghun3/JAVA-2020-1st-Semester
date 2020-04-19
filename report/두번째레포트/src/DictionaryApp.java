/*
 * 파일명 : DictionaryApp.java
 * 입력 : -
 * 출력 : 키와 값을 하나의 아이템으로 하여 원하는 값을 출력
 * 작성일 : 2020년 4월 19일
 * 작성자 : 20176088 김경훈
 *
 * Q. PairMap을 상속받는 Dictionary 클래스를 구현하고, 이를 다음과 같이 활용하는 main() 메소드를 가진 DictionaryApp도 작성하라
 */

class PairMap {
    protected String keyArray [];// key 저장하는 배열
    protected String valueArray []; // value 저장하는 배열

    String get(String key) {    //key 값으로 'value'를 검색
        String result = null;
        for(int i=0;i < keyArray.length;i++) //key배열만큼 반복
            if(keyArray[i].equals(key)) { //매개변수와 같은 key값을 찾기
                result = valueArray [i];
                break;
            }
        return result;  //같은 번지의 value 반환한다
    }
    void put(String key, String value) {  // key와 value를 저장하는 부
        for(int i=0;i < keyArray.length;i++) {
            if(keyArray[i] == key) {
                valueArray [i] = value;
                break;
            }
            else if(keyArray[i] == null) {
                keyArray[i] = key;
                valueArray [i] = value;
                break;
            }
        }
    }
    String delete(String key) { // key 값을 가진 아이템(value와 함께)을 삭제하고 삭제된 value 값 리턴
        String result = null;
        for(int i=0;i < keyArray.length;i++)
            if(keyArray[i].equals(key)) {
                valueArray[i] = null;
                result = valueArray[i];
                break;
            }
        return result;
    }
    int length() {// 현재 저장된 아이템의 개수 리턴
        int count = 0;
        for(int i=0;i < keyArray.length;i++)
            if(keyArray[i] != null)
                count++;
        return count;
    }
}

class Dictionary extends PairMap{ //PairMap을 상속받는 Dictionary 클래스를 구현

    Dictionary(int num){    //매개 변수 == 배열 크기
        keyArray = new String[num];
        valueArray = new String[num];
    }
}

public class DictionaryApp{

    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }

}