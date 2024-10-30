import models.Basket;
import models.Category;
import models.Product;
import models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
/*        Product food1 = new Product("Молоко", 2.29f, 4.9f);
        Product food2 = new Product("Хлеб", 1.60f, 4.8f);
        Product food3 = new Product("Колбаса", 15.34f, 5.0f);
        Product food4 = new Product("Майонез", 3.34f, 4.1f);
        Product food5 = new Product("Яйца куриные (10 шт)", 3.34f, 5.0f);
        ArrayList<Product> foodList = new ArrayList<>();
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);

        Product computer1 = new Product("Процессор", 1250.99f, 4.9f);
        Product computer2 = new Product("Материнская карта", 750.60f, 4.8f);
        Product computer3 = new Product("Видеокарта", 9999.99f, 4.9f);
        Product computer4 = new Product("Проводная мышь", 45.99f, 4.1f);
        Product computer5 = new Product("Оперативная память", 125.19f, 4.9f);
        ArrayList<Product> computerList = new ArrayList<>();
        computerList.add(computer1);
        computerList.add(computer2);
        computerList.add(computer3);
        computerList.add(computer4);
        computerList.add(computer5);

        Product householdApp1 = new Product("Робот-пылесос", 270.27f, 3.9f);
        Product householdApp2 = new Product("Фритюрница", 890.27f, 4.4f);
        Product householdApp3 = new Product("Вентилятор", 99.60f, 3.8f);
        Product householdApp4 = new Product("Стиральная машина", 16500.27f, 4.9f);
        Product householdApp5 = new Product("Холодильник", 12270.27f, 4.2f);
        ArrayList<Product> householdAppList = new ArrayList<>();
        householdAppList.add(householdApp1);
        householdAppList.add(householdApp2);
        householdAppList.add(householdApp3);
        householdAppList.add(householdApp4);
        householdAppList.add(householdApp5);

        Product sport1 = new Product("Футбольный мяч", 80.27f, 4.9f);
        Product sport2 = new Product("Шахматы", 50.27f, 4.4f);
        Product sport3 = new Product("Хоккейная клюшка", 44.27f, 4.2f);
        Product sport4 = new Product("Дартс", 35.25f, 4.5f);
        Product sport5 = new Product("Рекурсивный лук", 282.27f, 4.8f);
        ArrayList<Product> sportList = new ArrayList<>();
        sportList.add(sport1);
        sportList.add(sport2);
        sportList.add(sport3);
        sportList.add(sport4);
        sportList.add(sport5);

        Product musicalInstrument1 = new Product("Скрипка", 377.27f, 4.9f);
        Product musicalInstrument2 = new Product("Гитара", 255.72f, 4.9f);
        Product musicalInstrument3 = new Product("Барабан", 567.27f, 3.5f);
        Product musicalInstrument4 = new Product("Клавишное фортепиано", 223.27f, 3.9f);
        Product musicalInstrument5 = new Product("Флейта", 97.27f, 4.8f);
        ArrayList<Product> musicalInstrumentList = new ArrayList<>();
        musicalInstrumentList.add(musicalInstrument1);
        musicalInstrumentList.add(musicalInstrument2);
        musicalInstrumentList.add(musicalInstrument3);
        musicalInstrumentList.add(musicalInstrument4);
        musicalInstrumentList.add(musicalInstrument5);

        Category food = new Category("Еда", foodList);
        Category computers = new Category("Компьютеры", computerList);
        Category householdApp = new Category("Бытовая техника", householdAppList);
        Category sport = new Category("Спорт", sportList);
        Category musicalInstrument = new Category("Музыкальные инструменты", musicalInstrumentList);

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(food);
        categories.add(computers);
        categories.add(householdApp);
        categories.add(sport);
        categories.add(musicalInstrument);
        categories.sort(Comparator.comparing(Category::getName));*/

/*        ArrayList<Product> basket1List = new ArrayList<>();
        basket1List.add(food2);
        basket1List.add(computer3);
        Basket basket1 = new Basket(basket1List);

        ArrayList<Product> basket2List = new ArrayList<>();
        basket2List.add(food3);
        basket2List.add(computer2);
        Basket basket2 = new Basket(basket2List);*/

/*        User user1 = new User("qwerty", "qwetry", new Basket());
        User user2 = new User("123456", "123456", new Basket());

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);*/

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Professional\\IdeaProjects\\Store\\save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        try {
            users = (ArrayList<User>)objectInputStream.readObject();
            categories = (ArrayList<Category>)objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getException().getLocalizedMessage());
        }

        categories.get(1).getProducts().add(new Product("Вафли", 0.99f, 4.9f));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        byte choice = 0;
        String login = "";
        String password = "";
        User userLogined = new User();
        boolean isFind = false;
        while (true) {
            isFind = false;
            System.out.println("Выберите один из пунктов:");
            System.out.println("1. Аутентификация");
            System.out.println("2. Регистрация нового пользователя");
            System.out.println("3. Просмотр списка каталогов товара");
            System.out.println("4. Покупка товаров в корзине");
            System.out.println("5. Выход");
            choice = Byte.parseByte(bufferedReader.readLine());
            if (choice == 1) {
                while (true) {
                    System.out.print("Введите login: ");
                    login = bufferedReader.readLine();
                    System.out.print("Введите password: ");
                    password = bufferedReader.readLine();
                    for (User user : users) {
                        if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                            isFind = true;
                            userLogined = user;
                            break;

                        }
                    }
                    if (isFind) {
                        System.out.println("Аутентификация пройдена успешно");
                        break;
                    } else {
                        System.out.println("Неверный логин/пароль! Попробуйте ещё раз");
                    }
                }
            } else if (choice == 2) {
                while (true) {
                    System.out.print("Введите login: ");
                    login = bufferedReader.readLine();
                    System.out.print("Введите password: ");
                    password = bufferedReader.readLine();
                    if (!User.isValidLoginPassword(login, password)) {
                        continue;
                    }
                    for (User user : users) {
                        if (login.equals(user.getLogin())) {
                            isFind = true;
                            break;
                        }
                    }
                    if (isFind) {
                        System.out.println("Пользователь с таким логином уже существует");
                        isFind = false;
                    } else {
                        System.out.println("Регистрация прошла успешно.");
                        userLogined.setLogin(login);
                        userLogined.setPassword(password);
                        users.add(userLogined);
                        break;
                    }
                }
            } else if (choice == 3) {
                while (true) {
                    System.out.println("Выберите один из каталогов:");
                    for (int i = 0; i < categories.size(); i++) {
                        System.out.println((i + 1) + ". " + categories.get(i).getName());
                    }
                    System.out.println("0. Выход в главное меню");
                    choice = Byte.parseByte(bufferedReader.readLine());

                    if (choice == 0) {
                        break;
                    }
                    if (choice > categories.size() || choice < 0) {
                        System.out.println("Нет такой категории! Попробуйте ещё раз");
                    }
                    for (int i = 0; i < categories.size(); i++) {
                        if (choice == i + 1) {
                            boolean isChosen = false;
                            while (true) {
                                isChosen = false;
                                System.out.println("Выберите один из товаров для добавления в корзину:");
                                for (int j = 0; j < categories.get(i).getProducts().size(); j++) {
                                    System.out.println((j + 1) + ". " + categories.get(i).getProducts().get(j).getName());
                                }
                                System.out.println("0. Выход в список каталогов");
                                choice = Byte.parseByte(bufferedReader.readLine());
                                if (choice == 0) {
                                    break;
                                }
                                if (choice > categories.get(i).getProducts().size() || choice < 0) {
                                    System.out.println("Нет такого товара! Попробуйте ещё раз");
                                }
                                int j;
                                for (j = 0; j < categories.get(i).getProducts().size(); j++) {
                                    if (choice == j + 1) {
                                        isChosen = true;
                                        break;
                                    }
                                }
                                if (isChosen) {
                                    if (!userLogined.getLogin().isEmpty()) {
                                        System.out.println("Товар добавлен в корзину");
                                        userLogined.getBasket().getProducts().add(categories.get(i).getProducts().get(j));
                                    } else {
                                        System.out.println("Для добавления товара в корзину пройдите аутентификацию/регистрацию");
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (choice == 4) {
                userLogined.getBasket().printBill();
                userLogined.getBasket().getProducts().clear();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Выбран неправильный пункт. Попробуйте ещё раз");
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Professional\\IdeaProjects\\Store\\save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.writeObject(categories);
        objectOutputStream.close();
    }
}
