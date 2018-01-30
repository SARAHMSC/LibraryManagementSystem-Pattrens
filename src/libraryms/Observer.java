package libraryms;

/**
 * 
 * @author seemaanwer
 */
// Help from http://www.journaldev.com/1739/observer-design-pattern-in-java
// (3/04/2017).
public interface Observer {
	
	// This is used by the subject to update the observer.
	public void update();
	
	// This attached the subject to the observer.
	public void setSubject(Subject sub);
	public Subject getSubject();
}// Observer