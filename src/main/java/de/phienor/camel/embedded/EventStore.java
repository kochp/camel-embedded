package de.phienor.camel.embedded;

import org.apache.camel.Consume;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Philipp Koch (created), $Date$
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$<br>
 *          $Id: $
 */

@Component
public class EventStore {

    /**
     * The logger of this class.
     */
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EventStore.class);

    private List<EventInformation> eventInformations = new LinkedList<EventInformation>();


    @Consume(uri = ScheduledEventProducer.EVENTS_URL)
    public void consumeEvent(EventInformation eventInformation){

         LOGGER.info("received EventInformation:"+eventInformation);

        eventInformations.add(eventInformation);
    }



    public List<EventInformation> getEventInformations() {
        return eventInformations;
    }
}
