public class TV {
    String TVBrand = "";
    int year = 0, width = 0;

    public TV(String b, int y, int w) {
        TVBrand = b;
        year = y;
        width = w;
    }

    public TV(int y, int w) {
        year = y;
        width = w;
    }

    public TV(int w) {
        width = w;
    }

    void show() {
        if (TVBrand != "" && year != 0 && width != 0)
            System.out.println(TVBrand + "에서 만든 " + year + "년 " + width + "인치 TV");
        else if (year != 0 && width != 0)
            System.out.println(year + "년 " + width + "인치 TV");
        else if (width != 0)
            System.out.println(width + "인치 TV");
    }

    public static void main(String[] args) {
        TV myTV = new TV("LG", 2017, 45);
        myTV.show();
        TV myTV1 = new TV(2018, 52);
        myTV1.show();
        TV myTV2 = new TV(65);
        myTV2.show();
    }

}