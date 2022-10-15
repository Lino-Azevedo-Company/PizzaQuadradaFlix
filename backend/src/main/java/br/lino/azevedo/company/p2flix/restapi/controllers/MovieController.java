package br.lino.azevedo.company.p2flix.restapi.controllers;

import br.lino.azevedo.company.p2flix.domain.movie.Movie;
import br.lino.azevedo.company.p2flix.domain.movie.MovieService;
import br.lino.azevedo.company.p2flix.restapi.request.DefaultResourceRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

import static br.lino.azevedo.company.p2flix.restapi.request.DefaultResourceRequestHandler.ATTR_FILE;

@RestController
@RequestMapping("movie/")
@RequiredArgsConstructor
public class MovieController {

    private final DefaultResourceRequestHandler resourceRequestHandler;

    private final MovieService service;

    @GetMapping("{id}")
    public void getResourceMovieById(HttpServletRequest request, HttpServletResponse response,
                             @PathVariable final Long id) throws ServletException, IOException {
        File movie = service.getMovieResourceById(id);

        request.setAttribute(ATTR_FILE, movie);
        resourceRequestHandler.handleRequest(request, response);
    }
}
