package Model;

import javax.persistence.*;


@Entity

@Table (name = "chat")
public class Chat implements Bean  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;



    @JoinColumn(name = "user1", referencedColumnName = "username")
    private String user1;

    @JoinColumn(name = "user2", referencedColumnName = "username")
    private String user2;


    public Chat(){
    }


    public Integer getId() {
        return id;
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }
}
