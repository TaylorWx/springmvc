package spring_project01;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class Hello {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<String,String> cards;
    private Set<String> games;
    private String wife;
    private Properties info;

    public void setInfo(Properties info) {
        this.info = info;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCards(Map<String, String> cards) {
        this.cards = cards;
    }

    public void show(){
        System.out.println("hello" + name +"   address= "+address.getAddress());
        for(String str:books)
            System.out.println(str+"  ");
        System.out.println();
        System.out.println("hobbies="+hobbies);
        System.out.println("cards="+cards);
        System.out.println("games="+games);
        System.out.println("wife="+wife);
        System.out.println("info="+info);
    }

    public void setName(String name) {
        this.name = name;
    }
}
