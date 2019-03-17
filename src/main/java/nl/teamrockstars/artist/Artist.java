package nl.teamrockstars.artist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Artist {
    @Id
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Column(unique = true)
    private String name;

    protected Artist() {
    }

    public Artist(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
