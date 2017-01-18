package utils;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by HackuunaMatata on 19.01.2017.
 */
public class HashPassword {
    private static final Logger log = Logger.getLogger(HashPassword.class);

    public static String getMD5Hash(String password) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder(bytes.length * 2);
            for (byte b : bytes)
                sb.append(String.format("%02x", b & 0xff));
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error(e);
        }
        return  generatedPassword;
    }
}
