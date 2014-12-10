package de.phienor.camel.embedded;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Philipp Koch (created), $Date$
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$<br>
 *          $Id: $
 */
@Component
public class ScheduledEventProducer extends RouteBuilder{

    /**
     * The logger of this class.
     */
    public static final String EVENTS_URL = "jms:topic:socketEvents";
//    public static final String EVENTS_URL = "websocket:localhost/events?sendToAll=true";
    private static final String FROM_URI = "quartz2://schedulerGroup/cameltrigger?trigger.repeatInterval=5000&trigger.repeatCount=100";


    @Override
    public void configure() throws Exception {
        from(FROM_URI)
                .log(LoggingLevel.INFO,"creating Event")
                .setBody(simple("<eventInformation>" +
                        "<id>${exchangeId}</id>" +
                        "<text>${body}</text>" +
                        "</eventInformation>"))
                .to(EVENTS_URL);
    }
}
