package pro.sky.ShelterTelegramBot.model;

import jakarta.persistence.*;



import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="telephone", nullable = false)
    private Long telephone;
   @Column(name="address")
    private String address;

    @OneToOne
    @JoinColumn(name = "report_id")
    private Report report;
    @OneToMany(mappedBy = "client")
    private List<Attachment> attachments;
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;
    @OneToMany(mappedBy = "client")
    private List<Pet> pet;

    public Client() {
    }

    public Client(String name, int age, Long telephone, String address) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.address = address;

    }
    public Client(Long id,String name, int age, Long telephone, String address) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.address = address;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }





    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", telephone=" + telephone +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && Objects.equals(telephone, client.telephone) && Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, telephone, address);
    }
}
