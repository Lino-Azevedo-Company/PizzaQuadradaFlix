package br.lino.azevedo.company.p2flix.domain.movie;

import java.io.File;

public interface MovieService {

    Movie findById(Long id);

    File getMovieResourceById(Long id);

}
