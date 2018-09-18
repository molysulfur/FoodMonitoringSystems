package co.mahti.foodmonitoringsystems;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Upcbarcode {
    @SerializedName("upc_code")
    @Expose
    private String upcCode;
    @SerializedName("ingredients")
    @Expose
    private Object ingredients;
    @SerializedName("usage")
    @Expose
    private String usage;
    @SerializedName("product_web_page")
    @Expose
    private String productWebPage;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("nutrition")
    @Expose
    private Object nutrition;
    @SerializedName("brand")
    @Expose
    private Object brand;
    @SerializedName("formattedNutrition")
    @Expose
    private Object formattedNutrition;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("gcp_gcp")
    @Expose
    private String gcpGcp;

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public Object getIngredients() {
        return ingredients;
    }

    public void setIngredients(Object ingredients) {
        this.ingredients = ingredients;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getProductWebPage() {
        return productWebPage;
    }

    public void setProductWebPage(String productWebPage) {
        this.productWebPage = productWebPage;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getNutrition() {
        return nutrition;
    }

    public void setNutrition(Object nutrition) {
        this.nutrition = nutrition;
    }

    public Object getBrand() {
        return brand;
    }

    public void setBrand(Object brand) {
        this.brand = brand;
    }

    public Object getFormattedNutrition() {
        return formattedNutrition;
    }

    public void setFormattedNutrition(Object formattedNutrition) {
        this.formattedNutrition = formattedNutrition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGcpGcp() {
        return gcpGcp;
    }

    public void setGcpGcp(String gcpGcp) {
        this.gcpGcp = gcpGcp;
    }
}
