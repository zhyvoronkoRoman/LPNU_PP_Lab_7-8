package Train;
import Coaches.*;


import java.util.ArrayList;
import java.util.*;

public class Train {
    private String name;
        private ArrayList <Coach> coaches;

    public Train(String name){
        setName(name);
        this.coaches = new ArrayList<>();
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public void setName(String name) {this.name = name;}

    public void addCoach(Coach coach){
        coaches.add(coach);
    }

    public int numofpass() {
        int numOfPass = 0;
        for (int i = 0; i < coaches.size(); i++) {
            numOfPass += coaches.get(i).getNumberOfSeats();
        }
        return numOfPass;
    }

    public int numofbagage() {
        int numOfBags = 0;
        for (int i = 0; i < coaches.size(); i++) {
            numOfBags += (coaches.get(i).getNumOfBagsPerPerson() * coaches.get(i).getNumberOfSeats());
        }
        return numOfBags;
    }

    public ArrayList <Coach> sortCoaches() {
        for (int i = 0; i < coaches.size() - 1; i++) {
            for (int j = 0; j < coaches.size() - 1 - i; j++) {
                if (coaches.get(j).getComfLevel() > coaches.get(j + 1).getComfLevel()) {
                    Collections.swap(coaches, j, j + 1);
                }
            }
        }
        return coaches;
    }

    public void findCoach(int numOfPl){
        for(int i = 0; i < coaches.size()-1;i++){
            if (numOfPl >= coaches.get(i).getNumberOfSeats()){
                System.out.println(coaches.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "\n"+name +
                ", Вагони:" + coaches;
    }
}
