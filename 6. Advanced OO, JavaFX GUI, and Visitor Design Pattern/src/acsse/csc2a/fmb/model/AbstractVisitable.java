package acsse.csc2a.fmb.model;

/**
 * The AbstractVisitable interface represents an element that can accept a visitor.
 * This interface defines the accept method, which allows visitors to visit the implementing classes.
 */
public interface AbstractVisitable {

    /**
     * Accepts a visitor and allows it to visit the implementing class.
     * @param abstractVisitor The visitor to accept
     */
    void accept(AbstractVisitor abstractVisitor);
}
