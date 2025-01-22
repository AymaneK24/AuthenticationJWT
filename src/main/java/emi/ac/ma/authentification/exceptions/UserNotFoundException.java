package emi.ac.ma.authentification.exceptions;

public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }

}
