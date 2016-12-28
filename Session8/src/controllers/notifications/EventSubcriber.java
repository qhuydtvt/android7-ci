package controllers.notifications;

/**
 * Created by apple on 12/28/16.
 */
public interface EventSubcriber {
    boolean onEvent(EventType eventType, Object params);
}
