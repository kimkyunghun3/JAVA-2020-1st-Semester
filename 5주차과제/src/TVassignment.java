class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    int color;

    ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }



    void printProperty() {
        System.out.println("나의 Color TV는 " + getSize() + "인치 " + color + "컬러");
    }

}

class IPTV extends ColorTV {
    String adress;

    IPTV(String adress, int size, int color) {
        super(size, color);
        this.adress = adress;
    }

    void printProperty() {
        System.out.println("나의 IP TV 는 " + adress + " 주소의 " + getSize() + "인치 " + color + "컬러");
    }

}

public class TVassignment {

    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();

        IPTV ipTV = new IPTV("192.1.1.2", 48, 2048);
        ipTV.printProperty();

    }

}