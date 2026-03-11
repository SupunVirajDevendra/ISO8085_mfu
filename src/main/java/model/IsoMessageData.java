package model;

public class IsoMessageData {
    private int id;
    private String mti;
    private String field2;
    private String field3;
    private String field4;
    private String field7;
    private String field11;
    private String field41;
    private String field49;

    public IsoMessageData() {}

    public IsoMessageData(int id, String mti, String field2, String field3, String field4,
                          String field7, String field11, String field41, String field49) {
        this.id = id;
        this.mti = mti;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field7 = field7;
        this.field11 = field11;
        this.field41 = field41;
        this.field49 = field49;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMti() { return mti; }
    public void setMti(String mti) { this.mti = mti; }

    public String getField2() { return field2; }
    public void setField2(String field2) { this.field2 = field2; }

    public String getField3() { return field3; }
    public void setField3(String field3) { this.field3 = field3; }

    public String getField4() { return field4; }
    public void setField4(String field4) { this.field4 = field4; }

    public String getField7() { return field7; }
    public void setField7(String field7) { this.field7 = field7; }

    public String getField11() { return field11; }
    public void setField11(String field11) { this.field11 = field11; }

    public String getField41() { return field41; }
    public void setField41(String field41) { this.field41 = field41; }

    public String getField49() { return field49; }
    public void setField49(String field49) { this.field49 = field49; }

    @Override
    public String toString() {
        return "IsoMessageData{" +
                "id=" + id +
                ", mti='" + mti + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field7='" + field7 + '\'' +
                ", field11='" + field11 + '\'' +
                ", field41='" + field41 + '\'' +
                ", field49='" + field49 + '\'' +
                '}';
    }
}