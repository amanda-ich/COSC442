/**
 * Represents a simple bank account with an owner, a balance,
 * and an active/inactive status.
 *
 * <p>A bank account may be used to deposit funds, withdraw funds,
 * transfer funds to another account, and close the account.</p>
 *
 * <p>An account must have a zero balance before it can be closed.
 * Once closed, no deposits, withdrawals, or transfers may be made.</p>
 *
 * @author Your Name
 * @version 1.0
 */
public class BankAccount {

    private String owner;
    private double balance;
    private boolean active;

    /**
     * Constructs a new bank account for the specified owner
     * with the specified initial balance.
     *
     * <p>The account is active when it is created.</p>
     *
     * @param owner the name of the account owner
     * @param initialBalance the starting balance of the account
     *
     * @throws IllegalArgumentException if the initial balance is negative
     */
    public BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative."
            );
        }

        this.owner = owner;
        this.balance = initialBalance;
        this.active = true;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount the amount of money to deposit
     *
     * @throws IllegalArgumentException if the amount is less than
     *         or equal to zero
     * @throws IllegalStateException if the account is closed
     */
    public void deposit(double amount) {
        checkActive();

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive."
            );
        }

        balance += amount;
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount the amount of money to withdraw
     *
     * @throws IllegalArgumentException if the amount is less than
     *         or equal to zero
     * @throws IllegalArgumentException if the amount exceeds
     *         the current account balance
     * @throws IllegalStateException if the account is closed
     */
    public void withdraw(double amount) {
        checkActive();

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be positive."
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient funds."
            );
        }

        balance -= amount;
    }

    /**
     * Transfers the specified amount from this account to another account.
     *
     * <p>The amount is withdrawn from this account and deposited into
     * the destination account.</p>
     *
     * @param otherAccount the account that will receive the funds
     * @param amount the amount of money to transfer
     *
     * @throws IllegalArgumentException if the destination account is null
     * @throws IllegalArgumentException if the amount is less than
     *         or equal to zero
     * @throws IllegalArgumentException if the amount exceeds
     *         this account's balance
     * @throws IllegalStateException if this account is closed
     * @throws IllegalStateException if the destination account is closed
     */
    public void transferTo(BankAccount otherAccount, double amount) {
        checkActive();

        if (otherAccount == null) {
            throw new IllegalArgumentException(
                "Destination account cannot be null."
            );
        }

        withdraw(amount);
        otherAccount.deposit(amount);
    }

    /**
     * Closes the account.
     *
     * <p>The account may be closed only when its balance is exactly zero.</p>
     *
     * @throws IllegalStateException if the account balance is not zero
     */
    public void closeAccount() {
        if (balance != 0) {
            throw new IllegalStateException(
                "Account must have a zero balance before it can be closed."
            );
        }

        active = false;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the current account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the name of the account owner.
     *
     * @return the account owner's name
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Indicates whether the account is currently active.
     *
     * @return {@code true} if the account is active;
     *         {@code false} if the account is closed
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Verifies that the account is active.
     *
     * @throws IllegalStateException if the account is closed
     */
    private void checkActive() {
        if (!active) {
            throw new IllegalStateException(
                "Account is closed."
            );
        }
    }
}