package kata5.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;
import kata5.model.Person;
import kata5.model.SqlitePeopleLoader;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SqlitePeopleLoader peopleLoader = new SqlitePeopleLoader();
        List<Person> personsList = peopleLoader.load();
        List<Mail> mailList = new ArrayList();
        for (Person person : personsList) {
            mailList.add(person.getEmail());
        }
        
        Histogram<String> mailHistogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM...", mailHistogram);
        histogramDisplay.execute();
    }
    
}
