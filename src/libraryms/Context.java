package libraryms;
import com.borrow.State;

public class Context {
	private State state;
	public String id;

    public Context() {
	    state = null;
	} // Context()

    public void setState(State state) {
	    this.state = state;		
	} // setStatus()

	public State getState() {
	    return state;
	} // getState()
	   
	public String getId() {
	    return id;
	} // getId()
	   
	public void setId(String id) {
	    this.id = id;		
	} // setId()
} // Context