package module;

import java.io.Serializable;

public class Rating extends Team implements Serializable {

    private int clientNumber;
    private float rating;



    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }



    public Rating() {
        super();
        this.clientNumber = 0;
        this.rating = 0;
    }


    public Rating(String teamName, String country, int flag, int clientNumber, float rating) {
        super(teamName, country, flag);
        this.clientNumber = clientNumber;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "clientNumber=" + clientNumber +
                ", rating=" + rating +
                '}';
    }
}
