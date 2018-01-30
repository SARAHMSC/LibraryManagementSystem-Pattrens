package libraryms;

/**
 * 
 * @author seemaanwer
 */
//Help from http://www.journaldev.com/1739/observer-design-pattern-in-java
//(3/04/2017).
public class ObserverPatternTest {

	public static void main(String[] args) {
		
		// Create a subject - Book.
		Book topic = new Book(5,"Funny Bunnies","Sonia","Thriller",3);
		Book topic2 = new Book(1,"LOLA","Sonia","Thriller",3);
		System.out.println(topic.toString());
		System.out.println();
		
		// Create observers - Members.
		Member obj1 = new Member(1, "Johnathan", "UG");
		Member obj2 = new Member(2, "Saaqib", "PG");
		Member obj3 = new Member(3, "Mr George", "PG");
		
		// Register observers to the subject.
		// Attach observer to the subject.
		topic.register(obj1);
		obj1.setSubject(topic);
		topic.register(obj2);
		obj2.setSubject(topic);
		topic.register(obj3);
		obj3.setSubject(topic);
		
		topic2.register(obj1);
		obj1.setSubject(topic2);
		System.out.println();
		
		// Checks if any update is available.
		//obj1.update();
		//System.out.println();
		
		Borrow b = new Borrow();
		Return r = new Return();
		
		// Current state check.
		System.out.println(obj3.toString());
		System.out.println(topic.toString());
		System.out.println();
	
		System.out.println("'Member' " + obj3.getName()+ " wants to borrow the book " + topic.getTitle());
		b.borrowBook(obj3, topic); 
		System.out.println();
		
		// After booking state check.
		System.out.println(obj3.toString());
		System.out.println(topic.toString());
		System.out.println();
		 
		// This is when the subject's state is notified to the observers.
		System.out.println("'Member' " + obj3.getName()+ " wants to return the book " + topic.getTitle());
	    r.returnBook(obj3, topic);
		System.out.println();
	    
		// After returning state check.
		System.out.println(obj3.toString());
		System.out.println(topic.toString());
		System.out.println();
		
		// This is an invalid return so it fails and no user is notified.
		System.out.println("'Member' " + obj3.getName() + " wants to return the book " + topic.getTitle());
	    r.returnBook(obj3, topic);
		System.out.println();
	    
		// After returning state check.
		System.out.println(obj3.toString());
		System.out.println(topic.toString());
		System.out.println();
		
		System.out.println("'Member' " + obj1.getName() + " wants to borrow the book " + topic.getTitle());
		b.borrowBook(obj1, topic); 
		b.borrowBook(obj1, topic); 
		System.out.println();
		
		// Unregister an observer as they are no longer alerted.
		System.out.println("'Member' " + obj2.getName() + " unregisters from the book " + topic.getTitle());
		topic.unregister(obj2);
		System.out.println();
		
		// This is when the subject's state is notified to the observers, but obj2 isn't alerted as they have unsubscribed.
		System.out.println("'Member' " + obj1.getName() + " wants to return the book " + topic.getTitle());
	    r.returnBook(obj1, topic);
		System.out.println();
	} // main()
} // ObserverPatternTest