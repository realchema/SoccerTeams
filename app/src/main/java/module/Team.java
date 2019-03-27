package module;

import java.io.Serializable;

public class Team implements Serializable {

    private String teamName;
    private String country;
    private int flag;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Team() {
        this.teamName = "";
        this.country = "";
        this.flag = 0;
    }

    public Team(String teamName, String country, int flag) {
        this.teamName = teamName;
        this.country = country;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return teamName;
    }


}
