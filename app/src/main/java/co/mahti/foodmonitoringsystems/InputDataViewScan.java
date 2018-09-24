package co.mahti.foodmonitoringsystems;

public class InputDataViewScan {
    private String ProductName;
    private String UrlImage;
    private String Quantity;
    private String ExpiryDate;

    public InputDataViewScan() {
    }

    public InputDataViewScan(String productName,String UrlImage, String quantity, String expiryDate) {
        ProductName = productName;
        //UrlImage = urlImage;
        Quantity = quantity;
        ExpiryDate = expiryDate;
    }


}

