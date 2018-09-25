package co.mahti.foodmonitoringsystems;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SHA1 {
   // private static String data;
    //private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private String data = "8850124003850";
    private String key = "Xq93R9v8m8Ih3Ow2";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        return formatter.toString();
    }

    public static byte[] calculateRFC2104HMAC(String data, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return mac.doFinal(data.getBytes());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws Exception {
        byte[] hmac = calculateRFC2104HMAC("8850124003850", "Xq93R9v8m8Ih3Ow2");
        byte[] encodedBytes = Base64.getEncoder().encode(hmac);
        System.out.println("encodedBytes " + new String(encodedBytes));


    }
}