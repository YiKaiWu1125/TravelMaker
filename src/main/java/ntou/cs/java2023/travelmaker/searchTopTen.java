package ntou.cs.java2023.travelmaker;

import java.util.ArrayList;
public class SearchTopTen {
    ArrayList<Spide> spidesList = new ArrayList<Spide>();
    ArrayList<Attractions> attractionsList = new ArrayList<Attractions>();
    SearchTopTen(){}
    SearchTopTen(String where){
        search(where);
    }
    public void search(String where){
        spidesList.clear();
        spidesList.add(new EasyTravelSpide(where));
        spidesList.add(new OkgoSpide(where));
        spidesList.add(new TwInfoSpide(where));

        attractionsList.clear();
        for (Spide spide : spidesList){
            attractionsList.addAll(spide.getResult());
        }
    }
    public ArrayList<Attractions> getTopTen(){
        //System.out.println(attractionsList);
        ArrayList<Attractions> returnArrList = new ArrayList<Attractions>();
        int i = 1;
        try {
            for (Attractions attractions : attractionsList) {
                returnArrList.add(attractions);
                if (i++ >= 10) break;
            }
        }catch (Exception e){System.out.println(e);}
        return returnArrList;
    }
}
