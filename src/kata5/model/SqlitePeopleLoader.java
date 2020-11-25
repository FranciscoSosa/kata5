package kata5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlitePeopleLoader implements PeopleLoader{
    
    private final Connection connection;
    
    public SqlitePeopleLoader() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:data/people.db");
    }

    @Override
    public List<Person> load() {
        List<Person> personsList = new ArrayList();
        try(Statement statement = connection.createStatement()){
            ResultSet set = statement.executeQuery("Select first_name, last_name, address, email FROM people");
            while(set.next()){
                String name = set.getString("first_name") + " " + set.getString("last_name");
                String address = set.getString("address");
                Mail email = new Mail(set.getString("email"));
                personsList.add(new Person(name, address, email));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlitePeopleLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personsList;
    }
    
}
