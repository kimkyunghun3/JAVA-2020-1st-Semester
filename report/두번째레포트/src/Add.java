class OtherCalc{ //Add, Sub, Mul, Div 클래스에서 공통된 메소드와 필드를 포함하는 부모 클래스
    int a, b; //두개의 피연산자

    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
class Add extends OtherCalc{ //OtherCalc클래스의 자식 클래스 Add
    int calculate() { //덧셈 수행
        return a + b;
    }
}

class Sub extends OtherCalc{
    int calculate() { //뺄셈 수행
        return a - b;
    }
}

class Mul extends OtherCalc{
    int calculate() { //곱셈 수행
        return a * b;
    }
}
class Div extends OtherCalc{
    int calculate() { //나눗셈 수행
        return a / b;
    }
}

