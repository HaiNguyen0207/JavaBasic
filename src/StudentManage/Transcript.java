package StudentManage;


public class Transcript {
    private static int nextId = 1001;
    private String idTranscript;   //mã bảng điểm
    private float mark1;    //điểm hệ số 1
    private float mark2;   //điểm hệ số 2
    private float mark3;    //điểm hệ số 3
    private float avgMark; //điểm trung bình
    private Capacity capacity;  //học lực

    protected Transcript() {
        idTranscript = "";
        mark1 = 0f;
        mark2 = 0f;
        mark3 = 0f;
        avgMark = 0f;
        capacity = null;
    }


    public Transcript(float mark1, float mark2, float mark3) {
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Transcript.nextId = nextId;
    }

    public String getIdTranscript() {
        return idTranscript;
    }

    public void setIdTranscript() {
        if (idTranscript == null) {
            this.idTranscript = "TRA" + nextId;
            nextId++;
        } else {
            getIdTranscript();
        }
    }

    public float getMark1() {
        return mark1;
    }

    public void setMark1(float mark1) {
        this.mark1 = mark1;
    }

    public float getMark2() {
        return mark2;
    }

    public void setMark2(float mark2) {
        this.mark2 = mark2;
    }

    public float getMark3() {
        return mark3;
    }

    public void setMark3(float mark3) {
        this.mark3 = mark3;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    //tính điểm trung bình
    public void calculAvgMark() {
        avgMark = (mark1 + mark2 * 2 + mark3 * 3) / 6;
    }

    //xét học lực
    public void calculCapacity() {
        if (avgMark >= 9.0 && avgMark <= 10.0) {
            capacity = Capacity.A_Plus;
        } else if (avgMark >= 8.0 && avgMark < 9.0) {
            capacity =Capacity.A;
        } else if (avgMark >= 6.5 && avgMark < 8.0) {
            capacity = Capacity.B;
        } else if (avgMark >= 5.0 && avgMark < 6.5) {
            capacity = Capacity.C;
        } else if (avgMark >= 4.0 && avgMark < 5.0) {
            capacity = Capacity.D;
        } else {
            capacity = Capacity.F;
        }
    }
}

