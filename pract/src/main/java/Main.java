public class Main {
    public static void main(String[] args) {
        User user = new User();
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

        user.userByAge(user.userByGender("female"));
    }
}
