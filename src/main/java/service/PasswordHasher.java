package service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Formatter;

public class PasswordHasher {
    private static final int SALT_LENGTH = 16;

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        Formatter formatter = new Formatter();
        for (byte b : salt) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static String generateSaltedHash(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((password + salt).getBytes());
            byte[] hashedPassword = md.digest();

            Formatter formatter = new Formatter();
            for (byte b : hashedPassword) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean compareSaltedHash(String password, String salt, String saltedHash) {
        String generatedPasswordHash = generateSaltedHash(password, salt);
        return generatedPasswordHash.equals(saltedHash);
    }
}