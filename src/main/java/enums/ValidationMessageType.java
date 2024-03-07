package enums;

public enum ValidationMessageType {
    NULL_VALUE_ERROR("The input must not be null"),
    EMPTY_ARRAY_ERROR("The input array must not be empty"),
    OUT_OF_RANGE_ERROR("The input value must be between %d and %d"),
    BELOW_MINIMUM_ERROR("The value must be bigger than %d (inclusively)"),
    ABOVE_MAXIMUM_ERROR("The value must be smaller than %d (inclusively)");


    private final String message;

    ValidationMessageType(String message) {
        this.message = message;
    }

    public String getMessage(Object... boundaryValues) {
        if (boundaryValues.length > 2) {
            throw new IllegalArgumentException("Max allowed boundary values are 2 (lower/upper)");
        }

        return String.format(message, boundaryValues);
    }
}
