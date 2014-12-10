package de.phienor.camel.embedded;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Philipp Koch (created), $Date$
 * @author $Author$ (last changed)
 * @version $Rev$, $Date$<br>
 *          $Id: $
 */
@XmlRootElement
public class EventInformation {

    private String id;

    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "EventInformation{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
