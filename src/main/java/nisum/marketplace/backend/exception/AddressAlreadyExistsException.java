package nisum.marketplace.backend.exception;


public class AddressAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer itemId;

    public static AddressAlreadyExistsException createWith(Integer itemId) {
        return new AddressAlreadyExistsException(itemId);
    }

    private AddressAlreadyExistsException(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public String getMessage() {
        return "Address '" + itemId + "' already exists";
    }
}
