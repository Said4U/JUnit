import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {

    Map<Integer, String> nameMap = new HashMap<Integer, String>();
    Map<Integer, Integer> ageMap = new HashMap<Integer, Integer>();
    Map<Integer, String> genderMap = new HashMap<Integer, String>();

    public void putMap(int id, String gender){
        genderMap.put(id, gender);
    }


    public ArrayList<Integer> userByGender(String gender){
        ArrayList<Integer> usersID = new ArrayList<Integer>();
        for (Integer id: genderMap.keySet()) {
            if (genderMap.get(id).equals(gender)) {
                usersID.add(id);
            }
        }
        return usersID;
    }

    public double userByAge(ArrayList<Integer> usersID){
        double total = 0;
        for (Integer idUsers: usersID) {
            for (Integer idAge : ageMap.keySet()) {
                if (idUsers.equals(idAge)) {
                    total += ageMap.get(idAge);
                }
            }
        }
        return total/usersID.size();
    }


    public ArrayList<String> getAllUsers(){
        ArrayList<String> nameList = new ArrayList<>();
        for (String name: nameMap.values()){
            nameList.add(name);
        }
        return nameList;

    }

    public int getSizeUsers(){
        return nameMap.size();
    }

    public void genderToString(ArrayList<Integer> usersID){

        ArrayList<String> nameList = new ArrayList<String>();
        for (Integer id1: usersID) {
            nameList.add(nameMap.get(id1));
        }

        Object[] peopleArray = nameList.toArray();
        for (Object person : peopleArray){
            System.out.println(person);
        }
    }

    public int getSizeGender(ArrayList<Integer> usersID){
        return usersID.size();
    }

    public double getAverageAge(){
        double total = 0;
        for (Integer age: ageMap.values()){
            total += age;
        }
        return total/ageMap.size();
    }

}





