public class SqlQueries {

    public static final String CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS user (
        id int PRIMARY KEY AUTO_INCREMENT,
        first_name varchar(50),
        last_name varchar(50),
        age int)
         """;

    public static final String INSERT_USERS = """
        INSERT INTO user (first_name, last_name,age) VALUES
        ('john', 'snow',42),
        ('max', 'pax',18),
        ('Alla', 'Mazur',41),
        ('tirion', 'lanister',30),
        ('Bob', 'Stoborod',12),
        ('Alex', 'Koosyaka',3),
        ('Lora', 'Brown',64),
        ('Max', 'Black',80),
        ('Miho', 'Shwily',69)
        """;

    public static final String SELECT_USERS_YOUNGER_18 = """
        SELECT * FROM user WHERE age < 18
        """;

    public static final String SELECT_USERS_NAME_ENDS_O = """
        SELECT * FROM user WHERE first_name LIKE '%o'
        """;

    public static final String SELECT_USERS_AGE_BETWEEN_18_AND_60 = """
        SELECT * FROM user WHERE age BETWEEN 18 AND 60
        """;

    public static final String SELECT_USERS_NAME_WITH_A = """
        SELECT * FROM user WHERE first_name LIKE '%a%'
        """;

    public static final String SELECT_ADULT_USERS = """
        SELECT * FROM user WHERE age >=18
        """;

    public static final String SELECT_ALL_USERS = """
        SELECT * FROM user
        """;


    private SqlQueries() {
    }
}
