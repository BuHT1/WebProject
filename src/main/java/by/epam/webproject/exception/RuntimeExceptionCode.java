package by.epam.webproject.exception;

import com.sun.javafx.binding.StringFormatter;

public enum RuntimeExceptionCode {
    //Student 0-10
    STUDENT_NOT_FOUND(1,"Student with id %s not found."),

    //Group 0-20
    GROUP_NOT_FOUND(11,"Group with id %s not found.");

    private final String message;
    private final int code;

    RuntimeExceptionCode(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String generateMessage(String... messageParameters) {
        return String.format(getMessage(), messageParameters);
    }
}
