import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER, JDBCConstants.PASSWORD)) {
            var statement = connection.createStatement();

            statement.execute(SqlQueries.CREATE_TABLE);
            statement.execute(SqlQueries.INSERT_USERS);

            var resultSet = statement.executeQuery(SqlQueries.SELECT_ALL_USERS);

            var users = new ArrayList<>();

            while (resultSet.next()) {

                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));

                users.add(user);
            }

            System.out.println("Все пользователи:");
            users.forEach(System.out::println);

            System.out.println("-----------------------------------------------------------");
            System.out.println("Пользователи младше 18:");

            var younger18 = statement.executeQuery(SqlQueries.SELECT_USERS_YOUNGER_18);
            var usersYounger18 = new ArrayList<>();

            while (younger18.next()) {
                User user = new User();
                user.setId(younger18.getInt(1));
                user.setFirstName(younger18.getString(2));
                user.setLastName(younger18.getString(3));
                user.setAge(younger18.getInt(4));

                usersYounger18.add(user);
            }
            usersYounger18.forEach(System.out::println);

            System.out.println("-----------------------------------------------------------");
            System.out.println("Пользователи имя которых заканчивается на 'o':");

            var endsO = statement.executeQuery(SqlQueries.SELECT_USERS_NAME_ENDS_O);
            var usersEndsO = new ArrayList<>();

            while (endsO.next()) {
                User user = new User();
                user.setId(endsO.getInt(1));
                user.setFirstName(endsO.getString(2));
                user.setLastName(endsO.getString(3));
                user.setAge(endsO.getInt(4));

                usersEndsO.add(user);
            }
            usersEndsO.forEach(System.out::println);

            System.out.println("-----------------------------------------------------------");
            System.out.println("Пользователи возраст которых между 18 и 60:");

            var between18and60 = statement.executeQuery(SqlQueries.SELECT_USERS_AGE_BETWEEN_18_AND_60);
            var usersBetween = new ArrayList<>();

            while (between18and60.next()) {
                User user = new User();
                user.setId(between18and60.getInt(1));
                user.setFirstName(between18and60.getString(2));
                user.setLastName(between18and60.getString(3));
                user.setAge(between18and60.getInt(4));

                usersBetween.add(user);
            }
            usersBetween.forEach(System.out::println);

            System.out.println("-----------------------------------------------------------");
            System.out.println("Пользователей с буквой 'А' в имени:");

            var nameWithA = statement.executeQuery(SqlQueries.SELECT_USERS_NAME_WITH_A);
            var usersNameWithA = new ArrayList<>();

            while (nameWithA.next()) {
                User user = new User();
                user.setId(nameWithA.getInt(1));
                user.setFirstName(nameWithA.getString(2));
                user.setLastName(nameWithA.getString(3));
                user.setAge(nameWithA.getInt(4));

                usersNameWithA.add(user);
            }
            System.out.println(usersNameWithA.size());

            System.out.println("-----------------------------------------------------------");
            System.out.println("Пользователей старше 18 лет:");

            var adultUsers = statement.executeQuery(SqlQueries.SELECT_ADULT_USERS);
            var adultUsersList = new ArrayList<>();

            while (adultUsers.next()) {
                User user = new User();
                user.setId(adultUsers.getInt(1));
                user.setFirstName(adultUsers.getString(2));
                user.setLastName(adultUsers.getString(3));
                user.setAge(adultUsers.getInt(4));

                adultUsersList.add(user);
            }
            System.out.println(adultUsersList.size());

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
