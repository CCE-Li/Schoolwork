package cn.uptra.schoolwork.modules.user.util;

public class PasswordValidator {
    private final int minLength;

    public PasswordValidator(int minLength) {
        this.minLength = minLength;
    }

    public boolean isStrong(String pwd) {
        if (pwd == null) return false;
        if (pwd.length() < minLength) return false;
        int categories = 0;
        if (pwd.matches(".*[A-Z].*")) categories++;
        if (pwd.matches(".*[a-z].*")) categories++;
        if (pwd.matches(".*[0-9].*")) categories++;
        if (pwd.matches(".*[^A-Za-z0-9].*")) categories++;
        return categories >= 3;
    }
}

