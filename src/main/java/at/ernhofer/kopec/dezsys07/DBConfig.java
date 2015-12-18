package at.ernhofer.kopec.dezsys07;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.web.servlet.view.RedirectView;

/**
 * This class is used to configure the mongo database connection.
 *
 * @author Stefan Geyer
 * @author Mathias Ritter
 * @version 20151218
 */
@Configuration
public class DBConfig extends AbstractMongoConfiguration {

    /**
     * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo
     */
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("192.168.48.234", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

}