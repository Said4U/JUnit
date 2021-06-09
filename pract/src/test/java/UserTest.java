import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {

    User user = new User();


    @Before
    public void putData() {
        user.putMap(1, "female");
        user.putMap(2, "male");
        user.putMap(3, "male");
        user.putMap(4, "female");

        user.nameMap.put(1, "Женя");
        user.nameMap.put(2, "Олег");
        user.nameMap.put(3, "Сергей");
        user.nameMap.put(4, "Анатолий");

        user.ageMap.put(1, 20);
        user.ageMap.put(2, 20);
        user.ageMap.put(3, 30);
        user.ageMap.put(4, 35);
    }

    @Test
    public void userByGender() {

        ArrayList<Integer> expected =  user.userByGender("female");

        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(4);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void userByAge() {
        Assert.assertEquals(user.userByAge(user.userByGender("female")), 27.5, 0);
    }

    @Test
    public void getAllUsers() {

        ArrayList<String> expected = user.getAllUsers();

        ArrayList<String> actual = new ArrayList<>();
        actual.add("Женя");
        actual.add("Олег");
        actual.add("Сергей");
        actual.add("Анатолий");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getSizeUsers() {
        Assert.assertEquals(user.getSizeUsers(), 4, 0);
    }

    @Test
    public void getSizeGender() {
        Assert.assertEquals(user.getSizeGender(user.userByGender("female")), 2, 0);
    }

    @Test
    public void getAverageAge() {
        Assert.assertEquals(user.getAverageAge(), 26.25, 0);

    }
}