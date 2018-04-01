package chizaitongji.example.com.chizaitongji.Bean;

public class CanteenThumbnail {
    private String CanteenName;
    private String CanteenInfo;
    private int ImageId;

    public CanteenThumbnail(String canteenName, int imageId) {
        CanteenName = canteenName;
        ImageId = imageId;
    }

    public String getCanteenName() {
        return CanteenName;
    }

    public void setCanteenName(String canteenName) {
        CanteenName = canteenName;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getCanteenInfo() {
        return CanteenInfo;
    }

    public void setCanteenInfo(String canteenInfo) {
        CanteenInfo = canteenInfo;
    }
}
