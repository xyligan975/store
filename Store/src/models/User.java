package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {
    @Serial
    private static  final long serialVersionUID = 42L;

    private String login;
    private String password;
    private Basket basket;

    public User() {
        this.login = "";
        this.password = "";
        this.basket = new Basket();
    }

    public User(String login, String password, Basket basket) {
        this.login = login;
        this.password = password;
        this.basket = basket;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public static boolean isValidLoginPassword(String login, String password) {
        Pattern pattern = Pattern.compile("^[0-9a-zA-Z_]{6,19}$");
        Matcher matcher1 = pattern.matcher(login);
        Matcher matcher2 = pattern.matcher(password);
        try {
            if (!matcher1.matches()) {
                throw new WrongLoginException("Логин/пароль должен быть от 9 до 19 символов и содержать только латинские буквы, цифры и _");
            }
            if (!matcher2.matches()) {
                throw new WrongPasswordException("Логин/пароль должен быть от 9 до 19 символов и содержать только латинские буквы, цифры и _");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "login='" + login + '\'' +
                ", " + basket.toString();
    }
}
