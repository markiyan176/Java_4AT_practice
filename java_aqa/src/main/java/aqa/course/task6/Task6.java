package aqa.course.task6;


//Task
//
//        General:
//        Install MySQL server (or any SQL like db)
//        Make at least two tables (entities from the previous task)
//        Make models for those entities (from Task_5)
//        Setup Hibernate for those entities
//        Check basic CRUD (create, read, update, and delete the BD records using Hibernate)
//        Generate a few rows into all tables



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Task6 {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:sqlite:C:\\Users\\goro1\\Desktop\\AT\\lab1\\java_aqa\\src\\main\\db\\mydb.sqlite";

        Connection conn = DriverManager.getConnection(url);
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "age INTEGER" +
                ");";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);

        conn.close();
    }
}

