package co.mahti.foodmonitoringsystems;

import android.util.Xml;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Formatter;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SHA1 {
    //private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    //private String data = "8850124003850";
    //private String authKey = "Xq93R9v8m8Ih3Ow2";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        return formatter.toString();
    }

    public static String calculateRFC2104HMAC(String data, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return toHexString(mac.doFinal(data.getBytes()));
    }

    public static void main(String[] args) throws Exception {
        String hmac = calculateRFC2104HMAC("8850124003850", "Xq93R9v8m8Ih3Ow2");

        System.out.println(hmac);
        //assert hmac.equals("104152c5bfdca07bc633eebd46199f0255c9f49d");
    }
}