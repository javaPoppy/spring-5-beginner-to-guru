package udemy.learning.spring5beginnertoguru.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    private int doorNo;
    private String StreetName;
    private String city;
    private String country;
    private String postCode;

    public Address(int doorNo, String streetName, String city, String country, String postCode) {
        this.doorNo = doorNo;
        this.StreetName = streetName;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
    }
}
