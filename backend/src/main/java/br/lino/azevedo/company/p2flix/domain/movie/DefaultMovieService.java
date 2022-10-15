package br.lino.azevedo.company.p2flix.domain.movie;

import br.lino.azevedo.company.p2flix.infra.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {

    private final MovieRepository repository;

    @Override
    public Movie findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(String.format("Movie with id %d not found", id)));
    }

    @Override
    public File getMovieResourceById(Long id) {
        Movie movie = findById(id);
        return new File(movie.getCompleteFilePath());
    }
}
