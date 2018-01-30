package libraryms;

/**
 * 
 * @author seemaanwer
 */
// Help from http://www.journaldev.com/1739/observer-design-pattern-in-java
// (3/04/2017).
public interface Subject {

	// These are used to register and unregister observers.
	public void register(Observer obj);
	public void unregister(Observer obj);
	
	// This is used to notify observers of any change to subject.
	public void notifyObservers();
	
	// This gets the update from subject.
	public Object getUpdate(Observer obj);
} // Subject