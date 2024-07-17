import java.util.HashSet;
import java.util.Set;

public class SetProblem {
    static class User {
        private String name;
        private int age;
        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        //Overriding equals() and hashCode() methods for User class
        @Override
        public boolean equals(Object obj) {
            User other = (User) obj;

            if (this.name.equals(other.getName()) && this.age == other.getAge()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int asInt, sum = 0, resultHash;

            for (int i = 0; i < this.name.length(); i++) {
                asInt = (int) this.name.charAt(i);
//                System.out.println(asInt);

                sum += asInt * 31;
            }
            resultHash = sum % (this.age * 19);
//            System.out.println(resultHash);
            return resultHash;
        }
    }

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User("Max", 27));
        users.add(new User("Veronika", 20));
        users.add(new User("Denis", 30));
        users.add(new User("Max", 27));

        if (users.size() == 3) {
            System.out.println("System works well!");
        } else {
            throw new RuntimeException("Users set size should be 3!");
        }
    }
}