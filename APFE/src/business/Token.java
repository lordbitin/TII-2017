/* Copyright Guillem Catala. www.guillemcatala.com/petrinetsim. Licensed http://creativecommons.org/licenses/by-nc-sa/3.0/ */
package business;

import java.util.Optional;

/**
 *
 * @author Guillem
 */
public class Token {

    /** Represents the expression t*/
    private String initialMarkingExpression = "";
    /** Represents the colour of the token*/
    private Object object;
    /** Represents the timestamp of the token*/
    private long timestamp = 0;
    
    /** Represents if the token has been evaluated in its current place*/
    private boolean passedTransitionGuard = false;

    /** Creates a new token*/
    public Token(Object object) {
        this.object = object;
    }

    /** Creates a new token with a timestamp*/
    public Token(Object object, long timestamp) {
        this.object = object;
        this.timestamp = timestamp;
    }

    /** Creates a new token with a timestamp and a initial marking expression*/
    public Token(Object object, long timestamp, String initialMarkingExpression) {
        this.object = object;
        this.timestamp = timestamp;
        this.initialMarkingExpression = initialMarkingExpression;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     **/
    @Override
    public boolean equals(Object obj) {
        Token objToken = (Token) obj;
        if (objToken.getTimestamp() == timestamp) {
            //same color?
            Optional<Object> o1 = Optional.ofNullable(objToken.getObject());
            Optional<Object> o2 = Optional.ofNullable(this.object);
            
            boolean result = o1.equals(o2);
            if (o1.isPresent() && o2.isPresent()) {
                result = result && 
                        (o1.get().getClass().getName().equals(o2.get().getClass().getName())); 
            }
            return result;
        } else {
            return false;
        }
    }

    /**Returns a hash code value for the object. This method is
     * supported for the benefit of hashtables such as those provided by
     * <code>java.util.Hashtable</code>.*/
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.object != null ? this.object.hashCode() : 0);
        hash = 47 * hash + (int) (this.timestamp ^ (this.timestamp >>> 32));
        return hash;
    }

    /** Used to represent the object in a String*/
    @Override
    public String toString() {
        String s = "";
        if (!initialMarkingExpression.equals("")) {
            s = initialMarkingExpression;
        } else {
            s = object.toString();
            if (timestamp != 0) {
                s += " " + timestamp;
            }
        }
        return s;
    }

    /**
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    public boolean isPassedTransitionGuard() {
        return passedTransitionGuard;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the initialMarkintExpression
     */
    public String getInitialMarkingtExpression() {
        return initialMarkingExpression;
    }

    /**
     * @param initialMarkintExpression the initialMarkintExpression to set
     */
    public void setInitialMarkingtExpression(String initialMarkintExpression) {
        this.initialMarkingExpression = initialMarkintExpression;
    }

    public void setPassedTransitionGuard(boolean analyzed) {
        this.passedTransitionGuard = analyzed;
    }
}
