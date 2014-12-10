package de.phienor.camel.embedded;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Koch (created), $Date$
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$<br>
 *          $Id: $
 */
@Component
public class EmailSender {


    @Produce(uri = "smtp:camelsender@localhost?password=camel")
    private ProducerTemplate sendEmailMessage;

    public void sendEmail(String from, String to, String subject, String text){

        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("to",to);
        headers.put("from",from);
        headers.put("subject",subject);
        sendEmailMessage.sendBodyAndHeaders(text,headers);
    }
}
