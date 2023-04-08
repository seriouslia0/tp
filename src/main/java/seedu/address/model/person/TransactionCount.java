package seedu.address.model.person;

/**
 * Represents a Person's business size in the address book.
 * Guarantees: is valid as declared in {@link #isValidTransactionCount(String)} (String)}
 */
public class TransactionCount implements Comparable<TransactionCount> {


    public static final String MESSAGE_CONSTRAINTS =
            "Transaction Count will start and zero and be incremented to a value >= 0"
                    + " less than or equal to 9223372036854775807.\n"
                    + " It should be a whole number.";
    public static final String VALIDATION_REGEX = "^[0-9]\\d*$";

    public final String value;

    /**
     * Constructs an {@code TransactionCount}.
     *
     * @param transactionCount The initial number of transactions between user and the client
     */
    public TransactionCount(String transactionCount) {
        if (transactionCount != null) {
            this.value = transactionCount;
        } else {
            this.value = String.valueOf(0);
        }
    }

    public int getNumericValue() {
        return Integer.valueOf(this.value);
    }

    public static boolean isValidTransactionCount(String test) {
        try {
            return test.matches(VALIDATION_REGEX) && Long.parseLong(test) >= 0
                    && Long.parseLong(test) <= Long.MAX_VALUE;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Returns integer representation of business size value
     * @return Integer
     */
    public long getLongValue() {
        try {
            return Long.parseLong(this.value);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int compareTo(TransactionCount transactionCount) {
        if (this.getLongValue() - transactionCount.getLongValue() > 0) {
            return 1;
        } else if (this.getLongValue() - transactionCount.getLongValue() < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TransactionCount // instanceof handles nulls
                && value.equals(((TransactionCount) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
