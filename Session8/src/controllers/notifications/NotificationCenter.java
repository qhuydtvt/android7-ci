package controllers.notifications;

import javax.security.auth.Subject;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by apple on 12/28/16.
 */
public class NotificationCenter {

    private Vector<EventSubcriber> subcribers;

    public final static NotificationCenter instance = new NotificationCenter();

    private NotificationCenter() {
        subcribers = new Vector<>();
    }

    public void register(EventSubcriber subcriber) {
        this.subcribers.add(subcriber);
    }

    public void unregister(EventSubcriber subcriber) {
        this.subcribers.remove(subcriber);
    }

    public void onEvent(EventType eventType, Object params) {

        Iterator<EventSubcriber> iterator = this.subcribers.iterator();
        while(iterator.hasNext()) {
            EventSubcriber e = iterator.next();
            if(!e.onEvent(eventType, params)) {
                // Remove request
                iterator.remove();
            }
        }
//        for(EventSubcriber subcriber : subcribers) {
//            subcriber.onEvent(eventType, params);
//        }
    }
}
