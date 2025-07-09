package org.example;

class Client extends User {
    private double balance;
    private Cart cart;

    public Client(String name, String email, String address, double balance) {
        super(name, email, address);
        this.balance = balance;
        this.cart = new Cart();
    }

    public void addToCart(Book book, int quantity) {
        if (!book.isPurchasable()) {
            System.out.println("Book \"" + book.getTitle() + "\" is not purchasable.");
            return;
        }
        if (quantity <= 0) {

        }
        cart.addItem(book, quantity);
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = cart.calculateTotal();

        if (total > balance) {
            System.out.println("Insufficient balance. Total: $" + total + ", Balance: $" + balance);

            return;
        }


        for (CartItem item : cart.getItems()) {
            Book book = item.getBook();
            int quantity = item.getQuantity();

            if (book instanceof PaperBook) {
                 if(item.getQuantity()>((PaperBook) book).getStock())
                {
                    System.out.println("Purchase failed: "+book.getTitle() +" Do Not have enough stock.");
                     return;
                }
            }
        }



        for (CartItem item : cart.getItems()) {
            Book book = item.getBook();
            int quantity = item.getQuantity();

            if (book instanceof PaperBook) {
                try {
                    ((PaperBook) book).reduceStock(quantity);
                    book.deliver(email, address, new ShippingService());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (book instanceof EBook) {
                book.deliver(email, address, new MailService());
            }
        }

        balance -= total;
        cart.clear();
        System.out.println("Purchase successful. Total: $" + total + ". Remaining balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void addFunds(double amount) {
        balance += amount;
        System.out.println("$" + amount + " added to balance. Current balance: $" + balance);
    }

}
