package chizaitongji.example.com.chizaitongji.Bean;

public class SubCanteenInfo {
    private String SubCanteenName;
    private String SubCanteenDetail;

    public SubCanteenInfo(String subCanteenName, String subCanteeninfo) {
        this.SubCanteenName = subCanteenName;
        this.SubCanteenDetail = subCanteeninfo;
    }

    public String getSubCanteenName() {
        return SubCanteenName;
    }

    public void setSubCanteenName(String subCanteenName) {
        this.SubCanteenName = subCanteenName;
    }

    public String getSubCanteenDetail() {
        return SubCanteenDetail;
    }

    public void setSubCanteenDetail(String subCanteenDetail) {
        this.SubCanteenDetail = subCanteenDetail;
    }
}
