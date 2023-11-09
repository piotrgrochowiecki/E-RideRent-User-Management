package com.piotrgrochowiecki.eriderent.eriderent_user_management.data.password;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

    public static String hashPassword(String password) {
        SHA3.Digest512 digest512 = new SHA3.Digest512();
        byte[] digest = digest512.digest(password.getBytes());
        return Hex.toHexString(digest);
    }

}
