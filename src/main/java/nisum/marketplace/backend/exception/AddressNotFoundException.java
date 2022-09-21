package nisum.marketplace.backend.exception;


public class AddressNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer addressId;

    public static AddressNotFoundException createWith(Integer itemId) {
        return new AddressNotFoundException(itemId);
    }

    private AddressNotFoundException(Integer itemId) {
        this.addressId = itemId;
    }

    @Override
    public String getMessage() {
        return "Address '" + addressId + "' not found";
    }
}
