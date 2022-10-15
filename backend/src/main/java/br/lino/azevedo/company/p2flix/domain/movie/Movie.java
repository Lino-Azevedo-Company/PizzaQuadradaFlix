package br.lino.azevedo.company.p2flix.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pqf_movie")
@SequenceGenerator(name = "pqf_movie_sq", sequenceName = "pqf_movie_sq", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "pqf_movie_sq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "path")
    private String path;

    @Column(name = "movie_file")
    private String file;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "director")
    private String director;

    @Column(name = "year")
    private Integer year;

    @Column(name = "gender")
    private String gender;

    @Column(name = "classification")
    private Integer classification;

    @Column(name = "cover_file")
    private String cover;

    public void update(final Movie movie) {
        this.setTitle(movie.title);
        this.setPath(movie.path);
        this.setDuration(movie.getDuration());
        this.setSynopsis(movie.getSynopsis());
        this.setDirector(movie.getDirector());
        this.setYear(movie.getYear());
        this.setGender(movie.getGender());
        this.setClassification(movie.getClassification());
        this.setCover(movie.getCover());
    }

    public String getCompleteFilePath() {
        return String.format("%s/%s", getPath(), getFile());
    }

}
