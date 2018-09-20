package co.mahti.foodmonitoringsystems;

public class InputDataViewScan {
    private String ProductName;
    private String Image;
    private String Quantity;
    private String ExpiryDate;

    public InputDataViewScan() {
    }

    public InputDataViewScan(String productName,String image, String quantity, String expiryDate) {
        ProductName = productName;
        Image = image;
        Quantity = quantity;
        ExpiryDate = expiryDate;
    }

    public String getProductName() { return ProductName; }
    public String getImage() { return Image; }
    public String getQuality() {
        return Quantity;
    }
    public String getExpiryDate()
    {
        return ExpiryDate;
    }
    public void setProductName(String productName) { ProductName = productName; }
    public void setImage(String image) { Image = image; }
    public void setQuality(String quantity)
    {
        Quantity = quantity;
    }
    public void setExpiryDate(String expiryDate)
    {
        ExpiryDate = expiryDate;
    }
}

