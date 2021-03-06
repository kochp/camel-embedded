package de.phienor.camel.embedded.user;

import de.phienor.camel.embedded.EmailSender;
import org.apache.camel.Consume;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Philipp Koch (created), $Date$
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$<br>
 *          $Id: $
 */
@Component
public class AsynchronousUserWorker {

    /**
     * The logger of this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AsynchronousUserWorker.class);
    public static final String JMS_QUEUE_STORE_USER = "jms:queue:storeUser";

    @Autowired
    private EmailSender emailSender;

    @Consume(uri=JMS_QUEUE_STORE_USER)
    public void storeUserWorker(String user){

        LOGGER.info("Received User to store: {}",user);
        emailSender.sendEmail("camelsender@localhost","camel@localhost","User Anlage",
                "Hallo Camel,\n folgender User wurde angelegt:\n"+user);
    }

}
