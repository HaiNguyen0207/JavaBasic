package StudentManage;


public enum Capacity {
    F("Trượt Môn"), D("Yếu"),
    C("Trung Bình"), B("Khá"), A("Giỏi"),
    A_Plus("Xuất Xắc");
    private String value;

    Capacity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
