package udemy.learning.spring5beginnertoguru.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publisherName;

    @ManyToOne(targetEntity = Address.class)
    private List<Address> publisherAddressList;
}
