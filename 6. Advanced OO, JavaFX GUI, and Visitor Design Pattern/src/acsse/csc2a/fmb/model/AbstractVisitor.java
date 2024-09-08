package acsse.csc2a.fmb.model;

/**
 * The AbstractVisitor interface represents a visitor in the Visitor Design Pattern.
 * It defines a method for visiting FireworkEntity objects.
 */
public interface AbstractVisitor {

    /**
     * Visits a FireworkEntity object.
     * @param fireworkEntity The FireworkEntity to be visited
     */
    void visit(FireworkEntity fireworkEntity);
}
