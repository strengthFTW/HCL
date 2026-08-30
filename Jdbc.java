/*
4. JDBC Transactions

Problem Statement:
Perform multiple INSERT operations using a JDBC transaction.
Determine how many rows remain in the database after rollback.

Key concepts:
- setAutoCommit(false) starts manual transaction control.
- commit() permanently saves the changes.
- rollback() removes changes made after the last commit.

Example:
1. Insert row 1
2. Insert row 2
3. Commit
4. Insert row 3
5. Rollback

Result:
Rows 1 and 2 remain.
Row 3 is removed.

Output:
2
*/

import java.sql.*;

public class Jdbc {

    public static void main(String[] args) {

        try {   
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password"
            );

            con.setAutoCommit(false);

            Statement stmt = con.createStatement();

            // First two rows
            stmt.executeUpdate(
                "INSERT INTO students VALUES (1, 'John')"
            );

            stmt.executeUpdate(
                "INSERT INTO students VALUES (2, 'Mike')"
            );

            // Permanently save first two rows
            con.commit();

            // Third row
            stmt.executeUpdate(
                "INSERT INTO students VALUES (3, 'Sam')"
            );

            // Undo changes after the last commit
            con.rollback();

            System.out.println("2");

            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}