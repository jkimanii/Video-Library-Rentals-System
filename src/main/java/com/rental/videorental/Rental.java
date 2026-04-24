package com.rental.videorental;

public class Rental {
    private Customer customer;
    private Movie    movie;
    private boolean  returned;

    public Rental(Customer customer, Movie movie) {
        this.customer = customer;
        this.movie    = movie;
        this.returned = false;
    }

    public Customer getCustomer()     { return customer; }
    public Movie    getMovie()        { return movie; }
    public boolean  isReturned()      { return returned; }
    public void     setReturned(boolean returned) { this.returned = returned; }

    @Override
    public String toString() { return movie.getName() + " → " + customer.getName(); }
}
