package chizaitongji.example.com.chizaitongji.Bean;

public class CanteenThumbnail {
    private String CanteenName;
    private String CanteenInfo;
    private String ImageIdString;
    private int ImageId;


    public CanteenThumbnail(String canteenName, String canteenInfo, String imageIdString) {
        CanteenName = canteenName;
        CanteenInfo = canteenInfo;
        ImageIdString = imageIdString;
    }

    public String getCanteenName() {
        return CanteenName;
    }

    public void setCanteenName(String canteenName) {
        CanteenName = canteenName;
    }

    public String getImageIdString() {
        return ImageIdString;
    }

    public void setImageIdString(String imageIdString) {
        ImageIdString = imageIdString;
    }

    public String getCanteenInfo() {
        return CanteenInfo;
    }

    public void setCanteenInfo(String canteenInfo) {
        CanteenInfo = canteenInfo;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}
