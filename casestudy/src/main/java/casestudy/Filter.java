package casestudy;

import javax.persistence.*;

@Entity
@Table(name = "filters")
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;

    @OneToMany(targetEntity = Note.class)
    private Iterable<Note>notes;

    public Filter(){};

    public Filter(String name) {
        this.name = name;
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

    public Iterable<Note> getNotes(){
        return notes;
    }
    public void setNotes(Iterable<Note>notes){
        this.notes = notes;
    }
}
